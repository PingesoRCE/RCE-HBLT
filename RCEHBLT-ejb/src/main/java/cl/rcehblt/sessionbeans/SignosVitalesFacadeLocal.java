/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.SignosVitales;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface SignosVitalesFacadeLocal {

    void create(SignosVitales signosVitales);

    void edit(SignosVitales signosVitales);

    void remove(SignosVitales signosVitales);

    SignosVitales find(Object id);

    List<SignosVitales> findAll();

    List<SignosVitales> findRange(int[] range);

    int count();
    
}
