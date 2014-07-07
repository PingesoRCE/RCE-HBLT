/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Antmedidos;
import cl.rcehblt.entities.Episodios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DevelUser
 */
@Stateless
public class AntmedidosFacade extends AbstractFacade<Antmedidos> implements AntmedidosFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntmedidosFacade() {
        super(Antmedidos.class);
    }
    
    @Override
    public List<Antmedidos> searchByEpisodioGrupo(Episodios episodio, int grupo) {
        Query query;
        query = em.createNamedQuery("Antmedidos.findByEpisodioGrupo").
                setParameter("episodioid", episodio).
                setParameter("grupo", grupo);
        
        return query.getResultList();
    }

    @Override
    public List<Antmedidos> searchOldestGeneral(int idAnt, Episodios idEpisodio) {
        Query query;
        query = em.createNamedQuery("Antmedidos.findByIdAntmedidosFechaEpisodio").
                setParameter("idAntmedidos", idAnt).
                setParameter("episodioid", idEpisodio);
        return query.setMaxResults(1).getResultList();
    }
    
    
}
