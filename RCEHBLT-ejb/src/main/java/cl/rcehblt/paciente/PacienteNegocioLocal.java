/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.paciente;

import cl.rcehblt.entities.Paciente;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface PacienteNegocioLocal {
    public Paciente busquedaPacienteIdPersona(int id);
}

