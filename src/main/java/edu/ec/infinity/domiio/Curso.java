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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodCur", query = "SELECT c FROM Curso c WHERE c.codCur = :codCur"),
    @NamedQuery(name = "Curso.findByDescCur", query = "SELECT c FROM Curso c WHERE c.descCur = :descCur"),
    @NamedQuery(name = "Curso.findByAbreviaturaCurso", query = "SELECT c FROM Curso c WHERE c.abreviaturaCurso = :abreviaturaCurso"),
    @NamedQuery(name = "Curso.findByCupoMax", query = "SELECT c FROM Curso c WHERE c.cupoMax = :cupoMax"),
    @NamedQuery(name = "Curso.findByUsuarioIngreso", query = "SELECT c FROM Curso c WHERE c.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Curso.findByFechaIngreso", query = "SELECT c FROM Curso c WHERE c.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Curso.findByUsuarioModificacion", query = "SELECT c FROM Curso c WHERE c.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Curso.findByFechaModificacion", query = "SELECT c FROM Curso c WHERE c.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Curso.findByEstado", query = "SELECT c FROM Curso c WHERE c.estado = :estado")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_cur")
    private String codCur;
    @Size(max = 100)
    @Column(name = "desc_cur")
    private String descCur;
    @Size(max = 25)
    @Column(name = "abreviatura_curso")
    private String abreviaturaCurso;
    @Column(name = "cupo_max")
    private Integer cupoMax;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<TareaInsumoParaleo> tareaInsumoParaleoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<RegActas> regActasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<InsumoParalelo> insumoParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.EAGER)
    private List<Paralelo> paraleloList;
    @JoinColumn(name = "cod_nivel", referencedColumnName = "cod_nivel")
    @ManyToOne(fetch = FetchType.EAGER)
    private Nivel codNivel;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa codEmpresa;

    public Curso() {
    }

    public Curso(String codCur) {
        this.codCur = codCur;
    }

    public String getCodCur() {
        return codCur;
    }

    public void setCodCur(String codCur) {
        this.codCur = codCur;
    }

    public String getDescCur() {
        return descCur;
    }

    public void setDescCur(String descCur) {
        this.descCur = descCur;
    }

    public String getAbreviaturaCurso() {
        return abreviaturaCurso;
    }

    public void setAbreviaturaCurso(String abreviaturaCurso) {
        this.abreviaturaCurso = abreviaturaCurso;
    }

    public Integer getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(Integer cupoMax) {
        this.cupoMax = cupoMax;
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
    public List<TareaInsumoParaleo> getTareaInsumoParaleoList() {
        return tareaInsumoParaleoList;
    }

    public void setTareaInsumoParaleoList(List<TareaInsumoParaleo> tareaInsumoParaleoList) {
        this.tareaInsumoParaleoList = tareaInsumoParaleoList;
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

    @XmlTransient
    public List<RegActas> getRegActasList() {
        return regActasList;
    }

    public void setRegActasList(List<RegActas> regActasList) {
        this.regActasList = regActasList;
    }

    @XmlTransient
    public List<InsumoParalelo> getInsumoParaleloList() {
        return insumoParaleloList;
    }

    public void setInsumoParaleloList(List<InsumoParalelo> insumoParaleloList) {
        this.insumoParaleloList = insumoParaleloList;
    }

    @XmlTransient
    public List<Paralelo> getParaleloList() {
        return paraleloList;
    }

    public void setParaleloList(List<Paralelo> paraleloList) {
        this.paraleloList = paraleloList;
    }

    public Nivel getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(Nivel codNivel) {
        this.codNivel = codNivel;
    }

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCur != null ? codCur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCur == null && other.codCur != null) || (this.codCur != null && !this.codCur.equals(other.codCur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Curso[ codCur=" + codCur + " ]";
    }
    
}