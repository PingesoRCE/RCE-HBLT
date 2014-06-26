/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Interna;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface InternaFacadeLocal {

    void create(Interna interna);

    void edit(Interna interna);

    void remove(Interna interna);

    Interna find(Object id);

    List<Interna> findAll();

    List<Interna> findRange(int[] range);

    int count();
    
}
