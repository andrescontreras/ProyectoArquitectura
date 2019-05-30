/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.RentaErp;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Lenovo
 */
@Stateless
@LocalBean
public class FacadeInteroperabilidadERP {
   @EJB
   RentaErpFacade erpF;
    public void persist(RentaErp r){
        System.out.println("llega a funcion persist");
        RentaErp renta = r;
        System.out.println("declaracion renta");
       // erpF = new RentaErpFacade();
        erpF.crearRentaERP(renta); 
    }
    
}
