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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "rexterna_farmaco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RexternaFarmaco.findAll", query = "SELECT r FROM RexternaFarmaco r"),
    @NamedQuery(name = "RexternaFarmaco.findByRexternafarmacoid", query = "SELECT r FROM RexternaFarmaco r WHERE r.rexternafarmacoid = :rexternafarmacoid"),
    @NamedQuery(name = "RexternaFarmaco.findByCantidaddespacho", query = "SELECT r FROM RexternaFarmaco r WHERE r.cantidaddespacho = :cantidaddespacho")})
public class RexternaFarmaco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rexternafarmacoid")
    private Integer rexternafarmacoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidaddespacho")
    private int cantidaddespacho;
    @OneToMany(mappedBy = "rexternafarmacoid")
    private List<Indicaciones> indicacionesList;
    @JoinColumn(name = "prescriptionid", referencedColumnName = "prescriptionid")
    @ManyToOne
    private Interna prescriptionid;
    @JoinColumn(name = "formafarmaceuticaid", referencedColumnName = "formafarmaceuticaid")
    @ManyToOne(optional = false)
    private FormaFarmaceutica formafarmaceuticaid;
    @JoinColumn(name = "farmacoid", referencedColumnName = "farmacoid")
    @ManyToOne
    private Farmaco farmacoid;
    @JoinColumn(name = "dosisid", referencedColumnName = "dosisid")
    @ManyToOne(optional = false)
    private Dosis dosisid;

    public RexternaFarmaco() {
    }

    public RexternaFarmaco(Integer rexternafarmacoid) {
        this.rexternafarmacoid = rexternafarmacoid;
    }

    public RexternaFarmaco(Integer rexternafarmacoid, int cantidaddespacho) {
        this.rexternafarmacoid = rexternafarmacoid;
        this.cantidaddespacho = cantidaddespacho;
    }

    public Integer getRexternafarmacoid() {
        return rexternafarmacoid;
    }

    public void setRexternafarmacoid(Integer rexternafarmacoid) {
        this.rexternafarmacoid = rexternafarmacoid;
    }

    public int getCantidaddespacho() {
        return cantidaddespacho;
    }

    public void setCantidaddespacho(int cantidaddespacho) {
        this.cantidaddespacho = cantidaddespacho;
    }

    @XmlTransient
    public List<Indicaciones> getIndicacionesList() {
        return indicacionesList;
    }

    public void setIndicacionesList(List<Indicaciones> indicacionesList) {
        this.indicacionesList = indicacionesList;
    }

    public Interna getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Interna prescriptionid) {
        this.prescriptionid = prescriptionid;
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

    public Dosis getDosisid() {
        return dosisid;
    }

    public void setDosisid(Dosis dosisid) {
        this.dosisid = dosisid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rexternafarmacoid != null ? rexternafarmacoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RexternaFarmaco)) {
            return false;
        }
        RexternaFarmaco other = (RexternaFarmaco) object;
        if ((this.rexternafarmacoid == null && other.rexternafarmacoid != null) || (this.rexternafarmacoid != null && !this.rexternafarmacoid.equals(other.rexternafarmacoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.RexternaFarmaco[ rexternafarmacoid=" + rexternafarmacoid + " ]";
    }
    
}
