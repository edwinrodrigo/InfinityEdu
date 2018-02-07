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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCodUsuario", query = "SELECT u FROM Usuario u WHERE u.codUsuario = :codUsuario"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByUsuarioIngreso", query = "SELECT u FROM Usuario u WHERE u.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Usuario.findByFechaIngreso", query = "SELECT u FROM Usuario u WHERE u.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Usuario.findByUsuarioModificacion", query = "SELECT u FROM Usuario u WHERE u.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Usuario.findByFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.fechaModificacion = :fechaModificacion")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario")
    private Integer codUsuario;
    @Size(max = 10)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 10)
    @Column(name = "clave")
    private String clave;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<RolesUsuarios> rolesUsuariosList;

    public Usuario() {
    }

    public Usuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
    public List<RolesUsuarios> getRolesUsuariosList() {
        return rolesUsuariosList;
    }

    public void setRolesUsuariosList(List<RolesUsuarios> rolesUsuariosList) {
        this.rolesUsuariosList = rolesUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Usuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
