/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.IpdGes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface IpdGesFacadeLocal {

    void create(IpdGes ipdGes);

    void edit(IpdGes ipdGes);

    void remove(IpdGes ipdGes);

    IpdGes find(Object id);

    List<IpdGes> findAll();

    List<IpdGes> findRange(int[] range);

    List<IpdGes> searchById(int id);
    
    int count();
    
}
