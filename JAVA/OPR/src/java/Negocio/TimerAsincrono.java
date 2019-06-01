/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entities.Propiedad;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author imroo
 */
@Stateless
public class TimerAsincrono {

    @EJB
    PropiedadFacade f;
    
    @Schedule(dayOfWeek = "Mon-Sat", month = "*", hour = "0-23", dayOfMonth = "*", year = "*", minute = "*", second = "35", persistent = false)
    
    public void myTimer() throws InterruptedException, ExecutionException {
        System.out.println("Timer event: " + new Date());
        this.getRentasCliente();
    }

    @Asynchronous
    public void getRentasCliente() throws InterruptedException, ExecutionException
    {
        System.out.println("Soy asincrono");
        Future<List<Propiedad>> p =  f.getPropiedadesxCliente(new BigDecimal(900));
        List<Propiedad> res = p.get();
        System.out.println(res.size());
        System.out.println("===========================");
        System.out.println("===========================");
        for (Propiedad actual: res)
            System.out.println(actual.toString());
            
        System.out.println("===========================");
        System.out.println("===========================");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
