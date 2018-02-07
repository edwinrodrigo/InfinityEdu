/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danielPC
 */
@Entity
@Table(name = "paralelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paralelo.findAll", query = "SELECT p FROM Paralelo p"),
    @NamedQuery(name = "Paralelo.findByCodParalelo", query = "SELECT p FROM Paralelo p WHERE p.paraleloPK.codParalelo = :codParalelo"),
    @NamedQuery(name = "Paralelo.findByPeriodo", query = "SELECT p FROM Paralelo p WHERE p.paraleloPK.periodo = :periodo"),
    @NamedQuery(name = "Paralelo.findByCodNiv", query = "SELECT p FROM Paralelo p WHERE p.paraleloPK.codNiv = :codNiv"),
    @NamedQuery(name = "Paralelo.findByCodCurso", query = "SELECT p FROM Paralelo p WHERE p.paraleloPK.codCurso = :codCurso"),
    @NamedQuery(name = "Paralelo.findByCodEmpresa", query = "SELECT p FROM Paralelo p WHERE p.paraleloPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "Paralelo.findByDesParalelo", query = "SELECT p FROM Paralelo p WHERE p.desParalelo = :desParalelo"),
    @NamedQuery(name = "Paralelo.findByUsuarioIngreso", query = "SELECT p FROM Paralelo p WHERE p.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Paralelo.findByFechaIngreso", query = "SELECT p FROM Paralelo p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Paralelo.findByUsuarioModificacion", query = "SELECT p FROM Paralelo p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Paralelo.findByFechaModificacion", query = "SELECT p FROM Paralelo p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Paralelo.findByEstado", query = "SELECT p FROM Paralelo p WHERE p.estado = :estado")})
public class Paralelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParaleloPK paraleloPK;
    @Size(max = 100)
    @Column(name = "des_paralelo")
    private String desParalelo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paralelo", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paralelo", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paralelo", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paralelo", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @JoinColumn(name = "cod_tutor", referencedColumnName = "cod_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona codTutor;
    @JoinColumn(name = "periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Periodo periodo1;
    @JoinColumn(name = "cod_niv", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    @JoinColumn(name = "cod_curso", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;

    public Paralelo() {
    }

    public Paralelo(ParaleloPK paraleloPK) {
        this.paraleloPK = paraleloPK;
    }

    public Paralelo(String codParalelo, String periodo, String codNiv, String codCurso, String codEmpresa) {
        this.paraleloPK = new ParaleloPK(codParalelo, periodo, codNiv, codCurso, codEmpresa);
    }

    public ParaleloPK getParaleloPK() {
        return paraleloPK;
    }

    public void setParaleloPK(ParaleloPK paraleloPK) {
        this.paraleloPK = paraleloPK;
    }

    public String getDesParalelo() {
        return desParalelo;
    }

    public void setDesParalelo(String desParalelo) {
        this.desParalelo = desParalelo;
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

    @XmlTransient
    public List<AsistenciaMateriaEstudiante> getAsistenciaMateriaEstudianteList() {
        return asistenciaMateriaEstudianteList;
    }

    public void setAsistenciaMateriaEstudianteList(List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList) {
        this.asistenciaMateriaEstudianteList = asistenciaMateriaEstudianteList;
    }

    @XmlTransient
    public List<EstudianteMateriaParalelo> getEstudianteMateriaParaleloList() {
        return estudianteMateriaParaleloList;
    }

    public void setEstudianteMateriaParaleloList(List<EstudianteMateriaParalelo> estudianteMateriaParaleloList) {
        this.estudianteMateriaParaleloList = estudianteMateriaParaleloList;
    }

    @XmlTransient
    public List<MateriaParalelo> getMateriaParaleloList() {
        return materiaParaleloList;
    }

    public void setMateriaParaleloList(List<MateriaParalelo> materiaParaleloList) {
        this.materiaParaleloList = materiaParaleloList;
    }

    @XmlTransient
    public List<AreaMateria> getAreaMateriaList() {
        return areaMateriaList;
    }

    public void setAreaMateriaList(List<AreaMateria> areaMateriaList) {
        this.areaMateriaList = areaMateriaList;
    }

    public Persona getCodTutor() {
        return codTutor;
    }

    public void setCodTutor(Persona codTutor) {
        this.codTutor = codTutor;
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
        hash += (paraleloPK != null ? paraleloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paralelo)) {
            return false;
        }
        Paralelo other = (Paralelo) object;
        if ((this.paraleloPK == null && other.paraleloPK != null) || (this.paraleloPK != null && !this.paraleloPK.equals(other.paraleloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Paralelo[ paraleloPK=" + paraleloPK + " ]";
    }
    
}
