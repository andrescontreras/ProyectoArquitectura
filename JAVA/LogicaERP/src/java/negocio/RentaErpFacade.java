/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.RentaErp;
import integracion.IntegradorBD;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo
 */
@Stateless
public class RentaErpFacade extends AbstractFacade<RentaErp> {
    @PersistenceContext(unitName = "LogicaERPPU")
    private EntityManager em;

    IntegradorBD integrador = new IntegradorBD();
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentaErpFacade() {
        super(RentaErp.class);
    }
    
    public void crearRentaERP(RentaErp renta){
        System.out.println("En rentaerpfacade va a integrador a crear");
        if(em == null){
        System.out.println("El entityManager esta vacio");
        }else{
        integrador.crearRentaERP(em, renta);
        }
        
       
    }
    
}
