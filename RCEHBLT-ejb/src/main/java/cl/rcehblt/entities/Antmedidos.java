/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.rcehblt.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "antmedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antmedidos.findAll", query = "SELECT a FROM Antmedidos a"),
    @NamedQuery(name = "Antmedidos.findByIdAntmedidos", query = "SELECT a FROM Antmedidos a WHERE a.idAntmedidos = :idAntmedidos"),
    @NamedQuery(name = "Antmedidos.findByFecha", query = "SELECT a FROM Antmedidos a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Antmedidos.findByValor", query = "SELECT a FROM Antmedidos a WHERE a.valor = :valor"),
    @NamedQuery(name = "Antmedidos.findByGrupo", query = "SELECT a FROM Antmedidos a WHERE a.grupo = :grupo"),

    @NamedQuery(name = "Antmedidos.findByEpisodioGrupo", query = "SELECT a FROM Antmedidos a WHERE a.episodioid = :episodioid and a.grupo = :grupo"),
    @NamedQuery(name = "Antmedidos.findByIdAntmedidosFechaEpisodio", query = "SELECT a FROM Antmedidos a WHERE a.idAntecedente = :idAntecedente and a.episodioid = :episodioid ORDER BY a.fecha DESC")})
public class Antmedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antmedidos")
    private Integer idAntmedidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "valor")
    private String valor;
    @Column(name = "grupo")
    private Integer grupo;
    @JoinColumn(name = "episodioid", referencedColumnName = "episodioid")
    @ManyToOne(optional = false)
    private Episodios episodioid;
    @JoinColumn(name = "id_antecedente", referencedColumnName = "id_antecedente")
    @ManyToOne(optional = false)
    private Antecedentes idAntecedente;

    public Antmedidos() {
    }

    public Antmedidos(Integer idAntmedidos) {
        this.idAntmedidos = idAntmedidos;
    }

    public Antmedidos(Integer idAntmedidos, Date fecha, String valor) {
        this.idAntmedidos = idAntmedidos;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Integer getIdAntmedidos() {
        return idAntmedidos;
    }

    public void setIdAntmedidos(Integer idAntmedidos) {
        this.idAntmedidos = idAntmedidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getGrupo() {
        return grupo;
    }

    public void setGrupo(Integer grupo) {
        this.grupo = grupo;
    }

    public Episodios getEpisodioid() {
        return episodioid;
    }

    public void setEpisodioid(Episodios episodioid) {
        this.episodioid = episodioid;
    }

    public Antecedentes getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Antecedentes idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntmedidos != null ? idAntmedidos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antmedidos)) {
            return false;
        }
        Antmedidos other = (Antmedidos) object;
        if ((this.idAntmedidos == null && other.idAntmedidos != null) || (this.idAntmedidos != null && !this.idAntmedidos.equals(other.idAntmedidos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.Antmedidos[ idAntmedidos=" + idAntmedidos + " ]";
    }

}
