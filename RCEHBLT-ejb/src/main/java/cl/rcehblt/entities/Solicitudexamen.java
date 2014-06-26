/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "solicitudexamen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitudexamen.findAll", query = "SELECT s FROM Solicitudexamen s"),
    @NamedQuery(name = "Solicitudexamen.findBySolicitudeid", query = "SELECT s FROM Solicitudexamen s WHERE s.solicitudeid = :solicitudeid"),
    @NamedQuery(name = "Solicitudexamen.findByFecha", query = "SELECT s FROM Solicitudexamen s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Solicitudexamen.findByOtro", query = "SELECT s FROM Solicitudexamen s WHERE s.otro = :otro")})
public class Solicitudexamen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "solicitudeid")
    private Integer solicitudeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2147483647)
    @Column(name = "otro")
    private String otro;
    @OneToMany(mappedBy = "solicitudeid")
    private List<Solexex> solexexList;
    @JoinColumn(name = "consultaid", referencedColumnName = "consultaid")
    @ManyToOne(optional = false)
    private Consulta consultaid;

    public Solicitudexamen() {
    }

    public Solicitudexamen(Integer solicitudeid) {
        this.solicitudeid = solicitudeid;
    }

    public Solicitudexamen(Integer solicitudeid, Date fecha) {
        this.solicitudeid = solicitudeid;
        this.fecha = fecha;
    }

    public Integer getSolicitudeid() {
        return solicitudeid;
    }

    public void setSolicitudeid(Integer solicitudeid) {
        this.solicitudeid = solicitudeid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOtro() {
        return otro;
    }

    public void setOtro(String otro) {
        this.otro = otro;
    }

    @XmlTransient
    public List<Solexex> getSolexexList() {
        return solexexList;
    }

    public void setSolexexList(List<Solexex> solexexList) {
        this.solexexList = solexexList;
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
        hash += (solicitudeid != null ? solicitudeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitudexamen)) {
            return false;
        }
        Solicitudexamen other = (Solicitudexamen) object;
        if ((this.solicitudeid == null && other.solicitudeid != null) || (this.solicitudeid != null && !this.solicitudeid.equals(other.solicitudeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Solicitudexamen[ solicitudeid=" + solicitudeid + " ]";
    }
    
}
