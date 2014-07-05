/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.registroclinico;

import cl.rcehblt.entities.RegistroClinico;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface RegistroClinicoNegocioLocal {
    public RegistroClinico busquedaIdPersona(int idPersona);
}
