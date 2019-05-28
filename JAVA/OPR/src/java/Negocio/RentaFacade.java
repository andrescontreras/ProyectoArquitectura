/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Integracion.PropiedadJpaController;
import Integracion.exceptions.RollbackFailureException;
import entities.Propiedad;
import entities.Renta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andre
 */
@Stateless
public class RentaFacade {
     PropiedadJpaController jpa = new PropiedadJpaController();
     
     public void crearRenta(Propiedad renta){
         try {
             //jpa.agregarRenta(renta);
             System.out.println("Antes de create");
             jpa.create(renta);
             System.out.println("Despues de create");
         } catch (RollbackFailureException ex) {
             Logger.getLogger(RentaFacade.class.getName()).log(Level.SEVERE, null, ex);
         } catch (Exception ex) {
             Logger.getLogger(RentaFacade.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
