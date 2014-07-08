/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author camilo
 */
@Named(value = "indicacionesMb")
@SessionScoped
public class IndicacionesMb implements Serializable {

    List<String> recetas=new ArrayList<String>();
    List<String> examenes=new ArrayList<String>();
    List<String> derivaciones=new ArrayList<String>();
    
    
    public IndicacionesMb() {
    }

    public List<String> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<String> recetas) {
        this.recetas = recetas;
    }

    public List<String> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<String> examenes) {
        this.examenes = examenes;
    }

    public List<String> getDerivaciones() {
        return derivaciones;
    }

    public void setDerivaciones(List<String> derivaciones) {
        this.derivaciones = derivaciones;
    }

    
    
    
    public void termina() throws IOException{
        
        this.recetas.add("receta interna");
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/faces/views/Indicaciones.xhtml");
    }
    
    public void termina2() throws IOException{
        
        this.recetas.add("receta externa");
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/faces/views/Indicaciones.xhtml");
    }
    
    public void termina3() throws IOException{
        
        this.examenes.add("examen");
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/faces/views/Indicaciones.xhtml");
    }
    
    public void   redirige() throws IOException{
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/faces/views/RecetaInterna.xhtml");
    }
    
    public void   redirige2() throws IOException{
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/faces/views/RecetaExterna.xhtml");
    }
    
    public void   redirige3() throws IOException{
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        context2.redirect(context2.getRequestContextPath() + "/faces/views/ExGlicemia.xhtml");
    }
}
