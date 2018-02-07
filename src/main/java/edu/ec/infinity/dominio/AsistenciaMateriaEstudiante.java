/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "asistencia_materia_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findAll", query = "SELECT a FROM AsistenciaMateriaEstudiante a"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByCodEstudiante", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.codEstudiante = :codEstudiante"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByPeriodo", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.periodo = :periodo"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByCodNiv", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.codNiv = :codNiv"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByCodCur", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.codCur = :codCur"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByCodParalelo", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.codParalelo = :codParalelo"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByCodEmpresa", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByCodMat", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.codMat = :codMat"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByDia", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenciaMateriaEstudiantePK.dia = :dia"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByQuimestre", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.quimestre = :quimestre"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByParcial", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.parcial = :parcial"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByAsistenncia", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.asistenncia = :asistenncia"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByUsuarioIngreso", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByFechaIngreso", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByUsuarioModificacion", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByFechaModificacion", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "AsistenciaMateriaEstudiante.findByEstado", query = "SELECT a FROM AsistenciaMateriaEstudiante a WHERE a.estado = :estado")})
public class AsistenciaMateriaEstudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaMateriaEstudiantePK asistenciaMateriaEstudiantePK;
    @Column(name = "quimestre")
    private Integer quimestre;
    @Column(name = "parcial")
    private Integer parcial;
    @Size(max = 1)
    @Column(name = "asistenncia")
    private String asistenncia;
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
    @JoinColumns({
        @JoinColumn(name = "cod_paralelo", referencedColumnName = "cod_paralelo", insertable = false, updatable = false),
        @JoinColumn(name = "cod_niv", referencedColumnName = "cod_niv", insertable = false, updatable = false),
        @JoinColumn(name = "cod_cur", referencedColumnName = "cod_curso", insertable = false, updatable = false),
        @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false),
        @JoinColumn(name = "periodo", referencedColumnName = "periodo", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paralelo paralelo;
    @JoinColumn(name = "cod_niv", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_mat", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumn(name = "cod_estudiante", referencedColumnName = "cod_estudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estudiante estudiante;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    @JoinColumn(name = "cod_cur", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;

    public AsistenciaMateriaEstudiante() {
    }

    public AsistenciaMateriaEstudiante(AsistenciaMateriaEstudiantePK asistenciaMateriaEstudiantePK) {
        this.asistenciaMateriaEstudiantePK = asistenciaMateriaEstudiantePK;
    }

    public AsistenciaMateriaEstudiante(String codEstudiante, String periodo, String codNiv, String codCur, String codParalelo, String codEmpresa, String codMat, Date dia) {
        this.asistenciaMateriaEstudiantePK = new AsistenciaMateriaEstudiantePK(codEstudiante, periodo, codNiv, codCur, codParalelo, codEmpresa, codMat, dia);
    }

    public AsistenciaMateriaEstudiantePK getAsistenciaMateriaEstudiantePK() {
        return asistenciaMateriaEstudiantePK;
    }

    public void setAsistenciaMateriaEstudiantePK(AsistenciaMateriaEstudiantePK asistenciaMateriaEstudiantePK) {
        this.asistenciaMateriaEstudiantePK = asistenciaMateriaEstudiantePK;
    }

    public Integer getQuimestre() {
        return quimestre;
    }

    public void setQuimestre(Integer quimestre) {
        this.quimestre = quimestre;
    }

    public Integer getParcial() {
        return parcial;
    }

    public void setParcial(Integer parcial) {
        this.parcial = parcial;
    }

    public String getAsistenncia() {
        return asistenncia;
    }

    public void setAsistenncia(String asistenncia) {
        this.asistenncia = asistenncia;
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

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaMateriaEstudiantePK != null ? asistenciaMateriaEstudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaMateriaEstudiante)) {
            return false;
        }
        AsistenciaMateriaEstudiante other = (AsistenciaMateriaEstudiante) object;
        if ((this.asistenciaMateriaEstudiantePK == null && other.asistenciaMateriaEstudiantePK != null) || (this.asistenciaMateriaEstudiantePK != null && !this.asistenciaMateriaEstudiantePK.equals(other.asistenciaMateriaEstudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.AsistenciaMateriaEstudiante[ asistenciaMateriaEstudiantePK=" + asistenciaMateriaEstudiantePK + " ]";
    }
    
}
