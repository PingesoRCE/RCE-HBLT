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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DevelUser
 */
@Entity
@Table(name = "servicio_salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioSalud.findAll", query = "SELECT s FROM ServicioSalud s"),
    @NamedQuery(name = "ServicioSalud.findByIdServiciosalud", query = "SELECT s FROM ServicioSalud s WHERE s.idServiciosalud = :idServiciosalud"),
    @NamedQuery(name = "ServicioSalud.findByServNombre", query = "SELECT s FROM ServicioSalud s WHERE s.servNombre = :servNombre")})
public class ServicioSalud implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_serviciosalud")
    private Integer idServiciosalud;
    @Size(max = 50)
    @Column(name = "serv_nombre")
    private String servNombre;
    @OneToMany(mappedBy = "idServiciosalud")
    private List<Establecimiento> establecimientoList;
    @OneToMany(mappedBy = "idServiciosalud")
    private List<Paciente> pacienteList;

    public ServicioSalud() {
    }

    public ServicioSalud(Integer idServiciosalud) {
        this.idServiciosalud = idServiciosalud;
    }

    public Integer getIdServiciosalud() {
        return idServiciosalud;
    }

    public void setIdServiciosalud(Integer idServiciosalud) {
        this.idServiciosalud = idServiciosalud;
    }

    public String getServNombre() {
        return servNombre;
    }

    public void setServNombre(String servNombre) {
        this.servNombre = servNombre;
    }

    @XmlTransient
    public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServiciosalud != null ? idServiciosalud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioSalud)) {
            return false;
        }
        ServicioSalud other = (ServicioSalud) object;
        if ((this.idServiciosalud == null && other.idServiciosalud != null) || (this.idServiciosalud != null && !this.idServiciosalud.equals(other.idServiciosalud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.rcehblt.ServicioSalud[ idServiciosalud=" + idServiciosalud + " ]";
    }
    
}
