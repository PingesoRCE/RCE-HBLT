/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "prescription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescription.findAll", query = "SELECT p FROM Prescription p"),
    @NamedQuery(name = "Prescription.findByPrescriptionid", query = "SELECT p FROM Prescription p WHERE p.prescriptionid = :prescriptionid"),
    @NamedQuery(name = "Prescription.findByDescription", query = "SELECT p FROM Prescription p WHERE p.description = :description"),
    @NamedQuery(name = "Prescription.findByPrescriptionDay", query = "SELECT p FROM Prescription p WHERE p.prescriptionDay = :prescriptionDay")})
public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prescriptionid")
    private Integer prescriptionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prescription_day")
    @Temporal(TemporalType.DATE)
    private Date prescriptionDay;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prescription")
    private Interna interna;
    @JoinColumn(name = "consultaid", referencedColumnName = "consultaid")
    @ManyToOne
    private Consulta consultaid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prescription")
    private Externa externa;

    public Prescription() {
    }

    public Prescription(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Prescription(Integer prescriptionid, String description, Date prescriptionDay) {
        this.prescriptionid = prescriptionid;
        this.description = description;
        this.prescriptionDay = prescriptionDay;
    }

    public Integer getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(Integer prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPrescriptionDay() {
        return prescriptionDay;
    }

    public void setPrescriptionDay(Date prescriptionDay) {
        this.prescriptionDay = prescriptionDay;
    }

    public Interna getInterna() {
        return interna;
    }

    public void setInterna(Interna interna) {
        this.interna = interna;
    }

    public Consulta getConsultaid() {
        return consultaid;
    }

    public void setConsultaid(Consulta consultaid) {
        this.consultaid = consultaid;
    }

    public Externa getExterna() {
        return externa;
    }

    public void setExterna(Externa externa) {
        this.externa = externa;
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
        if (!(object instanceof Prescription)) {
            return false;
        }
        Prescription other = (Prescription) object;
        if ((this.prescriptionid == null && other.prescriptionid != null) || (this.prescriptionid != null && !this.prescriptionid.equals(other.prescriptionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Prescription[ prescriptionid=" + prescriptionid + " ]";
    }
    
}
