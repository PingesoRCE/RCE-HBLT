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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e"),
    @NamedQuery(name = "Examen.findByExamenid", query = "SELECT e FROM Examen e WHERE e.examenid = :examenid"),
    @NamedQuery(name = "Examen.findByCodigoexamenid", query = "SELECT e FROM Examen e WHERE e.codigoexamenid = :codigoexamenid"),
    @NamedQuery(name = "Examen.findByNombreexamen", query = "SELECT e FROM Examen e WHERE e.nombreexamen = :nombreexamen")})
public class Examen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examenid")
    private Integer examenid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigoexamenid")
    private String codigoexamenid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreexamen")
    private String nombreexamen;
    @JoinColumn(name = "areaexamenid", referencedColumnName = "areaexamenid")
    @ManyToOne
    private Areaexamen areaexamenid;
    @OneToMany(mappedBy = "examenid")
    private List<Indicaciones> indicacionesList;
    @OneToMany(mappedBy = "examenid")
    private List<Solexex> solexexList;

    public Examen() {
    }

    public Examen(Integer examenid) {
        this.examenid = examenid;
    }

    public Examen(Integer examenid, String codigoexamenid, String nombreexamen) {
        this.examenid = examenid;
        this.codigoexamenid = codigoexamenid;
        this.nombreexamen = nombreexamen;
    }

    public Integer getExamenid() {
        return examenid;
    }

    public void setExamenid(Integer examenid) {
        this.examenid = examenid;
    }

    public String getCodigoexamenid() {
        return codigoexamenid;
    }

    public void setCodigoexamenid(String codigoexamenid) {
        this.codigoexamenid = codigoexamenid;
    }

    public String getNombreexamen() {
        return nombreexamen;
    }

    public void setNombreexamen(String nombreexamen) {
        this.nombreexamen = nombreexamen;
    }

    public Areaexamen getAreaexamenid() {
        return areaexamenid;
    }

    public void setAreaexamenid(Areaexamen areaexamenid) {
        this.areaexamenid = areaexamenid;
    }

    @XmlTransient
    public List<Indicaciones> getIndicacionesList() {
        return indicacionesList;
    }

    public void setIndicacionesList(List<Indicaciones> indicacionesList) {
        this.indicacionesList = indicacionesList;
    }

    @XmlTransient
    public List<Solexex> getSolexexList() {
        return solexexList;
    }

    public void setSolexexList(List<Solexex> solexexList) {
        this.solexexList = solexexList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examenid != null ? examenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.examenid == null && other.examenid != null) || (this.examenid != null && !this.examenid.equals(other.examenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Examen[ examenid=" + examenid + " ]";
    }
    
}
