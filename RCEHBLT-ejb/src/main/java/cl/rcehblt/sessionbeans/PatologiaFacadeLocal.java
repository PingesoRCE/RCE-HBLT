/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Patologia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface PatologiaFacadeLocal {

    void create(Patologia patologia);

    void edit(Patologia patologia);

    void remove(Patologia patologia);

    Patologia find(Object id);

    List<Patologia> findAll();

    List<Patologia> findRange(int[] range);
    
    List<Patologia> searchByNombre(String nombre);

    int count();
    
    List<Patologia> searchById(String id);
}
