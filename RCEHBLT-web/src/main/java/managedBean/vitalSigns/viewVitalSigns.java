/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean.vitalSigns;

//import com.sun.glass.ui.SystemClipboard;
import cl.rcehblt.entities.Muesta;
import cl.rcehblt.entities.Paciente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import cl.rcehblt.sessionbeans.MuestaFacadeLocal;
import cl.rcehblt.sessionbeans.PacienteFacadeLocal;
import cl.rcehblt.sessionbeans.PersonaFacadeLocal;

/**
 *
 * @author Gustavo Salvo Lara
 */
@ManagedBean
@SessionScoped
public class viewVitalSigns {

    @EJB
    private PacienteFacadeLocal patientFacade;
    @EJB
    private PersonaFacadeLocal personFacade;
    @EJB
    private MuestaFacadeLocal muestaFacade;

    private List<Paciente> searchPaciente;
    private List<Muesta> searchSamples;
    private Integer PersonId;
    private Integer Rut;
    private Integer personID;
    private int samplesId;
    private List<Integer> groups = new ArrayList<Integer>();
    private List<DateGroup> dateGroup = new ArrayList<DateGroup>();

    @PostConstruct
    public void init() {
        /*PersonId = personFacade.findByRut(Rut);
        searchPaciente = patientFacade.searchByPerson(PersonId);
        boolean exist = false;
        int maxGroup = 0;
        searchSamples = muestaFacade.searchByPatient(searchPaciente.get(0));
        for (Muesta searchSample : searchSamples) {
            for (Integer group : groups) {
                if (group == searchSample.getGrupo()) {
                    exist = true;
                }
            }
            if (exist == false) {
                groups.add(searchSample.getGrupo());
                String dateAux = searchSample.getFecha().toString();
                dateGroup.add(new DateGroup(searchSample.getGrupo(), dateAux));
            }
            exist = false;
            maxGroup = searchSample.getGrupo();
        }
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), maxGroup);
        if (searchSamples.size() > 0) {
            long dateSample = searchSamples.get(0).getFecha().getTime();
            long today = (new Date()).getTime();
            long diference = today - dateSample;
            double diferenceDay = Math.floor(diference / (1000 * 60 * 60 * 24));
            if (diferenceDay >= 1) {
                searchSamples = null;
            }
        }*/
    }
    
    public void start(Integer rut){
        System.out.println("SI");
        Rut = rut;
        PersonId = personFacade.findByRut(Rut);
        searchPaciente = patientFacade.searchByPerson(PersonId);
        boolean exist = false;
        int maxGroup = 0;
        searchSamples = muestaFacade.searchByPatient(searchPaciente.get(0));
        System.out.println(searchSamples);
        for (Muesta searchSample : searchSamples) {
            for (Integer group : groups) {
                if (group == searchSample.getGrupo()) {
                    exist = true;
                }
            }
            if (exist == false) {
                groups.add(searchSample.getGrupo());
                String dateAux = searchSample.getFecha().toString();
                dateGroup.add(new DateGroup(searchSample.getGrupo(), dateAux));
            }
            exist = false;
            maxGroup = searchSample.getGrupo();
        }
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), maxGroup);
        if (searchSamples.size() > 0) {
            long dateSample = searchSamples.get(0).getFecha().getTime();
            long today = (new Date()).getTime();
            long diference = today - dateSample;
            double diferenceDay = Math.floor(diference / (1000 * 60 * 60 * 24));
            if (diferenceDay >= 1) {
                searchSamples = null;
            }
        }
    }

    public void update() {
        boolean exist = false;
        int maxGroup = 0;
        searchSamples = muestaFacade.searchByPatient(searchPaciente.get(0));
        for (Muesta searchSample : searchSamples) {
            for (Integer group : groups) {
                if (group == searchSample.getGrupo()) {
                    exist = true;
                }
            }
            if (exist == false) {
                groups.add(searchSample.getGrupo());
            }
            exist = false;
            maxGroup = searchSample.getGrupo();
        }
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), maxGroup);
        RequestContext.getCurrentInstance().execute("newConsultationDialog.show()");
    }

    public void showSamples() {
        PersonId = personFacade.findByRut(Rut);
        searchPaciente = patientFacade.searchByPerson(PersonId);
        searchSamples = muestaFacade.searchByPatientGroup(searchPaciente.get(0), samplesId);
        System.out.println("Fecha seleccionada: " + samplesId);

    }

    public List<DateGroup> getDateGroup() {
        return dateGroup;
    }

    public void setDateGroup(List<DateGroup> dateGroup) {
        this.dateGroup = dateGroup;
    }

    public List<Muesta> getSearchSamples() {
        return searchSamples;
    }

    public void setSearchSamples(List<Muesta> searchSamples) {
        this.searchSamples = searchSamples;
    }

}
