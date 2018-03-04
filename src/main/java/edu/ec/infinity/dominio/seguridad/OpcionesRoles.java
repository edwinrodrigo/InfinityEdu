/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio.seguridad;

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
@Table(name = "opciones_roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OpcionesRoles.findAll", query = "SELECT o FROM OpcionesRoles o"),
    @NamedQuery(name = "OpcionesRoles.findByCodOpcion", query = "SELECT o FROM OpcionesRoles o WHERE o.opcionesRolesPK.codOpcion = :codOpcion"),
    @NamedQuery(name = "OpcionesRoles.findByCodRol", query = "SELECT o FROM OpcionesRoles o WHERE o.opcionesRolesPK.codRol = :codRol"),
    @NamedQuery(name = "OpcionesRoles.findByEstado", query = "SELECT o FROM OpcionesRoles o WHERE o.estado = :estado"),
    @NamedQuery(name = "OpcionesRoles.findByUsuarioIngreso", query = "SELECT o FROM OpcionesRoles o WHERE o.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "OpcionesRoles.findByFechaIngreso", query = "SELECT o FROM OpcionesRoles o WHERE o.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "OpcionesRoles.findByUsuarioModificacion", query = "SELECT o FROM OpcionesRoles o WHERE o.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "OpcionesRoles.findByFechaModificacion", query = "SELECT o FROM OpcionesRoles o WHERE o.fechaModificacion = :fechaModificacion")})
public class OpcionesRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionesRolesPK opcionesRolesPK;
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
    @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Roles roles;
    @JoinColumn(name = "cod_opcion", referencedColumnName = "cod_opcion", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Opciones opciones;

    public OpcionesRoles() {
    }

    public OpcionesRoles(OpcionesRolesPK opcionesRolesPK) {
        this.opcionesRolesPK = opcionesRolesPK;
    }

    public OpcionesRoles(int codOpcion, int codRol) {
        this.opcionesRolesPK = new OpcionesRolesPK(codOpcion, codRol);
    }

    public OpcionesRolesPK getOpcionesRolesPK() {
        return opcionesRolesPK;
    }

    public void setOpcionesRolesPK(OpcionesRolesPK opcionesRolesPK) {
        this.opcionesRolesPK = opcionesRolesPK;
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

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Opciones getOpciones() {
        return opciones;
    }

    public void setOpciones(Opciones opciones) {
        this.opciones = opciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionesRolesPK != null ? opcionesRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionesRoles)) {
            return false;
        }
        OpcionesRoles other = (OpcionesRoles) object;
        if ((this.opcionesRolesPK == null && other.opcionesRolesPK != null) || (this.opcionesRolesPK != null && !this.opcionesRolesPK.equals(other.opcionesRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.OpcionesRoles[ opcionesRolesPK=" + opcionesRolesPK + " ]";
    }
    
}
