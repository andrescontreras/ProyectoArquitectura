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
public class PropiedadFacade{
    
    PropiedadJpaController jpa = new PropiedadJpaController();
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
