/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import cl.rcehblt.entities.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import java.util.Date;
import java.util.Calendar;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import cl.rcehblt.sessionbeans.*;

/**
 *
 * @author camilo
 */
@Named(value = "glicemia")
@RequestScoped
public class Glicemia {
    @EJB
    private RegistroClinicoFacadeLocal clinicalrecordsFacade;
    @EJB
    private PacienteFacadeLocal patientsFacade;
    
    
    
            

    String busca;
    String txt;
    String ayuna;
    String nombre;
    String fechaC;
   
    private Date fecha;
    String ficha;
    
    public Glicemia() {
    }
    
    /*public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        List<Patients> lista = patientsFacade.findAll();
        
        for (int i = 0; i < lista.size(); i++) {
           String rut=lista.get(i).getRut();
           
         if(rut.startsWith(query)){
                System.out.println(rut);
               results.add(rut);
          }
            
            
        }
         
        return results;
    }
    
    public void mostrarFicha(){
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll(); 
        Patients pasiente=new Patients();
        System.out.println("shiiiiiit");
        for (int i = 0; i < lista.size(); i++) {
            if(rut.equals(lista.get(i).getRut()))
                pasiente = lista.get(i);
        }
        List<Clinicalrecords> listaClinical= clinicalrecordsFacade.findRut(pasiente);
        System.out.println("hoooolaaaaa");
        System.out.println("ficha: "+listaClinical.get(0).getCrecid().toString());
        this.ficha=listaClinical.get(0).getCrecid().toString();
        this.txt=getBusca();
        
      
    }
    
    public void mostrarNombre(){
        String rut = getBusca();

        Patients persona = patientsFacade.find(rut);        
        String datoPersona =persona.getFirstName();
        String datoPersona2 =persona.getLastName();
        String datoPersona3 =persona.getLastName2();
        this.nombre=datoPersona+" "+datoPersona2+" "+datoPersona3;
    }*/
    
    
    
    /*public void botonAct(){
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        if(busca.equals("") || busca==null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "RUN invalido","Ingrese RUN valido" ));
        }
        else{

            try{


            mostrarNombre();

            mostrarFicha();


            context.addMessage(null, new FacesMessage("Successful", "RUN encontrado" ));
            }
            catch(NullPointerException e){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "RUN no encontrado","Ingrese RUN valido" ));
            }
        }
    }*/

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getAyuna() {
        return ayuna;
    }

    public void setAyuna(String ayuna) {
        this.ayuna = ayuna;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }
    
    
    
    
}
