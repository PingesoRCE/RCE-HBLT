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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "profesional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p"),
    @NamedQuery(name = "Profesional.findByIdPersona", query = "SELECT p FROM Profesional p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Profesional.findByProfActivo", query = "SELECT p FROM Profesional p WHERE p.profActivo = :profActivo"),
    @NamedQuery(name = "Profesional.findByProfFechadesde", query = "SELECT p FROM Profesional p WHERE p.profFechadesde = :profFechadesde"),
    @NamedQuery(name = "Profesional.findByProfeFechahasta", query = "SELECT p FROM Profesional p WHERE p.profeFechahasta = :profeFechahasta")})
public class Profesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private Integer idPersona;
    @Column(name = "prof_activo")
    private Boolean profActivo;
    @Column(name = "prof_fechadesde")
    @Temporal(TemporalType.DATE)
    private Date profFechadesde;
    @Column(name = "profe_fechahasta")
    @Temporal(TemporalType.DATE)
    private Date profeFechahasta;
    @ManyToMany(mappedBy = "profesionalList")
    private List<Local> localList;
    @OneToMany(mappedBy = "idPersona")
    private List<ConsentimientoInformado> consentimientoInformadoList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "id_subespecialidad", referencedColumnName = "id_subespecialidad")
    @ManyToOne
    private Subespecialidad idSubespecialidad;
    @OneToMany(mappedBy = "proIdPersona")
    private List<Profesional> profesionalList;
    @JoinColumn(name = "pro_id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Profesional proIdPersona;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_grupoprofesional", referencedColumnName = "id_grupoprofesional")
    @ManyToOne
    private GrupoProfesional idGrupoprofesional;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne
    private Cargo idCargo;

    public Profesional() {
    }

    public Profesional(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Boolean getProfActivo() {
        return profActivo;
    }

    public void setProfActivo(Boolean profActivo) {
        this.profActivo = profActivo;
    }

    public Date getProfFechadesde() {
        return profFechadesde;
    }

    public void setProfFechadesde(Date profFechadesde) {
        this.profFechadesde = profFechadesde;
    }

    public Date getProfeFechahasta() {
        return profeFechahasta;
    }

    public void setProfeFechahasta(Date profeFechahasta) {
        this.profeFechahasta = profeFechahasta;
    }

    @XmlTransient
    public List<Local> getLocalList() {
        return localList;
    }

    public void setLocalList(List<Local> localList) {
        this.localList = localList;
    }

    @XmlTransient
    public List<ConsentimientoInformado> getConsentimientoInformadoList() {
        return consentimientoInformadoList;
    }

    public void setConsentimientoInformadoList(List<ConsentimientoInformado> consentimientoInformadoList) {
        this.consentimientoInformadoList = consentimientoInformadoList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Subespecialidad getIdSubespecialidad() {
        return idSubespecialidad;
    }

    public void setIdSubespecialidad(Subespecialidad idSubespecialidad) {
        this.idSubespecialidad = idSubespecialidad;
    }

    @XmlTransient
    public List<Profesional> getProfesionalList() {
        return profesionalList;
    }

    public void setProfesionalList(List<Profesional> profesionalList) {
        this.profesionalList = profesionalList;
    }

    public Profesional getProIdPersona() {
        return proIdPersona;
    }

    public void setProIdPersona(Profesional proIdPersona) {
        this.proIdPersona = proIdPersona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public GrupoProfesional getIdGrupoprofesional() {
        return idGrupoprofesional;
    }

    public void setIdGrupoprofesional(GrupoProfesional idGrupoprofesional) {
        this.idGrupoprofesional = idGrupoprofesional;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesional)) {
            return false;
        }
        Profesional other = (Profesional) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Profesional[ idPersona=" + idPersona + " ]";
    }
    
}
