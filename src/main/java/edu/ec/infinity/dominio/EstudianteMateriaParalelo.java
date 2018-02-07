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
@Table(name = "estudiante_materia_paralelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteMateriaParalelo.findAll", query = "SELECT e FROM EstudianteMateriaParalelo e"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByCodEstudiante", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.codEstudiante = :codEstudiante"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByPeriodo", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.periodo = :periodo"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByCodNiv", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.codNiv = :codNiv"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByCodCur", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.codCur = :codCur"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByCodParalelo", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.codParalelo = :codParalelo"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByCodEmpresa", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByCodMat", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estudianteMateriaParaleloPK.codMat = :codMat"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByUsuarioIngreso", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByFechaIngreso", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByUsuarioModificacion", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByFechaModificacion", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "EstudianteMateriaParalelo.findByEstado", query = "SELECT e FROM EstudianteMateriaParalelo e WHERE e.estado = :estado")})
public class EstudianteMateriaParalelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteMateriaParaleloPK estudianteMateriaParaleloPK;
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

    public EstudianteMateriaParalelo() {
    }

    public EstudianteMateriaParalelo(EstudianteMateriaParaleloPK estudianteMateriaParaleloPK) {
        this.estudianteMateriaParaleloPK = estudianteMateriaParaleloPK;
    }

    public EstudianteMateriaParalelo(String codEstudiante, String periodo, String codNiv, String codCur, String codParalelo, String codEmpresa, String codMat) {
        this.estudianteMateriaParaleloPK = new EstudianteMateriaParaleloPK(codEstudiante, periodo, codNiv, codCur, codParalelo, codEmpresa, codMat);
    }

    public EstudianteMateriaParaleloPK getEstudianteMateriaParaleloPK() {
        return estudianteMateriaParaleloPK;
    }

    public void setEstudianteMateriaParaleloPK(EstudianteMateriaParaleloPK estudianteMateriaParaleloPK) {
        this.estudianteMateriaParaleloPK = estudianteMateriaParaleloPK;
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
        hash += (estudianteMateriaParaleloPK != null ? estudianteMateriaParaleloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteMateriaParalelo)) {
            return false;
        }
        EstudianteMateriaParalelo other = (EstudianteMateriaParalelo) object;
        if ((this.estudianteMateriaParaleloPK == null && other.estudianteMateriaParaleloPK != null) || (this.estudianteMateriaParaleloPK != null && !this.estudianteMateriaParaleloPK.equals(other.estudianteMateriaParaleloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.EstudianteMateriaParalelo[ estudianteMateriaParaleloPK=" + estudianteMateriaParaleloPK + " ]";
    }
    
}
