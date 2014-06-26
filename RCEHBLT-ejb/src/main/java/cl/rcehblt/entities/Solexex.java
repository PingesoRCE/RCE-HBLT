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
@Table(name = "solexex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solexex.findAll", query = "SELECT s FROM Solexex s"),
    @NamedQuery(name = "Solexex.findBySolexexid", query = "SELECT s FROM Solexex s WHERE s.solexexid = :solexexid")})
public class Solexex implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "solexexid")
    private Integer solexexid;
    @JoinColumn(name = "solicitudeid", referencedColumnName = "solicitudeid")
    @ManyToOne
    private Solicitudexamen solicitudeid;
    @JoinColumn(name = "examenid", referencedColumnName = "examenid")
    @ManyToOne
    private Examen examenid;

    public Solexex() {
    }

    public Solexex(Integer solexexid) {
        this.solexexid = solexexid;
    }

    public Integer getSolexexid() {
        return solexexid;
    }

    public void setSolexexid(Integer solexexid) {
        this.solexexid = solexexid;
    }

    public Solicitudexamen getSolicitudeid() {
        return solicitudeid;
    }

    public void setSolicitudeid(Solicitudexamen solicitudeid) {
        this.solicitudeid = solicitudeid;
    }

    public Examen getExamenid() {
        return examenid;
    }

    public void setExamenid(Examen examenid) {
        this.examenid = examenid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solexexid != null ? solexexid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solexex)) {
            return false;
        }
        Solexex other = (Solexex) object;
        if ((this.solexexid == null && other.solexexid != null) || (this.solexexid != null && !this.solexexid.equals(other.solexexid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Solexex[ solexexid=" + solexexid + " ]";
    }
    
}
