/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Farmaco;
import cl.rcehblt.entities.FfFarmaco;
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
public class FfFarmacoFacade extends AbstractFacade<FfFarmaco> implements FfFarmacoFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FfFarmacoFacade() {
        super(FfFarmaco.class);
    }
    
    @Override
    public List<FfFarmaco> findId(int idfarmaco) {
        Query q=em.createNamedQuery("FfFarmaco.findByFarmacoId").setParameter("farmacoId", idfarmaco);
        return q.getResultList();
    }
    
    @Override
    public List<FfFarmaco> findFarmacoId(Farmaco remedio) {
        Query q=em.createNamedQuery("FfFarmaco.findByFarmacoId").setParameter("farmacoId", remedio);
        return q.getResultList();
    }
    
}
