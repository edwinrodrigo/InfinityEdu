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
@Table(name = "materia_paralelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaParalelo.findAll", query = "SELECT m FROM MateriaParalelo m"),
    @NamedQuery(name = "MateriaParalelo.findByPeriodo", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.periodo = :periodo"),
    @NamedQuery(name = "MateriaParalelo.findByCodNiv", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.codNiv = :codNiv"),
    @NamedQuery(name = "MateriaParalelo.findByCodCur", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.codCur = :codCur"),
    @NamedQuery(name = "MateriaParalelo.findByCodEmpresa", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "MateriaParalelo.findByCodMat", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.codMat = :codMat"),
    @NamedQuery(name = "MateriaParalelo.findByCodParalelo", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.codParalelo = :codParalelo"),
    @NamedQuery(name = "MateriaParalelo.findByCodPro", query = "SELECT m FROM MateriaParalelo m WHERE m.materiaParaleloPK.codPro = :codPro"),
    @NamedQuery(name = "MateriaParalelo.findByNumHoras", query = "SELECT m FROM MateriaParalelo m WHERE m.numHoras = :numHoras"),
    @NamedQuery(name = "MateriaParalelo.findByTipo", query = "SELECT m FROM MateriaParalelo m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "MateriaParalelo.findByPrmFin", query = "SELECT m FROM MateriaParalelo m WHERE m.prmFin = :prmFin"),
    @NamedQuery(name = "MateriaParalelo.findByMatAcum", query = "SELECT m FROM MateriaParalelo m WHERE m.matAcum = :matAcum"),
    @NamedQuery(name = "MateriaParalelo.findByCodmatAcum", query = "SELECT m FROM MateriaParalelo m WHERE m.codmatAcum = :codmatAcum"),
    @NamedQuery(name = "MateriaParalelo.findByImprimeMat", query = "SELECT m FROM MateriaParalelo m WHERE m.imprimeMat = :imprimeMat"),
    @NamedQuery(name = "MateriaParalelo.findByCodArea", query = "SELECT m FROM MateriaParalelo m WHERE m.codArea = :codArea"),
    @NamedQuery(name = "MateriaParalelo.findByUsuarioIngreso", query = "SELECT m FROM MateriaParalelo m WHERE m.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "MateriaParalelo.findByFechaIngreso", query = "SELECT m FROM MateriaParalelo m WHERE m.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "MateriaParalelo.findByUsuarioModificacion", query = "SELECT m FROM MateriaParalelo m WHERE m.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "MateriaParalelo.findByFechaModificacion", query = "SELECT m FROM MateriaParalelo m WHERE m.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "MateriaParalelo.findByEstado", query = "SELECT m FROM MateriaParalelo m WHERE m.estado = :estado")})
public class MateriaParalelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MateriaParaleloPK materiaParaleloPK;
    @Column(name = "num_horas")
    private Integer numHoras;
    @Column(name = "tipo")
    private Integer tipo;
    @Size(max = 1)
    @Column(name = "prm_fin")
    private String prmFin;
    @Size(max = 1)
    @Column(name = "mat_acum")
    private String matAcum;
    @Size(max = 4)
    @Column(name = "cod_matAcum")
    private String codmatAcum;
    @Size(max = 2)
    @Column(name = "imprime_mat")
    private String imprimeMat;
    @Size(max = 4)
    @Column(name = "cod_area")
    private String codArea;
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
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona persona;
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
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    @JoinColumn(name = "cod_cur", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;

    public MateriaParalelo() {
    }

    public MateriaParalelo(MateriaParaleloPK materiaParaleloPK) {
        this.materiaParaleloPK = materiaParaleloPK;
    }

    public MateriaParalelo(String periodo, String codNiv, String codCur, String codEmpresa, String codMat, String codParalelo, String codPro) {
        this.materiaParaleloPK = new MateriaParaleloPK(periodo, codNiv, codCur, codEmpresa, codMat, codParalelo, codPro);
    }

    public MateriaParaleloPK getMateriaParaleloPK() {
        return materiaParaleloPK;
    }

    public void setMateriaParaleloPK(MateriaParaleloPK materiaParaleloPK) {
        this.materiaParaleloPK = materiaParaleloPK;
    }

    public Integer getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(Integer numHoras) {
        this.numHoras = numHoras;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getPrmFin() {
        return prmFin;
    }

    public void setPrmFin(String prmFin) {
        this.prmFin = prmFin;
    }

    public String getMatAcum() {
        return matAcum;
    }

    public void setMatAcum(String matAcum) {
        this.matAcum = matAcum;
    }

    public String getCodmatAcum() {
        return codmatAcum;
    }

    public void setCodmatAcum(String codmatAcum) {
        this.codmatAcum = codmatAcum;
    }

    public String getImprimeMat() {
        return imprimeMat;
    }

    public void setImprimeMat(String imprimeMat) {
        this.imprimeMat = imprimeMat;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materiaParaleloPK != null ? materiaParaleloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaParalelo)) {
            return false;
        }
        MateriaParalelo other = (MateriaParalelo) object;
        if ((this.materiaParaleloPK == null && other.materiaParaleloPK != null) || (this.materiaParaleloPK != null && !this.materiaParaleloPK.equals(other.materiaParaleloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.MateriaParalelo[ materiaParaleloPK=" + materiaParaleloPK + " ]";
    }
    
}
