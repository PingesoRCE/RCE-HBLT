/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author DevelUser
 */
@ManagedBean
@SessionScoped
public class Index {

    private int rut;
    
    public Index() {
    }
    
    public void redirigirAdministrador(){
        
    }
    
    public void redirigirAdmisionista(){
        
    }
    
    public void redirigirDoctor(){
        
    }
    
    public void redirigirTecnico(){
        
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }    
}
