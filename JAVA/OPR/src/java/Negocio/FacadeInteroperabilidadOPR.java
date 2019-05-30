/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;


import Integracion.IntegradorTopicoRenta;
import entities.Renta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.naming.NamingException;

/**
 *
 * @author Lenovo
 */
@Stateless
public class FacadeInteroperabilidadOPR {
   

    private final IntegradorTopicoRenta integradorTopicoRenta;
    public FacadeInteroperabilidadOPR(){
        integradorTopicoRenta = new IntegradorTopicoRenta();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void InformarSistemaERP(Renta renta){
        try {
            try {
                integradorTopicoRenta.enviarATopico(renta);
            } catch (NamingException ex) {
                Logger.getLogger(FacadeInteroperabilidadOPR.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JMSException ex) {
            Logger.getLogger(FacadeInteroperabilidadOPR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
