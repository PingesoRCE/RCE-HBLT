/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.RegistroClinico;
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
public class RegistroClinicoFacade extends AbstractFacade<RegistroClinico> implements RegistroClinicoFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroClinicoFacade() {
        super(RegistroClinico.class);
    }
    
    @Override
    public List<RegistroClinico> searchByPaciente(Paciente paciente) {
        Query query;
        query = em.createNamedQuery("RegistroClinico.findByPaciente").
                setParameter("idPersona", paciente);

        return query.getResultList();
    }
}
