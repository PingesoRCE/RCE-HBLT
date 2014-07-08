/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.sessionbeans;

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
public class FormaFarmaceuticaFacade extends AbstractFacade<FormaFarmaceutica> implements FormaFarmaceuticaFacadeLocal {
    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FormaFarmaceuticaFacade() {
        super(FormaFarmaceutica.class);
    }
    @Override
    public List<FormaFarmaceutica> findFormId(int remedio) {
    Query q=em.createNamedQuery("FormaFarmaceutica.findByFormafarmaceuticaid").setParameter("formafarmaceuticaid", remedio);
    return q.getResultList();
    }
     @Override
        public List<FormaFarmaceutica> findNombreFF(String entrada) {
        Query q=em.createNamedQuery("FormaFarmaceutica.findByNombreFf").setParameter("nombreFf", entrada);
        return q.getResultList();
        
    }
    
}
