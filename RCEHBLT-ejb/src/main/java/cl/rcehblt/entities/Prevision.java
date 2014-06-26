/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "prevision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prevision.findAll", query = "SELECT p FROM Prevision p"),
    @NamedQuery(name = "Prevision.findByIdPrevision", query = "SELECT p FROM Prevision p WHERE p.idPrevision = :idPrevision"),
    @NamedQuery(name = "Prevision.findByPreviNombre", query = "SELECT p FROM Prevision p WHERE p.previNombre = :previNombre")})
public class Prevision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prevision")
    private Integer idPrevision;
    @Size(max = 50)
    @Column(name = "previ_nombre")
    private String previNombre;
    @OneToMany(mappedBy = "idPrevision")
    private List<TipoPrevision> tipoPrevisionList;
    @OneToMany(mappedBy = "idPrevision")
    private List<Paciente> pacienteList;

    public Prevision() {
    }

    public Prevision(Integer idPrevision) {
        this.idPrevision = idPrevision;
    }

    public Integer getIdPrevision() {
        return idPrevision;
    }

    public void setIdPrevision(Integer idPrevision) {
        this.idPrevision = idPrevision;
    }

    public String getPreviNombre() {
        return previNombre;
    }

    public void setPreviNombre(String previNombre) {
        this.previNombre = previNombre;
    }

    @XmlTransient
    public List<TipoPrevision> getTipoPrevisionList() {
        return tipoPrevisionList;
    }

    public void setTipoPrevisionList(List<TipoPrevision> tipoPrevisionList) {
        this.tipoPrevisionList = tipoPrevisionList;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrevision != null ? idPrevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prevision)) {
            return false;
        }
        Prevision other = (Prevision) object;
        if ((this.idPrevision == null && other.idPrevision != null) || (this.idPrevision != null && !this.idPrevision.equals(other.idPrevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Prevision[ idPrevision=" + idPrevision + " ]";
    }
    
}
