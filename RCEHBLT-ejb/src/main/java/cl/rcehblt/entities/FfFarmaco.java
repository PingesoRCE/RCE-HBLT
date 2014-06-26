/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "ff_farmaco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FfFarmaco.findAll", query = "SELECT f FROM FfFarmaco f"),
    @NamedQuery(name = "FfFarmaco.findByFfFarmaco", query = "SELECT f FROM FfFarmaco f WHERE f.ffFarmaco = :ffFarmaco")})
public class FfFarmaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ff_farmaco")
    private Integer ffFarmaco;
    @JoinColumn(name = "formafarmaceuticaid", referencedColumnName = "formafarmaceuticaid")
    @ManyToOne(optional = false)
    private FormaFarmaceutica formafarmaceuticaid;
    @JoinColumn(name = "farmacoid", referencedColumnName = "farmacoid")
    @ManyToOne(optional = false)
    private Farmaco farmacoid;

    public FfFarmaco() {
    }

    public FfFarmaco(Integer ffFarmaco) {
        this.ffFarmaco = ffFarmaco;
    }

    public Integer getFfFarmaco() {
        return ffFarmaco;
    }

    public void setFfFarmaco(Integer ffFarmaco) {
        this.ffFarmaco = ffFarmaco;
    }

    public FormaFarmaceutica getFormafarmaceuticaid() {
        return formafarmaceuticaid;
    }

    public void setFormafarmaceuticaid(FormaFarmaceutica formafarmaceuticaid) {
        this.formafarmaceuticaid = formafarmaceuticaid;
    }

    public Farmaco getFarmacoid() {
        return farmacoid;
    }

    public void setFarmacoid(Farmaco farmacoid) {
        this.farmacoid = farmacoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ffFarmaco != null ? ffFarmaco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FfFarmaco)) {
            return false;
        }
        FfFarmaco other = (FfFarmaco) object;
        if ((this.ffFarmaco == null && other.ffFarmaco != null) || (this.ffFarmaco != null && !this.ffFarmaco.equals(other.ffFarmaco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.FfFarmaco[ ffFarmaco=" + ffFarmaco + " ]";
    }
    
}
