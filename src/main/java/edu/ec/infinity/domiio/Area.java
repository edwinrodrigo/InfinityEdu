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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByCodArea", query = "SELECT a FROM Area a WHERE a.codArea = :codArea"),
    @NamedQuery(name = "Area.findByNombre", query = "SELECT a FROM Area a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Area.findByUsuarioIngreso", query = "SELECT a FROM Area a WHERE a.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Area.findByFechaIngreso", query = "SELECT a FROM Area a WHERE a.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Area.findByUsuarioModificacion", query = "SELECT a FROM Area a WHERE a.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Area.findByFechaModificacion", query = "SELECT a FROM Area a WHERE a.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Area.findByEstado", query = "SELECT a FROM Area a WHERE a.estado = :estado")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_area")
    private String codArea;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area", fetch = FetchType.EAGER)
    private List<AreaMateria> areaMateriaList;
    @JoinColumn(name = "periodo", referencedColumnName = "cod_periodo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Periodo periodo;
    @JoinColumn(name = "cod_nivel", referencedColumnName = "cod_nivel")
    @ManyToOne(fetch = FetchType.EAGER)
    private Nivel codNivel;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa codEmpresa;

    public Area() {
    }

    public Area(String codArea) {
        this.codArea = codArea;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public List<AreaMateria> getAreaMateriaList() {
        return areaMateriaList;
    }

    public void setAreaMateriaList(List<AreaMateria> areaMateriaList) {
        this.areaMateriaList = areaMateriaList;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
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
        hash += (codArea != null ? codArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codArea == null && other.codArea != null) || (this.codArea != null && !this.codArea.equals(other.codArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Area[ codArea=" + codArea + " ]";
    }
    
}
