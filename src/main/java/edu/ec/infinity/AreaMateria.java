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
@Table(name = "area_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaMateria.findAll", query = "SELECT a FROM AreaMateria a"),
    @NamedQuery(name = "AreaMateria.findByCodNivel", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.codNivel = :codNivel"),
    @NamedQuery(name = "AreaMateria.findByPeriodo", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.periodo = :periodo"),
    @NamedQuery(name = "AreaMateria.findByCodEmpresa", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "AreaMateria.findByCodMat", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.codMat = :codMat"),
    @NamedQuery(name = "AreaMateria.findByCodParalelo", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.codParalelo = :codParalelo"),
    @NamedQuery(name = "AreaMateria.findByCodCur", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.codCur = :codCur"),
    @NamedQuery(name = "AreaMateria.findByCodArea", query = "SELECT a FROM AreaMateria a WHERE a.areaMateriaPK.codArea = :codArea"),
    @NamedQuery(name = "AreaMateria.findByUsuarioIngreso", query = "SELECT a FROM AreaMateria a WHERE a.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "AreaMateria.findByFechaIngreso", query = "SELECT a FROM AreaMateria a WHERE a.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "AreaMateria.findByUsuarioModificacion", query = "SELECT a FROM AreaMateria a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "AreaMateria.findByFechaModificacion", query = "SELECT a FROM AreaMateria a WHERE a.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "AreaMateria.findByEstado", query = "SELECT a FROM AreaMateria a WHERE a.estado = :estado")})
public class AreaMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreaMateriaPK areaMateriaPK;
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
        @JoinColumn(name = "cod_nivel", referencedColumnName = "cod_niv", insertable = false, updatable = false),
        @JoinColumn(name = "cod_cur", referencedColumnName = "cod_curso", insertable = false, updatable = false),
        @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false),
        @JoinColumn(name = "periodo", referencedColumnName = "periodo", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Paralelo paralelo;
    @JoinColumn(name = "cod_nivel", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_mat", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    @JoinColumn(name = "cod_cur", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;
    @JoinColumn(name = "cod_area", referencedColumnName = "cod_area", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Area area;

    public AreaMateria() {
    }

    public AreaMateria(AreaMateriaPK areaMateriaPK) {
        this.areaMateriaPK = areaMateriaPK;
    }

    public AreaMateria(String codNivel, String periodo, String codEmpresa, String codMat, String codParalelo, String codCur, String codArea) {
        this.areaMateriaPK = new AreaMateriaPK(codNivel, periodo, codEmpresa, codMat, codParalelo, codCur, codArea);
    }

    public AreaMateriaPK getAreaMateriaPK() {
        return areaMateriaPK;
    }

    public void setAreaMateriaPK(AreaMateriaPK areaMateriaPK) {
        this.areaMateriaPK = areaMateriaPK;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaMateriaPK != null ? areaMateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaMateria)) {
            return false;
        }
        AreaMateria other = (AreaMateria) object;
        if ((this.areaMateriaPK == null && other.areaMateriaPK != null) || (this.areaMateriaPK != null && !this.areaMateriaPK.equals(other.areaMateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.AreaMateria[ areaMateriaPK=" + areaMateriaPK + " ]";
    }
    
}
