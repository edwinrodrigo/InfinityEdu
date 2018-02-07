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
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByCodPeriodo", query = "SELECT p FROM Periodo p WHERE p.codPeriodo = :codPeriodo"),
    @NamedQuery(name = "Periodo.findByDescripcion", query = "SELECT p FROM Periodo p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Periodo.findByUsuarioIngreso", query = "SELECT p FROM Periodo p WHERE p.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Periodo.findByFechaIngreso", query = "SELECT p FROM Periodo p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Periodo.findByUsuarioModificacion", query = "SELECT p FROM Periodo p WHERE p.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Periodo.findByFechaModificacion", query = "SELECT p FROM Periodo p WHERE p.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Periodo.findByEstado", query = "SELECT p FROM Periodo p WHERE p.estado = :estado")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_periodo")
    private String codPeriodo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<TareaInsumoParaleo> tareaInsumoParaleoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @OneToMany(mappedBy = "periodo", fetch = FetchType.EAGER)
    private List<Area> areaList;
    @OneToMany(mappedBy = "codPeriodo", fetch = FetchType.EAGER)
    private List<Estudiante> estudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<RegActas> regActasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<Insumo> insumoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<Paralelo> paraleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<PerioricidadNota> perioricidadNotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo1", fetch = FetchType.EAGER)
    private List<NotasGrabadas> notasGrabadasList;

    public Periodo() {
    }

    public Periodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
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
    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @XmlTransient
    public List<RegActas> getRegActasList() {
        return regActasList;
    }

    public void setRegActasList(List<RegActas> regActasList) {
        this.regActasList = regActasList;
    }

    @XmlTransient
    public List<Insumo> getInsumoList() {
        return insumoList;
    }

    public void setInsumoList(List<Insumo> insumoList) {
        this.insumoList = insumoList;
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
    public List<NotasGrabadas> getNotasGrabadasList() {
        return notasGrabadasList;
    }

    public void setNotasGrabadasList(List<NotasGrabadas> notasGrabadasList) {
        this.notasGrabadasList = notasGrabadasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.codPeriodo == null && other.codPeriodo != null) || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Periodo[ codPeriodo=" + codPeriodo + " ]";
    }
    
}
