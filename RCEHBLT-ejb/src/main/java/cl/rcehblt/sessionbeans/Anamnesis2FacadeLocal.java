/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Anamnesis2;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface Anamnesis2FacadeLocal {

    void create(Anamnesis2 anamnesis2);

    void edit(Anamnesis2 anamnesis2);

    void remove(Anamnesis2 anamnesis2);

    Anamnesis2 find(Object id);

    List<Anamnesis2> findAll();

    List<Anamnesis2> findRange(int[] range);

    int count();
    
}
