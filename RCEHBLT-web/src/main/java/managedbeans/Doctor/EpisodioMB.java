package managedbeans.Doctor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Profesional;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Persona;
import cl.rcehblt.entities.RegistroClinico;
import cl.rcehblt.episodio.EpisodioNegocioLocal;
import cl.rcehblt.registroclinico.RegistroClinicoNegocioLocal;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author DevelUser
 */
@Named(value = "episodioMB")
@SessionScoped
public class EpisodioMB implements Serializable {
    @EJB
    private RegistroClinicoNegocioLocal registroClinicoNegocio;
    @EJB
    private EpisodiosFacadeLocal episodiosFacade;
    @EJB
    private EpisodioNegocioLocal episodioNegocio;
    @EJB
    private PacienteFacadeLocal pacienteFacade;

    private boolean abierto;
    private String nombre;
    private Persona persona;
    private Paciente paciente;
    private Profesional profesional;
    private Episodios episodio;
    private RegistroClinico registro;
    private List<String> consultas;
    private List<Paciente> listaPacientes;
    private List<Episodios> listaEpisodios;

    /**
     * Constructor de la clase.
     */
    public EpisodioMB() {
    }

    /**
     * Postconstructor. Se inicializan variables y se setean algunos valores por
     * default.
     */
    @PostConstruct
    public void init() {
        listaPacientes = pacienteFacade.findAll();
        listaEpisodios = new ArrayList<Episodios>();
        consultas = new ArrayList<String>();
        abierto = true;
        paciente = new Paciente();
        profesional = new Profesional();
        episodio = new Episodios();
    }

    /**
     * Buscar episodios. Busca una lista de episodios clínicos asociados a un
     * paciente determinado.
     *
     * @param persona Identificador del paciente al cual se le quieren buscar
     * los episodios.
     */
    public void buscarEpisodios() {
        listaEpisodios = episodioNegocio.busquedaEpisodioIdPersona(persona.getIdPersona());
    }

    /**
     * Nuevo episodios. Función que crea un nuevo episodio de un paciente
     * siempre y cuando éste no tenga otros episodios abiertos.
     */
    public void nuevoEpisodio() {
        boolean epiAbierto = false;
        listaEpisodios = episodioNegocio.busquedaEpisodioIdPersona(persona.getIdPersona());
        if (listaEpisodios != null) {
            for (Episodios episodio1 : listaEpisodios) {
                if (episodio1.getAbierto()) {
                    epiAbierto = true;
                    break;
                }
            }
        }
        registro = registroClinicoNegocio.busquedaIdPersona(persona.getIdPersona());
        if (!epiAbierto) {
            Date fecha = Calendar.getInstance().getTime();
            episodio.setAbierto(abierto);
            episodio.setFecha(fecha);
            episodio.setRegistroclinicoid(registro);
            episodio.setNombre(nombre);
            episodiosFacade.edit(episodio);
            this.resetData();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se ha generado un episodio exitosamente."));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe un episodio abierto."));
        }
    }

    /**
     * Cerrar episodio. Función que cierra un episodio clínico determinado.
     *
     * @param idEpisodio Id del episodio que se desea cerrar.
     */
    public void cerrarEpisodio(int idEpisodio) {
        episodio = episodiosFacade.find(idEpisodio);
        episodio.setAbierto(Boolean.FALSE);
        episodiosFacade.edit(episodio);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se ha cerrado el episodio."));
    }

    /**
     * Resetear datos. Función que reinicia los datos del episodio.
     */
    private void resetData() {
        nombre = "";
        episodio = new Episodios();
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<String> consultas) {
        this.consultas = consultas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public Episodios getEpisodio() {
        return episodio;
    }

    public void setEpisodio(Episodios episodio) {
        this.episodio = episodio;
    }

    public List<Episodios> getListaEpisodios() {
        return listaEpisodios;
    }

    public void setListaEpisodios(List<Episodios> listaEpisodios) {
        this.listaEpisodios = listaEpisodios;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
