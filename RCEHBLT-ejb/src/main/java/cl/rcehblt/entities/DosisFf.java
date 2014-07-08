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
@Table(name = "dosis_ff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DosisFf.findAll", query = "SELECT d FROM DosisFf d"),
    @NamedQuery(name = "DosisFf.findByFormaFarmaceuticaId", query = "SELECT d FROM DosisFf d WHERE d.formafarmaceuticaid = :ff"),
    @NamedQuery(name = "DosisFf.findByDosisff", query = "SELECT d FROM DosisFf d WHERE d.dosisff = :dosisff")})

public class DosisFf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dosisff")
    private Integer dosisff;
    @JoinColumn(name = "formafarmaceuticaid", referencedColumnName = "formafarmaceuticaid")
    @ManyToOne(optional = false)
    private FormaFarmaceutica formafarmaceuticaid;
    @JoinColumn(name = "dosisid", referencedColumnName = "dosisid")
    @ManyToOne(optional = false)
    private Dosis dosisid;

    public DosisFf() {
    }

    public DosisFf(Integer dosisff) {
        this.dosisff = dosisff;
    }

    public Integer getDosisff() {
        return dosisff;
    }

    public void setDosisff(Integer dosisff) {
        this.dosisff = dosisff;
    }

    public FormaFarmaceutica getFormafarmaceuticaid() {
        return formafarmaceuticaid;
    }

    public void setFormafarmaceuticaid(FormaFarmaceutica formafarmaceuticaid) {
        this.formafarmaceuticaid = formafarmaceuticaid;
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
        hash += (dosisff != null ? dosisff.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DosisFf)) {
            return false;
        }
        DosisFf other = (DosisFf) object;
        if ((this.dosisff == null && other.dosisff != null) || (this.dosisff != null && !this.dosisff.equals(other.dosisff))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.DosisFf[ dosisff=" + dosisff + " ]";
    }
    
}
