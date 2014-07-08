/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mb;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Holiwi-PC
 */
@Named(value = "interconsultaMb")
@RequestScoped
public class InterconsultaMb {

    String fecha,hora;
    String servicio,establecimiento,especialidad,unidad;
    String nombrePac,historiaCl,runPac,runPadre,domicilio,comuna,tel1,tel2,sexo,correo,edad,tiempoEdad;
    String atencion,establecimientoDer,especialidadDer,consulta,otros,problemaAuge,DescProblemaAuge,DescSubProblema,hipotesis,fundamento,examenes;
    String nombreDoc, runDoc;
    private Date date9;
    public InterconsultaMb() {
    }
    


    public String getHora() {
        Calendar hora2=new GregorianCalendar();
         this.hora = hora2.get(Calendar.HOUR)+":"+hora2.get(Calendar.MINUTE)+":"+hora2.get(Calendar.SECOND);
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        Calendar fecha2=new GregorianCalendar();
       
        this.fecha=fecha2.get(Calendar.DAY_OF_MONTH)+"/"+fecha2.get(Calendar.MONTH)+"/"+fecha2.get(Calendar.YEAR);
        return fecha;
    }

    public void setFecha(String fecha) {
        
        this.fecha = fecha;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getNombrePac() {
        return nombrePac;
    }

    public void setNombrePac(String nombrePac) {
        this.nombrePac = nombrePac;
    }

    public String getHistoriaCl() {
        return historiaCl;
    }

    public void setHistoriaCl(String historiaCl) {
        this.historiaCl = historiaCl;
    }

    public String getRunPac() {
        return runPac;
    }

    public void setRunPac(String runPac) {
        this.runPac = runPac;
    }

    public String getRunPadre() {
        return runPadre;
    }

    public void setRunPadre(String runPadre) {
        this.runPadre = runPadre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTiempoEdad() {
        return tiempoEdad;
    }

    public void setTiempoEdad(String tiempoEdad) {
        this.tiempoEdad = tiempoEdad;
    }

    public Date getDate9() {
        return date9;
    }

    public void setDate9(Date date9) {
        this.date9 = date9;
    }



    public String getAtencion() {
        return atencion;
    }

    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }

    public String getEstablecimientoDer() {
        return establecimientoDer;
    }

    public void setEstablecimientoDer(String establecimientoDer) {
        this.establecimientoDer = establecimientoDer;
    }

    public String getEspecialidadDer() {
        return especialidadDer;
    }

    public void setEspecialidadDer(String especialidadDer) {
        this.especialidadDer = especialidadDer;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public String getProblemaAuge() {
        return problemaAuge;
    }

    public void setProblemaAuge(String problemaAuge) {
        this.problemaAuge = problemaAuge;
    }

    public String getDescProblemaAuge() {
        return DescProblemaAuge;
    }

    public void setDescProblemaAuge(String DescProblemaAuge) {
        this.DescProblemaAuge = DescProblemaAuge;
    }

    public String getDescSubProblema() {
        return DescSubProblema;
    }

    public void setDescSubProblema(String DescSubProblema) {
        this.DescSubProblema = DescSubProblema;
    }

    public String getHipotesis() {
        return hipotesis;
    }

    public void setHipotesis(String hipotesis) {
        this.hipotesis = hipotesis;
    }

    public String getFundamento() {
        return fundamento;
    }

    public void setFundamento(String fundamento) {
        this.fundamento = fundamento;
    }

    public String getExamenes() {
        return examenes;
    }

    public void setExamenes(String examenes) {
        this.examenes = examenes;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getRunDoc() {
        return runDoc;
    }

    public void setRunDoc(String runDoc) {
        this.runDoc = runDoc;
    }
    
    
    
}
