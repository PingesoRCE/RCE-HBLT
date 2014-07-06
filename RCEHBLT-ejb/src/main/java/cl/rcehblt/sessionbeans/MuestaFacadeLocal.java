/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Muesta;
import cl.rcehblt.entities.Paciente;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface MuestaFacadeLocal {

    void create(Muesta muesta);

    void edit(Muesta muesta);

    void remove(Muesta muesta);

    Muesta find(Object id);

    List<Muesta> findAll();

    List<Muesta> findRange(int[] range);

    int count();
    
    List<Muesta> searchByPatientAndDate(Paciente patient, Date fecha);

    List<Muesta> searchByPatient(Paciente patient);

    List<Muesta> searchByPatientGroup(Paciente patient, int group);
}
