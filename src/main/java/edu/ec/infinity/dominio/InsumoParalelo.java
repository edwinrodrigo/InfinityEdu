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
@Table(name = "insumo_paralelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsumoParalelo.findAll", query = "SELECT i FROM InsumoParalelo i"),
    @NamedQuery(name = "InsumoParalelo.findByCodMateria", query = "SELECT i FROM InsumoParalelo i WHERE i.insumoParaleloPK.codMateria = :codMateria"),
    @NamedQuery(name = "InsumoParalelo.findByCodCurso", query = "SELECT i FROM InsumoParalelo i WHERE i.insumoParaleloPK.codCurso = :codCurso"),
    @NamedQuery(name = "InsumoParalelo.findByCodNivel", query = "SELECT i FROM InsumoParalelo i WHERE i.insumoParaleloPK.codNivel = :codNivel"),
    @NamedQuery(name = "InsumoParalelo.findByCodInsumo", query = "SELECT i FROM InsumoParalelo i WHERE i.insumoParaleloPK.codInsumo = :codInsumo"),
    @NamedQuery(name = "InsumoParalelo.findByPeriodo", query = "SELECT i FROM InsumoParalelo i WHERE i.insumoParaleloPK.periodo = :periodo"),
    @NamedQuery(name = "InsumoParalelo.findByCodEmpresa", query = "SELECT i FROM InsumoParalelo i WHERE i.insumoParaleloPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "InsumoParalelo.findByNombreActividad", query = "SELECT i FROM InsumoParalelo i WHERE i.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "InsumoParalelo.findByDescripcion", query = "SELECT i FROM InsumoParalelo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "InsumoParalelo.findByFecha", query = "SELECT i FROM InsumoParalelo i WHERE i.fecha = :fecha")})
public class InsumoParalelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InsumoParaleloPK insumoParaleloPK;
    @Size(max = 100)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cod_nivel", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumns({
        @JoinColumn(name = "cod_insumo", referencedColumnName = "cod_insumo", insertable = false, updatable = false),
        @JoinColumn(name = "periodo", referencedColumnName = "periodo", insertable = false, updatable = false),
        @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Insumo insumo;
    @JoinColumn(name = "cod_curso", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;

    public InsumoParalelo() {
    }

    public InsumoParalelo(InsumoParaleloPK insumoParaleloPK) {
        this.insumoParaleloPK = insumoParaleloPK;
    }

    public InsumoParalelo(String codMateria, String codCurso, String codNivel, int codInsumo, String periodo, String codEmpresa) {
        this.insumoParaleloPK = new InsumoParaleloPK(codMateria, codCurso, codNivel, codInsumo, periodo, codEmpresa);
    }

    public InsumoParaleloPK getInsumoParaleloPK() {
        return insumoParaleloPK;
    }

    public void setInsumoParaleloPK(InsumoParaleloPK insumoParaleloPK) {
        this.insumoParaleloPK = insumoParaleloPK;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
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
        hash += (insumoParaleloPK != null ? insumoParaleloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoParalelo)) {
            return false;
        }
        InsumoParalelo other = (InsumoParalelo) object;
        if ((this.insumoParaleloPK == null && other.insumoParaleloPK != null) || (this.insumoParaleloPK != null && !this.insumoParaleloPK.equals(other.insumoParaleloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.InsumoParalelo[ insumoParaleloPK=" + insumoParaleloPK + " ]";
    }
    
}
