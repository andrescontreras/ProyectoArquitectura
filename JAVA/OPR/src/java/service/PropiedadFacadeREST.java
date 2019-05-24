/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Negocio.PropiedadFacade;
import entities.Propiedad;
import java.util.List;
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
 * @author andre
 */
@Stateless
@Path("entities.propiedad")
public class PropiedadFacadeREST {
   PropiedadFacade p = new PropiedadFacade();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Propiedad entity) {
        
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Short id, Propiedad entity) {
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Short id) {

    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Propiedad find(@PathParam("id") Short id) {
        return null;
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Propiedad> findAll() {
        
       return p.getPropiedades();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Propiedad> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return null;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
       return null;
    }
    
}
