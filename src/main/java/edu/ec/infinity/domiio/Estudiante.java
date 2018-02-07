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
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByCodEstudiante", query = "SELECT e FROM Estudiante e WHERE e.codEstudiante = :codEstudiante"),
    @NamedQuery(name = "Estudiante.findByColegioProcedencia", query = "SELECT e FROM Estudiante e WHERE e.colegioProcedencia = :colegioProcedencia"),
    @NamedQuery(name = "Estudiante.findByMatriculaCondicionada", query = "SELECT e FROM Estudiante e WHERE e.matriculaCondicionada = :matriculaCondicionada"),
    @NamedQuery(name = "Estudiante.findByMatriculaLegalizada", query = "SELECT e FROM Estudiante e WHERE e.matriculaLegalizada = :matriculaLegalizada"),
    @NamedQuery(name = "Estudiante.findByFechaMatricula", query = "SELECT e FROM Estudiante e WHERE e.fechaMatricula = :fechaMatricula"),
    @NamedQuery(name = "Estudiante.findByNumFolio", query = "SELECT e FROM Estudiante e WHERE e.numFolio = :numFolio"),
    @NamedQuery(name = "Estudiante.findByNumMatricula", query = "SELECT e FROM Estudiante e WHERE e.numMatricula = :numMatricula"),
    @NamedQuery(name = "Estudiante.findByObservacion", query = "SELECT e FROM Estudiante e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "Estudiante.findByUsuarioIngreso", query = "SELECT e FROM Estudiante e WHERE e.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Estudiante.findByFechaIngreso", query = "SELECT e FROM Estudiante e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Estudiante.findByUsuarioModificacion", query = "SELECT e FROM Estudiante e WHERE e.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Estudiante.findByFechaModificacion", query = "SELECT e FROM Estudiante e WHERE e.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Estudiante.findByEstado", query = "SELECT e FROM Estudiante e WHERE e.estado = :estado")})
public class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_estudiante")
    private String codEstudiante;
    @Size(max = 100)
    @Column(name = "colegio_procedencia")
    private String colegioProcedencia;
    @Size(max = 1)
    @Column(name = "matricula_condicionada")
    private String matriculaCondicionada;
    @Size(max = 1)
    @Column(name = "matricula_legalizada")
    private String matriculaLegalizada;
    @Column(name = "fecha_matricula")
    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;
    @Size(max = 4)
    @Column(name = "num_folio")
    private String numFolio;
    @Size(max = 4)
    @Column(name = "num_matricula")
    private String numMatricula;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<TareaInsumoParaleo> tareaInsumoParaleoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona codPersona;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Periodo codPeriodo;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa codEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<PerioricidadNota> perioricidadNotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<RepresentanteEstudianteEmpresa> representanteEstudianteEmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.EAGER)
    private List<NotasGrabadas> notasGrabadasList;

    public Estudiante() {
    }

    public Estudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getColegioProcedencia() {
        return colegioProcedencia;
    }

    public void setColegioProcedencia(String colegioProcedencia) {
        this.colegioProcedencia = colegioProcedencia;
    }

    public String getMatriculaCondicionada() {
        return matriculaCondicionada;
    }

    public void setMatriculaCondicionada(String matriculaCondicionada) {
        this.matriculaCondicionada = matriculaCondicionada;
    }

    public String getMatriculaLegalizada() {
        return matriculaLegalizada;
    }

    public void setMatriculaLegalizada(String matriculaLegalizada) {
        this.matriculaLegalizada = matriculaLegalizada;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getNumFolio() {
        return numFolio;
    }

    public void setNumFolio(String numFolio) {
        this.numFolio = numFolio;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Persona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Persona codPersona) {
        this.codPersona = codPersona;
    }

    public Periodo getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Periodo codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
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
    public List<NotasGrabadas> getNotasGrabadasList() {
        return notasGrabadasList;
    }

    public void setNotasGrabadasList(List<NotasGrabadas> notasGrabadasList) {
        this.notasGrabadasList = notasGrabadasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstudiante != null ? codEstudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.codEstudiante == null && other.codEstudiante != null) || (this.codEstudiante != null && !this.codEstudiante.equals(other.codEstudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Estudiante[ codEstudiante=" + codEstudiante + " ]";
    }
    
}
