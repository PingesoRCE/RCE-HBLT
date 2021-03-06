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
@Table(name = "estado_conyugal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoConyugal.findAll", query = "SELECT e FROM EstadoConyugal e"),
    @NamedQuery(name = "EstadoConyugal.findByIdEstadoconyugal", query = "SELECT e FROM EstadoConyugal e WHERE e.idEstadoconyugal = :idEstadoconyugal"),
    @NamedQuery(name = "EstadoConyugal.findByEstadNombre", query = "SELECT e FROM EstadoConyugal e WHERE e.estadNombre = :estadNombre")})
public class EstadoConyugal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadoconyugal")
    private Integer idEstadoconyugal;
    @Size(max = 50)
    @Column(name = "estad_nombre")
    private String estadNombre;
    @OneToMany(mappedBy = "idEstadoconyugal")
    private List<Persona> personaList;

    public EstadoConyugal() {
    }

    public EstadoConyugal(Integer idEstadoconyugal) {
        this.idEstadoconyugal = idEstadoconyugal;
    }

    public Integer getIdEstadoconyugal() {
        return idEstadoconyugal;
    }

    public void setIdEstadoconyugal(Integer idEstadoconyugal) {
        this.idEstadoconyugal = idEstadoconyugal;
    }

    public String getEstadNombre() {
        return estadNombre;
    }

    public void setEstadNombre(String estadNombre) {
        this.estadNombre = estadNombre;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoconyugal != null ? idEstadoconyugal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoConyugal)) {
            return false;
        }
        EstadoConyugal other = (EstadoConyugal) object;
        if ((this.idEstadoconyugal == null && other.idEstadoconyugal != null) || (this.idEstadoconyugal != null && !this.idEstadoconyugal.equals(other.idEstadoconyugal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.EstadoConyugal[ idEstadoconyugal=" + idEstadoconyugal + " ]";
    }
    
}
