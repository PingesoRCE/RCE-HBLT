/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBean.patient;

import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Patologia;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import managedBean.Episodes.Episodes;
import managedBean.consultation.NewConsultation;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;

/**
 *
 * @author Martín
 */
@Named(value = "selectPatient")
@ViewScoped
public class SelectPatient {
    @EJB
    private PacienteFacadeLocal patientFacade;
    
    @ManagedProperty("#{episodes}")
    private Episodes episodesBean;

    
    private List<Paciente> patients;
    
    private Integer rut;
    /**
     * Creates a new instance of patient
     */
    public SelectPatient() {
    }
        
    public List<String> completeTextPatient(String query) {
        patients = patientFacade.findAll();
        List<String> results = new ArrayList<String>();
        
        for(Paciente patient: patients){
            if(patient.getPersona().getPersRut().toString().startsWith(query)){
                results.add(patient.getPersona().getPersRut().toString());
            }
        }
        
        return results;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public Episodes getEpisodesBean() {
        return episodesBean;
    }

    public void setEpisodesBean(Episodes episodesBean) {
        this.episodesBean = episodesBean;
    }
    
}
