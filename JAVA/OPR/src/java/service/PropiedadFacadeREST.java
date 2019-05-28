/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Negocio.PropiedadFacade;
import entities.Propiedad;
import entities.TransaccionDTO;
import java.math.BigDecimal;
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
 * @author andre
 */
@Stateless
@Path("entities.propiedad")
public class PropiedadFacadeREST {
    @EJB
    PropiedadFacade propFacade ;

    @POST
    @Consumes({"application/json"})
    public void create(Propiedad entity) {
        propFacade.crearPropiedad(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Short id, Propiedad entity) {
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Short id) {

    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Propiedad find(@PathParam("id") Short id) {
        return propFacade.getPropiedad(id);
    }
    
    @GET
    @Produces({"application/json"})
    public List<Propiedad> obtenerPropiedades(){
        return propFacade.getPropiedades();
    }

    @GET
    @Path("nombre/{nombre}")
    @Produces({"application/json"})
    public List<Propiedad> obtenerPropiedadesxNombre(@PathParam("nombre") String nombre) {
        return propFacade.getPropiedadesxNombre(nombre);
    }

    @GET
    @Path("cedula/{cedula}")
    @Produces({"application/json"})
    public List<Propiedad> obtenerPropiedadesxCedula(@PathParam("cedula") BigDecimal cedula) {

        return propFacade.getPropiedadesxCedula(cedula);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
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
