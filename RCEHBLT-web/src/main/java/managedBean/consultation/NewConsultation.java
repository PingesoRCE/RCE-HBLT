/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.consultation;

import cl.rcehblt.entities.Consulta;
import cl.rcehblt.entities.Diagnostico;
import cl.rcehblt.entities.Episodios;
import cl.rcehblt.entities.Muesta;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.Patologia;
import cl.rcehblt.entities.RegistroClinico;
import cl.rcehblt.sessionbeans.ConsultaFacadeLocal;
import cl.rcehblt.sessionbeans.DiagnosticoFacadeLocal;
import cl.rcehblt.sessionbeans.EpisodiosFacadeLocal;
import cl.rcehblt.sessionbeans.MuestaFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PatologiaFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import cl.rcehblt.sessionbeans.RegistroClinicoFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import managedBean.vitalSigns.viewVitalSigns;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@ViewScoped
public class NewConsultation {

    @EJB
    private PatologiaFacadeLocal pathologyFacade;
    @EJB
    private PacienteFacadeLocal patientFacade;
    @EJB
    private PersonaFacadeLocal personFacade;
    @EJB
    private ConsultaFacadeLocal consultationFacade;
    @EJB
    private DiagnosticoFacadeLocal diagnosticFacade;
    @EJB
    private EpisodiosFacadeLocal episodeFacade;
    @EJB
    private RegistroClinicoFacadeLocal clinicalRecordFacade;
    @EJB
    private MuestaFacadeLocal sampleFacade;

    @ManagedProperty(value = "#{viewVitalSigns}")
    private viewVitalSigns signosVitales;

    private List<Diagnostico> allDiagnosesConsultation = new ArrayList<Diagnostico>();
    private List<Diagnostico> allDiagnoses;
    private List<Consulta> searchConsultation;
    private List<Diagnostico> filteredDiagnosesConsultation;
    private List<Diagnostico> selectedDiagnosis;

    private List<Muesta> searchSamples;
    private List<Integer> groups = new ArrayList<Integer>();
    //<!--aqui-->    
    private List<Patologia> pathology;

    private Date diagnosticDate;
    private boolean diagnosticGes;
    private String diagnosticState;
    private String pathologyId;
    private String pathologyName;
    private boolean pathologyGes;

    private int personId;
    private Integer Rut;
    private String name;
    private List<Paciente> searchPatient;
    private List<RegistroClinico> searchClinicalRecord;
    private List<Episodios> searchEpisode;
    private Paciente patient;

    private DiagnosesPathology diagPath;
    private List<DiagnosesPathology> diagPathList = new ArrayList<DiagnosesPathology>();
    private Patologia selectedPathology;

    private String diagnosticHipothesis = "";
    private String consultationReason = "";
    private boolean consultationCanceled = false;
    private String canceledReason = "";
    private boolean consultationPaused = false;
    private String consultationNotes;
    private String physicalExamination;
    private String consultationState;
    private int episodeId;
    private boolean pertinence;
    private boolean isGes = false;
    private boolean disableEnd = true;
    private Integer idConsultation;

    public void start(Integer Rut) {
        this.Rut = Rut;
        personId = personFacade.findByRut(Rut);
        searchPatient = patientFacade.searchByPerson(personId);
        patient = searchPatient.get(0);
        name = searchPatient.get(0).getPersona().getPersNombres() + " " + searchPatient.get(0).getPersona().getPersApepaterno()
                + " " + searchPatient.get(0).getPersona().getPersApematerno();
        searchClinicalRecord = clinicalRecordFacade.searchByPaciente(searchPatient.get(0));
        searchEpisode = episodeFacade.searchByClinicalRegister(searchClinicalRecord.get(0));
        episodeId = searchEpisode.get(0).getEpisodioid();
        //<!--aqui-->
        boolean exist = false;
        int maxGroup = 0;
        searchSamples = sampleFacade.searchByPatient(searchPatient.get(0));
        for (int i = 0; i < searchSamples.size(); i++) {
            for (int j = 0; j < groups.size(); j++) {
                if (groups.get(j) == searchSamples.get(i).getGrupo()) {
                    exist = true;
                }
            }
            if (exist == false) {
                groups.add(searchSamples.get(i).getGrupo());
            }
            exist = false;
            maxGroup = searchSamples.get(i).getGrupo();
        }
        searchSamples = sampleFacade.searchByPatientGroup(searchPatient.get(0), maxGroup);
        signosVitales.start(Rut);
        addConsultation("iniciada");
        RequestContext.getCurrentInstance().execute("newConsultationDialog.show()");
    }

    public void loadConsultation(Consulta selectedConsultation) {
        consultationPaused = selectedConsultation.getPausada();
        if (consultationPaused) {
            idConsultation = selectedConsultation.getConsultaid();
            consultationReason = selectedConsultation.getMotivoConsulta();
            consultationNotes = selectedConsultation.getNotas();
            physicalExamination = selectedConsultation.getExploracionFisica();
            diagnosticHipothesis = selectedConsultation.getHdiagnostica();
            pertinence = selectedConsultation.getPertinencia();
            consultationCanceled = selectedConsultation.getCancelada();
            allDiagnosesConsultation = diagnosticFacade.searchByConsultation(selectedConsultation);
            for (Diagnostico diag : allDiagnosesConsultation) {
                diagPathList.add(new DiagnosesPathology(diag.getDiagnosticofecha(), diag.getDiagnosticoges(), diag.getDiagnosticoestado(), diag.getPatologiaid().getPatologiaid(), diag.getPatologiaid().getPatologianombre(), diag.getPatologiaid().getPatologiages()));
            }
        }
    }

    public void pathologyToAdd() {
        if (selectedPathology != null) {
            pathologyName = selectedPathology.getPatologianombre();
            pathologyGes = selectedPathology.getPatologiages();
            diagnosticGes = selectedPathology.getPatologiages();
            resetMoreDiagnoses();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diagnóstico seleccionado", "");
            FacesContext.getCurrentInstance().addMessage("", fm);
            RequestContext.getCurrentInstance().execute("pathologyListDialog.hide()");
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No ha seleccionado patología", "");
            FacesContext.getCurrentInstance().addMessage("", fm);
        }
    }

    public void addAllDiagnostic() {
        allDiagnosesConsultation.clear();
        searchConsultation = consultationFacade.searchByEpisodio(searchEpisode.get(0));
        for (Consulta searchConsultation1 : searchConsultation) {
            allDiagnoses = diagnosticFacade.searchByConsultation(searchConsultation1);
            for (Diagnostico allDiagnose : allDiagnoses) {
                allDiagnosesConsultation.add(allDiagnose);
            }
        }
    }

    public void addDiagnoses() {
        if (pathologyNotEmpty() && pathologyExists() && selectOneState()) {
            diagnosticDate = new Date();
            Patologia diagnosticPathology = pathologyFacade.searchByNombre(pathologyName).get(0);
            pathologyId = diagnosticPathology.getPatologiaid();
            pathologyGes = diagnosticPathology.getPatologiages();
            diagPath = new DiagnosesPathology(diagnosticDate, diagnosticGes, diagnosticState, pathologyId, pathologyName, pathologyGes);
            if (diagnosticGes == true && diagnosticState.equals("confirmado")) {
                isGes = true;
            }
            diagPathList.add(diagPath);
            resetDiagnostic();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Diagnóstico agregado", "");
            FacesContext.getCurrentInstance().addMessage("", fm);
        } else {
            if (!pathologyNotEmpty()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar una patología", "");
                FacesContext.getCurrentInstance().addMessage("", fm);
            } else if (!pathologyExists()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La patología no existe", "");
                FacesContext.getCurrentInstance().addMessage("", fm);
            }
            if (!selectOneState()) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar un estado", "");
                FacesContext.getCurrentInstance().addMessage("", fm);
            }
        }
    }

    /////////////////////////*Validación nuevo diagnostico*////////////////////////////
    public boolean pathologyNotEmpty() {
        return !pathologyName.isEmpty();
    }

    public boolean pathologyExists() {
        return !pathologyFacade.searchByNombre(pathologyName).isEmpty();
    }

    public boolean selectOneState() {
        return !diagnosticState.equals("0");
    }
    /////////////////////////*Fin validación nuevo diagnostico*////////////////////////////

    public void addConsultation() {
        if (consultationState.equals("iniciada")) {
            diagnosticHipothesis = "iniciada";
            consultationReason = "iniciada";
            consultationCanceled = false;
            consultationPaused = false;
            Consulta newConsultation = new Consulta(null);
            Date date = new Date();
            consultationCanceled = true;
            newConsultation.setEpisodioid(searchEpisode.get(0));
            newConsultation.setConsultafecha(date);
            newConsultation.setHdiagnostica(diagnosticHipothesis);
            newConsultation.setMotivoConsulta(consultationReason);
            newConsultation.setPausada(consultationCanceled);
            newConsultation.setPausada(consultationPaused);
            newConsultation.setEstado("iniciada");
            consultationFacade.create(newConsultation);
            consultationReason = "";
            diagnosticHipothesis = "";
            consultationState = "";
            idConsultation = newConsultation.getConsultaid();
        } else {
            if (consultationState.equals("cancelada")) {
                if (notEmptyCanceled()) {
                    if (!notEmptyHipothesis()) {
                        diagnosticHipothesis = "no ingresada.";
                    }
                    if (!notEmptyReason()) {
                        consultationReason = "no ingresado.";
                    }
                    Date date = new Date();

                    Consulta newConsultation = new Consulta(idConsultation);
                    consultationCanceled = true;
                    newConsultation.setEpisodioid(searchEpisode.get(0));
                    newConsultation.setHdiagnostica(diagnosticHipothesis);
                    newConsultation.setConsultafecha(date);
                    newConsultation.setCancelada(consultationCanceled);
                    newConsultation.setMotivocancel(canceledReason);
                    newConsultation.setPausada(consultationPaused);
                    newConsultation.setMotivoConsulta(consultationReason);
                    newConsultation.setNotas(consultationNotes);
                    newConsultation.setExploracionFisica(physicalExamination);
                    newConsultation.setPertinencia(pertinence);
                    newConsultation.setEstado("Cancelada");
                    consultationFacade.edit(newConsultation);
                    RequestContext.getCurrentInstance().execute("cancelConsultationDialog.hide()");
                    RequestContext.getCurrentInstance().execute("newConsultationDialog.hide()");

                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta cancelada", "");
                    FacesContext.getCurrentInstance().addMessage("", fm);
                    resetConsultation();
                } else {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un motivo para cancelar la consulta.", "");
                    FacesContext.getCurrentInstance().addMessage("", fm);
                }
            } else {
                System.out.println("whadafa");
                if (notEmptyHipothesis() && notEmptyReason() && notEmptyDiagnoses()) {
                    Date date = new Date();

                    Consulta newConsultation = new Consulta(idConsultation);
                    newConsultation.setEpisodioid(searchEpisode.get(0));
                    newConsultation.setHdiagnostica(diagnosticHipothesis);
                    newConsultation.setConsultafecha(date);
                    newConsultation.setCancelada(consultationCanceled);
                    newConsultation.setMotivocancel(canceledReason);
                    if (consultationState.equals("pausada")) {
                        consultationPaused = true;
                    } else {
                        consultationPaused = false;
                    }
                    newConsultation.setMotivoConsulta(consultationReason);
                    newConsultation.setNotas(consultationNotes);
                    newConsultation.setExploracionFisica(physicalExamination);
                    newConsultation.setPertinencia(pertinence);
                    newConsultation.setEstado(consultationState);
                    consultationFacade.edit(newConsultation);

                    for (DiagnosesPathology diagnostic : diagPathList) {
                        Patologia newPatologia = pathologyFacade.searchById(diagnostic.getPathologyId()).get(0);
                        Diagnostico newDiagnostico = new Diagnostico(null);
                        newDiagnostico.setPatologiaid(newPatologia);
                        newDiagnostico.setConsultaid(newConsultation);
                        newDiagnostico.setDiagnosticofecha(diagnostic.getDiagnosticDate());
                        newDiagnostico.setDiagnosticoges(diagnostic.isDiagnosticGes());
                        newDiagnostico.setDiagnosticoestado(diagnostic.getDiagnosticState());
                        diagnosticFacade.create(newDiagnostico);
                    }
                    RequestContext.getCurrentInstance().execute("dialogEndConsultation.hide()");
                    RequestContext.getCurrentInstance().execute("newConsultationDialog.hide()");
                    resetConsultation();
                    if (consultationReason.equals("pausada")) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta pausada", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    } else {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta finalizada", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                } else {
                    if (!notEmptyHipothesis()) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar una hipótesis", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                    if (!notEmptyReason()) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un motivo para la consulta", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                    if (!notEmptyDiagnoses()) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un diagnóstico", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                }
            }
        }
    }

    public void addConsultation(String consultationState) {
        if (consultationState.equals("iniciada")) {
            diagnosticHipothesis = "iniciada";
            consultationReason = "iniciada";
            consultationCanceled = false;
            consultationPaused = false;
            Consulta newConsultation = new Consulta(null);
            Date date = new Date();
            consultationCanceled = true;
            newConsultation.setEpisodioid(searchEpisode.get(0));
            newConsultation.setConsultafecha(date);
            newConsultation.setHdiagnostica(diagnosticHipothesis);
            newConsultation.setMotivoConsulta(consultationReason);
            newConsultation.setPausada(consultationCanceled);
            newConsultation.setPausada(consultationPaused);
            newConsultation.setEstado("iniciada");
            consultationFacade.create(newConsultation);
            consultationReason = "";
            diagnosticHipothesis = "";
            this.consultationState = "";
            idConsultation = newConsultation.getConsultaid();
        } else {
            this.consultationState = consultationState;
            if (consultationState.equals("cancelada")) {
                if (notEmptyCanceled()) {
                    if (!notEmptyHipothesis()) {
                        diagnosticHipothesis = "no ingresada.";
                    }
                    if (!notEmptyReason()) {
                        consultationReason = "no ingresado.";
                    }
                    Date date = new Date();

                    Consulta newConsultation = new Consulta(idConsultation);
                    consultationCanceled = true;
                    newConsultation.setEpisodioid(searchEpisode.get(0));
                    newConsultation.setHdiagnostica(diagnosticHipothesis);
                    newConsultation.setConsultafecha(date);
                    newConsultation.setCancelada(consultationCanceled);
                    newConsultation.setMotivocancel(canceledReason);
                    newConsultation.setPausada(consultationPaused);
                    newConsultation.setMotivoConsulta(consultationReason);
                    newConsultation.setNotas(consultationNotes);
                    newConsultation.setExploracionFisica(physicalExamination);
                    newConsultation.setPertinencia(pertinence);
                    newConsultation.setEstado("Cancelada");

                    consultationFacade.edit(newConsultation);
                    RequestContext.getCurrentInstance().execute("cancelConsultationDialog.hide()");
                    RequestContext.getCurrentInstance().execute("newConsultationDialog.hide()");

                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta cancelada", "");
                    FacesContext.getCurrentInstance().addMessage("", fm);
                    resetConsultation();
                } else {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un motivo para cancelar la consulta.", "");
                    FacesContext.getCurrentInstance().addMessage("", fm);
                }
            } else {
                if (notEmptyHipothesis() && notEmptyReason() && notEmptyDiagnoses()) {
                    Date date = new Date();

                    Consulta newConsultation = new Consulta(idConsultation);
                    newConsultation.setEpisodioid(searchEpisode.get(0));
                    newConsultation.setHdiagnostica(diagnosticHipothesis);
                    newConsultation.setConsultafecha(date);
                    newConsultation.setCancelada(consultationCanceled);
                    newConsultation.setMotivocancel(canceledReason);
                    if (consultationState.equals("pausada")) {
                        consultationPaused = true;
                    } else {
                        consultationPaused = false;
                    }
                    newConsultation.setPausada(consultationPaused);
                    newConsultation.setMotivoConsulta(consultationReason);
                    newConsultation.setNotas(consultationNotes);
                    newConsultation.setExploracionFisica(physicalExamination);
                    newConsultation.setPertinencia(pertinence);
                    newConsultation.setEstado(consultationState);
                    consultationFacade.edit(newConsultation);
                    for (DiagnosesPathology diagnostic : diagPathList) {
                        Patologia newPatologia = pathologyFacade.searchById(diagnostic.getPathologyId()).get(0);
                        Diagnostico newDiagnostico = new Diagnostico(null);
                        newDiagnostico.setPatologiaid(newPatologia);
                        newDiagnostico.setConsultaid(newConsultation);
                        newDiagnostico.setDiagnosticofecha(diagnostic.getDiagnosticDate());
                        newDiagnostico.setDiagnosticoges(diagnostic.isDiagnosticGes());
                        newDiagnostico.setDiagnosticoestado(diagnostic.getDiagnosticState());
                        diagnosticFacade.create(newDiagnostico);
                    }
                    RequestContext.getCurrentInstance().execute("dialogEndConsultation.hide()");
                    RequestContext.getCurrentInstance().execute("newConsultationDialog.hide()");
                    resetConsultation();
                    if (consultationReason.equals("pausada")) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta pausada", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    } else {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta finalizada", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                } else {
                    if (!notEmptyHipothesis()) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar una hipótesis", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                    if (!notEmptyReason()) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un motivo para la consulta", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                    if (!notEmptyDiagnoses()) {
                        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un diagnóstico", "");
                        FacesContext.getCurrentInstance().addMessage("", fm);
                    }
                }
            }
        }
    }

    /////////////////////////*Validación nueva consulta*////////////////////////////
    public boolean notEmptyCanceled() {
        return !canceledReason.isEmpty();
    }

    public boolean notEmptyHipothesis() {
        return !diagnosticHipothesis.isEmpty();
    }

    public boolean notEmptyReason() {
        return !consultationReason.isEmpty();
    }

    public boolean notEmptyDiagnoses() {
        return !diagPathList.isEmpty();
    }
    /////////////////////////*Fin validación nueva consulta*////////////////////////////

    public void selectEnable() {
        if (!consultationState.isEmpty()) {
            disableEnd = false;
        }
    }

    public void resetConsultation() {
        diagnosticDate = null;
        diagnosticGes = false;
        diagnosticState = "";
        pathologyId = "";
        pathologyName = "";
        pathologyGes = false;
        disableEnd = true;
        diagPath = null;
        diagPathList = new ArrayList<DiagnosesPathology>();
        diagnosticHipothesis = "";
        consultationReason = "";
        consultationCanceled = false;
        canceledReason = "";
        consultationPaused = false;
        consultationNotes = "";
        physicalExamination = "";
        pertinence = false;
        isGes = false;
        disableEnd = true;
        consultationState = "";
        resetDiagnostic();
    }

    public void resetDiagnostic() {
        pathologyName = "";
        diagnosticState = "0";
        diagnosticGes = false;
        resetMoreDiagnoses();
    }

    public void resetMoreDiagnoses() {
        selectedPathology = null;
    }

    public void resetCancel() {
        canceledReason = "";
    }

    public List<String> completeTextPathology(String query) {
        pathology = pathologyFacade.findAll();
        List<String> results = new ArrayList<String>();

        for (Patologia pathology1 : pathology) {
            if (pathology1.getPatologianombre().startsWith(query)) {
                results.add(pathology1.getPatologianombre());
                pathologyId = pathology1.getPatologiaid();
            }
        }
        return results;
    }

    public boolean isIsGes() {
        return isGes;
    }

    public void setIsGes(boolean isGes) {
        this.isGes = isGes;
    }

    public Integer getRut() {
        return Rut;
    }

    public void setRut(Integer rut) {
        this.Rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DiagnosesPathology> getDiagPathList() {
        return diagPathList;
    }

    public void setDiagPathList(List<DiagnosesPathology> diagPathList) {
        this.diagPathList = diagPathList;
    }

    public Patologia getSelectedPathology() {
        return selectedPathology;
    }

    public void setSelectedPathology(Patologia selectedPathology) {
        this.selectedPathology = selectedPathology;
    }

    public Date getDiagnosticDate() {
        return diagnosticDate;
    }

    public void setDiagnosticDate(Date diagnosticDate) {
        this.diagnosticDate = diagnosticDate;
    }

    public boolean isDiagnosticGes() {
        return diagnosticGes;
    }

    public void setDiagnosticGes(boolean diagnosticGes) {
        this.diagnosticGes = diagnosticGes;
    }

    public String getDiagnosticState() {
        return diagnosticState;
    }

    public void setDiagnosticState(String diagnosticState) {
        this.diagnosticState = diagnosticState;
    }

    public String getPathologyId() {
        return pathologyId;
    }

    public void setPathologyId(String pathologyId) {
        this.pathologyId = pathologyId;
    }

    public String getPathologyName() {
        return pathologyName;
    }

    public void setPathologyName(String pathologyName) {
        this.pathologyName = pathologyName;
    }

    public boolean isPathologyGes() {
        return pathologyGes;
    }

    public void setPathologyGes(boolean pathologyGes) {
        this.pathologyGes = pathologyGes;
    }

    public String getDiagnosticHipothesis() {
        return diagnosticHipothesis;
    }

    public void setDiagnosticHipothesis(String diagnosticHipothesis) {
        this.diagnosticHipothesis = diagnosticHipothesis;
    }

    public String getConsultationReason() {
        return consultationReason;
    }

    public void setConsultationReason(String consultationReason) {
        this.consultationReason = consultationReason;
    }

    public boolean isConsultationCanceled() {
        return consultationCanceled;
    }

    public void setConsultationCanceled(boolean consultationCanceled) {
        this.consultationCanceled = consultationCanceled;
    }

    public String getCanceledReason() {
        return canceledReason;
    }

    public void setCanceledReason(String canceledReason) {
        this.canceledReason = canceledReason;
    }

    public boolean isConsultationPaused() {
        return consultationPaused;
    }

    public void setConsultationPaused(boolean consultationPaused) {
        this.consultationPaused = consultationPaused;
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

    public boolean isPertinence() {
        return pertinence;
    }

    public void setPertinence(boolean pertinence) {
        this.pertinence = pertinence;
    }

    //<!--aqui-->
    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }

    public List<Muesta> getSearchSamples() {
        return searchSamples;
    }

    public void setSearchSamples(List<Muesta> searchSamples) {
        this.searchSamples = searchSamples;
    }

    public List<Diagnostico> getSelectedDiagnosis() {
        return selectedDiagnosis;
    }

    public void setSelectedDiagnosis(List<Diagnostico> selectedDiagnosis) {
        this.selectedDiagnosis = selectedDiagnosis;
    }

    public List<Diagnostico> getFilteredDiagnosesConsultation() {
        return filteredDiagnosesConsultation;
    }

    public void setFilteredDiagnosesConsultation(List<Diagnostico> filteredDiagnosesConsultation) {
        this.filteredDiagnosesConsultation = filteredDiagnosesConsultation;
    }

    public List<Diagnostico> getAllDiagnosesConsultation() {
        return allDiagnosesConsultation;
    }

    public void setAllDiagnosesConsultation(List<Diagnostico> allDiagnosesConsultation) {
        this.allDiagnosesConsultation = allDiagnosesConsultation;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    public String getConsultationState() {
        return consultationState;
    }

    public void setConsultationState(String consultationState) {
        this.consultationState = consultationState;
    }

    public boolean isDisableEnd() {
        return disableEnd;
    }

    public void setDisableEnd(boolean disableEnd) {
        this.disableEnd = disableEnd;
    }

    public viewVitalSigns getSignosVitales() {
        return signosVitales;
    }

    public void setSignosVitales(viewVitalSigns signosVitales) {
        this.signosVitales = signosVitales;
    }

}
