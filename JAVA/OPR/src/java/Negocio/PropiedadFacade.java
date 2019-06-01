/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Integracion.IntegracionBD;
import Integracion.IntegradorColaCorreo;
import Integracion.IntegradorCorreo;
import entities.Propiedad;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class PropiedadFacade extends AbstractFacade<Propiedad>{
    
    @PersistenceContext(unitName = "LogicaOPRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public PropiedadFacade() {
        super(Propiedad.class);
    }
    
    @Resource
    SessionContext ctx ;
    
    IntegracionBD bd  = new IntegracionBD();
    
    
    IntegradorColaCorreo intCola;
    public void crearPropiedad(Propiedad propiedad){
        try {
            bd.crearPropiedad(em, propiedad);
            String datosCorreo = propiedad.getDescripcion() + ","+ "Propiedad agregada" + "," + "La propiedad que postulo fue agregada";
            intCola = new IntegradorColaCorreo();
            try {
                intCola.sendTestMSg(datosCorreo);
                //   correo.enviarCorreo("santiagosw18@gmail.com", "Propiedad agregada", "La propiedad que postulo fue agregada");
            } catch (NamingException ex) {
                Logger.getLogger(PropiedadFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JMSException ex) {
            Logger.getLogger(PropiedadFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Propiedad getPropiedad(Short id){
        return bd.findPropiedad(em, id);
    }
    public List<Propiedad> getPropiedades(){
        
        return bd.getPropiedades(em);
    }
    public List<Propiedad> getPropiedadesxNombre(String nombre){
        return bd.getPropiedadesxNombre(em, nombre);
    }
    public List<Propiedad> getPropiedadesxCedula(BigDecimal cedula){
        return bd.getPropiedadesxCedula(em,cedula);
    }
    
    @Asynchronous
    public Future<List<Propiedad>> getPropiedadesxCliente(BigDecimal cedula){
        
        if ( ctx.wasCancelCalled() ) {
            return new AsyncResult<>(null);
        }
        System.out.println("preconsula");
        List<Propiedad> p = bd.getPropiedadesxCedula(em,cedula);
        return new AsyncResult<>(p);
    }

    public void deletePropiedad(Short id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
