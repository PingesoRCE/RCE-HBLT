/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.RegistroClinico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface RegistroClinicoFacadeLocal {

    void create(RegistroClinico registroClinico);

    void edit(RegistroClinico registroClinico);

    void remove(RegistroClinico registroClinico);

    RegistroClinico find(Object id);

    List<RegistroClinico> findAll();

    List<RegistroClinico> findRange(int[] range);

    int count();
    
    List<RegistroClinico> searchByPaciente(Paciente idPaciente);
}
