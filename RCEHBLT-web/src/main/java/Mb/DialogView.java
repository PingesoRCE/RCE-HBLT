package Mb;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "dialogView")
@RequestScoped
public class DialogView {

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

    @PostConstruct
    public void init() {
        exam = new ArrayList<String>();
        examCito = new ArrayList<String>();
        examOrin = new ArrayList<String>();
        examMarc = new ArrayList<String>();
        examHemat = new ArrayList<String>();
        examHorm = new ArrayList<String>();
        examInmun = new ArrayList<String>();
        examVen = new ArrayList<String>();
        selectedExamen = new ArrayList<String>();

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

    public List<String> getSelectedExamen() {
        return selectedExamen;
    }

    public void setSelectedExamen(List<String> selectedExamen) {
        this.selectedExamen = selectedExamen;
    }

    public String getVdrl() {
        return vdrl;
    }

    public void setVdrl(String vdrl) {
        this.vdrl = vdrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
