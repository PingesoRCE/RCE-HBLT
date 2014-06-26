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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "externa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Externa.findAll", query = "SELECT e FROM Externa e"),
    @NamedQuery(name = "Externa.findByPrescriptionid", query = "SELECT e FROM Externa e WHERE e.prescriptionid = :prescriptionid")})
public class Externa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescriptionid")
    private Integer prescriptionid;
    @JoinColumn(name = "prescriptionid", referencedColumnName = "prescriptionid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prescription prescription;

    public Externa() {
    }

    public Externa(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Integer getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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
        if (!(object instanceof Externa)) {
            return false;
        }
        Externa other = (Externa) object;
        if ((this.prescriptionid == null && other.prescriptionid != null) || (this.prescriptionid != null && !this.prescriptionid.equals(other.prescriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Externa[ prescriptionid=" + prescriptionid + " ]";
    }
    
}
