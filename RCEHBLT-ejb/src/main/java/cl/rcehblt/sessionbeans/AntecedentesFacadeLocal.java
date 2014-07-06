/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Antecedentes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface AntecedentesFacadeLocal {

    void create(Antecedentes antecedentes);

    void edit(Antecedentes antecedentes);

    void remove(Antecedentes antecedentes);

    Antecedentes find(Object id);

    List<Antecedentes> findAll();

    List<Antecedentes> findRange(int[] range);

    int count();
    
    List<Antecedentes> searchByName(String nombre);
}
