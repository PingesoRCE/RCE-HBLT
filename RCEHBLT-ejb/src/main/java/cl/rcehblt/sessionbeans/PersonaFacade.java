/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Persona;
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
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    @Override
    public Integer findByRut(Integer rut) {
        List<Persona> searchPerson;
        Query query;
        query = em.createNamedQuery("Persona.findByPersRut").
                setParameter("persRut", rut);
        
        searchPerson = query.getResultList();
        
        return searchPerson.get(0).getIdPersona();
    }
    
    @Override
    public List<Persona> findByRutPerson(Integer rut) {
        List<Persona> searchPerson;
        Query query;
        query = em.createNamedQuery("Persona.findByPersRut").
                setParameter("persRut", rut);
        
        searchPerson = query.getResultList();
        
        return searchPerson;
    }    
}
