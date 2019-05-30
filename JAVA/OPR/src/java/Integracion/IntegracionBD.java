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
import javax.persistence.StoredProcedureQuery;

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
     public List<Renta> getRentas(EntityManager em){
         Query query = em.createQuery("Select e from Renta e");
        return (List<Renta>)query.getResultList();
     }

    public void revisarContratos(EntityManager em) {
        //Query query = em.createQuery("Select e from Propiedad e");
        System.out.println("holaaaa");
        /*Query select = em.createQuery("Select e from Renta e WHERE e.estado = '0'");
        List <Renta> rentas = (List<Renta>)select.getResultList();
        for (Renta r : rentas){
            System.out.println(r.getEstado());
            }
        Query update = em.createQuery("UPDATE Renta e SET e.estado = '2' WHERE e.estado = '0'");
        update.executeUpdate();
                */
        StoredProcedureQuery actualizar = em.createStoredProcedureQuery("renta_tapi.actualizar_contratos");
        actualizar.execute();
    }
    public String confirmarContrato(int idPropiedad, int documentoUsuario, EntityManager em){
        Query query = em.createQuery("Select e from Renta e WHERE e.estado = 0 and e.cedulaUsuario = "+documentoUsuario+" and e.idPropiedad = "+idPropiedad);
        List<Renta> rentas = (List<Renta>)query.getResultList();
        if(rentas.size()==0){
            System.out.println("no existe la propiedad aociada a este usuario puede que no exista o que ya se venció el contrato");
            return ("no existe la propiedad aociada a este usuario puede que no exista o que ya se venció el contrato");
        }else{
            Query actualizar = em.createQuery("Update Renta e set e.estado = '1' WHERE e.estado = '0' and e.cedulaUsuario = "+documentoUsuario+" and e.idPropiedad = "+idPropiedad);
            actualizar.executeUpdate();
             System.out.println("contrato actualizado correctamente");
            return ("contrato actualizado correctamente");
        }
    }
}
