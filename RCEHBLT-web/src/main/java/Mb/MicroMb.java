/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jaco
 */
@Named(value = "microMb")
@RequestScoped
public class MicroMb {

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
    
    @PostConstruct
    public void init() {
        
        exaam = new ArrayList<String>();
        exaamCito = new ArrayList<String>();
        exaamCito1 = new ArrayList<String>();
        exaamCito2 = new ArrayList<String>();
        exaamCito3 = new ArrayList<String>();
        
         
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
 
        

    }

    public String getDescriptiion() {
        return descriptiion;
    }

    public void setDescriptiion(String descriptiion) {
        this.descriptiion = descriptiion;
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

    
    
    
    
}
