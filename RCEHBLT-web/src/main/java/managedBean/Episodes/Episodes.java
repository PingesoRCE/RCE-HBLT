/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.Episodes;


import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.RegistroClinico;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import cl.rcehblt.sessionbeans.RegistroClinicoFacadeLocal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@ViewScoped
public class Episodes {
    @EJB
    private EpisodiosFacadeLocal episodesFacade;
    @EJB
    private RegistroClinicoFacadeLocal clinicalRecordFacade;
    @EJB
    private PacienteFacadeLocal patientFacade;
    @EJB
    private PersonaFacadeLocal personFacade;

    
    private Integer personId;
    private List<Paciente> searchPatient;
    private List<RegistroClinico> searchClinicalRecord;
    private List<Episodios> searchEpisode;
    private Integer rut;
    private String name;    
    private int episode = 0;
    private Map<String,String> episodes = new HashMap<String,String>();
    
    @PostConstruct
    public void init(){
        rut = 6972769;
        personId = personFacade.findByRut(rut);
        searchPatient = patientFacade.searchByPerson(personId);
        searchClinicalRecord = clinicalRecordFacade.searchByPaciente(searchPatient.get(0));
        searchEpisode = episodesFacade.searchByClinicalRegister(searchClinicalRecord.get(0));
        name = searchPatient.get(0).getPersona().getPersNombres() +" "+searchPatient.get(0).getPersona().getPersApepaterno() 
                +" "+searchPatient.get(0).getPersona().getPersApematerno();
        
        episodes = new HashMap<String,String>();
        episodes.put("Seleccione", "0");
        for(int i= 0; i<searchEpisode.size(); i++){
            String aux = searchEpisode.get(i).getEpisodioid().toString();
            episodes.put(aux, aux);
        }
    }
    
    public void startEpisodes(Integer rutPaciente){
        rut = rutPaciente;
        personId = personFacade.findByRut(rut);
        searchPatient = patientFacade.searchByPerson(personId);
        searchClinicalRecord = clinicalRecordFacade.searchByPaciente(searchPatient.get(0));
        searchEpisode = episodesFacade.searchByClinicalRegister(searchClinicalRecord.get(0));
        name = searchPatient.get(0).getPersona().getPersNombres() +" "+searchPatient.get(0).getPersona().getPersApepaterno() 
                +" "+searchPatient.get(0).getPersona().getPersApematerno();
        
        episodes = new HashMap<String,String>();
        episodes.put("Seleccione", "0");
        for(int i= 0; i<searchEpisode.size(); i++){
            String aux = searchEpisode.get(i).getEpisodioid().toString();
            episodes.put(aux, aux);
        }
    }
    
    public void resetEpisodes(){
        episode = 0;
    }

    public Map<String, String> getEpisodes() {
        return episodes;
    }
    public void setEpisodes(Map<String, String> episodes) {
        this.episodes = episodes;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEpisode() {
        return episode;
    }
    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer Rut) {
        this.rut = Rut;
    }
    
    
    
   
}