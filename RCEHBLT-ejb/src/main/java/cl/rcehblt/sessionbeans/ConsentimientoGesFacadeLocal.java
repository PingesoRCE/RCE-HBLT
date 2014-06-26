/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.ConsentimientoGes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface ConsentimientoGesFacadeLocal {

    void create(ConsentimientoGes consentimientoGes);

    void edit(ConsentimientoGes consentimientoGes);

    void remove(ConsentimientoGes consentimientoGes);

    ConsentimientoGes find(Object id);

    List<ConsentimientoGes> findAll();

    List<ConsentimientoGes> findRange(int[] range);

    int count();
    
}
