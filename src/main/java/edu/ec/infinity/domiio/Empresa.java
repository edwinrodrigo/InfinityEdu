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
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByCodEmpresa", query = "SELECT e FROM Empresa e WHERE e.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "Empresa.findByDescripcion", query = "SELECT e FROM Empresa e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Empresa.findByRepresentanteLegal", query = "SELECT e FROM Empresa e WHERE e.representanteLegal = :representanteLegal"),
    @NamedQuery(name = "Empresa.findByNombreRector", query = "SELECT e FROM Empresa e WHERE e.nombreRector = :nombreRector"),
    @NamedQuery(name = "Empresa.findByNombreSecretario", query = "SELECT e FROM Empresa e WHERE e.nombreSecretario = :nombreSecretario"),
    @NamedQuery(name = "Empresa.findByProfesionRector", query = "SELECT e FROM Empresa e WHERE e.profesionRector = :profesionRector"),
    @NamedQuery(name = "Empresa.findByProfesionSecretario", query = "SELECT e FROM Empresa e WHERE e.profesionSecretario = :profesionSecretario"),
    @NamedQuery(name = "Empresa.findByUsuarioIngreso", query = "SELECT e FROM Empresa e WHERE e.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Empresa.findByFechaIngreso", query = "SELECT e FROM Empresa e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Empresa.findByUsuarioModificacion", query = "SELECT e FROM Empresa e WHERE e.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Empresa.findByFechaModificacion", query = "SELECT e FROM Empresa e WHERE e.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 100)
    @Column(name = "representante_legal")
    private String representanteLegal;
    @Size(max = 100)
    @Column(name = "nombre_rector")
    private String nombreRector;
    @Size(max = 100)
    @Column(name = "nombre_secretario")
    private String nombreSecretario;
    @Size(max = 50)
    @Column(name = "profesion_rector")
    private String profesionRector;
    @Size(max = 50)
    @Column(name = "profesion_secretario")
    private String profesionSecretario;
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
    @OneToMany(mappedBy = "codEmpresa", fetch = FetchType.EAGER)
    private List<Materia> materiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @OneToMany(mappedBy = "codEmpresa", fetch = FetchType.EAGER)
    private List<Area> areaList;
    @OneToMany(mappedBy = "codEmpresa", fetch = FetchType.EAGER)
    private List<Estudiante> estudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<RegActas> regActasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<Insumo> insumoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<Paralelo> paraleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<PerioricidadNota> perioricidadNotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<RepresentanteEstudianteEmpresa> representanteEstudianteEmpresaList;
    @OneToMany(mappedBy = "codEmpresa", fetch = FetchType.EAGER)
    private List<Curso> cursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private List<NotasGrabadas> notasGrabadasList;

    public Empresa() {
    }

    public Empresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getNombreRector() {
        return nombreRector;
    }

    public void setNombreRector(String nombreRector) {
        this.nombreRector = nombreRector;
    }

    public String getNombreSecretario() {
        return nombreSecretario;
    }

    public void setNombreSecretario(String nombreSecretario) {
        this.nombreSecretario = nombreSecretario;
    }

    public String getProfesionRector() {
        return profesionRector;
    }

    public void setProfesionRector(String profesionRector) {
        this.profesionRector = profesionRector;
    }

    public String getProfesionSecretario() {
        return profesionSecretario;
    }

    public void setProfesionSecretario(String profesionSecretario) {
        this.profesionSecretario = profesionSecretario;
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
    public List<RepresentanteEstudianteEmpresa> getRepresentanteEstudianteEmpresaList() {
        return representanteEstudianteEmpresaList;
    }

    public void setRepresentanteEstudianteEmpresaList(List<RepresentanteEstudianteEmpresa> representanteEstudianteEmpresaList) {
        this.representanteEstudianteEmpresaList = representanteEstudianteEmpresaList;
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
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Empresa[ codEmpresa=" + codEmpresa + " ]";
    }
    
}
