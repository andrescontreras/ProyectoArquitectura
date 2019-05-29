/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import entities.Propiedad;
import entities.Renta;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Stateless
public class IntegracionBD {

    public IntegracionBD(){
    }
    
    public List<Propiedad> getPropiedades(EntityManager em)
    {
        Query query = em.createQuery("Select e from Propiedad e");
        return (List<Propiedad>)query.getResultList();
    }
    
    public Propiedad findPropiedad(EntityManager em ,Short id) {
        return em.find(Propiedad.class, id);
    }
    
   public List<Propiedad> getPropiedadesxNombre(EntityManager em,String nombre)
    {
        Query query = em.createQuery("Select e from Propiedad e WHERE e.nombre LIKE '%"+nombre+"%'");
        List<Propiedad> list = query.getResultList();
        return list;
    }
    public List<Propiedad> getPropiedadesxCedula(EntityManager em, BigDecimal cedula)
    { 
        Query query = em.createQuery("Select e from Propiedad e WHERE e.cedulaOwner LIKE '%"+cedula+"%'");
        List<Propiedad> list = query.getResultList();
        return list;
    }
    
    public void crearPropiedad(EntityManager em, Propiedad propiedad){
        em.persist(propiedad);
    }
    
    // Funciones resnta
    
     public void crearRenta(EntityManager em,Renta renta){
        em.persist(renta);
     }
}
