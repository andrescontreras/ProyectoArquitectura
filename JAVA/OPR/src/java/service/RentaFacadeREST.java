/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Negocio.RentaFacade;
import entities.AprobacionDTO;
import entities.Renta;
import entities.TransaccionDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author santi
 */
@Stateless
@Path("renta")
public class RentaFacadeREST {

    
    @EJB
    RentaFacade rentaF;
    public RentaFacadeREST() {}

    @POST
    @Consumes({ "application/json"})
    public AprobacionDTO create(TransaccionDTO entity) {
        //super.create(entity); 
        return rentaF.crearRenta(entity);
    }

    @GET
    @Produces({"application/json"})
    public List<Renta> findAll() {
        return rentaF.mostrarRentas();
    }
    
}
