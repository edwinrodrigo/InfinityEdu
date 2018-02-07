/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
 * @author danielPC
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByCodRol", query = "SELECT r FROM Roles r WHERE r.codRol = :codRol"),
    @NamedQuery(name = "Roles.findByNombre", query = "SELECT r FROM Roles r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Roles.findByEstado", query = "SELECT r FROM Roles r WHERE r.estado = :estado"),
    @NamedQuery(name = "Roles.findByUsuarioIngreso", query = "SELECT r FROM Roles r WHERE r.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Roles.findByFechaIngreso", query = "SELECT r FROM Roles r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Roles.findByUsuarioModificacion", query = "SELECT r FROM Roles r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Roles.findByFechaModificacion", query = "SELECT r FROM Roles r WHERE r.fechaModificacion = :fechaModificacion")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_rol")
    private Integer codRol;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 1)
    @Column(name = "estado")
    private String estado;
    @Size(max = 10)
    @Column(name = "usuario_ingreso")
    private String usuarioIngreso;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Size(max = 10)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.EAGER)
    private List<OpcionesRoles> opcionesRolesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles", fetch = FetchType.EAGER)
    private List<RolesUsuarios> rolesUsuariosList;

    public Roles() {
    }

    public Roles(Integer codRol) {
        this.codRol = codRol;
    }

    public Integer getCodRol() {
        return codRol;
    }

    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @XmlTransient
    public List<OpcionesRoles> getOpcionesRolesList() {
        return opcionesRolesList;
    }

    public void setOpcionesRolesList(List<OpcionesRoles> opcionesRolesList) {
        this.opcionesRolesList = opcionesRolesList;
    }

    @XmlTransient
    public List<RolesUsuarios> getRolesUsuariosList() {
        return rolesUsuariosList;
    }

    public void setRolesUsuariosList(List<RolesUsuarios> rolesUsuariosList) {
        this.rolesUsuariosList = rolesUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Roles[ codRol=" + codRol + " ]";
    }
    
}
