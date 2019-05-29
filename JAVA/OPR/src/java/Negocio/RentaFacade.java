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
import java.util.Date;
import java.util.List;
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
        proxy.httpPost(transaccion);
        AprobacionDTO apro = proxy.httpGet();
        
        /*
        AprobacionDTO apro = new AprobacionDTO();
         apro.setEstado(true);
         apro.setFechaAprobacion(transaccion.getFecha());
         apro.setNumAprobacion(12);*/
        if (apro.isEstado()) {
            Renta renta = new Renta();
            renta.setCedulaUsuario(transaccion.getNumDocumento());
            renta.setEmail(transaccion.getEmail());
            renta.setEstado('0');
            Date date = new Date();
            renta.setFecha(date);
            renta.setFechaRenta(transaccion.getFecha());
            renta.setIdPropiedad((short) 2);
            renta.setPrecioRenta(43);
            bd.crearRenta(em, renta);
            //Se coloca la renta en el topico
        } 
        
        //Devuelvo al REST la Aprobacion para que se la mande a la Presentacion
        //"fecha": "2019-05-24T00:02:44-05:00"

        return apro;
    }

    public List<Renta> mostrarRentas() {
        return bd.getRentas(em);
    }

}
