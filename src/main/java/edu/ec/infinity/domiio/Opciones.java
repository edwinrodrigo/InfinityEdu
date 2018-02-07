/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

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
@Table(name = "opciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
    @NamedQuery(name = "Opciones.findByCodOpcion", query = "SELECT o FROM Opciones o WHERE o.codOpcion = :codOpcion"),
    @NamedQuery(name = "Opciones.findByNombre", query = "SELECT o FROM Opciones o WHERE o.nombre = :nombre"),
    @NamedQuery(name = "Opciones.findByDescripcion", query = "SELECT o FROM Opciones o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Opciones.findByIcono", query = "SELECT o FROM Opciones o WHERE o.icono = :icono"),
    @NamedQuery(name = "Opciones.findByUrl", query = "SELECT o FROM Opciones o WHERE o.url = :url"),
    @NamedQuery(name = "Opciones.findByAccion", query = "SELECT o FROM Opciones o WHERE o.accion = :accion"),
    @NamedQuery(name = "Opciones.findByOrden", query = "SELECT o FROM Opciones o WHERE o.orden = :orden"),
    @NamedQuery(name = "Opciones.findByOpcionPadre", query = "SELECT o FROM Opciones o WHERE o.opcionPadre = :opcionPadre"),
    @NamedQuery(name = "Opciones.findByEstado", query = "SELECT o FROM Opciones o WHERE o.estado = :estado"),
    @NamedQuery(name = "Opciones.findByUsuarioIngreso", query = "SELECT o FROM Opciones o WHERE o.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Opciones.findByFechaIngreso", query = "SELECT o FROM Opciones o WHERE o.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Opciones.findByUsuarioModificacion", query = "SELECT o FROM Opciones o WHERE o.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Opciones.findByFechaModificacion", query = "SELECT o FROM Opciones o WHERE o.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Opciones.findByModulo", query = "SELECT o FROM Opciones o WHERE o.modulo = :modulo")})
public class Opciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_opcion")
    private Integer codOpcion;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "icono")
    private String icono;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 30)
    @Column(name = "accion")
    private String accion;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "opcion_padre")
    private Integer opcionPadre;
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
    @Size(max = 1)
    @Column(name = "modulo")
    private String modulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opciones", fetch = FetchType.EAGER)
    private List<OpcionesRoles> opcionesRolesList;

    public Opciones() {
    }

    public Opciones(Integer codOpcion) {
        this.codOpcion = codOpcion;
    }

    public Integer getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(Integer codOpcion) {
        this.codOpcion = codOpcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getOpcionPadre() {
        return opcionPadre;
    }

    public void setOpcionPadre(Integer opcionPadre) {
        this.opcionPadre = opcionPadre;
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

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    @XmlTransient
    public List<OpcionesRoles> getOpcionesRolesList() {
        return opcionesRolesList;
    }

    public void setOpcionesRolesList(List<OpcionesRoles> opcionesRolesList) {
        this.opcionesRolesList = opcionesRolesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOpcion != null ? codOpcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.codOpcion == null && other.codOpcion != null) || (this.codOpcion != null && !this.codOpcion.equals(other.codOpcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Opciones[ codOpcion=" + codOpcion + " ]";
    }
    
}
