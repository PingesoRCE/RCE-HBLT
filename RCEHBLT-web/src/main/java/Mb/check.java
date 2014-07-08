/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.bean.ViewScoped;

import javax.inject.Inject;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;
 
@ManagedBean
@ViewScoped
public class check {
    @Inject
    LoginSessionMB session;
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
    //@EJB
    //private ProfessionalsFacadeLocal professionalsFacade;



    int ano;
    int mes;
    int dia;
    String nombreDoc;
    String apellidoDoc;
    String runDoc;
    String nombre;
    String runPac;
    String edad;
    String ficha;
    String text;
    String busca;
    String fecha;
    String txt;
    String domicilio;
    String lastMessage;
    String user;
    String contrasena;
    String apellido;
    String userPrint;
    String passPrint;
    String verificar;
    String prevision;
    
    private String select;
    private String examenS;
    private String numero;
    private String diaCita;
    private Date date9;
    private String[] selectedExam;
    private List<String> exam;

       
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
    @PostConstruct
    public void init() {
        exam = new ArrayList<String>();
        exam.add("Ecografía Obstetrica");
        exam.add("Ecografía Transvaginal");
        exam.add("Ecografía Ginecologica");
        exam.add("Dopler Materno Fetal");
        exam.add("Dopler Ginecologico");
        exam.add("Perfil Biofisico Fetal");
        exam.add("Scan 11-14");
        exam.add("Scan 22-25");
        exam.add("Ecocardiografía Fetal");
    }

    public String[] getSelectedExam() {
        return selectedExam;
    }

    public void setSelectedExam(String[] selectedExam) {
        this.selectedExam = selectedExam;
    }

    public List<String> getExam() {
        return exam;
    }

    public void setExam(List<String> exam) {
        this.exam = exam;
    }

    public Date getDate9() {
        return date9;
    }

    public void setDate9(Date date9) {
        this.date9 = date9;
    }
    
    public String getDiaCita() {
        return diaCita;
    }

    public void setDiaCita(String diaCita) {
        this.diaCita = diaCita;
    }

    public LoginSessionMB getSession() {
        return session;
    }

    public void setSession(LoginSessionMB session) {
        this.session = session;
    }

    public FormaFarmaceuticaFacadeLocal getFormaFarmaceuticaFacade() {
        return formaFarmaceuticaFacade;
    }

    public void setFormaFarmaceuticaFacade(FormaFarmaceuticaFacadeLocal formaFarmaceuticaFacade) {
        this.formaFarmaceuticaFacade = formaFarmaceuticaFacade;
    }

    public FfFarmacoFacadeLocal getFfFarmacoFacade() {
        return ffFarmacoFacade;
    }

    public void setFfFarmacoFacade(FfFarmacoFacadeLocal ffFarmacoFacade) {
        this.ffFarmacoFacade = ffFarmacoFacade;
    }

    public FarmacoFacadeLocal getFarmacoFacade() {
        return farmacoFacade;
    }

    public void setFarmacoFacade(FarmacoFacadeLocal farmacoFacade) {
        this.farmacoFacade = farmacoFacade;
    }

    public PrevisionFacadeLocal getPrevisionFacade() {
        return previsionFacade;
    }

    public void setPrevisionFacade(PrevisionFacadeLocal previsionFacade) {
        this.previsionFacade = previsionFacade;
    }

   

    

    

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getApellidoDoc() {
        return apellidoDoc;
    }

    public void setApellidoDoc(String apellidoDoc) {
        this.apellidoDoc = apellidoDoc;
    }

    public String getRunDoc() {
        return runDoc;
    }

    public void setRunDoc(String runDoc) {
        this.runDoc = runDoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRunPac() {
        return runPac;
    }

    public void setRunPac(String runPac) {
        this.runPac = runPac;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
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

    public String getUserPrint() {
        return userPrint;
    }

    public void setUserPrint(String userPrint) {
        this.userPrint = userPrint;
    }

    public String getPassPrint() {
        return passPrint;
    }

    public void setPassPrint(String passPrint) {
        this.passPrint = passPrint;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getExamenS() {
        return examenS;
    }

    public void setExamenS(String examenS) {
        this.examenS = examenS;
    }
 
    public String getConsole() {
        return select;
    }
 
    public void setConsole(String console) {
        this.select = console;
    }
    public int getAno() {
        Calendar fecha = new GregorianCalendar();
        ano = fecha.get(Calendar.YEAR);
        return ano;
    }
    /*public void validacion2() throws IOException {
        System.out.println("entré :DDDDDDDDDDD");

        String usuario = Login.user;
        String pass = Login.contrasena;
        System.out.println(usuario +" "+pass);
        FacesContext context = FacesContext.getCurrentInstance();

        Professionals prof = professionalsFacade.find(usuario);

        if (prof.getFirstName().equals(pass) && usuario.equalsIgnoreCase(userPrint) && pass.equalsIgnoreCase(passPrint)) {
            this.apellido = prof.getLastName();
            FacesContext.getCurrentInstance().getExternalContext();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome" + user + "" + apellido, getUser()));
            verificar = "Si";
            System.out.println("Soy VALIDO!!!!!!!!!! :DDDDDDDDDDD");
            //this.dispose(); 

        } else {
            verificar = "No";
            System.out.println("NO Soy VALIDO!!!!!!!!!! :DDDDDDDDDDD");
            FacesContext.getCurrentInstance().getExternalContext().redirect("RecetaExterna.xhtml");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Invalido", "Verificar usuario o contraseña"));
        }

    }*/
    
    
    public void comparar(){
        System.out.println("entre a comparar"+ session.getRut()+" "+ session.getContrasena());
        
        if(session.getRut().equals(userPrint) && session.getContrasena().equals(passPrint)){
        verificar="Si";
        
        
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Invalido", "Verificar usuario o contraseña"));
                verificar="No";
                
                }
    
    
    }

    public void validacion() throws IOException {
        System.out.println("entré :DDDDDDDDDDD");
        String usuario = getUserPrint();
        String pass = getPassPrint();
        FacesContext context = FacesContext.getCurrentInstance();
        //Professionals prof=professionalsFacade.find(usuario);

        //if(prof.getFirstName().equals(pass)){
        context.addMessage(null, new FacesMessage("Welcome", "asd"));
            //this.apellido = prof.getLastName();
        //FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");

        //}
        //else{
        //context.addMessage(null, new FacesMessage("Usuario Invalido", "asd" ));
        //}
    }

    public void truco() {
        System.out.println(text);
    }

    /*public void mostrarDomicilio() {
        String rut = getBusca();
        this.txt = rut;
        System.out.println("ruuuuuuuuuut: " + rut);

        Patients persona = patientsFacade.find(rut);
        if (persona == null) {
            System.out.print("persona no encontrada");
            this.domicilio = "";
            return;
        }
        System.out.println("direccion: " + persona.getAddress());
        String datoPersona = persona.getAddress();

        this.domicilio = datoPersona;
    }

    public void mostrarEdad() {
        String rut = getBusca();

        Patients persona = patientsFacade.find(rut);
        System.out.println("direccion: " + persona.getDateOfBirth().toString());
        String datoPersona = persona.getDateOfBirth();
        String [] lista = datoPersona.split("/");
        edad = (getAno() - Integer.parseInt(lista[2]))+"";
        
    }

    public void mostrarNombre() {
        String rut = getBusca();

        Patients persona = patientsFacade.find(rut);
        String datoPersona = persona.getFirstName();
        String datoPersona2 = persona.getLastName();
        String datoPersona3 = persona.getLastName2();
        this.nombre = datoPersona + " " + datoPersona2 + " " + datoPersona3;
    }

    public void mostrarFecha() {

        Calendar fecha2 = new GregorianCalendar();

        this.fecha = fecha2.get(Calendar.DAY_OF_MONTH) + "/" + (fecha2.get(Calendar.MONTH)+1) + "/" + fecha2.get(Calendar.YEAR);
    }

    public void mostrarFicha() {
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll();
        Patients pasiente = new Patients();
        System.out.println("shiiiiiit");
        for (int i = 0; i < lista.size(); i++) {
            if (rut.equals(lista.get(i).getRut())) {
                pasiente = lista.get(i);
            }
        }
        List<Clinicalrecords> listaClinical = clinicalrecordsFacade.findRut(pasiente);
        System.out.println("hoooolaaaaa");
        System.out.println("ficha: " + listaClinical.get(0).getCrecid().toString());
        this.ficha = listaClinical.get(0).getCrecid().toString();

    }

    public void botonAct() {

        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("entre boton");

        if ("".equals(busca) || busca == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Debe ingresar un RUN obligatoriamente"));
        } else {
            try {
                System.out.println("rut valido");
                mostrarDomicilio();
                mostrarEdad();
                mostrarFecha();
                mostrarNombre();
                mostrarFicha();
                mostrarPrevision();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos obtenidos"));
            } catch (NullPointerException e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "RUN no encontrado"));
            }

        }

    }

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        List<Patients> lista = patientsFacade.findAll();

        for (int i = 0; i < lista.size(); i++) {
            String rut = lista.get(i).getRut();

            if (rut.startsWith(query)) {
                System.out.println(rut);
                results.add(rut);
            }

        }

        return results;
    }*/

    public void getSomeValue() throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, Object> requestMap = context.getExternalContext().getRequestMap();

        //Whatever you need to do
        String message
                = "The Result you wish to display";

        requestMap.put("lastMessage", message);
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void destroyWorld() {
        System.out.println("entré a destroy!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "RUN no encontrado"));
    }

   /* public void mostrarPrevision(){
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

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        Calendar fecha = new GregorianCalendar();
        mes = fecha.get(Calendar.MONTH);
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        Calendar fecha = new GregorianCalendar();
        dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}