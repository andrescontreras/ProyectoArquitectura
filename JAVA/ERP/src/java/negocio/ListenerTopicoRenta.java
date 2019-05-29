/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Renta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Lenovo
 */
@MessageDriven(mappedName = "jms/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "jms/ConnectionFactory"),
    @ActivationConfigProperty(propertyName = "destinationName", propertyValue = "jms/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),})
public class ListenerTopicoRenta implements MessageListener {

    public ListenerTopicoRenta() {

    }

    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
        System.err.println("onMessage");
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                
                String strDatos = msg.getText();
                System.err.println(strDatos);
                StringTokenizer tokens = new StringTokenizer(strDatos, ",");
                Short id = Short.parseShort(tokens.nextToken());
                String cedulaUsuario = tokens.nextToken();
                short idPropiedad = Short.parseShort(tokens.nextToken());
                String email = tokens.nextToken();
                long precioRenta = Long.parseLong(tokens.nextToken());
                Date fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(tokens.nextToken());
                Character estado = tokens.nextToken().charAt(0);
              
                Renta r = new Renta(id,cedulaUsuario,idPropiedad,email,precioRenta,fecha,estado);
                FacadeInteroperabilidadERP f = new FacadeInteroperabilidadERP();
                f.persist(r);
                //    System.out.println("Recibido asincrono [" + msg.getText() + "]");
            } else {
                //   System.err.println("El mensaje no es de tipo texto");
            }
        } catch (JMSException e) {
            System.err.println("JMSException en onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception en onMessage():" + t.getMessage());
        }

    }

}
