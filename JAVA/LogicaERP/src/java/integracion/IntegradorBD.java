/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entities.RentaErp;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;

/**
 *
 * @author Lenovo
 */
@Stateless
@LocalBean
public class IntegradorBD {

    public void crearRentaERP(EntityManager em, RentaErp renta){
        System.out.println("Antes del persist ------------------------------------" + em.isOpen());
        em.persist(renta);
        System.out.println("Despues del persist ------------------------------------");
    }
}
