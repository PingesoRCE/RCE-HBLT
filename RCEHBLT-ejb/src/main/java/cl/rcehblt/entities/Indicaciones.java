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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "indicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicaciones.findAll", query = "SELECT i FROM Indicaciones i"),
    @NamedQuery(name = "Indicaciones.findByIndicacionid", query = "SELECT i FROM Indicaciones i WHERE i.indicacionid = :indicacionid"),
    @NamedQuery(name = "Indicaciones.findByOtroind", query = "SELECT i FROM Indicaciones i WHERE i.otroind = :otroind")})
public class Indicaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "indicacionid")
    private Integer indicacionid;
    @Size(max = 2147483647)
    @Column(name = "otroind")
    private String otroind;
    @JoinColumn(name = "rexternafarmacoid", referencedColumnName = "rexternafarmacoid")
    @ManyToOne
    private RexternaFarmaco rexternafarmacoid;
    @JoinColumn(name = "examenid", referencedColumnName = "examenid")
    @ManyToOne
    private Examen examenid;
    @JoinColumn(name = "consultaid", referencedColumnName = "consultaid")
    @ManyToOne
    private Consulta consultaid;

    public Indicaciones() {
    }

    public Indicaciones(Integer indicacionid) {
        this.indicacionid = indicacionid;
    }

    public Integer getIndicacionid() {
        return indicacionid;
    }

    public void setIndicacionid(Integer indicacionid) {
        this.indicacionid = indicacionid;
    }

    public String getOtroind() {
        return otroind;
    }

    public void setOtroind(String otroind) {
        this.otroind = otroind;
    }

    public RexternaFarmaco getRexternafarmacoid() {
        return rexternafarmacoid;
    }

    public void setRexternafarmacoid(RexternaFarmaco rexternafarmacoid) {
        this.rexternafarmacoid = rexternafarmacoid;
    }

    public Examen getExamenid() {
        return examenid;
    }

    public void setExamenid(Examen examenid) {
        this.examenid = examenid;
    }

    public Consulta getConsultaid() {
        return consultaid;
    }

    public void setConsultaid(Consulta consultaid) {
        this.consultaid = consultaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicacionid != null ? indicacionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicaciones)) {
            return false;
        }
        Indicaciones other = (Indicaciones) object;
        if ((this.indicacionid == null && other.indicacionid != null) || (this.indicacionid != null && !this.indicacionid.equals(other.indicacionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Indicaciones[ indicacionid=" + indicacionid + " ]";
    }
    
}
