/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author GrupoZero
 */


@Stateless
public class TimerSuperRenta {
    
    @EJB
    RentaSuperFacade f;
    
    
    @Schedule(dayOfWeek = "Mon-Sat", month = "*", hour = "0-23", dayOfMonth = "*", year = "*", minute = "*", second = "50", persistent = true)
    
    public void myTimer() throws Exception {
        System.out.println("Timer event: " + new Date());
        f.consultarRentas();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
