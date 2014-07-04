/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.profesional;

import cl.rcehblt.entities.Profesional;
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
public class ProfesionalNegocio implements ProfesionalNegocioLocal {
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
    public Profesional busquedaProfesionalIdPersona(int id) {
        System.out.println("el id de la persona es: " + id);
        Query q = em.createNamedQuery("Profesional.findByIdPersona");
        q.setParameter("idPersona", id);
        List<Profesional> res = q.getResultList();
        if (res.isEmpty()) {
            System.out.println("soy null");
            return null;
        }
        else {
            return res.get(0);
        }
      //nadaaa  
    }

    @Override
    public List<Profesional> busquedaProfesionalSubespecialidad(int id){
        Query q = em.createNamedQuery("Profesional.findByProfeSubespecialidad");
        q.setParameter("profeSubespecialidad", id);
        return q.getResultList();
    }
    
    @Override
    public List<Profesional> busquedaProfesionalEspecialidad(int id){
        Query q = em.createNamedQuery("Profesional.findByProfeEspecialidad");
        q.setParameter("profeEspecialidad", id);
        return q.getResultList();
    }
    
}
