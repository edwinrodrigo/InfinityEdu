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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByCodMat", query = "SELECT m FROM Materia m WHERE m.codMat = :codMat"),
    @NamedQuery(name = "Materia.findByDesMat", query = "SELECT m FROM Materia m WHERE m.desMat = :desMat"),
    @NamedQuery(name = "Materia.findByAbrMat", query = "SELECT m FROM Materia m WHERE m.abrMat = :abrMat"),
    @NamedQuery(name = "Materia.findByUsuarioIngreso", query = "SELECT m FROM Materia m WHERE m.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Materia.findByFechaIngreso", query = "SELECT m FROM Materia m WHERE m.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Materia.findByUsuarioModificacion", query = "SELECT m FROM Materia m WHERE m.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Materia.findByFechaModificacion", query = "SELECT m FROM Materia m WHERE m.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Materia.findByEstado", query = "SELECT m FROM Materia m WHERE m.estado = :estado")})
public class Materia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_mat")
    private String codMat;
    @Size(max = 80)
    @Column(name = "des_mat")
    private String desMat;
    @Size(max = 60)
    @Column(name = "abr_mat")
    private String abrMat;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<TareaInsumoParaleo> tareaInsumoParaleoList;
    @JoinColumn(name = "cod_niv", referencedColumnName = "cod_nivel")
    @ManyToOne(fetch = FetchType.EAGER)
    private Nivel codNiv;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa codEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<AsistenciaMateriaEstudiante> asistenciaMateriaEstudianteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<EstudianteMateriaParalelo> estudianteMateriaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<MateriaParalelo> materiaParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<RegActas> regActasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<InsumoParalelo> insumoParaleloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<PerioricidadNota> perioricidadNotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia", fetch = FetchType.EAGER)
    private List<NotasGrabadas> notasGrabadasList;

    public Materia() {
    }

    public Materia(String codMat) {
        this.codMat = codMat;
    }

    public String getCodMat() {
        return codMat;
    }

    public void setCodMat(String codMat) {
        this.codMat = codMat;
    }

    public String getDesMat() {
        return desMat;
    }

    public void setDesMat(String desMat) {
        this.desMat = desMat;
    }

    public String getAbrMat() {
        return abrMat;
    }

    public void setAbrMat(String abrMat) {
        this.abrMat = abrMat;
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

    public Nivel getCodNiv() {
        return codNiv;
    }

    public void setCodNiv(Nivel codNiv) {
        this.codNiv = codNiv;
    }

    public Empresa getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Empresa codEmpresa) {
        this.codEmpresa = codEmpresa;
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
        hash += (codMat != null ? codMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codMat == null && other.codMat != null) || (this.codMat != null && !this.codMat.equals(other.codMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Materia[ codMat=" + codMat + " ]";
    }
    
}
