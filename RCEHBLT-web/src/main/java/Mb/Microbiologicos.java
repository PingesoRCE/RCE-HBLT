/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;

/**
 *
 * @author camilo
 */
@Named(value = "microbiologicos")
@RequestScoped
public class Microbiologicos {
    @EJB
    private RegistroClinicoFacadeLocal clinicalrecordsFacade;
    @EJB
    private PacienteFacadeLocal patientsFacade;

    String seso;
    String txt;
    String nombre;
    String edad;
    String ficha;
    String domicilio;
    String prevision;
    String fecha;
    String busca;
    String fono;
    
    public Microbiologicos() {
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
    }*/
    
   /* public void mostrarNombre(){
        String rut = getBusca();

        Patients persona = patientsFacade.find(rut);        
        String datoPersona =persona.getFirstName();
        String datoPersona2 =persona.getLastName();
        String datoPersona3 =persona.getLastName2();
        this.nombre=datoPersona+" "+datoPersona2+" "+datoPersona3;
    }
    
    public void mostrarFecha(){
        
        Calendar fecha2=new GregorianCalendar();
        
        
        this.fecha=fecha2.get(Calendar.DAY_OF_MONTH)+"/"+fecha2.get(Calendar.MONTH)+"/"+fecha2.get(Calendar.YEAR);
    }
    
    public void mostrarDomicilio(){
        String rut = getBusca();
        
        System.out.println("ruuuuuuuuuut: "+rut);
     
        Patients persona = patientsFacade.find(rut);
        if (persona == null) {
            System.out.print("persona no encontrada");
            this.domicilio = "";
            return;
        }
        System.out.println("direccion: "+persona.getAddress());
        String datoPersona = persona.getAddress();
       this.txt=rut;
        this.domicilio=datoPersona;
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
        
        
      
    }
   
   public void mostrarPrevision(){
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll(); 
        Patients pasiente=new Patients();
        Prevision prev = new Prevision();
        for (int i = 0; i < lista.size(); i++) {
            if(rut.equals(lista.get(i).getRut())){
                pasiente = lista.get(i);
                prev = pasiente.getPrevisionid();
            }
        }
      //  List<Prevision> listaPrevision= previsionFacade.findID(pasiente);
     
        this.prevision=prev.getType();
       
        
      
    }
   
    public void mostrarEdad(){
        String rut = getBusca();
        
        
        Patients persona = patientsFacade.find(rut);
        System.out.println("edad: "+persona.getDateOfBirth().toString());
        String datoPersona =persona.getDateOfBirth().toString();
        this.edad=datoPersona;
    }
    
    public void mostrarFono(){
        String rut = getBusca();
        
        
        Patients persona = patientsFacade.find(rut);
        System.out.println("fono: "+persona.getPhone());
        String datoPersona =persona.getPhone();
        this.fono=datoPersona;
    }*/
   
    /*public void botonAct(){
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        if(busca.equals("") || busca==null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "RUN invalido","Ingrese RUN valido" ));
        }
        else{

            try{

            mostrarDomicilio();

            mostrarEdad();

            mostrarFecha();

            mostrarNombre();

            mostrarFicha();

            mostrarPrevision();
            
            mostrarFono();



            context.addMessage(null, new FacesMessage("Successful", "RUN encontrado" ));
            }
            catch(NullPointerException e){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "RUN no encontrado","Ingrese RUN valido" ));
            }
        }
    }*/
    

    public String getSeso() {
        return seso;
    }

    public void setSeso(String seso) {
        this.seso = seso;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
    
    
}
