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
@Table(name = "episodios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Episodios.findAll", query = "SELECT e FROM Episodios e"),
    @NamedQuery(name = "Episodios.findByEpisodioid", query = "SELECT e FROM Episodios e WHERE e.episodioid = :episodioid"),
    @NamedQuery(name = "Episodios.findByFecha", query = "SELECT e FROM Episodios e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Episodios.findByNombre", query = "SELECT e FROM Episodios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Episodios.findByAbierto", query = "SELECT e FROM Episodios e WHERE e.abierto = :abierto")})
public class Episodios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "episodioid")
    private Integer episodioid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "abierto")
    private boolean abierto;
    @JoinColumn(name = "registroclinicoid", referencedColumnName = "registroclinicoid")
    @ManyToOne(optional = false)
    private RegistroClinico registroclinicoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioid")
    private List<Consulta> consultaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "episodioid")
    private List<Antmedidos> antmedidosList;

    public Episodios() {
    }

    public Episodios(Integer episodioid) {
        this.episodioid = episodioid;
    }

    public Episodios(Integer episodioid, Date fecha, String nombre, boolean abierto) {
        this.episodioid = episodioid;
        this.fecha = fecha;
        this.nombre = nombre;
        this.abierto = abierto;
    }

    public Integer getEpisodioid() {
        return episodioid;
    }

    public void setEpisodioid(Integer episodioid) {
        this.episodioid = episodioid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public RegistroClinico getRegistroclinicoid() {
        return registroclinicoid;
    }

    public void setRegistroclinicoid(RegistroClinico registroclinicoid) {
        this.registroclinicoid = registroclinicoid;
    }

    @XmlTransient
    public List<Consulta> getConsultaList() {
        return consultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        this.consultaList = consultaList;
    }

    @XmlTransient
    public List<Antmedidos> getAntmedidosList() {
        return antmedidosList;
    }

    public void setAntmedidosList(List<Antmedidos> antmedidosList) {
        this.antmedidosList = antmedidosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (episodioid != null ? episodioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Episodios)) {
            return false;
        }
        Episodios other = (Episodios) object;
        if ((this.episodioid == null && other.episodioid != null) || (this.episodioid != null && !this.episodioid.equals(other.episodioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Episodios[ episodioid=" + episodioid + " ]";
    }
    
}
