/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "tipo_identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT t FROM TipoIdentificacion t"),
    @NamedQuery(name = "TipoIdentificacion.findByCodigo", query = "SELECT t FROM TipoIdentificacion t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TipoIdentificacion.findByDescricpcion", query = "SELECT t FROM TipoIdentificacion t WHERE t.descricpcion = :descricpcion"),
    @NamedQuery(name = "TipoIdentificacion.findByUsuarioIngreso", query = "SELECT t FROM TipoIdentificacion t WHERE t.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "TipoIdentificacion.findByFechaIngreso", query = "SELECT t FROM TipoIdentificacion t WHERE t.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "TipoIdentificacion.findByUsuarioModificacion", query = "SELECT t FROM TipoIdentificacion t WHERE t.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "TipoIdentificacion.findByFechaModificacion", query = "SELECT t FROM TipoIdentificacion t WHERE t.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "TipoIdentificacion.findByEstado", query = "SELECT t FROM TipoIdentificacion t WHERE t.estado = :estado")})
public class TipoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Size(max = 10)
    @Column(name = "descricpcion")
    private String descricpcion;
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
    @OneToMany(mappedBy = "tipoIdenficacion", fetch = FetchType.EAGER)
    private List<Persona> personaList;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricpcion() {
        return descricpcion;
    }

    public void setDescricpcion(String descricpcion) {
        this.descricpcion = descricpcion;
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
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.TipoIdentificacion[ codigo=" + codigo + " ]";
    }
    
}
