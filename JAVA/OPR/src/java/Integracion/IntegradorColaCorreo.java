/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integracion;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Lenovo
 */
//@ManagedBean(name = "request")
//@NoneScoped
public class IntegradorColaCorreo implements Serializable {

    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;

    @Resource(mappedName = "jms/Queue")
    private Queue queue;

    /**
     * Creates a new instance of IntegradorColaCorreo
     */
    public IntegradorColaCorreo() {

    }

    public static void sendTestMSg(String msgText) throws NamingException, JMSException {
        QueueConnection queueCon = null;
        try {
            // get the initial context, refer to your app server docs for this
            Context ctx = new InitialContext();

            // get the connection factory, and open a connection
            QueueConnectionFactory qcf = (QueueConnectionFactory) ctx.lookup("jms/ConnectionFactory");
            queueCon = qcf.createQueueConnection();

            // create queue session off the connection
            QueueSession queueSession = queueCon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            // get handle on queue, create a sender and send the message
            Queue queue = (Queue) ctx.lookup("jms/Queue");
            QueueSender sender = queueSession.createSender(queue);

            Message msg = queueSession.createTextMessage(msgText);

            msg.setBooleanProperty("ACK_DEBUG", true);
            msg.setFloatProperty("ACK_BALANCE", 24234.44f);
            sender.send(msg);

            System.out.println("sent the message");
        } finally {
            // close the queue connection
            if (queueCon != null) {
                queueCon.close();
            }
        }
    }
}
