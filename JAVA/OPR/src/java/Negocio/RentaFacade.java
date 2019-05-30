/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entities.AprobacionDTO;
import entities.Renta;
import entities.TransaccionDTO;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author santi
 */
@Stateless
public class RentaFacade extends AbstractFacade<Renta> {
    @PersistenceContext(unitName = "LogicaOPRPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentaFacade() {
        super(Renta.class);
    }
    
    public AprobacionDTO crearRenta(TransaccionDTO renta){
        //getEntityManager().persist(renta);
        AprobacionDTO aprob = new AprobacionDTO();
        aprob.setEstado(2);
        Date date= new Date();
        aprob.setFechaAprobacion(date);
        aprob.setNumAprobacion(123);
        return aprob;
        
    }
    
}
