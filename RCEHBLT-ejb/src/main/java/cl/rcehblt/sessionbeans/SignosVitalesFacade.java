/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.SignosVitales;
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
public class SignosVitalesFacade extends AbstractFacade<SignosVitales> implements SignosVitalesFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SignosVitalesFacade() {
        super(SignosVitales.class);
    }
    
    @Override
    public List<SignosVitales> searchById(int id) {
        Query query;
        query = em.createNamedQuery("SignosVitales.findByIdSvitales").
                setParameter("idSvitales", id);
        
        return query.getResultList();
    }

    @Override
    public List<SignosVitales> searchByName(String nombre) {
        Query query;
        query = em.createNamedQuery("SignosVitales.findByNombreSvital").
                setParameter("nombreSvital", nombre);
        
        return query.getResultList();
    }
}
