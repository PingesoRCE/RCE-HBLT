/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author camilo
 */
@ManagedBean
@SessionScoped
public class Login {
    
    
    public static String user;
    public static String contrasena;
    String apellido;
    boolean verificacion;
    

    public boolean isVerificacion() {
        return verificacion;
    }

    public void setVerificacion(boolean verificacion) {
        this.verificacion = verificacion;
    }
   
    public Login() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    
    /*public void validacion() throws IOException{
        String usuario=getUser();
        String pass=getContrasena();
        FacesContext context = FacesContext.getCurrentInstance();
        
        
        
        if(prof.getFirstName().equals(pass)){
            context.addMessage(null, new FacesMessage("Welcome" +user+""+apellido, getUser() ));
            this.apellido = prof.getLastName();
            FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
            
            
        }
        else{
             context.addMessage(null, new FacesMessage("Usuario Invalido", "Verificar usuario o contraseña" ));
        }
        
    }*/
    
}
