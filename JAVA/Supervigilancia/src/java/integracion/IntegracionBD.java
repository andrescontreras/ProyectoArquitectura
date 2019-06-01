/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion;

import entities.RentaSuper;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author GrupoZero
 */
@Stateless
public class IntegracionBD {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void persistRentas(EntityManager em, RentaSuper r)
    {
        em.persist(r);
    }
}
