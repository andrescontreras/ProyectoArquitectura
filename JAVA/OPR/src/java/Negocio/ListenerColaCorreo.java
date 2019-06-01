/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Integracion.IntegradorCorreo;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Lenovo
 */
@MessageDriven(mappedName = "jms/Queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "jms/ConnectionFactory"),
    @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "addressList", propertyValue = "10.192.12.30"),
})
public class ListenerColaCorreo implements MessageListener {

    @EJB
    IntegradorCorreo correo; 
    public ListenerColaCorreo() {
    }
    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        System.err.println("onMessage - Cola");

        if (message instanceof TextMessage) {
            try {
                msg = (TextMessage) message;
                String strDatos = msg.getText();
                System.err.println(strDatos);
                StringTokenizer tokens = new StringTokenizer(strDatos, ",");
                String toEmail = tokens.nextToken();
                String subject = tokens.nextToken();
                String mensaje = tokens.nextToken();
                correo.enviarCorreo(toEmail, subject, mensaje);
            } catch (JMSException ex) {
                Logger.getLogger(ListenerColaCorreo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
}
