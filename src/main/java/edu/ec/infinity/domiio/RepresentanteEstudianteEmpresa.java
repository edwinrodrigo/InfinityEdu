/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

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
@Table(name = "representante_estudiante_empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findAll", query = "SELECT r FROM RepresentanteEstudianteEmpresa r"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByCodPersona", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.representanteEstudianteEmpresaPK.codPersona = :codPersona"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByCodEstudiante", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.representanteEstudianteEmpresaPK.codEstudiante = :codEstudiante"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByCodEmpresa", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.representanteEstudianteEmpresaPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByUsuarioIngreso", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByFechaIngreso", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByUsuarioModificacion", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByFechaModificacion", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "RepresentanteEstudianteEmpresa.findByEstado", query = "SELECT r FROM RepresentanteEstudianteEmpresa r WHERE r.estado = :estado")})
public class RepresentanteEstudianteEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepresentanteEstudianteEmpresaPK representanteEstudianteEmpresaPK;
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
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona persona;
    @JoinColumn(name = "cod_estudiante", referencedColumnName = "cod_estudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estudiante estudiante;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public RepresentanteEstudianteEmpresa() {
    }

    public RepresentanteEstudianteEmpresa(RepresentanteEstudianteEmpresaPK representanteEstudianteEmpresaPK) {
        this.representanteEstudianteEmpresaPK = representanteEstudianteEmpresaPK;
    }

    public RepresentanteEstudianteEmpresa(String codPersona, String codEstudiante, String codEmpresa) {
        this.representanteEstudianteEmpresaPK = new RepresentanteEstudianteEmpresaPK(codPersona, codEstudiante, codEmpresa);
    }

    public RepresentanteEstudianteEmpresaPK getRepresentanteEstudianteEmpresaPK() {
        return representanteEstudianteEmpresaPK;
    }

    public void setRepresentanteEstudianteEmpresaPK(RepresentanteEstudianteEmpresaPK representanteEstudianteEmpresaPK) {
        this.representanteEstudianteEmpresaPK = representanteEstudianteEmpresaPK;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (representanteEstudianteEmpresaPK != null ? representanteEstudianteEmpresaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteEstudianteEmpresa)) {
            return false;
        }
        RepresentanteEstudianteEmpresa other = (RepresentanteEstudianteEmpresa) object;
        if ((this.representanteEstudianteEmpresaPK == null && other.representanteEstudianteEmpresaPK != null) || (this.representanteEstudianteEmpresaPK != null && !this.representanteEstudianteEmpresaPK.equals(other.representanteEstudianteEmpresaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.RepresentanteEstudianteEmpresa[ representanteEstudianteEmpresaPK=" + representanteEstudianteEmpresaPK + " ]";
    }
    
}
