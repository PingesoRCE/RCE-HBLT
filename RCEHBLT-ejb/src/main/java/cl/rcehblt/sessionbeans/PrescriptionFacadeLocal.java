/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Prescription;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface PrescriptionFacadeLocal {

    void create(Prescription prescription);

    void edit(Prescription prescription);

    void remove(Prescription prescription);

    Prescription find(Object id);

    List<Prescription> findAll();

    List<Prescription> findRange(int[] range);

    int count();
    
}
