/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.DosisFf;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface DosisFfFacadeLocal {

    void create(DosisFf dosisFf);

    void edit(DosisFf dosisFf);

    void remove(DosisFf dosisFf);

    DosisFf find(Object id);

    List<DosisFf> findAll();

    List<DosisFf> findRange(int[] range);

    int count();
    
}
