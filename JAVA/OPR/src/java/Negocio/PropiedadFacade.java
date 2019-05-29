/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Integracion.IntegracionBD;
import Integracion.IntegradorCorreo;
import entities.Propiedad;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
    
    IntegracionBD bd  = new IntegracionBD();
    
    @EJB
    IntegradorCorreo correo; 
    
    public void crearPropiedad(Propiedad propiedad){
        correo.enviarCorreo("prowebphp@gmail.com", "prowebphp@gmail.com", "php12345", "santiagosw18@gmail.com", "Propiedad agregada", "La propiedad que postulo fue agregada");
        //bd.crearPropiedad(em, propiedad);
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
    
}
