/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mb;

import cl.rcehblt.entities.*;
import cl.rcehblt.sessionbeans.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import managedBean.consultation.NewConsultation;



/**
 *
 * @author camilo
 */
@ManagedBean
@SessionScoped
public class MedicamentosMb {
    @EJB
    private InternaFacadeLocal recetaInternaFacade;
    @EJB
    private ConsultaFacadeLocal consultaFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;
    @EJB
    private RegistroClinicoFacadeLocal registroClinicoFacade;
    @EJB
    private ExamenFacadeLocal examenFacade;
    @EJB
    private SolicitudexamenFacadeLocal solicitudexamenFacade;
    @EJB
    private SolexexFacadeLocal solexexFacade;
    

    @Inject
    LoginSessionMB session;

    @Inject
    IndicacionesMb indicacion;

    @EJB
    private RexternaFarmacoFacadeLocal rexternaFarmacoFacade;

    @EJB
    private ExternaFacadeLocal recetaExternaFacade;
    @EJB
    private RegistroClinicoFacadeLocal clinicalrecordsFacade;
    //@EJB
    //private ProfessionalsFacadeLocal professionalsFacade;
    @EJB
    private PrescriptionFacadeLocal prescriptionFacade;
    @EJB
    private DosisFfFacadeLocal dosisFfFacade;
    @EJB
    private FormaFarmaceuticaFacadeLocal formaFarmaceuticaFacade;
    @EJB
    private DosisFacadeLocal dosisFacade;
    @EJB
    private FfFarmacoFacadeLocal ffFarmacoFacade;
    @EJB
    private FarmacoFacadeLocal farmacoFacade;

    String fechaC;
    String ayuna;
    List<String> dosis;
    String dosis2;
    String buscaFarmaco;
    List<String> formaFarm;
    List<FormaFarmaceutica> aa;
    String ff;
    List<String> receta = new ArrayList<String>();
    String periodo;
    String unidades;
    List<datosReceta> recetaa = new ArrayList<datosReceta>();
    String verificar;
    String userPrint;
    String passPrint;
    String busca;
    String descripcion;
    List<String> examen= new ArrayList<String>();
    List<String> otros= new ArrayList<String>();
    List<String> recetae= new ArrayList<String>();
    List<String> receta1;
    public static int validacion=0;
    
    private String[] selectedBio;
    private String[] selectedCito;
    private String[] selectedOrina;
    private String[] selectedMarc;
    private String[] selectedHemat;
    private String[] selectedHorm;
    private String[] selectedInmun;
    private String[] selectedVen;
    private List<String> selectedExamen;
    private List<String> exam;
    private List<String> examCito;
    private List<String> examOrin;
    private List<String> examMarc;
    private List<String> examHemat;
    private List<String> examHorm;
    private List<String> examInmun;
    private List<String> examVen;
    private String description;
    private String vdrl;
    
    private String[] selectedBiio;
    private String[] selectedCiito;
    private String[] selectedCiito1;
    private String[] selectedCiito2;
    private String[] selectedCiito3;
    private List<String> exaam;
    private List<String> exaamCito;
    private List<String> exaamCito1;
    private List<String> exaamCito2;
    private List<String> exaamCito3;
    private String descriptiion;
    
    private String select;
    private String examenS;
    private String numero;
    private String diaCita;
    private Date date9;
    private String[] selectedExam;
    private List<String> examm;
    
    private String Obs;
    private String referencia;
    private String tratamiento;

    public MedicamentosMb() {
    }
    
    @PostConstruct
    public void init() {
        exaam = new ArrayList<String>();
        exaamCito = new ArrayList<String>();
        exaamCito1 = new ArrayList<String>();
        exaamCito2 = new ArrayList<String>();
        exaamCito3 = new ArrayList<String>();
        exam = new ArrayList<String>();
        examCito = new ArrayList<String>();
        examOrin = new ArrayList<String>();
        examMarc = new ArrayList<String>();
        examHemat = new ArrayList<String>();
        examHorm = new ArrayList<String>();
        examInmun = new ArrayList<String>();
        examVen = new ArrayList<String>();
        selectedExamen = new ArrayList<String>();
        examm = new ArrayList<String>();

        exam.add("Glicemia");
        exam.add("Nitrógeno ureico");
        exam.add("Creatina");
        exam.add("x3 Electrolitos (Na, K, Cl)");
        exam.add("pH y GSA FiO2_______");
        exam.add("pH y GSV");
        exam.add("Creatinquinasa CK");
        exam.add("LDH");
        exam.add("Láctico");
        exam.add("Cetonemia");
        exam.add("Calcio");
        exam.add("Fósforo");
        exam.add("Magnesio");
        exam.add("Lipasa");
        exam.add("Amilasa");
        exam.add("PCR");
        exam.add("Acido urico");
        exam.add("GOT");
        exam.add("GPT");
        exam.add("GGT");
        exam.add("Fosfatasa alcalina");
        exam.add("Bilirrubina total");
        exam.add("Proteinas totales");
        exam.add("Albúmina");
        exam.add("Colesterol total");
        exam.add("Colesterol HDL");
        exam.add("Triglicéridos");
        exam.add("Prueba tolerancia glucosa (0' y 120')");
        exam.add("Clearence creatina (*)");
        exam.add("Osmolaridad plasma");
        examCito.add("Citológico para Citoquimico");
        examCito.add("Fisico-quimico para Citoquimico");
        examCito.add("pH Liquido Biológico");
        examOrin.add("Orina completa");
        examOrin.add("Microalbuminuria");
        examOrin.add("Electrolitos (K, Na, Cl) en orina aislada");
        examOrin.add("Electrolitos (K, Na, Cl) en orina 24 hrs.");
        examOrin.add("Creatinina en orina aislada");
        examOrin.add("Creatinina en orina 24 hrs.");
        examOrin.add("Proteinas en orina aislada");
        examOrin.add("Proteinas en orina 24 hrs.");
        examOrin.add("Nitrógeno ureico en orina 24 hrs.");
        examOrin.add("Calcio en orina 24 hrs.");
        examOrin.add("Fosforo en orina 24 hrs.");
        examOrin.add("Glucosa en orina 24 hrs.");
        examOrin.add("Acido urico en orina 24 hrs.");
        examOrin.add("Estudios cálculos");
        examOrin.add("Proteína/Creatina");
        examMarc.add("Ferritina");
        examMarc.add("Alfafetoproteina");
        examMarc.add("CEA");
        examMarc.add("Ca 125");
        examMarc.add("Antigeno prostatico especif.");
        examHemat.add("Hematocrito");
        examHemat.add("Hemoglobina");
        examHemat.add("Hemoglobina glicosilada");
        examHemat.add("Hemograma");
        examHemat.add("Recuento leucocitos");
        examHemat.add("Recuento reticulocitos");
        examHemat.add("Recuento plaquetas");
        examHemat.add("Eosinófilos absolutos");
        examHemat.add("Eosinófilos sec. nasal");
        examHemat.add("Epsinófilos sec. bronquial");
        examHemat.add("Tiempo protrombina");
        examHemat.add("T. trombina parcial activada");
        examHemat.add("Test Weber");
        examHemat.add("Leucocitos fecales");
        examHemat.add("VHS");
        examHorm.add("Paratohormona");
        examHorm.add("Cortisol basal");
        examHorm.add("Cortisol PM");
        examHorm.add("Cortisol urinario 24 hrs.(***)");
        examHorm.add("Gonadotrofina coriónica Cualitativa");
        examHorm.add("Gonadotrofina coriónica Cuantitativa");
        examHorm.add("FSH");
        examHorm.add("LH");
        examHorm.add("Insulina Basal");
        examHorm.add("Insulina Post.");
        examHorm.add("Prolactina");
        examHorm.add("Testosterona");
        examHorm.add("TSH");
        examHorm.add("T4 libre");
        examHorm.add("T3 Total");
        examHorm.add("Estradiol");
        examInmun.add("x6 ENA");
        examInmun.add("Ac. Anti DNA");
        examInmun.add("x2 Ac. Anticardiolopinas");
        examInmun.add("c/u Ac. Antinucleares u otros");
        examInmun.add("ANCA");
        examInmun.add("Ac. Antiperoxidasa Tiroidea (TPO)");
        examInmun.add("Antiestreptolinasa O");
        examInmun.add("x2 Cuantificación C-3 y C-4");
        examInmun.add("Crioglobulinas");
        examInmun.add("Factor reumatoideo Cuantitativo");
        examInmun.add("x5 Inmunofijación Ig");
        examInmun.add("x3 Cuantificación Ig (A, G, M)");
        examInmun.add("Crioaglutininas");
        examInmun.add("Monotest (mononucleosis)");
        examInmun.add("Electrofororesis proteínas séricas");
        examInmun.add("Electrofororesis proteínas en orina");
        examInmun.add("Electrofororesis proteínas en LCR");
        examInmun.add("Bence Jones orina");
        examInmun.add("ELISA hidatidosis (IgG)");
        examInmun.add("ELISA cistecercosis");
        examInmun.add("ELISA fasciolasis (IgG)");
        examInmun.add("ELISA triquinosis (IgG)");
        examInmun.add("ELISA Chagas (IgG)");
        examInmun.add("ELISA toxocariosis (IgG)");
        examInmun.add("x2 IFI Chagas (IgG e IgM)");
        examInmun.add("x2 IFI toxoplasma (IgG e IgM)");
        examVen.add("VDRL");
        examVen.add("MHA-TP");
        
        
        exaam.add("Gram");
        exaam.add("Examen directo fresco");
        exaam.add("Antibiograma");
        exaam.add("Cultivo corriente");
        exaam.add("Cultivo anaerobio");
        exaam.add("Cultivo hongos");
        exaam.add("Hermocultivo aerobio I");
        exaam.add("Hermocultivo aerobio II");
        exaam.add("Hermocultivo aerobio");
        exaam.add("Hermocultivo cateter");
        exaam.add("Hermocultivo hongos");
        exaam.add("Punta de cateter");
        exaam.add("Liquido cavidad esteril en vial");
        exaam.add("Urocultivo(incluye antibiograma)");
        exaam.add("Coprocultivo");
        exaamCito.add("Cultivo corriente 1");
        exaamCito.add("Cultivo corriente 2");
        exaamCito1.add("Cultivo corriente 1");
        exaamCito1.add("Cultivo corriente 2");
        exaamCito2.add("Frasco hermocultivo");
        exaamCito2.add("Cultivo corriente");
        exaamCito3.add("Cultivo corriente 1");
        exaamCito3.add("Cultivo corriente 2");
        exaamCito3.add("Flujo vaginal (incluye Ex. directo, Gram, Trichonomas, c.corriente, c.hongos)");
        exaamCito3.add("Secrecion uretral");
        exaamCito3.add("C. Neisseria gonorrhoeae");
        exaamCito3.add("Portacion Streptococcus Grupo B embarazadas (vaginorectal)");
        exaamCito3.add("Cultivo deposiciones Clostridium difficille");
        exaamCito3.add("Toxina C. difficille en deposiciones");
        exaamCito3.add("Hisopado recral para busqueda ERV");
        exaamCito3.add("Tinta china");
        exaamCito3.add("Test ureasa");
        
        
        examm.add("Ecografía Obstetrica");
        examm.add("Ecografía Transvaginal");
        examm.add("Ecografía Ginecologica");
        examm.add("Dopler Materno Fetal");
        examm.add("Dopler Ginecologico");
        examm.add("Perfil Biofisico Fetal");
        examm.add("Scan 11-14");
        examm.add("Scan 22-25");
        examm.add("Ecocardiografía Fetal");

    }

    public List<String> complete2(String query) {
        List<String> results = new ArrayList<String>();
        List<Farmaco> lista = farmacoFacade.findAll();

        for (int i = 0; i < lista.size(); i++) {
            String nombre = lista.get(i).getNombrefarmaco();

            if (nombre.startsWith(query)) {
                System.out.println(nombre);
                results.add(nombre);
            }

        }

        return results;
    }

    public void mostrarForma() {
        System.out.println("fooooorma");
        
        List<Farmaco> med = farmacoFacade.findAll();
        Farmaco SMed=new Farmaco();
        
        for(Farmaco aux: med){
            if(aux.getNombrefarmaco().equals(buscaFarmaco)){
                    System.out.println(aux.getNombrefarmaco());
                  SMed=aux;
            }
        }
        
        List<FfFarmaco> listaff = ffFarmacoFacade.findAll();
        
        List<FfFarmaco> SFf= new ArrayList<FfFarmaco>();
        System.out.println("busco: "+SMed.getFarmacoid());
        for(FfFarmaco aux: listaff){
            System.out.println("compara: "+aux.getFarmacoid().getFarmacoid());
            if(aux.getFarmacoid().getFarmacoid()==SMed.getFarmacoid()){
                
                SFf.add(aux);
                System.out.println(aux.getFormafarmaceuticaid().getNombreFf());
                
            }
        }
        List<String> results = new ArrayList<String>();
        for(int i=0;i<SFf.size();i++){
            System.out.println(SFf.get(i).getFormafarmaceuticaid().getNombreFf());
            results.add(SFf.get(i).getFormafarmaceuticaid().getNombreFf());
        }
        this.formaFarm=results;
    }

    public void mostrarDosis() {
        System.out.println("getff: " + getFf());
        System.out.println("ff: " + ff);
        List<FormaFarmaceutica> formaFarmaceutica = formaFarmaceuticaFacade.findNombreFF(ff);

        //System.out.println(farmaco.getNombrefarmaco());
        List<String> results = new ArrayList<String>();

        List<DosisFf> listaDosis = dosisFfFacade.findDosisId(formaFarmaceutica.get(0));

        for (int i = 0; i < listaDosis.size(); i++) {
            Dosis listadosis = listaDosis.get(i).getDosisid();
            results.add(listadosis.getCantidad() + " " + listadosis.getMedida());

        }
        System.out.println(results);

        this.dosis = results;

    }
    public void guardarElectro(){
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("pertenece: "+examen);
        if(Obs.equals("") || referencia.equals("") || tratamiento.equals("")){
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Para Guardar debe ingresar todos los campos solicitados"));
        }else{
        
            if(perteneceExam("Electrocardiograma")==true){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Examen ya solicitado"));
            }else{
                
                List<Solicitudexamen> sol = new ArrayList<Solicitudexamen>();
             System.out.println("guaaaadar examen electro");
            Solicitudexamen solicitud = new Solicitudexamen();
            Consulta consulte = new Consulta();
            consulte=consultaFacade.find(19);
            Examen ex = new Examen();
            ex=examenFacade.find(2);
            solicitud.setConsultaid(consulte);
            java.util.Date fechaActual = new java.util.Date();//fecha actual
            solicitud.setFecha(fechaActual);
            solicitudexamenFacade.create(solicitud);

            sol=solicitudexamenFacade.findAll();
            solicitud=sol.get(sol.size()-1);
            Solexex solex = new Solexex();
            solex.setExamenid(ex);
            solex.setSolicitudeid(solicitud);
            solexexFacade.create(solex);
            examen.add("Electrocardiograma");
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
            Obs="";
            referencia="";
            tratamiento="";
            }
            
            
            
        }
    }
    public void guardarElisa(){
        examen.add("Elisa");
    }
    public void guardarGlicemia(){
         FacesContext context = FacesContext.getCurrentInstance();
         System.out.println("entre glicemiaa");
         System.out.println("ayuna: "+ayuna);
         System.out.println("fecha: "+fechaC);
         if(ayuna.equals("") || fechaC.equals("")){
             System.out.println("entre if");
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Para Guardar debe ingresar todos los campos solicitados"));
         }else{
             if(perteneceExam("Glicemia")==true){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Examen ya solicitado"));
            }else{
             
                    System.out.println("entre else");
                   List<Solicitudexamen> sol = new ArrayList<Solicitudexamen>();
                   System.out.println("guaaaadar examen glicemia");
                  Solicitudexamen solicitud = new Solicitudexamen();
                  Consulta consulte = new Consulta();
                  consulte=consultaFacade.find(1);
                    System.out.println("consulte: "+consulte);
                  Examen ex = new Examen();
                  ex=examenFacade.find(2);
                    System.out.println("examen: "+ex);
                  solicitud.setConsultaid(consulte);
                  java.util.Date fechaActual = new java.util.Date();//fecha actual
                  solicitud.setFecha(fechaActual);
                  solicitudexamenFacade.create(solicitud);
                    System.out.println("nnnnnnn");
                  sol=solicitudexamenFacade.findAll();
                  solicitud=sol.get(sol.size()-1);
                  Solexex solex = new Solexex();
                  solex.setExamenid(ex);
                  solex.setSolicitudeid(solicitud);
                  solexexFacade.create(solex);
                   examen.add("Glicemia");
                   context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
                   ayuna=null;
                   fechaC=null;
                    System.out.println(ayuna);
                    System.out.println(fechaC);
             }
         }
       }
        
    
    public void guardarLaboratorio(){
        
        FacesContext context = FacesContext.getCurrentInstance();
       
        
        
        if(selectedBio.length >0 || selectedCito.length >0 || selectedHemat.length >0 || selectedHorm.length >0 || selectedInmun.length >0 || selectedMarc.length >0 ||selectedOrina.length >0 || selectedVen.length >0){
             
            if(perteneceExam("Laboratorio")==true){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Examen ya solicitado"));
            }else{
                List<Solicitudexamen> sol = new ArrayList<Solicitudexamen>();

                Solicitudexamen solicitud = new Solicitudexamen();
                Consulta consulte = new Consulta();
                consulte=consultaFacade.find(19);
                Examen ex = new Examen();
                ex=examenFacade.find(2);
                solicitud.setConsultaid(consulte);
                java.util.Date fechaActual = new java.util.Date();//fecha actual
                solicitud.setFecha(fechaActual);
                solicitudexamenFacade.create(solicitud);

                sol=solicitudexamenFacade.findAll();
                solicitud=sol.get(sol.size()-1);
                Solexex solex = new Solexex();
                solex.setExamenid(ex);
                solex.setSolicitudeid(solicitud);
                solexexFacade.create(solex);
                examen.add("Laboratorio");

                 System.out.println("guaaaadar examen labo");
                 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
            }
         }else{
        
            System.out.println("entre if");
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Debe seleccinar al menos un examen"));
        }
    }
    
    public void guardarMicro(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(selectedBiio.length>0 || selectedCiito.length>0 || selectedCiito1.length>0 || selectedCiito2.length>0 || selectedCiito3.length>0 ){
            
            if(perteneceExam("Microbiologico")==true){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Examen ya solicitado"));
            }else{
                List<Solicitudexamen> sol = new ArrayList<Solicitudexamen>();
                System.out.println("guaaaadar examen micro");
               Solicitudexamen solicitud = new Solicitudexamen();
               Consulta consulte = new Consulta();
               consulte=consultaFacade.find(19);
               Examen ex = new Examen();
               ex=examenFacade.find(2);
               solicitud.setConsultaid(consulte);
               java.util.Date fechaActual = new java.util.Date();//fecha actual
               solicitud.setFecha(fechaActual);
               solicitudexamenFacade.create(solicitud);

               sol=solicitudexamenFacade.findAll();
               solicitud=sol.get(sol.size()-1);
               Solexex solex = new Solexex();
               solex.setExamenid(ex);
               solex.setSolicitudeid(solicitud);
               solexexFacade.create(solex);
               examen.add("Microbiologico");
               context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
            }
        }else{
            System.out.println("entre if");
             context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Debe seleccinar al menos un examen"));
        }
        
        
    }
    public void guardarRadiologico(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (selectedExam.length>0 && !(select.equals("")) && !(numero.equals(""))){
            if(perteneceExam("Radiologico")==true){
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Examen ya solicitado"));
            }else{
                List<Solicitudexamen> sol = new ArrayList<Solicitudexamen>();
                System.out.println("guaaaadar examen radio");
               Solicitudexamen solicitud = new Solicitudexamen();
               Consulta consulte = new Consulta();
               consulte=consultaFacade.find(19);
               Examen ex = new Examen();
               ex=examenFacade.find(2);
               solicitud.setConsultaid(consulte);
               java.util.Date fechaActual = new java.util.Date();//fecha actual
               solicitud.setFecha(fechaActual);
               solicitudexamenFacade.create(solicitud);

               sol=solicitudexamenFacade.findAll();
               solicitud=sol.get(sol.size()-1);
               Solexex solex = new Solexex();
               solex.setExamenid(ex);
               solex.setSolicitudeid(solicitud);
               solexexFacade.create(solex);
               examen.add("Radiologico");
               context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
            }
        }else{
               context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Para Guardar debe ingresar todos los campos solicitados"));
        }
        
        
    }
    public void guardarTns(){
        
        List<Solicitudexamen> sol = new ArrayList<Solicitudexamen>();
         System.out.println("guaaaadar examen tns");
        Solicitudexamen solicitud = new Solicitudexamen();
        Consulta consulte = new Consulta();
        consulte=consultaFacade.find(19);
        Examen ex = new Examen();
        ex=examenFacade.find(1);
        solicitud.setConsultaid(consulte);
        java.util.Date fechaActual = new java.util.Date();//fecha actual
        solicitud.setFecha(fechaActual);
        solicitudexamenFacade.create(solicitud);
        
        sol=solicitudexamenFacade.findAll();
        solicitud=sol.get(sol.size()-1);
        Solexex solex = new Solexex();
        solex.setExamenid(ex);
        solex.setSolicitudeid(solicitud);
        solexexFacade.create(solex);
        examen.add("TNS");
    }
    public void guardarContraRef(){
        otros.add("Contrarreferencia");
    }
    public void guardarRecetaExterna(){
        recetae.add("Receta Externa");
    }
    public void guardarInter(){
        otros.add("Interconsulta");
    }
    
    /* EL "BUSCA" NO SE OBTIENE POR EL MOMENTO*/
    public void guardarRecetaInterna() throws IOException {
       

        FacesContext context = FacesContext.getCurrentInstance();
       
        System.out.println("VALIDACION:"+validacion);
 

        if (validacion != 0) {
             System.out.println("Guardar");
             Prescription receta = new Prescription();
             List<Prescription> recetas = new ArrayList<Prescription>();
             Consulta consulte = new Consulta();
             Persona doctor = new Persona(); // guarda en la tabla persona
             RegistroClinico clin = new RegistroClinico();
             Interna recetaInterna = new Interna();
             List<Farmaco> remedios=new ArrayList<Farmaco>();
             System.out.println("1111");
             FormaFarmaceutica forma = new FormaFarmaceutica();
             List<FormaFarmaceutica> formas = new ArrayList<FormaFarmaceutica>();
             Dosis laDosis = new Dosis();
             System.out.println("222222");
             clin = registroClinicoFacade.find(1);
             System.out.println("33333");
             doctor = personaFacade.find(17409087);
             System.out.println("444444");
             System.out.println(session.getFicha());
             System.out.println("55555");
             consulte = consultaFacade.find(1);//HAY QUE CAMBIAR ESTO
            System.out.println("consulta: "+consulte.getConsultaid());
             receta.setConsultaid(consulte);
             System.out.println("777777");
             receta.setDescription(descripcion);
             System.out.println("des: "+descripcion);
             System.out.println("888888");
             java.util.Date fechaActual = new java.util.Date();//fecha actual
             System.out.println("9999");
             System.out.println("fecha: "+fechaActual);
             receta.setPrescriptionDay(fechaActual);
             System.out.println("100000");
             prescriptionFacade.create(receta);
             System.out.println("asdasd");
             recetas = prescriptionFacade.findAll();
             System.out.println("shiiiit");
             System.out.println("-----------> GUARDAR receta");
             //guarda en receta interna
             receta = recetas.get(recetas.size() - 1);//toma el ultimo valor guardado
             System.out.println("recetaaaaaaa=" + receta.getPrescriptionid());
             recetaInterna.setPrescriptionid(receta.getPrescriptionid());
             recetaInterna.setPeriodoDeTraamiento(2);
             recetaInternaFacade.create(recetaInterna);
             System.out.println("-----------> GUARDAR receta externa");
             //guarda en recetaexternafarmaco
            
             for (int i = 0; i < recetaa.size(); i++) {
                  RexternaFarmaco rexF = new RexternaFarmaco();
                 Farmaco remedio;
                 List<Farmaco> todos= new ArrayList<Farmaco>();
                 todos=farmacoFacade.findAll();
                 System.out.println(todos.get(0).getNombrefarmaco());
                 
                 
                 
                 for(Farmaco aux:todos){
                    System.out.println("todos: "+aux.getNombrefarmaco());
                     if( aux.getNombrefarmaco().equals(recetaa.get(i).getNombre())){
                         System.out.println("entreeeeeeeee");
                         remedios.add(aux);
                     }
                 }
                
                
                 System.out.println("remedios: "+remedios);
                remedio = remedios.get(0);
                 System.out.println("remedio: "+remedio);
                formas = formaFarmaceuticaFacade.findNombreFF(recetaa.get(i).getForma());
                 System.out.println("formas: "+formas);
                forma = formas.get(0);
                 System.out.println("forma: "+forma);
                laDosis = dosisFacade.find(1);
                 System.out.println("ladosis: "+laDosis);
                 //rexF.setIndicacionesCollection(null);
                rexF.setCantidaddespacho(Integer.parseInt(recetaa.get(i).getUnidades()));
                rexF.setFarmacoid(remedio);
                rexF.setFormafarmaceuticaid(forma);
                rexF.setDosisid(laDosis);
                rexF.setPrescriptionid(recetaInterna);
                System.out.println("lalalalalala");
                rexternaFarmacoFacade.create(rexF);
                System.out.println("-----------> GUARDAR receta farmaco");

             }
            receta1 = new ArrayList<String>();
            System.out.println("saludines");
            for (int i = 0; i < recetaa.size(); i++) {
                indicacion.recetas.add(recetaa.get(i).nombre + " " + recetaa.get(i).forma + " " + recetaa.get(i).unidades);
            }
            receta1 = indicacion.recetas;
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Successful", "Datos Guardados"));
            
            
            
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Para Guardar debe ingresar todos los campos solicitados"));
        }

    }

    public void validarBotonMas() {
        System.out.println("Entré al MAS");
        FacesContext context = FacesContext.getCurrentInstance();

        //hayRut(context);
        if (periodo == null || periodo == "" || periodo.equals("") || dosis == null || dosis.equals("")
                || formaFarm == null || formaFarm.equals("") || ff == null || ff.equals("") || buscaFarmaco == null
                || buscaFarmaco.equals("") || dosis2 == null || dosis2.equals("") || unidades == null || unidades.equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Ingrese todos los campos de Medicamentos, luego pulse el botón ''Más'"));
            
        } else {
            try {
                int p = Integer.parseInt(periodo);
                int u = Integer.parseInt(unidades);
                System.out.println("periodo="+periodo);
                System.out.println("unidades="+unidades);
                if (p >= 1 && u >= 1) {
                    datosReceta objeto = new datosReceta(buscaFarmaco, ff, dosis2, periodo, unidades);
                    recetaa.add(objeto);
                    validacion++;
                    this.buscaFarmaco = "";
                    this.formaFarm.clear();
                    this.dosis.clear();
                    this.periodo = "";
                    this.unidades = "";

                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Periodo y unidades exigen números mayores ó igual a 1"));
                    
                }

            } catch (NumberFormatException nfe) {
                validacion = 0;
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Periodo y unidades exige datos numéricos"));
            }
        }

    }

    public void eliminarReceta(String clave) {

        for (int i = 0; i < recetaa.size(); i++) {
            if (recetaa.get(i).id.equals(clave)) {
                recetaa.remove(i);
            }
        }
        if(recetaa.size()==0){
            validacion = 0;
        }
    }

    public void comparar() {
        System.out.println("entre a comparar" + session.getRut() + " " + session.getContrasena());

        if (session.getRut().equals(userPrint) && session.getContrasena().equals(passPrint)) {
            verificar = "Si";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Invalido", "Verificar usuario o contraseña"));
            verificar = "No";
        }

    }

    public List<String> getElectroCG() {
        return examen;
    }

    public void setElectroCG(List<String> examen) {
        this.examen = examen;
    }

    public String getVerificar() {
        return verificar;
    }

    public void setVerificar(String verificar) {
        this.verificar = verificar;
    }

    public String getUserPrint() {
        return userPrint;
    }

    public void setUserPrint(String userPrint) {
        this.userPrint = userPrint;
    }

    public String getPassPrint() {
        return passPrint;
    }

    public void setPassPrint(String passPrint) {
        this.passPrint = passPrint;
    }

    public List<String> getDosis() {
        return dosis;
    }

    public void setDosis(List<String> dosis) {
        this.dosis = dosis;
    }

    public String getDosis2() {
        return dosis2;
    }

    public void setDosis2(String dosis2) {
        this.dosis2 = dosis2;
    }

    public String getBuscaFarmaco() {
        return buscaFarmaco;
    }

    public void setBuscaFarmaco(String buscafarmaco) {
        this.buscaFarmaco = buscafarmaco;
    }

    public List<String> getFormaFarm() {
        return formaFarm;
    }

    public void setFormaFarm(List<String> formaFarm) {
        this.formaFarm = formaFarm;
    }

    public String getFf() {
        return ff;
    }

    public List<String> getReceta1() {
        return receta1;
    }

    public void setReceta1(List<String> receta1) {
        this.receta1 = receta1;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    public void clear() {
        ff = null;
    }

    public List<FormaFarmaceutica> getAa() {
        return aa;
    }

    public void setAa(List<FormaFarmaceutica> aa) {
        this.aa = aa;
    }

    public List<String> getReceta() {
        return receta;
    }

    public void setReceta(List<String> receta) {
        this.receta = receta;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public List<datosReceta> getRecetaa() {
        return recetaa;
    }

    public void setRecetaa(List<datosReceta> recetaa) {
        this.recetaa = recetaa;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public IndicacionesMb getIndicacion() {
        return indicacion;
    }

    public List<String> getExamen() {
        return examen;
    }

    public void setExamen(List<String> examen) {
        this.examen = examen;
    }

    public List<String> getOtros() {
        return otros;
    }

    public void setOtros(List<String> otros) {
        this.otros = otros;
    }

    public List<String> getRecetae() {
        return recetae;
    }

    public void setRecetae(List<String> recetae) {
        this.recetae = recetae;
    }

    public void setIndicacion(IndicacionesMb indicacion) {
        this.indicacion = indicacion;
    }

    public String getAyuna() {
        return ayuna;
    }

    public void setAyuna(String ayuna) {
        this.ayuna = ayuna;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public String[] getSelectedBio() {
        return selectedBio;
    }

    public void setSelectedBio(String[] selectedBio) {
        this.selectedBio = selectedBio;
    }

    public String[] getSelectedCito() {
        return selectedCito;
    }

    public void setSelectedCito(String[] selectedCito) {
        this.selectedCito = selectedCito;
    }

    public String[] getSelectedOrina() {
        return selectedOrina;
    }

    public void setSelectedOrina(String[] selectedOrina) {
        this.selectedOrina = selectedOrina;
    }

    public String[] getSelectedMarc() {
        return selectedMarc;
    }

    public void setSelectedMarc(String[] selectedMarc) {
        this.selectedMarc = selectedMarc;
    }

    public String[] getSelectedHemat() {
        return selectedHemat;
    }

    public void setSelectedHemat(String[] selectedHemat) {
        this.selectedHemat = selectedHemat;
    }

    public String[] getSelectedHorm() {
        return selectedHorm;
    }

    public void setSelectedHorm(String[] selectedHorm) {
        this.selectedHorm = selectedHorm;
    }

    public String[] getSelectedInmun() {
        return selectedInmun;
    }

    public void setSelectedInmun(String[] selectedInmun) {
        this.selectedInmun = selectedInmun;
    }

    public String[] getSelectedVen() {
        return selectedVen;
    }

    public void setSelectedVen(String[] selectedVen) {
        this.selectedVen = selectedVen;
    }

    public List<String> getSelectedExamen() {
        return selectedExamen;
    }

    public void setSelectedExamen(List<String> selectedExamen) {
        this.selectedExamen = selectedExamen;
    }

    public List<String> getExam() {
        return exam;
    }

    public void setExam(List<String> exam) {
        this.exam = exam;
    }

    public List<String> getExamCito() {
        return examCito;
    }

    public void setExamCito(List<String> examCito) {
        this.examCito = examCito;
    }

    public List<String> getExamOrin() {
        return examOrin;
    }

    public void setExamOrin(List<String> examOrin) {
        this.examOrin = examOrin;
    }

    public List<String> getExamMarc() {
        return examMarc;
    }

    public void setExamMarc(List<String> examMarc) {
        this.examMarc = examMarc;
    }

    public List<String> getExamHemat() {
        return examHemat;
    }

    public void setExamHemat(List<String> examHemat) {
        this.examHemat = examHemat;
    }

    public List<String> getExamHorm() {
        return examHorm;
    }

    public void setExamHorm(List<String> examHorm) {
        this.examHorm = examHorm;
    }

    public List<String> getExamInmun() {
        return examInmun;
    }

    public void setExamInmun(List<String> examInmun) {
        this.examInmun = examInmun;
    }

    public List<String> getExamVen() {
        return examVen;
    }

    public void setExamVen(List<String> examVen) {
        this.examVen = examVen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public List<String> getExaam() {
        return exaam;
    }

    public void setExaam(List<String> exaam) {
        this.exaam = exaam;
    }

    public List<String> getExaamCito() {
        return exaamCito;
    }

    public void setExaamCito(List<String> exaamCito) {
        this.exaamCito = exaamCito;
    }

    public List<String> getExaamCito1() {
        return exaamCito1;
    }

    public void setExaamCito1(List<String> exaamCito1) {
        this.exaamCito1 = exaamCito1;
    }

    public List<String> getExaamCito2() {
        return exaamCito2;
    }

    public void setExaamCito2(List<String> exaamCito2) {
        this.exaamCito2 = exaamCito2;
    }

    public List<String> getExaamCito3() {
        return exaamCito3;
    }

    public void setExaamCito3(List<String> exaamCito3) {
        this.exaamCito3 = exaamCito3;
    }

    public String[] getSelectedBiio() {
        return selectedBiio;
    }

    public void setSelectedBiio(String[] selectedBiio) {
        this.selectedBiio = selectedBiio;
    }

    public String[] getSelectedCiito() {
        return selectedCiito;
    }

    public void setSelectedCiito(String[] selectedCiito) {
        this.selectedCiito = selectedCiito;
    }

    public String[] getSelectedCiito1() {
        return selectedCiito1;
    }

    public void setSelectedCiito1(String[] selectedCiito1) {
        this.selectedCiito1 = selectedCiito1;
    }

    public String[] getSelectedCiito2() {
        return selectedCiito2;
    }

    public void setSelectedCiito2(String[] selectedCiito2) {
        this.selectedCiito2 = selectedCiito2;
    }

    public String[] getSelectedCiito3() {
        return selectedCiito3;
    }

    public void setSelectedCiito3(String[] selectedCiito3) {
        this.selectedCiito3 = selectedCiito3;
    }

    public String getDescriptiion() {
        return descriptiion;
    }

    public void setDescriptiion(String descriptiion) {
        this.descriptiion = descriptiion;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getExamenS() {
        return examenS;
    }

    public void setExamenS(String examenS) {
        this.examenS = examenS;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDiaCita() {
        return diaCita;
    }

    public void setDiaCita(String diaCita) {
        this.diaCita = diaCita;
    }

    public Date getDate9() {
        return date9;
    }

    public void setDate9(Date date9) {
        this.date9 = date9;
    }

    public String[] getSelectedExam() {
        return selectedExam;
    }

    public void setSelectedExam(String[] selectedExam) {
        this.selectedExam = selectedExam;
    }

    public List<String> getExamm() {
        return examm;
    }

    public void setExamm(List<String> examm) {
        this.examm = examm;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    public Boolean perteneceExam(String elem){
        for(int i=0;i<examen.size();i++){
            if(examen.get(i).equals(elem)){
                return true;
            }
            
        }
        return false;
    }
    
    public Boolean perteneceReceta(String elem){
        for(int i=0;i<recetaa.size();i++){
            if(recetaa.get(i).equals(elem)){
                return true;
            }
            
        }
        return false;
    }
    
    public boolean mostrarOtros() {
        try{
            return description.length()!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarVen() {
        try{
            return selectedVen.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarOrina() {
        try{
            return selectedOrina.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarMarc() {
        try{
            return selectedMarc.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarInmun() {
        try{
            return selectedInmun.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarHorm() {
        try{
            return selectedHorm.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarHemat() {
        try{
            return selectedHemat.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarCito() {
        try{
            return selectedCito.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean mostrarBio() {
        try{
            return selectedBio.length!=0;
        }catch(Exception ex){
            return false;
        }
    }
    
    
}
