/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import entities.Renta;
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
    
    public void crearRenta(Renta renta){
        getEntityManager().persist(renta);
        
        
    }
    
}
