/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeanVitalSigns;

import cl.rcehblt.entities.Muesta;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.sessionbeans.MuestaFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Joel
 */
@ManagedBean
@ViewScoped
public class showSamples {
    @EJB
    private PacienteFacadeLocal pacienteFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;
    @EJB
    private MuestaFacadeLocal muestaFacade;
    
    private List<Paciente> searchPaciente;
    private List<Muesta> searchSamples;
    private int samplesId;
    
    
    private Integer PersonId;
    private Integer Rut;

    private List<Integer> grupos = new ArrayList<Integer>(); 
    /**
     * Creates a new instance of showSamples
     */
    public showSamples() {
    }
    
    public void start(Integer rut){
        Rut = rut;
        PersonId = personaFacade.findByRut(Rut);
        searchPaciente = pacienteFacade.searchByPerson(PersonId);
        //Date fecha = new Date(1990, 17, 9);
        searchSamples = new ArrayList<Muesta>();
        if(searchPaciente.size() > 0)
            searchSamples = muestaFacade.searchByPatient(searchPaciente.get(0));
        boolean existe = false;
        int maxGroup = 0;
        
        for(int i = 0; i<searchSamples.size(); i++){
            for(int j = 0; j<grupos.size(); j++){
                if(grupos.get(j) == searchSamples.get(i).getGrupo()){
                    existe = true;
                }
            }
            if(existe == false){
                grupos.add(searchSamples.get(i).getGrupo());
            }
            existe = false;
            maxGroup = searchSamples.get(i).getGrupo();
        }
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), maxGroup);
        RequestContext.getCurrentInstance().execute("previousVitalSignsDialog.show()");
    }

    public void loadSamples(){
        PersonId = personaFacade.findByRut(Rut);
        searchPaciente = pacienteFacade.searchByPerson(PersonId);
        searchSamples = muestaFacade.searchByPatient(searchPaciente.get(0));
        boolean existe = false;
        int maxGroup = 0;
        
        for (Muesta searchSample : searchSamples) {
            for (Integer grupo : grupos) {
                if (grupo == searchSample.getGrupo()) {
                    existe = true;
                }
            }
            if (existe == false) {
                grupos.add(searchSample.getGrupo());
            }
            existe = false;
            maxGroup = searchSample.getGrupo();
        }
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), maxGroup);
    }
    
    public void showSamples(){
        System.out.println(Rut);
        PersonId = personaFacade.findByRut(Rut);
        searchPaciente = pacienteFacade.searchByPerson(PersonId);
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), samplesId);   
    }
    
    public List<Muesta> getSearchSamples() {
        return searchSamples;
    }

    public void setSearchSamples(List<Muesta> searchSamples) {
        this.searchSamples = searchSamples;
    }

    public int getSamplesId() {
        return samplesId;
    }

    public void setSamplesId(int samplesId) {
        this.samplesId = samplesId;
    }

    public List<Paciente> getSearchPaciente() {
        return searchPaciente;
    }

    public void setSearchPaciente(List<Paciente> searchPaciente) {
        this.searchPaciente = searchPaciente;
    }

    public Integer getPersonId() {
        return PersonId;
    }

    public void setPersonId(Integer PersonId) {
        this.PersonId = PersonId;
    }

    public List<Integer> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Integer> grupos) {
        this.grupos = grupos;
    }
    
}
