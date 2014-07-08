/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;




@ManagedBean
@RequestScoped
public class RecetaIntMb {
    
    //@Inject
    //LoginSessionMB session;
    
    
    @EJB
    private FormaFarmaceuticaFacadeLocal formaFarmaceuticaFacade;
    @EJB
    private FfFarmacoFacadeLocal ffFarmacoFacade;
    @EJB
    private FarmacoFacadeLocal farmacoFacade;

    @EJB
    private PrevisionFacadeLocal previsionFacade;
    
    
    @EJB
    private RegistroClinicoFacadeLocal clinicalrecordsFacade;
    @EJB
    private PacienteFacadeLocal patientsFacade;
    
    String txt;
    String edad;
    String nombre;
    String domicilio;
    String ciudad;
    String fecha;
    String ficha;
    String prevision;
    Date date;
    String busca;
    String buscaFarmaco;
    List<String> formaFarm;
    List<String> dosis;
    String ff;
    String dosis2;
    String rpta;
    String unidades;
    String periodo;
    String descripcion;
    String fechaNac;
    List<datosReceta> recetaa = new ArrayList<datosReceta>();
    
    
    
    
    
    
    public RecetaIntMb() {
        
    }
    
    
    /*public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        List<Paciente> lista = patientsFacade.findAll();
        
        for (int i = 0; i < lista.size(); i++) {
           String rut=lista.get(i).getRut();
           
         if(rut.startsWith(query)){
                System.out.println(rut);
               results.add(rut);
          }
            
            
        }
         
        return results;
    }*/
    
    
    public List<String> complete2(String query) {
        List<String> results = new ArrayList<String>();
        List<Farmaco> lista = farmacoFacade.findAll();
        
        for (int i = 0; i < lista.size(); i++) {
           String nombre=lista.get(i).getNombrefarmaco();
           
         if(nombre.startsWith(query)){
                System.out.println(nombre);
               results.add(nombre);
          }
            
            
        }
         
        return results;
    }
    
    
    
    /*public void mostrarEdad(){
        String rut = getBusca();
        
        
        Paciente persona = patientsFacade.find(rut);
        System.out.println("direccion: "+persona.getDateOfBirth().toString());
        String datoPersona =persona.getDateOfBirth().toString();
        this.edad=datoPersona;
    }*/
   
    public void mostrarForma(){
        System.out.println("nada: "+ getBuscaFarmaco());
        System.out.println("lala: "+buscaFarmaco);
        List<Farmaco> farmaco = farmacoFacade.findNombre(buscaFarmaco);
        
        //System.out.println(farmaco.getNombrefarmaco());
        List<String> results = new ArrayList<String>();
        System.out.println("tamano: "+farmaco);
        
       
        
        
        
        List<FfFarmaco> listaff = ffFarmacoFacade.findFarmacoId(farmaco.get(0));
        System.out.println("fFfarmaco: "+listaff);
        //System.out.println("fff: "+listaff);
        
        /*System.out.println(listaff.get(0).getFormafarmaceuticaid());
        
        
        
        for(int i=0;i<listaff.size();i++){
            FormaFarmaceutica listaFormFarm=listaff.get(i).getFormafarmaceuticaid();
            results.add(listaFormFarm.getNombreFf());
           
        
        }
         System.out.println(results);
        
         this.formaFarm=results;
    }
    
    public void mostrarDosis(){
        System.out.println("lalalalalalalalalalalalalalalala: "+ getFf());
        System.out.println("lala: "+ff);
        List<FormaFarmaceutica> formaFarmaceutica = formaFarmaceuticaFacade.findNombreFF(ff);
        System.out.println("holaaa:"+formaFarmaceutica.get(0).getFormafarmaceuticaid());
        //System.out.println(farmaco.getNombrefarmaco());
        List<String> results = new ArrayList<String>();
        
        
       
        
        
        
        List<DosisFf> listaDosis = dosisFfFacade.findDosisId(formaFarmaceutica.get(0));
        System.out.println(listaDosis);
       // System.out.println("fFfarmaco: "+listaff);
        //System.out.println("fff: "+listaff);
        
        
        
       
        /*for(int i=0;i<listaff.size();i++){
            FormaFarmaceutica listaFormFarm=listaff.get(i).getFormafarmaceuticaid();
            results.add(listaFormFarm.getNombreFf());
           
        
        }
         System.out.println(results);
        
         this.formaFarm=results;*/
         results.add("hola");
         this.dosis = results;
    }
    
    /*public void mostrarNombre(){
        String rut = getBusca();
        Patients persona = patientsFacade.find(rut);        
        String datoPersona =persona.getFirstName();
        String datoPersona2 =persona.getLastName();
        String datoPersona3 =persona.getLastName2();
        this.nombre=datoPersona+" "+datoPersona2+" "+datoPersona3;
    }*/
    
    public void mostrarFecha(){
        
        Calendar fecha2=new GregorianCalendar();
        
        
        this.fecha=fecha2.get(Calendar.DAY_OF_MONTH)+"/"+fecha2.get(Calendar.MONTH)+"/"+fecha2.get(Calendar.YEAR);
    }
    
    /*public void mostrarDomicilio(){
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
    }*/
    
   /*public void mostrarFicha(){
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
        
        
      
    }*/
   
   
   /*public void mostrarPrevision(){
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
       
        
      
    }*/
   
    /*public void mostrarFechaNac(){
        String rut = getBusca();
        Patients persona = patientsFacade.find(rut);
        System.out.println("direccion: " + persona.getDateOfBirth().toString());
        fechaNac = persona.getDateOfBirth();
    }*/
   
    

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getEdad() {
        
        return edad;
    }

    public void setEdad(String edad) {
        
        
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }
    
    

 
    /*public void botonAct(){
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        if(busca.equals("") || busca==null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Debe ingresar un RUN obligatoriamente"));
        }
        else{
           
            try{

            mostrarDomicilio();

            mostrarEdad();

            mostrarFecha();

            mostrarNombre();

            mostrarFicha();
            session.setFicha(Integer.parseInt(ficha));
            session.setRutPaciente(busca);
            mostrarPrevision();
            
            



            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos obtenidos"));
            }
            catch(NullPointerException e){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "RUN no encontrado"));
            }
        }
    }*/
    
    
    
    /*public void botonAct2(){
        
        mostrarEdad();
        mostrarFecha();
        mostrarNombre();
        mostrarFicha();
        
    }
    
    public void botonAct3(){
        
        mostrarNombre();
        mostrarPrevision();
        
        
        
    }*/

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getBuscaFarmaco() {
        return buscaFarmaco;
    }

    public void setBuscaFarmaco(String buscaFarmaco) {
        this.buscaFarmaco = buscaFarmaco;
    }

    public List<String> getFormaFarm() {
        return formaFarm;
    }

    public void setFormaFarm(List<String> formaFarm) {
        this.formaFarm = formaFarm;
    }

    public List<String> getDosis() {
        return dosis;
    }

    public void setDosis(List<String> dosis) {
        this.dosis = dosis;
    }

    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    public String getDosis2() {
        return dosis2;
    }

    public void setDosis2(String dosis2) {
        this.dosis2 = dosis2;
    }

    public String getRpta() {
        return rpta;
    }

    public void setRpta(String rpta) {
        this.rpta = rpta;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<datosReceta> getRecetaa() {
        return recetaa;
    }

    public void setRecetaa(List<datosReceta> recetaa) {
        this.recetaa = recetaa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
}
