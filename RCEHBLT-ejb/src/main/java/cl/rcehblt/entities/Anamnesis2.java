/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "anamnesis2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anamnesis2.findAll", query = "SELECT a FROM Anamnesis2 a"),
    @NamedQuery(name = "Anamnesis2.findByIdAnamnesis", query = "SELECT a FROM Anamnesis2 a WHERE a.idAnamnesis = :idAnamnesis"),
    @NamedQuery(name = "Anamnesis2.findByAnamDescripcion", query = "SELECT a FROM Anamnesis2 a WHERE a.anamDescripcion = :anamDescripcion"),
    @NamedQuery(name = "Anamnesis2.findByAnamCausacesarea", query = "SELECT a FROM Anamnesis2 a WHERE a.anamCausacesarea = :anamCausacesarea"),
    @NamedQuery(name = "Anamnesis2.findByAnamPartoprem", query = "SELECT a FROM Anamnesis2 a WHERE a.anamPartoprem = :anamPartoprem"),
    @NamedQuery(name = "Anamnesis2.findByAnamEmbmultiple", query = "SELECT a FROM Anamnesis2 a WHERE a.anamEmbmultiple = :anamEmbmultiple"),
    @NamedQuery(name = "Anamnesis2.findByAnamMortinato", query = "SELECT a FROM Anamnesis2 a WHERE a.anamMortinato = :anamMortinato"),
    @NamedQuery(name = "Anamnesis2.findByAnamMortineonato", query = "SELECT a FROM Anamnesis2 a WHERE a.anamMortineonato = :anamMortineonato"),
    @NamedQuery(name = "Anamnesis2.findByAnamDu", query = "SELECT a FROM Anamnesis2 a WHERE a.anamDu = :anamDu"),
    @NamedQuery(name = "Anamnesis2.findByAnamPresentacion", query = "SELECT a FROM Anamnesis2 a WHERE a.anamPresentacion = :anamPresentacion"),
    @NamedQuery(name = "Anamnesis2.findByAnamPosicion", query = "SELECT a FROM Anamnesis2 a WHERE a.anamPosicion = :anamPosicion"),
    @NamedQuery(name = "Anamnesis2.findByAnamConsistencia", query = "SELECT a FROM Anamnesis2 a WHERE a.anamConsistencia = :anamConsistencia"),
    @NamedQuery(name = "Anamnesis2.findByAnamBorramiento", query = "SELECT a FROM Anamnesis2 a WHERE a.anamBorramiento = :anamBorramiento"),
    @NamedQuery(name = "Anamnesis2.findByAnamPlano", query = "SELECT a FROM Anamnesis2 a WHERE a.anamPlano = :anamPlano"),
    @NamedQuery(name = "Anamnesis2.findByAnamMembranas", query = "SELECT a FROM Anamnesis2 a WHERE a.anamMembranas = :anamMembranas"),
    @NamedQuery(name = "Anamnesis2.findByAnamBishop", query = "SELECT a FROM Anamnesis2 a WHERE a.anamBishop = :anamBishop"),
    @NamedQuery(name = "Anamnesis2.findByAnamEcoprecoz", query = "SELECT a FROM Anamnesis2 a WHERE a.anamEcoprecoz = :anamEcoprecoz"),
    @NamedQuery(name = "Anamnesis2.findByAnamUltimoemb", query = "SELECT a FROM Anamnesis2 a WHERE a.anamUltimoemb = :anamUltimoemb"),
    @NamedQuery(name = "Anamnesis2.findByAnamUltimocontrol", query = "SELECT a FROM Anamnesis2 a WHERE a.anamUltimocontrol = :anamUltimocontrol"),
    @NamedQuery(name = "Anamnesis2.findByAnamEg", query = "SELECT a FROM Anamnesis2 a WHERE a.anamEg = :anamEg"),
    @NamedQuery(name = "Anamnesis2.findByAnamVaginales", query = "SELECT a FROM Anamnesis2 a WHERE a.anamVaginales = :anamVaginales"),
    @NamedQuery(name = "Anamnesis2.findByAnamCesareas", query = "SELECT a FROM Anamnesis2 a WHERE a.anamCesareas = :anamCesareas"),
    @NamedQuery(name = "Anamnesis2.findByAnamMenorpeso", query = "SELECT a FROM Anamnesis2 a WHERE a.anamMenorpeso = :anamMenorpeso"),
    @NamedQuery(name = "Anamnesis2.findByAnamMayorpeso", query = "SELECT a FROM Anamnesis2 a WHERE a.anamMayorpeso = :anamMayorpeso"),
    @NamedQuery(name = "Anamnesis2.findByAnamAu", query = "SELECT a FROM Anamnesis2 a WHERE a.anamAu = :anamAu"),
    @NamedQuery(name = "Anamnesis2.findByAnamLcf", query = "SELECT a FROM Anamnesis2 a WHERE a.anamLcf = :anamLcf"),
    @NamedQuery(name = "Anamnesis2.findByAnamDilatacion", query = "SELECT a FROM Anamnesis2 a WHERE a.anamDilatacion = :anamDilatacion")})
public class Anamnesis2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anamnesis")
    private Integer idAnamnesis;
    @Size(max = 2147483647)
    @Column(name = "anam_descripcion")
    private String anamDescripcion;
    @Size(max = 2147483647)
    @Column(name = "anam_causacesarea")
    private String anamCausacesarea;
    @Size(max = 20)
    @Column(name = "anam_partoprem")
    private String anamPartoprem;
    @Size(max = 20)
    @Column(name = "anam_embmultiple")
    private String anamEmbmultiple;
    @Size(max = 20)
    @Column(name = "anam_mortinato")
    private String anamMortinato;
    @Size(max = 20)
    @Column(name = "anam_mortineonato")
    private String anamMortineonato;
    @Size(max = 20)
    @Column(name = "anam_du")
    private String anamDu;
    @Size(max = 20)
    @Column(name = "anam_presentacion")
    private String anamPresentacion;
    @Size(max = 20)
    @Column(name = "anam_posicion")
    private String anamPosicion;
    @Size(max = 20)
    @Column(name = "anam_consistencia")
    private String anamConsistencia;
    @Size(max = 20)
    @Column(name = "anam_borramiento")
    private String anamBorramiento;
    @Size(max = 20)
    @Column(name = "anam_plano")
    private String anamPlano;
    @Size(max = 20)
    @Column(name = "anam_membranas")
    private String anamMembranas;
    @Size(max = 20)
    @Column(name = "anam_bishop")
    private String anamBishop;
    @Column(name = "anam_ecoprecoz")
    @Temporal(TemporalType.DATE)
    private Date anamEcoprecoz;
    @Column(name = "anam_ultimoemb")
    @Temporal(TemporalType.DATE)
    private Date anamUltimoemb;
    @Column(name = "anam_ultimocontrol")
    @Temporal(TemporalType.DATE)
    private Date anamUltimocontrol;
    @Column(name = "anam_eg")
    private Integer anamEg;
    @Column(name = "anam_vaginales")
    private Integer anamVaginales;
    @Column(name = "anam_cesareas")
    private Integer anamCesareas;
    @Column(name = "anam_menorpeso")
    private Integer anamMenorpeso;
    @Column(name = "anam_mayorpeso")
    private Integer anamMayorpeso;
    @Column(name = "anam_au")
    private Integer anamAu;
    @Column(name = "anam_lcf")
    private Integer anamLcf;
    @Column(name = "anam_dilatacion")
    private Integer anamDilatacion;
    @JoinColumn(name = "consultaid", referencedColumnName = "consultaid")
    @ManyToOne(optional = false)
    private Consulta consultaid;

    public Anamnesis2() {
    }

    public Anamnesis2(Integer idAnamnesis) {
        this.idAnamnesis = idAnamnesis;
    }

    public Integer getIdAnamnesis() {
        return idAnamnesis;
    }

    public void setIdAnamnesis(Integer idAnamnesis) {
        this.idAnamnesis = idAnamnesis;
    }

    public String getAnamDescripcion() {
        return anamDescripcion;
    }

    public void setAnamDescripcion(String anamDescripcion) {
        this.anamDescripcion = anamDescripcion;
    }

    public String getAnamCausacesarea() {
        return anamCausacesarea;
    }

    public void setAnamCausacesarea(String anamCausacesarea) {
        this.anamCausacesarea = anamCausacesarea;
    }

    public String getAnamPartoprem() {
        return anamPartoprem;
    }

    public void setAnamPartoprem(String anamPartoprem) {
        this.anamPartoprem = anamPartoprem;
    }

    public String getAnamEmbmultiple() {
        return anamEmbmultiple;
    }

    public void setAnamEmbmultiple(String anamEmbmultiple) {
        this.anamEmbmultiple = anamEmbmultiple;
    }

    public String getAnamMortinato() {
        return anamMortinato;
    }

    public void setAnamMortinato(String anamMortinato) {
        this.anamMortinato = anamMortinato;
    }

    public String getAnamMortineonato() {
        return anamMortineonato;
    }

    public void setAnamMortineonato(String anamMortineonato) {
        this.anamMortineonato = anamMortineonato;
    }

    public String getAnamDu() {
        return anamDu;
    }

    public void setAnamDu(String anamDu) {
        this.anamDu = anamDu;
    }

    public String getAnamPresentacion() {
        return anamPresentacion;
    }

    public void setAnamPresentacion(String anamPresentacion) {
        this.anamPresentacion = anamPresentacion;
    }

    public String getAnamPosicion() {
        return anamPosicion;
    }

    public void setAnamPosicion(String anamPosicion) {
        this.anamPosicion = anamPosicion;
    }

    public String getAnamConsistencia() {
        return anamConsistencia;
    }

    public void setAnamConsistencia(String anamConsistencia) {
        this.anamConsistencia = anamConsistencia;
    }

    public String getAnamBorramiento() {
        return anamBorramiento;
    }

    public void setAnamBorramiento(String anamBorramiento) {
        this.anamBorramiento = anamBorramiento;
    }

    public String getAnamPlano() {
        return anamPlano;
    }

    public void setAnamPlano(String anamPlano) {
        this.anamPlano = anamPlano;
    }

    public String getAnamMembranas() {
        return anamMembranas;
    }

    public void setAnamMembranas(String anamMembranas) {
        this.anamMembranas = anamMembranas;
    }

    public String getAnamBishop() {
        return anamBishop;
    }

    public void setAnamBishop(String anamBishop) {
        this.anamBishop = anamBishop;
    }

    public Date getAnamEcoprecoz() {
        return anamEcoprecoz;
    }

    public void setAnamEcoprecoz(Date anamEcoprecoz) {
        this.anamEcoprecoz = anamEcoprecoz;
    }

    public Date getAnamUltimoemb() {
        return anamUltimoemb;
    }

    public void setAnamUltimoemb(Date anamUltimoemb) {
        this.anamUltimoemb = anamUltimoemb;
    }

    public Date getAnamUltimocontrol() {
        return anamUltimocontrol;
    }

    public void setAnamUltimocontrol(Date anamUltimocontrol) {
        this.anamUltimocontrol = anamUltimocontrol;
    }

    public Integer getAnamEg() {
        return anamEg;
    }

    public void setAnamEg(Integer anamEg) {
        this.anamEg = anamEg;
    }

    public Integer getAnamVaginales() {
        return anamVaginales;
    }

    public void setAnamVaginales(Integer anamVaginales) {
        this.anamVaginales = anamVaginales;
    }

    public Integer getAnamCesareas() {
        return anamCesareas;
    }

    public void setAnamCesareas(Integer anamCesareas) {
        this.anamCesareas = anamCesareas;
    }

    public Integer getAnamMenorpeso() {
        return anamMenorpeso;
    }

    public void setAnamMenorpeso(Integer anamMenorpeso) {
        this.anamMenorpeso = anamMenorpeso;
    }

    public Integer getAnamMayorpeso() {
        return anamMayorpeso;
    }

    public void setAnamMayorpeso(Integer anamMayorpeso) {
        this.anamMayorpeso = anamMayorpeso;
    }

    public Integer getAnamAu() {
        return anamAu;
    }

    public void setAnamAu(Integer anamAu) {
        this.anamAu = anamAu;
    }

    public Integer getAnamLcf() {
        return anamLcf;
    }

    public void setAnamLcf(Integer anamLcf) {
        this.anamLcf = anamLcf;
    }

    public Integer getAnamDilatacion() {
        return anamDilatacion;
    }

    public void setAnamDilatacion(Integer anamDilatacion) {
        this.anamDilatacion = anamDilatacion;
    }

    public Consulta getConsultaid() {
        return consultaid;
    }

    public void setConsultaid(Consulta consultaid) {
        this.consultaid = consultaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnamnesis != null ? idAnamnesis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anamnesis2)) {
            return false;
        }
        Anamnesis2 other = (Anamnesis2) object;
        if ((this.idAnamnesis == null && other.idAnamnesis != null) || (this.idAnamnesis != null && !this.idAnamnesis.equals(other.idAnamnesis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Anamnesis2[ idAnamnesis=" + idAnamnesis + " ]";
    }
    
}
