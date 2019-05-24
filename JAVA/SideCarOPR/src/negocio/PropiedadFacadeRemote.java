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

/**
 *
 * @author santi
 */
@Remote
public interface PropiedadFacadeRemote {

    void create(Propiedad propiedad);

    void edit(Propiedad propiedad);

    void remove(Propiedad propiedad);

    Propiedad find(Object id);

    List<Propiedad> findAll();

    List<Propiedad> findRange(int[] range);

    int count();
    
    List<Propiedad> buscarPropiedades();
    List<Propiedad> buscarPropiedadxNombre(String nombre);
    List<Propiedad> buscarPropiedadxCedula(BigDecimal cedula);
    
}
