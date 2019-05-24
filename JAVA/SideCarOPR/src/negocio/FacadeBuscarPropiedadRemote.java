/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Propiedad;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *
 * @author santi
 */
@Remote
public interface FacadeBuscarPropiedadRemote {
    public List<Propiedad> buscarPropiedadxNombre(String nombre,EntityManager em);
    
    public List<Propiedad> buscarPropiedadxCedula(BigDecimal cedula,EntityManager em);

    public List<Propiedad> buscarPropiedades(EntityManager em);
}
