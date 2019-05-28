/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Negocio.RentaFacade;
import entities.Propiedad;
import entities.Renta;
import entities.TransaccionDTO;
import java.util.Calendar;
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
 * @author santi
 */
@Stateless
@Path("renta")
public class RentaFacadeREST {
    RentaFacade facadeR = new RentaFacade();

    @POST
    @Consumes({"application/json"})
    public void crearRenta(TransaccionDTO entity) {
        Renta renta = new Renta();
        renta.setCedulaUsuario(entity.getNumDocumento());
        renta.setEmail(entity.getEmail());
        //renta.setEstado(Character.MIN_VALUE);
        renta.setEstado('0');
        Calendar calDate = Calendar.getInstance();
        java.sql.Date sqlDate = new java.sql.Date(calDate.getTimeInMillis());
        renta.setFecha(sqlDate);
        System.out.println("Esto es la fecha en sql que se manda "+sqlDate);
        renta.setFechaRenta(sqlDate);
        renta.setPrecioRenta(entity.getDescontar());
        Propiedad propi =  new Propiedad();
        propi.setCedulaOwner(123);
        propi.setDescripcion("Descripcion");
        propi.setDireccion("Direccion");
        propi.setLocalidad("Localidad");
        propi.setNombre("Nombre");
        propi.setNombreOwner("NombreOwner");
        propi.setNumCuartos((short)1);
        propi.setPrecio(190);
        propi.setRentada('0');
        propi.setTipo("Tipo");
        propi.setTipoCedula("TipoCedula");
        facadeR.crearRenta(propi);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Short id, Renta entity) {
        
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Short id) {
        
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Renta find(@PathParam("id") Short id) {
        return null;
    }
    
}
