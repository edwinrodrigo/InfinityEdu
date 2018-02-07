/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i"),
    @NamedQuery(name = "Insumo.findByCodInsumo", query = "SELECT i FROM Insumo i WHERE i.insumoPK.codInsumo = :codInsumo"),
    @NamedQuery(name = "Insumo.findByPeriodo", query = "SELECT i FROM Insumo i WHERE i.insumoPK.periodo = :periodo"),
    @NamedQuery(name = "Insumo.findByCodEmpresa", query = "SELECT i FROM Insumo i WHERE i.insumoPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "Insumo.findByNombreInsumo", query = "SELECT i FROM Insumo i WHERE i.nombreInsumo = :nombreInsumo"),
    @NamedQuery(name = "Insumo.findByDescripcion", query = "SELECT i FROM Insumo i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Insumo.findByPeso", query = "SELECT i FROM Insumo i WHERE i.peso = :peso"),
    @NamedQuery(name = "Insumo.findByUsuarioIngreso", query = "SELECT i FROM Insumo i WHERE i.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "Insumo.findByFechaIngreso", query = "SELECT i FROM Insumo i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Insumo.findByUsuarioModificacion", query = "SELECT i FROM Insumo i WHERE i.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "Insumo.findByFechaModificacion", query = "SELECT i FROM Insumo i WHERE i.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Insumo.findByEstado", query = "SELECT i FROM Insumo i WHERE i.estado = :estado")})
public class Insumo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InsumoPK insumoPK;
    @Size(max = 100)
    @Column(name = "nombre_insumo")
    private String nombreInsumo;
    @Size(max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private BigDecimal peso;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo", fetch = FetchType.EAGER)
    private List<TareaInsumoParaleo> tareaInsumoParaleoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insumo", fetch = FetchType.EAGER)
    private List<InsumoParalelo> insumoParaleloList;
    @JoinColumn(name = "periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Periodo periodo1;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public Insumo() {
    }

    public Insumo(InsumoPK insumoPK) {
        this.insumoPK = insumoPK;
    }

    public Insumo(int codInsumo, String periodo, String codEmpresa) {
        this.insumoPK = new InsumoPK(codInsumo, periodo, codEmpresa);
    }

    public InsumoPK getInsumoPK() {
        return insumoPK;
    }

    public void setInsumoPK(InsumoPK insumoPK) {
        this.insumoPK = insumoPK;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
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
    public List<InsumoParalelo> getInsumoParaleloList() {
        return insumoParaleloList;
    }

    public void setInsumoParaleloList(List<InsumoParalelo> insumoParaleloList) {
        this.insumoParaleloList = insumoParaleloList;
    }

    public Periodo getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(Periodo periodo1) {
        this.periodo1 = periodo1;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insumoPK != null ? insumoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.insumoPK == null && other.insumoPK != null) || (this.insumoPK != null && !this.insumoPK.equals(other.insumoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.Insumo[ insumoPK=" + insumoPK + " ]";
    }
    
}
