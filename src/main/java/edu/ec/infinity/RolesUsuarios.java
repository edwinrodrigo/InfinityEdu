/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danielPC
 */
@Entity
@Table(name = "roles_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolesUsuarios.findAll", query = "SELECT r FROM RolesUsuarios r"),
    @NamedQuery(name = "RolesUsuarios.findByCodRol", query = "SELECT r FROM RolesUsuarios r WHERE r.rolesUsuariosPK.codRol = :codRol"),
    @NamedQuery(name = "RolesUsuarios.findByCodUsuario", query = "SELECT r FROM RolesUsuarios r WHERE r.rolesUsuariosPK.codUsuario = :codUsuario"),
    @NamedQuery(name = "RolesUsuarios.findByEstado", query = "SELECT r FROM RolesUsuarios r WHERE r.estado = :estado"),
    @NamedQuery(name = "RolesUsuarios.findByUsuarioIngreso", query = "SELECT r FROM RolesUsuarios r WHERE r.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "RolesUsuarios.findByFechaIngreso", query = "SELECT r FROM RolesUsuarios r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "RolesUsuarios.findByUsuarioModificacion", query = "SELECT r FROM RolesUsuarios r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RolesUsuarios.findByFechaModificacion", query = "SELECT r FROM RolesUsuarios r WHERE r.fechaModificacion = :fechaModificacion")})
public class RolesUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolesUsuariosPK rolesUsuariosPK;
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
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Roles roles;

    public RolesUsuarios() {
    }

    public RolesUsuarios(RolesUsuariosPK rolesUsuariosPK) {
        this.rolesUsuariosPK = rolesUsuariosPK;
    }

    public RolesUsuarios(int codRol, int codUsuario) {
        this.rolesUsuariosPK = new RolesUsuariosPK(codRol, codUsuario);
    }

    public RolesUsuariosPK getRolesUsuariosPK() {
        return rolesUsuariosPK;
    }

    public void setRolesUsuariosPK(RolesUsuariosPK rolesUsuariosPK) {
        this.rolesUsuariosPK = rolesUsuariosPK;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolesUsuariosPK != null ? rolesUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesUsuarios)) {
            return false;
        }
        RolesUsuarios other = (RolesUsuarios) object;
        if ((this.rolesUsuariosPK == null && other.rolesUsuariosPK != null) || (this.rolesUsuariosPK != null && !this.rolesUsuariosPK.equals(other.rolesUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.RolesUsuarios[ rolesUsuariosPK=" + rolesUsuariosPK + " ]";
    }
    
}
