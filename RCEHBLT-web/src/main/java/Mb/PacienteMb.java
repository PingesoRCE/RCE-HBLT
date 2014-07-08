/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mb;


import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;

/**
 *
 * @author lol
 */
@Named(value = "pacienteMb")
@SessionScoped
public class PacienteMb implements Serializable {

    @Inject
    LoginMB login;

    @Inject
    LoginSessionMB session;
    //@EJB
    //private ProfessionalsFacadeLocal professionalsFacade;
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

    private String rut, nombre, contrasena, apellido;
    private int ano;
    private int mes;
    private int dia;
    private String nombreDoc;
    private String apellidoDoc;
    private String runDoc;
    private String nombrePac;
    private String runPac;
    private String edad;
    private String ficha;
    private String text;
    private String busca;
    private String fecha;
    private String txt;
    private String domicilio;
    private String lastMessage;
    private String user;
    private String apellidoPac;
    private String userPrint;
    private String passPrint;
    private String verificar;
    private String prevision;

    public PacienteMb() {
    }

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
        System.out.println("entre a comparar" + session.getRut() + " " + session.getContrasena());

        if (session.getRut().equals(userPrint) && session.getContrasena().equals(passPrint)) {
            verificar = "Si";

        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Invalido", "Verificar usuario o contraseña"));
            verificar = "No";

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

        Paciente persona = patientsFacade.find(rut);
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

        Paciente persona = patientsFacade.find(rut);
        System.out.println("direccion: " + persona.getDateOfBirth().toString());
        String datoPersona = persona.getDateOfBirth();
        String[] lista = datoPersona.split("/");
        edad = (getAno() - Integer.parseInt(lista[2])) + "";

    }

    public void mostrarNombre() {
        String rut = getBusca();

        Paciente persona = patientsFacade.find(rut);
        String datoPersona = persona.getFirstName();
        String datoPersona2 = persona.getLastName();
        String datoPersona3 = persona.getLastName2();
        this.nombrePac = datoPersona + " " + datoPersona2 + " " + datoPersona3;
    }

    public void mostrarFecha() {

        Calendar fecha2 = new GregorianCalendar();

        this.fecha = fecha2.get(Calendar.DAY_OF_MONTH) + "/" + (fecha2.get(Calendar.MONTH) + 1) + "/" + fecha2.get(Calendar.YEAR);
    }

    public void mostrarFicha() {
        String rut = getBusca();
        List<Paciente> lista = patientsFacade.findAll();
        Paciente pasiente = new Paciente();
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
        List<Paciente> lista = patientsFacade.findAll();

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
        List<Paciente> lista = patientsFacade.findAll();
        Paciente pasiente = new Paciente();
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


    public int getAno() {
        Calendar fecha = new GregorianCalendar();
        ano = fecha.get(Calendar.YEAR);
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
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

    public String getApellidoPac() {
        return apellidoPac;
    }

    public void setApellidoPac(String apellidoPac) {
        this.apellidoPac = apellidoPac;
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

   /* public void login(String rutt, String password) throws IOException {
        System.out.println(rutt);
        Professionals prof = professionalsFacade.find(rutt);
        System.out.println("asd");
        if (prof.getFirstName().equals(password)) {
            rut = rutt;
            contrasena = password;
            nombre = password;
            apellido = prof.getLastName();
            ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
            context2.redirect(context2.getRequestContextPath() + "/faces/views/inicio.xhtml");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de inicio", "Usuario o contraseña inválidos"));
        }

    }*/
    private boolean error = false;

    public void logout() throws IOException {

    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

}
