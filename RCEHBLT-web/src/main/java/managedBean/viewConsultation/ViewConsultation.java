/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.viewConsultation;

import cl.rcehblt.entities.Consulta;
import cl.rcehblt.entities.Diagnostico;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Patologia;
import cl.rcehblt.entities.Persona;
import cl.rcehblt.sessionbeans.DiagnosticoFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PatologiaFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import managedBean.consultation.DiagnosesPathology;
import managedBean.consultation.NewConsultation;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@ViewScoped
public class ViewConsultation {
    @EJB
    private DiagnosticoFacadeLocal diagnosisFacade;
    @EJB
    private PersonaFacadeLocal personFacade;
    @EJB
    private PacienteFacadeLocal patientFacade;

    @ManagedProperty("#{newConsultation}")
    private NewConsultation newConsultation;
    
    private Integer rut;
    private String nombre;
    private Diagnostico selectedDiagnosis;
    private Consulta selectedConsultation;
    private String consultationReason;
    private String consultationNotes;
    private String physicalExamination;
    private String diagnosisHipothesis;
    private boolean consultationCanceled = false;
    private boolean consultationPaused = false;
    private List<Diagnostico> diagnosis;
    private List<DiagnosesPathology> diagPathList = new ArrayList<DiagnosesPathology>();
    private boolean pertinence;

    private List<Paciente> searchPatient;

    private Diagnostico diagnoses;
    private Consulta consultation;

    /*@PostConstruct
    public void init() {
    }*/
    
    public void startConsultations(Integer rutPaciente){
        rut = rutPaciente;
        System.out.println("2: "+rut);
        searchPatient = patientFacade.searchByPerson(personFacade.findByRut(rut));
        System.out.println("3: "+searchPatient);
        nombre = searchPatient.get(0).getPersona().getPersNombres() + " " + searchPatient.get(0).getPersona().getPersApepaterno()
                + " " + searchPatient.get(0).getPersona().getPersApematerno();
        System.out.println("4");
        //RequestContext.getCurrentInstance().execute("newConsultationDialog.show()");
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void completeDataConsultation() {
        Consulta selectedConsultation = selectedDiagnosis.getConsultaid();
        consultationReason = selectedConsultation.getMotivoConsulta();
        consultationNotes = selectedConsultation.getNotas();
        physicalExamination = selectedConsultation.getExploracionFisica();
        diagnosisHipothesis = selectedConsultation.getHdiagnostica();
        pertinence = selectedConsultation.getPertinencia();
        consultationCanceled = selectedConsultation.getCancelada();
        consultationPaused = selectedConsultation.getPausada();
        diagnosis = diagnosisFacade.searchByConsultation(selectedConsultation);
        for (Diagnostico diag : diagnosis) {
            diagPathList.add(new DiagnosesPathology(diag.getDiagnosticofecha(), diag.getDiagnosticoges(), diag.getDiagnosticoestado(), diag.getPatologiaid().getPatologiaid(), diag.getPatologiaid().getPatologianombre(), diag.getPatologiaid().getPatologiages()));
        }
    }

    public void completeData() {
        consultationPaused = selectedConsultation.getPausada();
        if (consultationPaused) {
            newConsultation.loadConsultation(selectedConsultation);
            RequestContext.getCurrentInstance().execute("newConsultationDialog.show()");
        } else {
            if (selectedConsultation != null) {
                consultationReason = selectedConsultation.getMotivoConsulta();
                consultationNotes = selectedConsultation.getNotas();
                physicalExamination = selectedConsultation.getExploracionFisica();
                diagnosisHipothesis = selectedConsultation.getHdiagnostica();
                pertinence = selectedConsultation.getPertinencia();
                diagnosis = diagnosisFacade.searchByConsultation(selectedConsultation);
                consultationCanceled = selectedConsultation.getCancelada();
                for (Diagnostico diag : diagnosis) {
                    diagPathList.add(new DiagnosesPathology(diag.getDiagnosticofecha(), diag.getDiagnosticoges(), diag.getDiagnosticoestado(), diag.getPatologiaid().getPatologiaid(), diag.getPatologiaid().getPatologianombre(), diag.getPatologiaid().getPatologiages()));
                }
                RequestContext.getCurrentInstance().execute("viewConsultationWV.show()");
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar una consulta", "");
                FacesContext.getCurrentInstance().addMessage("", fm);
            }
        }
    }

    public Diagnostico getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Diagnostico diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Consulta getConsultation() {
        return consultation;
    }

    public void setConsultation(Consulta consultation) {
        this.consultation = consultation;
    }

    public Diagnostico getSelectedDiagnosis() {
        return selectedDiagnosis;
    }

    public void setSelectedDiagnosis(Diagnostico selectedDiagnosis) {
        this.selectedDiagnosis = selectedDiagnosis;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public String getConsultationNotes() {
        return consultationNotes;
    }

    public void setConsultationNotes(String consultationNotes) {
        this.consultationNotes = consultationNotes;
    }

    public String getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(String physicalExamination) {
        this.physicalExamination = physicalExamination;
    }

    public String getDiagnosisHipothesis() {
        return diagnosisHipothesis;
    }

    public void setDiagnosisHipothesis(String diagnosisHipothesis) {
        this.diagnosisHipothesis = diagnosisHipothesis;
    }

    public List<DiagnosesPathology> getDiagPathList() {
        return diagPathList;
    }

    public void setDiagPathList(List<DiagnosesPathology> diagPathList) {
        this.diagPathList = diagPathList;
    }

    public boolean isPertinence() {
        return pertinence;
    }

    public void setPertinence(boolean pertinence) {
        this.pertinence = pertinence;
    }

    public List<Diagnostico> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(List<Diagnostico> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Consulta getSelectedConsultation() {
        return selectedConsultation;
    }

    public void setSelectedConsultation(Consulta selectedConsultation) {
        this.selectedConsultation = selectedConsultation;
    }

    public boolean isConsultationCanceled() {
        return consultationCanceled;
    }

    public void setConsultationCanceled(boolean consultationCanceled) {
        this.consultationCanceled = consultationCanceled;
    }

    public boolean isConsultationPaused() {
        return consultationPaused;
    }

    public void setConsultationPaused(boolean consultationPaused) {
        this.consultationPaused = consultationPaused;
    }

    public NewConsultation getNewConsultation() {
        return newConsultation;
    }

    public void setNewConsultation(NewConsultation newConsultation) {
        this.newConsultation = newConsultation;
    }

    
    
}
