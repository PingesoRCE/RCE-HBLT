/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Consulta;
import cl.rcehblt.entities.Diagnostico;
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
public class DiagnosticoFacade extends AbstractFacade<Diagnostico> implements DiagnosticoFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiagnosticoFacade() {
        super(Diagnostico.class);
    }
    
    @Override
    public List<Diagnostico> searchByConsultation(Consulta consulta) {
        Query query;
        query = em.createNamedQuery("Diagnostico.findByConsulta").
                setParameter("consultaid", consulta);
        
        return query.getResultList();
    }
}
