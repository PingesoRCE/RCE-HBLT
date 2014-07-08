/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mb;


//import entity.Professionals;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import session.ProfessionalsFacadeLocal;


/**
 *
 * @author lol
 */
@Named(value = "loginSessionMB")
@SessionScoped
public class LoginSessionMB implements Serializable {
    
    //@EJB
    //private ProfessionalsFacadeLocal professionalsFacade;
    
    @Inject
    LoginMB login;
    
    private String rut, nombre, contrasena,apellido,rutPaciente;
    private int ficha;
    
    public LoginSessionMB() {
    }

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LoginMB getLogin() {
        return login;
    }

    public void setLogin(LoginMB login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }



    public void login(String rutt, String password) throws IOException {
        System.out.println(rutt);
        
        if(password.equals("Jorge")){
            rut= rutt;
            contrasena = password;
            nombre = "Joel";
            apellido = "Ávalos";
            ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
            context2.redirect(context2.getRequestContextPath() + "/faces/doctor/index.xhtml");
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de inicio", "Usuario o contraseña inválidos"));
        }
        
    }
    
    private boolean error = false;

    public void logout() throws IOException {
       
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getRutPaciente() {
        return rutPaciente;
    }

    public void setRutPaciente(String rutPaciente) {
        this.rutPaciente = rutPaciente;
    }
   
    
}
