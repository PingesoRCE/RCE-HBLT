/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Externa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface ExternaFacadeLocal {

    void create(Externa externa);

    void edit(Externa externa);

    void remove(Externa externa);

    Externa find(Object id);

    List<Externa> findAll();

    List<Externa> findRange(int[] range);

    int count();
    
}
