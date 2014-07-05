/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.registroclinico;

import cl.rcehblt.entities.RegistroClinico;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DevelUser
 */
@Stateless
public class RegistroClinicoNegocio implements RegistroClinicoNegocioLocal {

    @PersistenceContext(unitName = "cl_RCEHBLT-ejb_ejb_0.1PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public RegistroClinico busquedaIdPersona(int idPersona){
        Query q = em.createNamedQuery("RegistroClinico.findByIdPersona");
        q.setParameter("idPersona", idPersona);
        List<RegistroClinico> res = q.getResultList();
        if (res.isEmpty()) {
            return null;
        }
        else {
            return res.get(0);
        }        
    }
}
