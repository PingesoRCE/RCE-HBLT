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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "areaexamen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areaexamen.findAll", query = "SELECT a FROM Areaexamen a"),
    @NamedQuery(name = "Areaexamen.findByAreaexamenid", query = "SELECT a FROM Areaexamen a WHERE a.areaexamenid = :areaexamenid"),
    @NamedQuery(name = "Areaexamen.findByNombreareaexamenid", query = "SELECT a FROM Areaexamen a WHERE a.nombreareaexamenid = :nombreareaexamenid")})
public class Areaexamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "areaexamenid")
    private Integer areaexamenid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreareaexamenid")
    private String nombreareaexamenid;
    @OneToMany(mappedBy = "areaexamenid")
    private List<Examen> examenList;

    public Areaexamen() {
    }

    public Areaexamen(Integer areaexamenid) {
        this.areaexamenid = areaexamenid;
    }

    public Areaexamen(Integer areaexamenid, String nombreareaexamenid) {
        this.areaexamenid = areaexamenid;
        this.nombreareaexamenid = nombreareaexamenid;
    }

    public Integer getAreaexamenid() {
        return areaexamenid;
    }

    public void setAreaexamenid(Integer areaexamenid) {
        this.areaexamenid = areaexamenid;
    }

    public String getNombreareaexamenid() {
        return nombreareaexamenid;
    }

    public void setNombreareaexamenid(String nombreareaexamenid) {
        this.nombreareaexamenid = nombreareaexamenid;
    }

    @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaexamenid != null ? areaexamenid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areaexamen)) {
            return false;
        }
        Areaexamen other = (Areaexamen) object;
        if ((this.areaexamenid == null && other.areaexamenid != null) || (this.areaexamenid != null && !this.areaexamenid.equals(other.areaexamenid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Areaexamen[ areaexamenid=" + areaexamenid + " ]";
    }
    
}
