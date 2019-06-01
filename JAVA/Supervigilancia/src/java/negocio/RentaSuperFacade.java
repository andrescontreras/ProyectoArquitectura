/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.RentaSuper;
import integracion.IntegracionBD;
import integracion.ProxyRentas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GrupoZero
 */
@Stateless
public class RentaSuperFacade extends AbstractFacade<RentaSuper> {
    @PersistenceContext(unitName = "SuperintendeciaDeVigilanciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RentaSuperFacade() {
        super(RentaSuper.class);
    }
    
    IntegracionBD ibd = new IntegracionBD();
    ProxyRentas proxy = new ProxyRentas();
    
    public void consultarRentas() throws IOException, Exception
    {
        System.out.println("ENTRE A LA FACHADA");
        List<RentaSuper> rentas = new ArrayList<>();
        //proxy.hola();
        rentas = proxy.cosultarRentas();
        //System.out.println(rentas.size());
        for (RentaSuper r: rentas)
        {
            System.out.println(r.getId());
            //ibd.persistRentas(em, r);
            em.persist(r);
        }
    }
    
}
