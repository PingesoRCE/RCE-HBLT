/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Consulta;
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
public class ConsultaFacade extends AbstractFacade<Consulta> implements ConsultaFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultaFacade() {
        super(Consulta.class);
    }
    
    @Override
    public List<Consulta> searchByEpisodio(Episodios episodio) {
        Query query;
        query = em.createNamedQuery("Consulta.findByEpisodio").
                setParameter("episodioid", episodio);
        
        return query.getResultList();
    }
}
