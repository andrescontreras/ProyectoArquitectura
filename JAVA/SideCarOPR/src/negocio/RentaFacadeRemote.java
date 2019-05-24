/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entities.Renta;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author santi
 */
@Remote
public interface RentaFacadeRemote {

    void create(Renta renta);

    void edit(Renta renta);

    void remove(Renta renta);

    Renta find(Object id);

    List<Renta> findAll();

    List<Renta> findRange(int[] range);

    int count();
    
}
