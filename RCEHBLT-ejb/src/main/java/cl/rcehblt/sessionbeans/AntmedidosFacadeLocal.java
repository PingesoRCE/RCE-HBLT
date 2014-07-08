/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Antecedentes;
import cl.rcehblt.entities.Antmedidos;
import cl.rcehblt.entities.Episodios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DevelUser
 */
@Local
public interface AntmedidosFacadeLocal {

    void create(Antmedidos antmedidos);

    void edit(Antmedidos antmedidos);

    void remove(Antmedidos antmedidos);

    Antmedidos find(Object id);

    List<Antmedidos> findAll();

    List<Antmedidos> findRange(int[] range);

    int count();
    
    List<Antmedidos> searchByEpisodioGrupo(Episodios episodio, int grupo);

    List<Antmedidos> searchOldestGeneral(Antecedentes idAnt, Episodios idEpisodio);
}
