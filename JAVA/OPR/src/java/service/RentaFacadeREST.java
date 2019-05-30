/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Negocio.RentaFacade;
import entities.ConfirmacionDTO;
import entities.Renta;
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
public class RentaFacadeREST extends AbstractFacade<Renta> {
    @PersistenceContext(unitName = "LogicaOPRPU")
    private EntityManager em;
    
    @EJB
    RentaFacade rentaF;
    public RentaFacadeREST() {
        super(Renta.class);
    }

    @POST
    @Override
    @Consumes({ "application/json"})
    public void create(Renta entity) {
        //super.create(entity); 
        rentaF.crearRenta(entity);
    }
    
    @POST
    @Consumes({"application/json"})
    @Path("confirmar")
    public String confirmar(ConfirmacionDTO confirmacion) {   
        return rentaF.confirmarContrato(confirmacion.getIdPropiedad(), confirmacion.getDocumentoUsuario() );
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Short id, Renta entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Short id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Renta find(@PathParam("id") Short id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Renta> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Renta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
