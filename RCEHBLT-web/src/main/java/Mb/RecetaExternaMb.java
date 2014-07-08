/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mb;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;
/**
 *
 * @author camilo
 */
@ManagedBean(name = "recetaexternaMb")
@RequestScoped

public class RecetaExternaMb {
    @EJB
    private ExternaFacadeLocal recetaExternaFacade;
    @EJB
    private ConsultaFacadeLocal consultaFacade;

    @EJB
    private InternaFacadeLocal recetaInternaFacade;

    @EJB
    private PrescriptionFacadeLocal prescriptionFacade;

    @Inject
    LoginSessionMB session;
    
    @Inject
    MedicamentosMb medicamentos;
    
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
   // @EJB
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
    String text = " ";
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
    String fechaNac;

    public RecetaExternaMb() {

    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
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

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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

    public int getAno() {
        Calendar fecha = new GregorianCalendar();
        ano = fecha.get(Calendar.YEAR);
        return ano;
    }

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

    public String getNombreDoc() {

        return nombreDoc;
    }

    public MedicamentosMb getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(MedicamentosMb medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getRunDoc() {

        return runDoc;
    }

    public void setRunDoc(String runDoc) {
        this.runDoc = runDoc;
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

    public String getApellidoDoc() {
        return apellidoDoc;
    }

    public void setApellidoDoc(String apellidoDoc) {
        this.apellidoDoc = apellidoDoc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    /*public void validacion2() throws IOException {
        System.out.println("entré :DDDDDDDDDDD");

        String usuario = Login.user;
        String pass = Login.contrasena;
        System.out.println(usuario + " " + pass);
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

    public void comparar() {
        System.out.println("entre a comparar y el rut es:" + session.getRut() + "y la pass:" + session.getContrasena());

        if (session.getRut().equals(userPrint) && session.getContrasena().equals(passPrint)) {
            verificar = "Si";

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Invalido", "Verificar usuario o contraseña"));
            verificar = "No";

        }

    }
    public void guardarRecetaExterna() {
            FacesContext context = FacesContext.getCurrentInstance();
             Prescription receta = new Prescription();
             List<Prescription> recetas = new ArrayList<Prescription>();
             Consulta consulte = new Consulta();
             consulte = consultaFacade.find(2);
             Externa recetaExterna = new Externa();
             List<Farmaco> remedios = new ArrayList<Farmaco>();
             Farmaco remedio = new Farmaco();
             FormaFarmaceutica forma = new FormaFarmaceutica();
             List<FormaFarmaceutica> formas = new ArrayList<FormaFarmaceutica>();
             Dosis laDosis = new Dosis();
             receta.setConsultaid(consulte);
             receta.setDescription(text);
             java.util.Date fechaActual = new java.util.Date();//fecha actual
             receta.setPrescriptionDay(fechaActual);
             prescriptionFacade.create(receta);
             recetas = prescriptionFacade.findAll();
             System.out.println("-----------> GUARDAR receta");
             //guarda en receta interna
             receta = recetas.get(recetas.size() - 1);//toma el ultimo valor guardado
             System.out.println("recetaaaaaaa=" + receta.getPrescriptionid());
             recetaExterna.setPrescriptionid(receta.getPrescriptionid());
             
             recetaExternaFacade.create(recetaExterna);
             System.out.println("-----------> GUARDAR receta externa");
             //guarda en recetaexternafarmaco
             medicamentos.recetae.add("Receta Externa");
             System.out.println(text);
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
           
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
        String[] lista = datoPersona.split("-");
        edad = (getAno() - Integer.parseInt(lista[2])) + "";

    }

    public void mostrarFechaNac() {
        String rut = getBusca();
        Patients persona = patientsFacade.find(rut);
        System.out.println("direccion: " + persona.getDateOfBirth().toString());
        fechaNac = persona.getDateOfBirth();
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

        this.fecha = fecha2.get(Calendar.DAY_OF_MONTH) + "/" + (fecha2.get(Calendar.MONTH) + 1) + "/" + fecha2.get(Calendar.YEAR);
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

    }*/

   /* public void botonAct() {

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
                session.setFicha(Integer.parseInt(ficha));
                session.setRutPaciente(busca);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos obtenidos"));
            } catch (NullPointerException e) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "RUN no encontrado"));
            }

        }

    }*/

    /*public List<String> complete(String query) {
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

   /* public void mostrarPrevision() {
        String rut = getBusca();
        List<Patients> lista = patientsFacade.findAll();
        Patients pasiente = new Patients();
        Prevision prev = new Prevision();
        for (int i = 0; i < lista.size(); i++) {
            if (rut.equals(lista.get(i).getRut())) {
                pasiente = lista.get(i);
                prev = pasiente.getPrevisionid();
            }
        }
      //  List<Prevision> listaPrevision= previsionFacade.findID(pasiente);

        this.prevision = prev.getType();

    }*/

   /* public void guardarRecetaExterna() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean hayrut;
        try {
            String rut=session.getRutPaciente();
            System.out.println("------> RUUUUUUT:"+rut);
            if (rut.equals("") || rut == null) {
                hayrut = false;
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Debe ingresar un RUN obligatoriamente"));
            } else {
                hayrut = true;
                Prescription receta = new Prescription();
                List<Prescription> recetas = new ArrayList<Prescription>();
                Professionals doctor = new Professionals();
                Clinicalrecords clin = new Clinicalrecords();
                RecetaInterna recetaExterna = new RecetaInterna();
                clin = clinicalrecordsFacade.find(session.getFicha());
                doctor = professionalsFacade.find(session.getRut());
                receta.setDescription(text);
                receta.setRut(doctor);
                receta.setCrecid(clin);
                java.util.Date fechaActual = new java.util.Date();//fecha actual
                receta.setPrescriptionDay(fechaActual);
                prescriptionFacade.create(receta);
                recetas = prescriptionFacade.findAll();
                System.out.println("-----------> GUARDAR receta");
                //guarda en receta interna
                receta = recetas.get(recetas.size() - 1);//toma el ultimo valor guardado
                System.out.println("recetaaaaaaa=" + receta.getPrescriptionid());
                recetaExterna.setCrecid(session.getFicha());
                recetaExterna.setPrescriptionid(receta.getPrescriptionid());
                recetaExterna.setDescription(text);
                recetaExterna.setPrescriptionDay(fechaActual);
                recetaInternaFacade.create(recetaExterna);
                session.setRutPaciente("");
                System.out.println("-----------> GUARDAR receta externa");
                session.setRutPaciente("");
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
            }
        } catch (NullPointerException e) {
            hayrut = false;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Ingrese RUN válido para guardar cambios"));
        }
        System.out.println("hayrut:" + hayrut);

    }*/

}
