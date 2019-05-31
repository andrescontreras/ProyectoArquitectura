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
    
    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "9-19", dayOfMonth = "*", year = "*", minute = "*", second = "0", persistent = false)
    
    public void myTimer() throws InterruptedException, ExecutionException {
        System.out.println("Timer event: " + new Date());
        this.getRentasCliente();
    }

    @Asynchronous
    public void getRentasCliente() throws InterruptedException, ExecutionException
    {
        
        Future<List<Propiedad>> p =  f.getPropiedadesxCliente(new BigDecimal(1018));
        List<Propiedad> res = p.get();
        System.out.println(res.size());
        for (Propiedad actual: res)
            System.out.println(actual.toString());
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
