/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "perioricidad_nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerioricidadNota.findAll", query = "SELECT p FROM PerioricidadNota p"),
    @NamedQuery(name = "PerioricidadNota.findByPeriodo", query = "SELECT p FROM PerioricidadNota p WHERE p.perioricidadNotaPK.periodo = :periodo"),
    @NamedQuery(name = "PerioricidadNota.findByCodNiv", query = "SELECT p FROM PerioricidadNota p WHERE p.perioricidadNotaPK.codNiv = :codNiv"),
    @NamedQuery(name = "PerioricidadNota.findByCodEst", query = "SELECT p FROM PerioricidadNota p WHERE p.perioricidadNotaPK.codEst = :codEst"),
    @NamedQuery(name = "PerioricidadNota.findByCodMat", query = "SELECT p FROM PerioricidadNota p WHERE p.perioricidadNotaPK.codMat = :codMat"),
    @NamedQuery(name = "PerioricidadNota.findByCodEmpresa", query = "SELECT p FROM PerioricidadNota p WHERE p.perioricidadNotaPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "PerioricidadNota.findByQuimestre", query = "SELECT p FROM PerioricidadNota p WHERE p.perioricidadNotaPK.quimestre = :quimestre"),
    @NamedQuery(name = "PerioricidadNota.findByNotaFinal", query = "SELECT p FROM PerioricidadNota p WHERE p.notaFinal = :notaFinal"),
    @NamedQuery(name = "PerioricidadNota.findByUsuarioIngreso", query = "SELECT p FROM PerioricidadNota p WHERE p.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "PerioricidadNota.findByFechaIngreso", query = "SELECT p FROM PerioricidadNota p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PerioricidadNota.findByUsuarioModificacion", query = "SELECT p FROM PerioricidadNota p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "PerioricidadNota.findByFechaModificacion", query = "SELECT p FROM PerioricidadNota p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "PerioricidadNota.findByEstado", query = "SELECT p FROM PerioricidadNota p WHERE p.estado = :estado")})
public class PerioricidadNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerioricidadNotaPK perioricidadNotaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota_final")
    private BigDecimal notaFinal;
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
    @JoinColumn(name = "periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Periodo periodo1;
    @JoinColumn(name = "cod_niv", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_mat", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumn(name = "cod_est", referencedColumnName = "cod_estudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estudiante estudiante;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public PerioricidadNota() {
    }

    public PerioricidadNota(PerioricidadNotaPK perioricidadNotaPK) {
        this.perioricidadNotaPK = perioricidadNotaPK;
    }

    public PerioricidadNota(String periodo, String codNiv, String codEst, String codMat, String codEmpresa, int quimestre) {
        this.perioricidadNotaPK = new PerioricidadNotaPK(periodo, codNiv, codEst, codMat, codEmpresa, quimestre);
    }

    public PerioricidadNotaPK getPerioricidadNotaPK() {
        return perioricidadNotaPK;
    }

    public void setPerioricidadNotaPK(PerioricidadNotaPK perioricidadNotaPK) {
        this.perioricidadNotaPK = perioricidadNotaPK;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
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

    public Periodo getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(Periodo periodo1) {
        this.periodo1 = periodo1;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
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
        hash += (perioricidadNotaPK != null ? perioricidadNotaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerioricidadNota)) {
            return false;
        }
        PerioricidadNota other = (PerioricidadNota) object;
        if ((this.perioricidadNotaPK == null && other.perioricidadNotaPK != null) || (this.perioricidadNotaPK != null && !this.perioricidadNotaPK.equals(other.perioricidadNotaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.PerioricidadNota[ perioricidadNotaPK=" + perioricidadNotaPK + " ]";
    }
    
}
