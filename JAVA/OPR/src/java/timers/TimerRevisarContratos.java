/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timers;

/**
 *
 * @author USUARIO
 */


import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import entities.Renta;
import Negocio.RentaFacade;
import javax.ejb.EJB;

@Singleton
@LocalBean
@Startup
public class TimerRevisarContratos {
 
    @Resource
    private TimerService timerService;
    @EJB
    RentaFacade r = new RentaFacade();
    @PostConstruct
    private void init() {
        timerService.createTimer(10000, 2000000000, "IntervalTimerDemo_Info");
    }
 
    @Timeout
    public void execute(Timer timer) {    
        r.revisarContratos();
    }
}