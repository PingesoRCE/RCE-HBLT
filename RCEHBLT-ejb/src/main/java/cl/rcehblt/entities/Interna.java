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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "interna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interna.findAll", query = "SELECT i FROM Interna i"),
    @NamedQuery(name = "Interna.findByPrescriptionid", query = "SELECT i FROM Interna i WHERE i.prescriptionid = :prescriptionid"),
    @NamedQuery(name = "Interna.findByPeriodoDeTraamiento", query = "SELECT i FROM Interna i WHERE i.periodoDeTraamiento = :periodoDeTraamiento")})
public class Interna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescriptionid")
    private Integer prescriptionid;
    @Column(name = "periodo_de_traamiento")
    private Integer periodoDeTraamiento;
    @JoinColumn(name = "prescriptionid", referencedColumnName = "prescriptionid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prescription prescription;
    @OneToMany(mappedBy = "prescriptionid")
    private List<RexternaFarmaco> rexternaFarmacoList;

    public Interna() {
    }

    public Interna(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Integer getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Integer getPeriodoDeTraamiento() {
        return periodoDeTraamiento;
    }

    public void setPeriodoDeTraamiento(Integer periodoDeTraamiento) {
        this.periodoDeTraamiento = periodoDeTraamiento;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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
        hash += (prescriptionid != null ? prescriptionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interna)) {
            return false;
        }
        Interna other = (Interna) object;
        if ((this.prescriptionid == null && other.prescriptionid != null) || (this.prescriptionid != null && !this.prescriptionid.equals(other.prescriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Interna[ prescriptionid=" + prescriptionid + " ]";
    }
    
}
