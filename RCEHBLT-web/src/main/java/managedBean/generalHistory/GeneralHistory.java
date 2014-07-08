/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.generalHistory;

import cl.rcehblt.entities.Antecedentes;
import cl.rcehblt.entities.Antmedidos;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Persona;
import cl.rcehblt.entities.RegistroClinico;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import cl.rcehblt.sessionbeans.AntecedentesFacadeLocal;
import cl.rcehblt.sessionbeans.AntmedidosFacadeLocal;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import cl.rcehblt.sessionbeans.RegistroClinicoFacadeLocal;

/**
 *
 * @author Martín
 */
@ManagedBean
@ViewScoped
public class GeneralHistory {

    @EJB
    private AntecedentesFacadeLocal antecedentesFacade;
    @EJB
    private AntmedidosFacadeLocal antmedidosFacade;
    @EJB
    private EpisodiosFacadeLocal episodeFacade;
    @EJB
    private RegistroClinicoFacadeLocal clinicalRecordFacade;
    @EJB
    private PacienteFacadeLocal patientFacade;
    @EJB
    private PersonaFacadeLocal personFacade;

    private Integer rut = 6972769;
    private String antecedentes;
    private Antmedidos newAntmedido;
    private List<Antecedentes> searchAntecedente;
    private List<Antmedidos> searchAmedidos;
    private int personId;
    private List<Paciente> searchPatient;
    private Paciente patient;
    private List<RegistroClinico> searchClinicalRecord;
    private List<Episodios> searchEpisode;
    private Integer idGeneral;

    public GeneralHistory() {

    }

    @PostConstruct
    public void init() {
    }

    public void start(Integer rut) {
        this.rut = rut;
        personId = personFacade.findByRut(rut);
        searchPatient = patientFacade.searchByPerson(personId);
        patient = searchPatient.get(0);
        searchClinicalRecord = clinicalRecordFacade.searchByPaciente(searchPatient.get(0));
        searchEpisode = episodeFacade.searchByClinicalRegister(searchClinicalRecord.get(0));
        idGeneral = antecedentesFacade.searchByName("Generales").get(0).getIdAntecedente();
        searchAmedidos = antmedidosFacade.searchOldestGeneral(idGeneral, searchEpisode.get(0));
        
        System.out.println("ACA ESTOY MI PORTES ES: " + searchAmedidos.size());
        
        if (!searchAmedidos.isEmpty()) {
            for (Antmedidos antmed : searchAmedidos) {
                if (antmed.getIdAntecedente().getIdAntecedente().equals(idGeneral)) {
                    antecedentes = antmed.getValor();
                }
            }
        }
    }

    public void save() {
        if (!antecedentes.isEmpty()) {
            Date fecha = new Date();
            personId = personFacade.findByRut(rut);
            searchPatient = patientFacade.searchByPerson(personId);
            patient = searchPatient.get(0);
            searchClinicalRecord = clinicalRecordFacade.searchByPaciente(searchPatient.get(0));
            searchEpisode = episodeFacade.searchByClinicalRegister(searchClinicalRecord.get(0));

            newAntmedido = new Antmedidos();
            searchAntecedente = antecedentesFacade.searchByName("Generales");
            newAntmedido.setIdAntmedidos(null);
            newAntmedido.setEpisodioid(searchEpisode.get(0));
            newAntmedido.setIdAntecedente(searchAntecedente.get(0));
            newAntmedido.setValor(antecedentes);
            newAntmedido.setFecha(fecha);
            newAntmedido.setGrupo(0);
            antmedidosFacade.create(newAntmedido);

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Antecedentes guardados.", "");
            FacesContext.getCurrentInstance().addMessage("", fm);

            RequestContext.getCurrentInstance().execute("dialogGeneralHistory.hide()");
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un antecedente", "");
            FacesContext.getCurrentInstance().addMessage("", fm);
        }
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

}
