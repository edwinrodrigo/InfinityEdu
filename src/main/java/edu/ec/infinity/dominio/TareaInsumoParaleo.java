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
@Table(name = "tarea_insumo_paraleo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TareaInsumoParaleo.findAll", query = "SELECT t FROM TareaInsumoParaleo t"),
    @NamedQuery(name = "TareaInsumoParaleo.findByPeriodo", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.periodo = :periodo"),
    @NamedQuery(name = "TareaInsumoParaleo.findByCodNivel", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.codNivel = :codNivel"),
    @NamedQuery(name = "TareaInsumoParaleo.findByCodCurso", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.codCurso = :codCurso"),
    @NamedQuery(name = "TareaInsumoParaleo.findByCodMateria", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.codMateria = :codMateria"),
    @NamedQuery(name = "TareaInsumoParaleo.findByCodInsumo", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.codInsumo = :codInsumo"),
    @NamedQuery(name = "TareaInsumoParaleo.findByCodEmpresa", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "TareaInsumoParaleo.findByCodEst", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.tareaInsumoParaleoPK.codEst = :codEst"),
    @NamedQuery(name = "TareaInsumoParaleo.findByQuimestre", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.quimestre = :quimestre"),
    @NamedQuery(name = "TareaInsumoParaleo.findByParcial", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.parcial = :parcial"),
    @NamedQuery(name = "TareaInsumoParaleo.findByNomTarea", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.nomTarea = :nomTarea"),
    @NamedQuery(name = "TareaInsumoParaleo.findByFechaInicio", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "TareaInsumoParaleo.findByFechaFin", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.fechaFin = :fechaFin"),
    @NamedQuery(name = "TareaInsumoParaleo.findByOpcional", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.opcional = :opcional"),
    @NamedQuery(name = "TareaInsumoParaleo.findByRutaArchivo", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.rutaArchivo = :rutaArchivo"),
    @NamedQuery(name = "TareaInsumoParaleo.findByLinkTarea", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.linkTarea = :linkTarea"),
    @NamedQuery(name = "TareaInsumoParaleo.findByUsuarioIngreso", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "TareaInsumoParaleo.findByFechaIngreso", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TareaInsumoParaleo.findByUsuarioModificacion", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "TareaInsumoParaleo.findByFechaModificacion", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "TareaInsumoParaleo.findByEstado", query = "SELECT t FROM TareaInsumoParaleo t WHERE t.estado = :estado")})
public class TareaInsumoParaleo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TareaInsumoParaleoPK tareaInsumoParaleoPK;
    @Column(name = "quimestre")
    private Integer quimestre;
    @Column(name = "parcial")
    private Integer parcial;
    @Size(max = 100)
    @Column(name = "nom_tarea")
    private String nomTarea;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Size(max = 1)
    @Column(name = "opcional")
    private String opcional;
    @Size(max = 100)
    @Column(name = "ruta_archivo")
    private String rutaArchivo;
    @Size(max = 500)
    @Column(name = "link_tarea")
    private String linkTarea;
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
    @JoinColumn(name = "cod_nivel", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumns({
        @JoinColumn(name = "cod_insumo", referencedColumnName = "cod_insumo", insertable = false, updatable = false),
        @JoinColumn(name = "periodo", referencedColumnName = "periodo", insertable = false, updatable = false),
        @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Insumo insumo;
    @JoinColumn(name = "cod_est", referencedColumnName = "cod_estudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estudiante estudiante;
    @JoinColumn(name = "cod_curso", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;

    public TareaInsumoParaleo() {
    }

    public TareaInsumoParaleo(TareaInsumoParaleoPK tareaInsumoParaleoPK) {
        this.tareaInsumoParaleoPK = tareaInsumoParaleoPK;
    }

    public TareaInsumoParaleo(String periodo, String codNivel, String codCurso, String codMateria, int codInsumo, String codEmpresa, String codEst) {
        this.tareaInsumoParaleoPK = new TareaInsumoParaleoPK(periodo, codNivel, codCurso, codMateria, codInsumo, codEmpresa, codEst);
    }

    public TareaInsumoParaleoPK getTareaInsumoParaleoPK() {
        return tareaInsumoParaleoPK;
    }

    public void setTareaInsumoParaleoPK(TareaInsumoParaleoPK tareaInsumoParaleoPK) {
        this.tareaInsumoParaleoPK = tareaInsumoParaleoPK;
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

    public String getNomTarea() {
        return nomTarea;
    }

    public void setNomTarea(String nomTarea) {
        this.nomTarea = nomTarea;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getOpcional() {
        return opcional;
    }

    public void setOpcional(String opcional) {
        this.opcional = opcional;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getLinkTarea() {
        return linkTarea;
    }

    public void setLinkTarea(String linkTarea) {
        this.linkTarea = linkTarea;
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

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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
        hash += (tareaInsumoParaleoPK != null ? tareaInsumoParaleoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaInsumoParaleo)) {
            return false;
        }
        TareaInsumoParaleo other = (TareaInsumoParaleo) object;
        if ((this.tareaInsumoParaleoPK == null && other.tareaInsumoParaleoPK != null) || (this.tareaInsumoParaleoPK != null && !this.tareaInsumoParaleoPK.equals(other.tareaInsumoParaleoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.TareaInsumoParaleo[ tareaInsumoParaleoPK=" + tareaInsumoParaleoPK + " ]";
    }
    
}
