/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author danielPC
 */
@Entity
@Table(name = "telefono_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefonoPersona.findAll", query = "SELECT t FROM TelefonoPersona t"),
    @NamedQuery(name = "TelefonoPersona.findByCodPersona", query = "SELECT t FROM TelefonoPersona t WHERE t.codPersona = :codPersona"),
    @NamedQuery(name = "TelefonoPersona.findByCelular", query = "SELECT t FROM TelefonoPersona t WHERE t.celular = :celular"),
    @NamedQuery(name = "TelefonoPersona.findByConvencional1", query = "SELECT t FROM TelefonoPersona t WHERE t.convencional1 = :convencional1"),
    @NamedQuery(name = "TelefonoPersona.findByTelefonoOpcional", query = "SELECT t FROM TelefonoPersona t WHERE t.telefonoOpcional = :telefonoOpcional"),
    @NamedQuery(name = "TelefonoPersona.findByUsuarioIngreso", query = "SELECT t FROM TelefonoPersona t WHERE t.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "TelefonoPersona.findByFechaIngreso", query = "SELECT t FROM TelefonoPersona t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TelefonoPersona.findByUsuarioModificacion", query = "SELECT t FROM TelefonoPersona t WHERE t.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "TelefonoPersona.findByFechaModificacion", query = "SELECT t FROM TelefonoPersona t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "TelefonoPersona.findByEstado", query = "SELECT t FROM TelefonoPersona t WHERE t.estado = :estado")})
public class TelefonoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_persona")
    private String codPersona;
    @Size(max = 10)
    @Column(name = "celular")
    private String celular;
    @Size(max = 25)
    @Column(name = "convencional1")
    private String convencional1;
    @Size(max = 25)
    @Column(name = "telefono_opcional")
    private String telefonoOpcional;
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
    @Column(name = "estado")
    private String estado;

    public TelefonoPersona() {
    }

    public TelefonoPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getConvencional1() {
        return convencional1;
    }

    public void setConvencional1(String convencional1) {
        this.convencional1 = convencional1;
    }

    public String getTelefonoOpcional() {
        return telefonoOpcional;
    }

    public void setTelefonoOpcional(String telefonoOpcional) {
        this.telefonoOpcional = telefonoOpcional;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonoPersona)) {
            return false;
        }
        TelefonoPersona other = (TelefonoPersona) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.TelefonoPersona[ codPersona=" + codPersona + " ]";
    }
    
}
