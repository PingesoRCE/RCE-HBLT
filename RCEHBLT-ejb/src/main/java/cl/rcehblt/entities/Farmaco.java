/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "farmaco")
@XmlRootElement
@NamedQueries({
    
    @NamedQuery(name = "Farmaco.findAll", query = "SELECT f FROM Farmaco f"),
    @NamedQuery(name = "Farmaco.findByFarmacoid", query = "SELECT f FROM Farmaco f WHERE f.farmacoid = :farmacoid"),
    @NamedQuery(name = "Farmaco.findByCodigoatc", query = "SELECT f FROM Farmaco f WHERE f.codigoatc = :codigoatc"),
    @NamedQuery(name = "Farmaco.findByNombrefarmaco", query = "SELECT f FROM Farmaco f WHERE f.nombrefarmaco = :nombrefarmaco")})
public class Farmaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "farmacoid")
    private Integer farmacoid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigoatc")
    private String codigoatc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombrefarmaco")
    private String nombrefarmaco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmacoid")
    private List<FfFarmaco> ffFarmacoList;
    @OneToMany(mappedBy = "farmacoid")
    private List<RexternaFarmaco> rexternaFarmacoList;

    public Farmaco() {
    }

    public Farmaco(Integer farmacoid) {
        this.farmacoid = farmacoid;
    }

    public Farmaco(Integer farmacoid, String codigoatc, String nombrefarmaco) {
        this.farmacoid = farmacoid;
        this.codigoatc = codigoatc;
        this.nombrefarmaco = nombrefarmaco;
    }

    public Integer getFarmacoid() {
        return farmacoid;
    }

    public void setFarmacoid(Integer farmacoid) {
        this.farmacoid = farmacoid;
    }

    public String getCodigoatc() {
        return codigoatc;
    }

    public void setCodigoatc(String codigoatc) {
        this.codigoatc = codigoatc;
    }

    public String getNombrefarmaco() {
        return nombrefarmaco;
    }

    public void setNombrefarmaco(String nombrefarmaco) {
        this.nombrefarmaco = nombrefarmaco;
    }

    @XmlTransient
    public List<FfFarmaco> getFfFarmacoList() {
        return ffFarmacoList;
    }

    public void setFfFarmacoList(List<FfFarmaco> ffFarmacoList) {
        this.ffFarmacoList = ffFarmacoList;
    }

    @XmlTransient
    public List<RexternaFarmaco> getRexternaFarmacoList() {
        return rexternaFarmacoList;
    }

    public void setRexternaFarmacoList(List<RexternaFarmaco> rexternaFarmacoList) {
        this.rexternaFarmacoList = rexternaFarmacoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (farmacoid != null ? farmacoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Farmaco)) {
            return false;
        }
        Farmaco other = (Farmaco) object;
        if ((this.farmacoid == null && other.farmacoid != null) || (this.farmacoid != null && !this.farmacoid.equals(other.farmacoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Farmaco[ farmacoid=" + farmacoid + " ]";
    }
    
}
