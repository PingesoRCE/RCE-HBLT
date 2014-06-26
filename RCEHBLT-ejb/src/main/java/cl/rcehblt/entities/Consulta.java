/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "consulta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consulta.findAll", query = "SELECT c FROM Consulta c"),
    @NamedQuery(name = "Consulta.findByConsultaid", query = "SELECT c FROM Consulta c WHERE c.consultaid = :consultaid"),
    @NamedQuery(name = "Consulta.findByHdiagnostica", query = "SELECT c FROM Consulta c WHERE c.hdiagnostica = :hdiagnostica"),
    @NamedQuery(name = "Consulta.findByConsultafecha", query = "SELECT c FROM Consulta c WHERE c.consultafecha = :consultafecha"),
    @NamedQuery(name = "Consulta.findByCancelada", query = "SELECT c FROM Consulta c WHERE c.cancelada = :cancelada"),
    @NamedQuery(name = "Consulta.findByMotivocancel", query = "SELECT c FROM Consulta c WHERE c.motivocancel = :motivocancel"),
    @NamedQuery(name = "Consulta.findByPausada", query = "SELECT c FROM Consulta c WHERE c.pausada = :pausada"),
    @NamedQuery(name = "Consulta.findByMotivoConsulta", query = "SELECT c FROM Consulta c WHERE c.motivoConsulta = :motivoConsulta"),
    @NamedQuery(name = "Consulta.findByNotas", query = "SELECT c FROM Consulta c WHERE c.notas = :notas"),
    @NamedQuery(name = "Consulta.findByExploracionFisica", query = "SELECT c FROM Consulta c WHERE c.exploracionFisica = :exploracionFisica"),
    @NamedQuery(name = "Consulta.findByEstado", query = "SELECT c FROM Consulta c WHERE c.estado = :estado"),
    @NamedQuery(name = "Consulta.findByPertinencia", query = "SELECT c FROM Consulta c WHERE c.pertinencia = :pertinencia")})
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consultaid")
    private Integer consultaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "hdiagnostica")
    private String hdiagnostica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consultafecha")
    @Temporal(TemporalType.DATE)
    private Date consultafecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancelada")
    private boolean cancelada;
    @Size(max = 2147483647)
    @Column(name = "motivocancel")
    private String motivocancel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pausada")
    private boolean pausada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "motivo_consulta")
    private String motivoConsulta;
    @Size(max = 2147483647)
    @Column(name = "notas")
    private String notas;
    @Size(max = 2147483647)
    @Column(name = "exploracion_fisica")
    private String exploracionFisica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pertinencia")
    private boolean pertinencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultaid")
    private List<Anamnesis2> anamnesis2List;
    @JoinColumn(name = "episodioid", referencedColumnName = "episodioid")
    @ManyToOne(optional = false)
    private Episodios episodioid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultaid")
    private List<Diagnostico> diagnosticoList;
    @OneToMany(mappedBy = "consultaid")
    private List<Prescription> prescriptionList;
    @OneToMany(mappedBy = "consultaid")
    private List<Indicaciones> indicacionesList;
    @OneToMany(mappedBy = "consultaid")
    private List<IpdGes> ipdGesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultaid")
    private List<Solicitudexamen> solicitudexamenList;
    @OneToMany(mappedBy = "consultaid")
    private List<ConsentimientoGes> consentimientoGesList;

    public Consulta() {
    }

    public Consulta(Integer consultaid) {
        this.consultaid = consultaid;
    }

    public Consulta(Integer consultaid, String hdiagnostica, Date consultafecha, boolean cancelada, boolean pausada, String motivoConsulta, String estado, boolean pertinencia) {
        this.consultaid = consultaid;
        this.hdiagnostica = hdiagnostica;
        this.consultafecha = consultafecha;
        this.cancelada = cancelada;
        this.pausada = pausada;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
        this.pertinencia = pertinencia;
    }

    public Integer getConsultaid() {
        return consultaid;
    }

    public void setConsultaid(Integer consultaid) {
        this.consultaid = consultaid;
    }

    public String getHdiagnostica() {
        return hdiagnostica;
    }

    public void setHdiagnostica(String hdiagnostica) {
        this.hdiagnostica = hdiagnostica;
    }

    public Date getConsultafecha() {
        return consultafecha;
    }

    public void setConsultafecha(Date consultafecha) {
        this.consultafecha = consultafecha;
    }

    public boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public String getMotivocancel() {
        return motivocancel;
    }

    public void setMotivocancel(String motivocancel) {
        this.motivocancel = motivocancel;
    }

    public boolean getPausada() {
        return pausada;
    }

    public void setPausada(boolean pausada) {
        this.pausada = pausada;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getExploracionFisica() {
        return exploracionFisica;
    }

    public void setExploracionFisica(String exploracionFisica) {
        this.exploracionFisica = exploracionFisica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean getPertinencia() {
        return pertinencia;
    }

    public void setPertinencia(boolean pertinencia) {
        this.pertinencia = pertinencia;
    }

    @XmlTransient
    public List<Anamnesis2> getAnamnesis2List() {
        return anamnesis2List;
    }

    public void setAnamnesis2List(List<Anamnesis2> anamnesis2List) {
        this.anamnesis2List = anamnesis2List;
    }

    public Episodios getEpisodioid() {
        return episodioid;
    }

    public void setEpisodioid(Episodios episodioid) {
        this.episodioid = episodioid;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    @XmlTransient
    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }

    @XmlTransient
    public List<Indicaciones> getIndicacionesList() {
        return indicacionesList;
    }

    public void setIndicacionesList(List<Indicaciones> indicacionesList) {
        this.indicacionesList = indicacionesList;
    }

    @XmlTransient
    public List<IpdGes> getIpdGesList() {
        return ipdGesList;
    }

    public void setIpdGesList(List<IpdGes> ipdGesList) {
        this.ipdGesList = ipdGesList;
    }

    @XmlTransient
    public List<Solicitudexamen> getSolicitudexamenList() {
        return solicitudexamenList;
    }

    public void setSolicitudexamenList(List<Solicitudexamen> solicitudexamenList) {
        this.solicitudexamenList = solicitudexamenList;
    }

    @XmlTransient
    public List<ConsentimientoGes> getConsentimientoGesList() {
        return consentimientoGesList;
    }

    public void setConsentimientoGesList(List<ConsentimientoGes> consentimientoGesList) {
        this.consentimientoGesList = consentimientoGesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultaid != null ? consultaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.consultaid == null && other.consultaid != null) || (this.consultaid != null && !this.consultaid.equals(other.consultaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Consulta[ consultaid=" + consultaid + " ]";
    }
    
}
