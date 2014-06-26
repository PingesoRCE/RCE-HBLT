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
@Table(name = "dosis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dosis.findAll", query = "SELECT d FROM Dosis d"),
    @NamedQuery(name = "Dosis.findByDosisid", query = "SELECT d FROM Dosis d WHERE d.dosisid = :dosisid"),
    @NamedQuery(name = "Dosis.findByCodigodosis", query = "SELECT d FROM Dosis d WHERE d.codigodosis = :codigodosis"),
    @NamedQuery(name = "Dosis.findByCantidad", query = "SELECT d FROM Dosis d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Dosis.findByMedida", query = "SELECT d FROM Dosis d WHERE d.medida = :medida")})
public class Dosis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dosisid")
    private Integer dosisid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigodosis")
    private String codigodosis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "medida")
    private String medida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dosisid")
    private List<DosisFf> dosisFfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dosisid")
    private List<RexternaFarmaco> rexternaFarmacoList;

    public Dosis() {
    }

    public Dosis(Integer dosisid) {
        this.dosisid = dosisid;
    }

    public Dosis(Integer dosisid, String codigodosis, int cantidad, String medida) {
        this.dosisid = dosisid;
        this.codigodosis = codigodosis;
        this.cantidad = cantidad;
        this.medida = medida;
    }

    public Integer getDosisid() {
        return dosisid;
    }

    public void setDosisid(Integer dosisid) {
        this.dosisid = dosisid;
    }

    public String getCodigodosis() {
        return codigodosis;
    }

    public void setCodigodosis(String codigodosis) {
        this.codigodosis = codigodosis;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    @XmlTransient
    public List<DosisFf> getDosisFfList() {
        return dosisFfList;
    }

    public void setDosisFfList(List<DosisFf> dosisFfList) {
        this.dosisFfList = dosisFfList;
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
        hash += (dosisid != null ? dosisid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dosis)) {
            return false;
        }
        Dosis other = (Dosis) object;
        if ((this.dosisid == null && other.dosisid != null) || (this.dosisid != null && !this.dosisid.equals(other.dosisid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Dosis[ dosisid=" + dosisid + " ]";
    }
    
}
