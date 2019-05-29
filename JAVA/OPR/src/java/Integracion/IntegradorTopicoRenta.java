/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import entities.Renta;
import javax.annotation.Resource;
import javax.ejb.Stateless;
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
@Stateless
public class IntegradorTopicoRenta {

    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Topic")
    private static Topic topic;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void enviarATopico(Renta renta) throws JMSException {
        Connection connection = null;
        Session session = null;
        MessageProducer publisher = null;
        Message message = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            publisher = session.createProducer(topic);
            String mensaje =renta.getId().toString()+","+String.valueOf(renta.getCedulaUsuario())+","+ renta.getEmail()+","+String.valueOf(renta.getPrecioRenta())+","+renta.getFecha().toString() +","+renta.getEstado();
            message = session.createTextMessage(mensaje);
            publisher.send(message);
            System.out.println("Enviando a topico: " + mensaje );
        } finally {
            // Cerramos los recursos
            publisher.close();
            session.close();
            connection.close();
        }

    }
}
