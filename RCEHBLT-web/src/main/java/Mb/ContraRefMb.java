package Mb;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "contraRefMb")
@RequestScoped
public class ContraRefMb {
    private String consultorios;
    private String telefono;
    private String a;
    private String de;
    private String tratamiento;
    private String diagnostico;

    public String getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(String consultorios) {
        this.consultorios = consultorios;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
    private String plan;
    public ContraRefMb() {
    }
    
}
