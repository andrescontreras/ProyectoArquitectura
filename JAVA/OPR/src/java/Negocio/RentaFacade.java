/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Integracion.IntegracionBD;
import Integracion.ProxyFinanciera;
import entities.AprobacionDTO;
import entities.Renta;
import entities.TransaccionDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author santi
 */
@Stateless
public class RentaFacade extends AbstractFacade<Renta> {

    @PersistenceContext(unitName = "LogicaOPRPU")
    private EntityManager em;
    IntegracionBD bd = new IntegracionBD();
    ProxyFinanciera proxy = new ProxyFinanciera();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentaFacade() {
        super(Renta.class);
    }

    public AprobacionDTO crearRenta(TransaccionDTO transaccion) {
        AprobacionDTO apro = proxy.httpPost(transaccion);
        //AprobacionDTO apro = proxy.httpGet();
        /*
         AprobacionDTO apro = new AprobacionDTO();
         apro.setEstado(true);
         apro.setFechaAprobacion(transaccion.getFecha());
         apro.setNumAprobacion(12);*/
        if (apro.getEstado() == 2) {
            try {
                Renta renta = new Renta();
                renta.setCedulaUsuario(transaccion.getNumDocumento());
                renta.setEmail(transaccion.getEmail());
                renta.setEstado('0');
                Date date = new Date();
                renta.setFecha(date);
                Date dateRenta;
                dateRenta = new SimpleDateFormat("dd/MM/yyyy").parse(transaccion.getFechaRenta());
                renta.setFechaRenta(dateRenta);
                renta.setIdPropiedad((short) transaccion.getIdPropiedad());
                renta.setPrecioRenta(transaccion.getDescontar());
                bd.crearRenta(em, renta);
                //Se coloca la renta en el topico
                FacadeInteroperabilidadOPR interoperbilidad = new FacadeInteroperabilidadOPR();
                interoperbilidad.InformarSistemaERP(renta);
            } catch (ParseException ex) {
                Logger.getLogger(RentaFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Devuelvo al REST la Aprobacion para que se la mande a la Presentacion
        //"fecha": "2019-05-24T00:02:44-05:00"
        return apro;

    }

    public List<Renta> mostrarRentas() {
        return bd.getRentas(em);
    }
}
