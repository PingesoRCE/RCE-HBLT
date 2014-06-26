/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Solexex;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface SolexexFacadeLocal {

    void create(Solexex solexex);

    void edit(Solexex solexex);

    void remove(Solexex solexex);

    Solexex find(Object id);

    List<Solexex> findAll();

    List<Solexex> findRange(int[] range);

    int count();
    
}
