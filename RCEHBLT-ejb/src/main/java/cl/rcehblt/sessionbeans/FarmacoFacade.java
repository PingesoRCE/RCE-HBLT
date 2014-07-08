/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

import cl.rcehblt.entities.Farmaco;
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
public class FarmacoFacade extends AbstractFacade<Farmaco> implements FarmacoFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;
    private Object entrada;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FarmacoFacade() {
        super(Farmaco.class);
    }
    @Override
     public List<Farmaco> findNombre(String buscaFarmaco){
         Query q=em.createNamedQuery("Farmaco.findByNombrefarmaco").setParameter("nombrefarmaco", entrada);
        return q.getResultList();
     }
    
}
