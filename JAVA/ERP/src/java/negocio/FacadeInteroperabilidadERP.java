/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.RentaErp;
import integracion.RentaErpJpaController;
import integracion.exceptions.RollbackFailureException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
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

    public void persist(RentaErp r){
   
      
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SideCarERPPU");
            RentaErpJpaController control= new RentaErpJpaController(emf);
            RentaErp renta = r;
            control.create(renta);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(FacadeInteroperabilidadERP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacadeInteroperabilidadERP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
}
