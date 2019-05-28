/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Integracion.PropiedadJpaController;
import entities.Propiedad;
import java.math.BigDecimal;
import java.util.List;
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
    PropiedadJpaController jpa = new PropiedadJpaController();
    
    public void crearPropiedad(Propiedad propiedad){
        getEntityManager().persist(propiedad);
    }
    public Propiedad getPropiedad(Short id){
        return jpa.findPropiedad(id);
    }
    public List<Propiedad> getPropiedades(){
        return jpa.getPropiedades();
    }
    public List<Propiedad> getPropiedadesxNombre(String nombre){
        return jpa.getPropiedadesxNombre(nombre);
    }
    public List<Propiedad> getPropiedadesxCedula(BigDecimal cedula){
        return jpa.getPropiedadesxCedula(cedula);
    }
    
}
