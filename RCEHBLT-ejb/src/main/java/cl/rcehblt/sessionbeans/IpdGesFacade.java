/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.IpdGes;
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
public class IpdGesFacade extends AbstractFacade<IpdGes> implements IpdGesFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IpdGesFacade() {
        super(IpdGes.class);
    }
    
    @Override
    public List<IpdGes> searchById(int id) {
        Query query;
        query = em.createNamedQuery("IpdGes.findByIdIpd").
                setParameter("idIpd", id);
        
        return query.getResultList();
    }
}
