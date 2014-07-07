/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.ViewEpisodes;

import cl.rcehblt.entities.Consulta;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Persona;
import cl.rcehblt.sessionbeans.ConsultaFacadeLocal;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;
/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@ViewScoped
public class ViewEpisodes {
    @EJB
    private ConsultaFacadeLocal consultationFacade;
    @EJB
    private EpisodiosFacadeLocal episodesFacade;
    @EJB
    private PersonaFacadeLocal personFacade;
    @EJB
    private PacienteFacadeLocal patientFacade;
    
    private List<Paciente> searchPatient;
    private int idEpisode;
    private List<Consulta> consultations;
    private List<Consulta> filterConsultations;
    private Consulta selectedConsultation;
    private Integer rut;
    private String name;
    
   @PostConstruct
    public void init(){
        //consultations = consultationFacade.s;
        /*Date a= new Date();
        Consulta aux1 = new Consulta(1, "paciente grave",a , false, false, "le dolia un pelo");
        Consulta aux2 = new Consulta(1, "paciente grave2",a , false, false, "le dolia un pelo2");
        consultations = new ArrayList<Consulta>();
        consultations.add(aux1);
        consultations.add(aux2);*/
    }

     public void startEpisodes(Persona persona, Episodios episodio){
        rut = persona.getPersRut();
        idEpisode = episodio.getEpisodioid();
        searchPatient = patientFacade.searchByPerson(personFacade.findByRut(rut));
        name = searchPatient.get(0).getPersona().getPersNombres() + " " + searchPatient.get(0).getPersona().getPersApepaterno()
                + " " + searchPatient.get(0).getPersona().getPersApematerno();
        consultations = consultationFacade.searchByEpisodio(episodio);
        RequestContext.getCurrentInstance().execute("viewEpisodesDialog.show()");
    }
    
    public void resetView(){
        idEpisode = 0;
        selectedConsultation = null;
        consultations.clear();
    }
    
    public void loadConsultations(){        
        Episodios episodeSelected = episodesFacade.find(idEpisode);
        consultations = consultationFacade.searchByEpisodio(episodeSelected);        
        RequestContext.getCurrentInstance().execute("viewEpisodesDialog.show()");
    }
    
    public int getIdEpisode() {
        return idEpisode;
    }

    public void setIdEpisode(int idEpisode) {
        this.idEpisode = idEpisode;
    }
    
    public List<Consulta> getFilterConsultations() {
        return filterConsultations;
    }

    public void setFilterConsultations(List<Consulta> filterConsultations) {
        this.filterConsultations = filterConsultations;
    }

    
    public List<Consulta> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consulta> consultations) {
        this.consultations = consultations;
    }

    public Consulta getSelectedConsultation() {
        return selectedConsultation;
    }

    public void setSelectedConsultation(Consulta selectedConsultation) {
        this.selectedConsultation = selectedConsultation;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
