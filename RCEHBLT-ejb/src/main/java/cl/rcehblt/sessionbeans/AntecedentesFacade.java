/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Antecedentes;
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
public class AntecedentesFacade extends AbstractFacade<Antecedentes> implements AntecedentesFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentesFacade() {
        super(Antecedentes.class);
    }
    
    @Override
    public List<Antecedentes> searchByName(String nombre) {
        Query query;
        query = em.createNamedQuery("Antecedentes.findByNombreAntecedente").
                setParameter("nombreAntecedente", nombre);
        
        return query.getResultList();
    }
}
