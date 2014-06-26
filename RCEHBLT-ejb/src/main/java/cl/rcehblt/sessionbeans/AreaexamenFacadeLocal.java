/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Areaexamen;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface AreaexamenFacadeLocal {

    void create(Areaexamen areaexamen);

    void edit(Areaexamen areaexamen);

    void remove(Areaexamen areaexamen);

    Areaexamen find(Object id);

    List<Areaexamen> findAll();

    List<Areaexamen> findRange(int[] range);

    int count();
    
}
