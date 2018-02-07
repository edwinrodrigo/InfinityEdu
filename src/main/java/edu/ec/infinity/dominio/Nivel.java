/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByCodNivel", query = "SELECT n FROM Nivel n WHERE n.codNivel = :codNivel"),
    @NamedQuery(name = "Nivel.findByDescripcion", query = "SELECT n FROM Nivel n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "Nivel.findByUsuarioIngreso", query = "SELECT n FROM Nivel n WHERE n.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Nivel.findByFechaIngreso", query = "SELECT n FROM Nivel n WHERE n.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Nivel.findByUsuarioModificacion", query = "SELECT n FROM Nivel n WHERE n.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Nivel.findByFechaModificacion", query = "SELECT n FROM Nivel n WHERE n.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Nivel.findByEstado", query = "SELECT n FROM Nivel n WHERE n.estado = :estado"),
    @NamedQuery(name = "Nivel.findByCodEmpresa", query = "SELECT n FROM Nivel n WHERE n.codEmpresa = :codEmpresa")})
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_nivel")
    private String codNivel;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
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
    @Size(max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<TareaInsumoParaleo> tareaInsumoParaleoList;
    @OneToMany(mappedBy = "codNiv", fetch = FetchType.EAGER)
    private List<Materia> materiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @OneToMany(mappedBy = "codNivel", fetch = FetchType.EAGER)
    private List<Area> areaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<RegActas> regActasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<InsumoParalelo> insumoParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<Paralelo> paraleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<PerioricidadNota> perioricidadNotaList;
    @OneToMany(mappedBy = "codNivel", fetch = FetchType.EAGER)
    private List<Curso> cursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel", fetch = FetchType.EAGER)
    private List<NotasGrabadas> notasGrabadasList;

    public Nivel() {
    }

    public Nivel(String codNivel) {
        this.codNivel = codNivel;
    }

    public String getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(String codNivel) {
        this.codNivel = codNivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @XmlTransient
    public List<TareaInsumoParaleo> getTareaInsumoParaleoList() {
        return tareaInsumoParaleoList;
    }

    public void setTareaInsumoParaleoList(List<TareaInsumoParaleo> tareaInsumoParaleoList) {
        this.tareaInsumoParaleoList = tareaInsumoParaleoList;
    }

    @XmlTransient
    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
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
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
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

    @XmlTransient
    public List<PerioricidadNota> getPerioricidadNotaList() {
        return perioricidadNotaList;
    }

    public void setPerioricidadNotaList(List<PerioricidadNota> perioricidadNotaList) {
        this.perioricidadNotaList = perioricidadNotaList;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @XmlTransient
    public List<NotasGrabadas> getNotasGrabadasList() {
        return notasGrabadasList;
    }

    public void setNotasGrabadasList(List<NotasGrabadas> notasGrabadasList) {
        this.notasGrabadasList = notasGrabadasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNivel != null ? codNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.codNivel == null && other.codNivel != null) || (this.codNivel != null && !this.codNivel.equals(other.codNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Nivel[ codNivel=" + codNivel + " ]";
    }
    
}
