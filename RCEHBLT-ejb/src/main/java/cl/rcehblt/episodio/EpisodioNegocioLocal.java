/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.episodio;

import cl.rcehblt.entities.Episodios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface EpisodioNegocioLocal {
    public List<Episodios> busquedaEpisodioIdPersona(int idPersona);
}
