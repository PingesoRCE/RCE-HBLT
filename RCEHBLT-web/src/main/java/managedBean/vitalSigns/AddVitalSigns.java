/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.vitalSigns;

import cl.rcehblt.entities.Muesta;
import cl.rcehblt.entities.Paciente;
import cl.rcehblt.entities.RegistroClinico;
import cl.rcehblt.entities.SignosVitales;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import cl.rcehblt.sessionbeans.MuestaFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;
import cl.rcehblt.sessionbeans.RegistroClinicoFacadeLocal;
import cl.rcehblt.sessionbeans.SignosVitalesFacadeLocal;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@ViewScoped
public class AddVitalSigns {

    @EJB
    private MuestaFacadeLocal sampleFacade;
    @EJB
    private RegistroClinicoFacadeLocal clinicalRecordFacade;
    @EJB
    private PacienteFacadeLocal patientFacade;
    @EJB
    private PersonaFacadeLocal personFacade;
    @EJB
    private SignosVitalesFacadeLocal vitalSignsFacade;

    private List<SignosVitales> searchVitalSigns;
    private String vitalSignsName;
    private int vitalSignsMinRange;
    private int vitalSignsMaxRange;

    private List<SignosVitales> selectedVitalSign;
    private int vitalSignsId;
    private Double vitalSignsValue= new Double(0);

    private List<Paciente> searchPatient;
    private List<RegistroClinico> searchClinicalRecord;

    private Integer PersonId;
    private Integer rut = 6972769;

    private List<Muesta> createSamples = new ArrayList<Muesta>();
    private List<Muesta> createSamplesAlways = new ArrayList<Muesta>();
    int max = 0;

    private Double imc;

    private Double peso = new Double(0);
    private String unitPeso ;
    private Double maxPeso;
    private Double minPeso;

    private Double altura= new Double(0);
    private String unitAltura;
    private Double maxAltura;
    private Double minAltura;

    private Double temperatura= new Double(0);
    private String unitTemperatura;
    private Double maxTemperatura;
    private Double minTemperatura;

    private Double saturacion= new Double(0);
    private String unitSaturacion;
    private Double maxSaturacion;
    private Double minSaturacion;

    private Double presionSistolica= new Double(0);
    private String unitPresionSistolica;
    private Double maxPresionSistolica;
    private Double minPresionSistolica;

    private Double presionDiastolica= new Double(0);
    private String unitPresionDiastolica;
    private Double maxPresionDiastolica;
    private Double minPresionDiastolica;

    private String GeneralUnit;
    private Double maxGeneralUnit;
    private Double minGeneralUnit;

    private List<SignosVitales> controllerVitalSigns = new ArrayList<SignosVitales>();

    public void start(Integer rut){
        this.rut = rut;
    }
    
    public void returnUnit() {
        for (int i = 0; i < searchVitalSigns.size(); i++) {

            if (searchVitalSigns.get(i).getNombreSvital().equals("Peso")) {
                unitPeso = searchVitalSigns.get(i).getUnidad();
                minPeso = (double) searchVitalSigns.get(i).getRangoMin();
                maxPeso = (double) searchVitalSigns.get(i).getRangoMax();
            }
            if (searchVitalSigns.get(i).getNombreSvital().equals("Altura")) {
                unitAltura = searchVitalSigns.get(i).getUnidad();
                minAltura = (double) searchVitalSigns.get(i).getRangoMin();
                maxAltura = (double) searchVitalSigns.get(i).getRangoMax();
            }
            if (searchVitalSigns.get(i).getNombreSvital().equals("Temperatura")) {
                unitTemperatura = searchVitalSigns.get(i).getUnidad();
                minTemperatura = (double) searchVitalSigns.get(i).getRangoMin();
                maxTemperatura = (double) searchVitalSigns.get(i).getRangoMax();
            }
            if (searchVitalSigns.get(i).getNombreSvital().equals("Saturación O2")) {
                unitSaturacion = searchVitalSigns.get(i).getUnidad();
                minSaturacion = (double) searchVitalSigns.get(i).getRangoMin();
                maxSaturacion = (double) searchVitalSigns.get(i).getRangoMax();
            }
            if (searchVitalSigns.get(i).getNombreSvital().equals("Presión Sistólica")) {
                unitPresionSistolica = searchVitalSigns.get(i).getUnidad();
                minPresionSistolica = (double) searchVitalSigns.get(i).getRangoMin();
                maxPresionSistolica = (double) searchVitalSigns.get(i).getRangoMax();
            }
            if (searchVitalSigns.get(i).getNombreSvital().equals("Presión Diastólica")) {
                unitPresionDiastolica = searchVitalSigns.get(i).getUnidad();
                minPresionDiastolica = (double) searchVitalSigns.get(i).getRangoMin();
                maxPresionDiastolica = (double) searchVitalSigns.get(i).getRangoMax();
            }

        }
    }

    public void resultIMC() {
        if(altura!=0 && peso !=0){
            imc = Math.rint((peso/((altura/100)*(altura/100)))*100)/100;
        }
    }

    public void returnGeneralUnit() {
        vitalSignsValue = 0.0;
        if (vitalSignsId == 0) {
            GeneralUnit = "";
            maxGeneralUnit = 0.0;
            minGeneralUnit = 0.0;
        } else {
            for (int i = 0; i < searchVitalSigns.size(); i++) {
                if (searchVitalSigns.get(i).getIdSvitales() == vitalSignsId) {
                    GeneralUnit = searchVitalSigns.get(i).getUnidad();
                    maxGeneralUnit = (double) searchVitalSigns.get(i).getRangoMax();
                    minGeneralUnit = (double) searchVitalSigns.get(i).getRangoMin();
                    if (searchVitalSigns.get(i).getIdSvitales() == 17) {
                        vitalSignsValue = imc;
                    }
                    return;
                }
            }
        }

    }

    @PostConstruct
    public void init() {
        String[] vitalSignsO = {"Peso", "Altura", "Temperatura", "Saturación O2",
            "Presión Sistólica", "Presión Diastólica"};
        searchVitalSigns = vitalSignsFacade.findAll();
        returnUnit();
        for (int i = 0; i < searchVitalSigns.size(); i++) {
            for (int j = 0; j < vitalSignsO.length; j++) {
                if (searchVitalSigns.get(i).getNombreSvital().equals(vitalSignsO[j])) {
                    searchVitalSigns.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    public void addNewVitalSigns() {
        SignosVitales newVitalSigns = new SignosVitales(null, vitalSignsName);
        newVitalSigns.setRangoMin(vitalSignsMinRange);
        newVitalSigns.setRangoMax(vitalSignsMaxRange);

        vitalSignsFacade.create(newVitalSigns);
        searchVitalSigns = vitalSignsFacade.findAll();
    }

    public void createVitalSignsPatients() {
        PersonId = personFacade.findByRut(rut);
        searchPatient = patientFacade.searchByPerson(PersonId);
        searchClinicalRecord = clinicalRecordFacade.searchByPaciente(searchPatient.get(0));

        List<Muesta> allSamples = sampleFacade.searchByPatient(searchPatient.get(0));
        max = 0;
        if (allSamples.isEmpty()) {
            max = 0;
        } else {
            for (Muesta allSample : allSamples) {
                if (allSample.getGrupo() > max) {
                    max = allSample.getGrupo();
                } else {
                }
            }
            max++;
        }

        Date fecha = new Date();

        selectedVitalSign = vitalSignsFacade.searchByName("Peso");
        Muesta newMuesta = new Muesta(null);
        newMuesta.setFecha(fecha);
        newMuesta.setValor(peso);
        newMuesta.setIdPersona(searchPatient.get(0));
        newMuesta.setIdSvitales(selectedVitalSign.get(0));
        newMuesta.setGrupo(max);
        createSamplesAlways.add(newMuesta);

        newMuesta = new Muesta(null);
        selectedVitalSign = vitalSignsFacade.searchByName("Altura");
        newMuesta.setFecha(fecha);
        newMuesta.setValor(altura);
        newMuesta.setIdPersona(searchPatient.get(0));
        newMuesta.setIdSvitales(selectedVitalSign.get(0));
        newMuesta.setGrupo(max);
        createSamplesAlways.add(newMuesta);

        newMuesta = new Muesta(null);
        selectedVitalSign = vitalSignsFacade.searchByName("Temperatura");
        newMuesta.setFecha(fecha);
        newMuesta.setValor(temperatura);
        newMuesta.setIdPersona(searchPatient.get(0));
        newMuesta.setIdSvitales(selectedVitalSign.get(0));
        newMuesta.setGrupo(max);
        createSamplesAlways.add(newMuesta);

        newMuesta = new Muesta(null);
        selectedVitalSign = vitalSignsFacade.searchByName("Saturación O2");
        newMuesta.setFecha(fecha);
        newMuesta.setValor(saturacion);
        newMuesta.setIdPersona(searchPatient.get(0));
        newMuesta.setIdSvitales(selectedVitalSign.get(0));
        newMuesta.setGrupo(max);
        createSamplesAlways.add(newMuesta);

        newMuesta = new Muesta(null);
        selectedVitalSign = vitalSignsFacade.searchByName("Presión Sistólica");
        newMuesta.setFecha(fecha);
        newMuesta.setValor(presionSistolica);
        newMuesta.setIdPersona(searchPatient.get(0));
        newMuesta.setIdSvitales(selectedVitalSign.get(0));
        newMuesta.setGrupo(max);
        createSamplesAlways.add(newMuesta);

        newMuesta = new Muesta(null);
        selectedVitalSign = vitalSignsFacade.searchByName("Presión Diastólica");
        newMuesta.setFecha(fecha);
        newMuesta.setValor(presionDiastolica);
        newMuesta.setIdPersona(searchPatient.get(0));
        newMuesta.setIdSvitales(selectedVitalSign.get(0));
        newMuesta.setGrupo(max);
        createSamplesAlways.add(newMuesta);

        for (int i = 0; i < createSamplesAlways.size(); i++) {
            if (createSamplesAlways.get(i).getValor() != 0) {
                sampleFacade.create(createSamplesAlways.get(i));
            }
        }

        createSamplesAlways.clear();

        for (Muesta createSample : createSamples) {
            sampleFacade.create(createSample);
        }

        resetVitalSigns();
    }

    public void deleteVitalSignal(Muesta deleteSample) {
        for (int i = 0; i < createSamples.size(); i++) {
            if (deleteSample.getIdSvitales().equals(createSamples.get(i).getIdSvitales())) {
                createSamples.remove(i);
                return;
            }
        }
    }

    public void addVitalSignsPatients() {
        if (vitalSignsId == 0) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Seleccione un signo vital", "");
            FacesContext.getCurrentInstance().addMessage("", fm);
        } else {
            boolean exists = false;
            PersonId = personFacade.findByRut(rut);
            searchPatient = patientFacade.searchByPerson(PersonId);
            selectedVitalSign = vitalSignsFacade.searchById(vitalSignsId);
            List<Muesta> allSamples = sampleFacade.searchByPatient(searchPatient.get(0));
            max = 0;
            if (allSamples.isEmpty()) {
                max = 0;
            } else {
                for (int i = 0; i < allSamples.size(); i++) {
                    if (allSamples.get(i).getGrupo() > max) {
                        max = allSamples.get(i).getGrupo();
                    } else {

                    }
                }
                max++;
            }
            Date fecha = new Date();
            Muesta newMuesta = new Muesta(null);
            newMuesta.setValor(vitalSignsValue);
            newMuesta.setFecha(fecha);
            newMuesta.setIdPersona(searchPatient.get(0));
            newMuesta.setIdSvitales(selectedVitalSign.get(0));
            newMuesta.setGrupo(max);
            for (Muesta createSample : createSamples) {
                if (newMuesta.getIdSvitales().equals(createSample.getIdSvitales())) {
                    exists = true;
                }
            }
            if (!exists) {
                createSamples.add(newMuesta);
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "El signo vital se ha ingresado.", "");
                FacesContext.getCurrentInstance().addMessage("", fm);
            }
        }
    }

    public void resetVitalSigns() {
        createSamples.clear();
        max = 0;
        peso = 0.0;
        altura = 0.0;
        temperatura = 0.0;
        saturacion = 0.0;
        presionSistolica = 0.0;
        presionDiastolica = 0.0;
        vitalSignsId = 0;
        vitalSignsValue = 0.0;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(Double saturacion) {
        this.saturacion = saturacion;
    }

    public Double getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(Double presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public Double getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(Double presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    public List<SignosVitales> getSearchVitalSigns() {
        return searchVitalSigns;
    }

    public void setSearchVitalSigns(List<SignosVitales> searchVitalSigns) {
        this.searchVitalSigns = searchVitalSigns;
    }

    public int getVitalSignsId() {
        return vitalSignsId;
    }

    public void setVitalSignsId(int vitalSignsId) {
        this.vitalSignsId = vitalSignsId;
    }

    public Double getVitalSignsValue() {
        return vitalSignsValue;
    }

    public void setVitalSignsValue(Double vitalSignsValue) {
        this.vitalSignsValue = vitalSignsValue;
    }

    public List<Muesta> getCreateSamples() {
        return createSamples;
    }

    public void setCreateSamples(List<Muesta> createSamples) {
        this.createSamples = createSamples;
    }

    public String getUnitPeso() {
        return unitPeso;
    }

    public void setUnitPeso(String unitPeso) {
        this.unitPeso = unitPeso;
    }

    public String getUnitAltura() {
        return unitAltura;
    }

    public void setUnitAltura(String unitAltura) {
        this.unitAltura = unitAltura;
    }

    public String getUnitTemperatura() {
        return unitTemperatura;
    }

    public void setUnitTemperatura(String unitTemperatura) {
        this.unitTemperatura = unitTemperatura;
    }

    public String getUnitSaturacion() {
        return unitSaturacion;
    }

    public void setUnitSaturacion(String unitSaturacion) {
        this.unitSaturacion = unitSaturacion;
    }

    public String getUnitPresionSistolica() {
        return unitPresionSistolica;
    }

    public void setUnitPresionSistolica(String unitPresionSistolica) {
        this.unitPresionSistolica = unitPresionSistolica;
    }

    public String getUnitPresionDiastolica() {
        return unitPresionDiastolica;
    }

    public void setUnitPresionDiastolica(String unitPresionDiastolica) {
        this.unitPresionDiastolica = unitPresionDiastolica;
    }

    public String getGeneralUnit() {
        return GeneralUnit;
    }

    public void setGeneralUnit(String GeneralUnit) {
        this.GeneralUnit = GeneralUnit;
    }

    public Double getMaxPeso() {
        return maxPeso;
    }

    public void setMaxPeso(Double maxPeso) {
        this.maxPeso = maxPeso;
    }

    public Double getMinPeso() {
        return minPeso;
    }

    public void setMinPeso(Double minPeso) {
        this.minPeso = minPeso;
    }

    public Double getMaxAltura() {
        return maxAltura;
    }

    public void setMaxAltura(Double maxAltura) {
        this.maxAltura = maxAltura;
    }

    public Double getMinAltura() {
        return minAltura;
    }

    public void setMinAltura(Double minAltura) {
        this.minAltura = minAltura;
    }

    public Double getMaxTemperatura() {
        return maxTemperatura;
    }

    public void setMaxTemperatura(Double maxTemperatura) {
        this.maxTemperatura = maxTemperatura;
    }

    public Double getMinTemperatura() {
        return minTemperatura;
    }

    public void setMinTemperatura(Double minTemperatura) {
        this.minTemperatura = minTemperatura;
    }

    public Double getMaxSaturacion() {
        return maxSaturacion;
    }

    public void setMaxSaturacion(Double maxSaturacion) {
        this.maxSaturacion = maxSaturacion;
    }

    public Double getMinSaturacion() {
        return minSaturacion;
    }

    public void setMinSaturacion(Double minSaturacion) {
        this.minSaturacion = minSaturacion;
    }

    public Double getMaxPresionSistolica() {
        return maxPresionSistolica;
    }

    public void setMaxPresionSistolica(Double maxPresionSistolica) {
        this.maxPresionSistolica = maxPresionSistolica;
    }

    public Double getMinPresionSistolica() {
        return minPresionSistolica;
    }

    public void setMinPresionSistolica(Double minPresionSistolica) {
        this.minPresionSistolica = minPresionSistolica;
    }

    public Double getMaxPresionDiastolica() {
        return maxPresionDiastolica;
    }

    public void setMaxPresionDiastolica(Double maxPresionDiastolica) {
        this.maxPresionDiastolica = maxPresionDiastolica;
    }

    public Double getMinPresionDiastolica() {
        return minPresionDiastolica;
    }

    public void setMinPresionDiastolica(Double minPresionDiastolica) {
        this.minPresionDiastolica = minPresionDiastolica;
    }

    public Double getMaxGeneralUnit() {
        return maxGeneralUnit;
    }

    public void setMaxGeneralUnit(Double maxGeneralUnit) {
        this.maxGeneralUnit = maxGeneralUnit;
    }

    public Double getMinGeneralUnit() {
        return minGeneralUnit;
    }

    public void setMinGeneralUnit(Double minGeneralUnit) {
        this.minGeneralUnit = minGeneralUnit;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

}
