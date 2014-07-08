/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.DosisFf;
import cl.rcehblt.entities.FormaFarmaceutica;
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
public class DosisFfFacade extends AbstractFacade<DosisFf> implements DosisFfFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DosisFfFacade() {
        super(DosisFf.class);
    }
    @Override
   public List<DosisFf> findDosisId(FormaFarmaceutica remedio) {
        Query q=em.createNamedQuery("DosisFf.findByFormaFarmaceuticaId").setParameter("ff", remedio);
        return q.getResultList();
    }
}
