/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import entities.Renta;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lenovo
 */
@ManagedBean(name = "request")
@NoneScoped
public class IntegradorTopicoRenta implements Serializable {

    @Resource(mappedName = "jms/Topic")
    private Topic topic;
    @Resource(mappedName = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;
    /**
     * Creates a new instance of IntegradorTopicoRenta2
     */
    
    public IntegradorTopicoRenta() {
        
    }

    public static void enviarATopico(Renta renta) throws NamingException, JMSException {
        TopicConnection topicCon = null;
        try {
            // get the initial context, refer to your app server docs for this
            Context ctx = new InitialContext();

            // get the connection factory, and open a connection
            TopicConnectionFactory tcf = (TopicConnectionFactory) ctx.lookup("jms/ConnectionFactory");
            topicCon = tcf.createTopicConnection();

            // create queue session off the connection
            TopicSession topicSession = topicCon.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            // get handle on queue, create a sender and send the message
            Topic topic = (Topic) ctx.lookup("jms/Topic");
            MessageProducer publisher = topicSession.createProducer(topic);
         // TopicSender sender = topicSession.createSender(topic);
            String mensaje ="94"+","+String.valueOf(renta.getCedulaUsuario())+","+ renta.getEmail()+","+String.valueOf(renta.getIdPropiedad())+","+String.valueOf(renta.getPrecioRenta())+","+renta.getFecha().toString() +","+renta.getEstado()+","+renta.getFechaRenta().toString();
            Message msg = topicSession.createTextMessage(mensaje);
            msg.setBooleanProperty("ACK_DEBUG", true);
            msg.setFloatProperty("ACK_BALANCE", 24234.44f);
            publisher.send(msg);

            System.out.println("sent the message");
        } finally {
            // close the queue connection
            if (topicCon != null) {
                topicCon.close();
            }
        }
    }
    
}
