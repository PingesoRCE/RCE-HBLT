/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;


public class datosReceta {
    
    String id;
    String nombre;
    String forma;
    String dosis;
    String periodo;
    String unidades;

    datosReceta(String buscaFarmaco, String ff, String dosis2, String periodo, String unidades) {
        this.nombre=buscaFarmaco;
        this.forma=ff;
        this.dosis=dosis2;
        this.periodo=periodo;
        this.unidades=unidades;
        this.id=buscaFarmaco+dosis2+periodo+unidades+id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
