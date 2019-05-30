/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import entities.Renta;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

/**
 *
 * @author Lenovo
 */

public class IntegradorTopicoRenta implements Serializable {

    @Resource(mappedName = "jms/Topic")
    private Topic topic;
    @Resource(mappedName = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;
   

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void enviarATopico(Renta renta) throws JMSException {
        
        Connection connection = null;
        Session session = null;
        
        Message message;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(topic);
            String mensaje =renta.getId().toString()+","+String.valueOf(renta.getCedulaUsuario())+","+ renta.getEmail()+","+String.valueOf(renta.getPrecioRenta())+","+renta.getFecha().toString() +","+renta.getEstado();
            message = session.createTextMessage(mensaje);
            publisher.send(message);
            System.out.println("Enviando a topico: " + mensaje );
        } finally {
            // Cerramos los recursos
           
        }

    }
}
