/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "reg_actas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegActas.findAll", query = "SELECT r FROM RegActas r"),
    @NamedQuery(name = "RegActas.findByPeriodo", query = "SELECT r FROM RegActas r WHERE r.regActasPK.periodo = :periodo"),
    @NamedQuery(name = "RegActas.findByCodNiv", query = "SELECT r FROM RegActas r WHERE r.regActasPK.codNiv = :codNiv"),
    @NamedQuery(name = "RegActas.findByCodCur", query = "SELECT r FROM RegActas r WHERE r.regActasPK.codCur = :codCur"),
    @NamedQuery(name = "RegActas.findByCodMat", query = "SELECT r FROM RegActas r WHERE r.regActasPK.codMat = :codMat"),
    @NamedQuery(name = "RegActas.findByCodPro", query = "SELECT r FROM RegActas r WHERE r.regActasPK.codPro = :codPro"),
    @NamedQuery(name = "RegActas.findByCodEmpresa", query = "SELECT r FROM RegActas r WHERE r.regActasPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "RegActas.findByQuimestre", query = "SELECT r FROM RegActas r WHERE r.regActasPK.quimestre = :quimestre"),
    @NamedQuery(name = "RegActas.findByParcial", query = "SELECT r FROM RegActas r WHERE r.regActasPK.parcial = :parcial"),
    @NamedQuery(name = "RegActas.findByEstAsen", query = "SELECT r FROM RegActas r WHERE r.estAsen = :estAsen"),
    @NamedQuery(name = "RegActas.findByUsuarioIngreso", query = "SELECT r FROM RegActas r WHERE r.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "RegActas.findByFechaIngreso", query = "SELECT r FROM RegActas r WHERE r.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "RegActas.findByUsuarioModificacion", query = "SELECT r FROM RegActas r WHERE r.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "RegActas.findByFechaModificacion", query = "SELECT r FROM RegActas r WHERE r.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "RegActas.findByEstado", query = "SELECT r FROM RegActas r WHERE r.estado = :estado")})
public class RegActas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegActasPK regActasPK;
    @Column(name = "est_asen")
    private Integer estAsen;
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
    @JoinColumn(name = "cod_pro", referencedColumnName = "cod_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona persona;
    @JoinColumn(name = "periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Periodo periodo1;
    @JoinColumn(name = "cod_niv", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_mat", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;
    @JoinColumn(name = "cod_cur", referencedColumnName = "cod_cur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Curso curso;

    public RegActas() {
    }

    public RegActas(RegActasPK regActasPK) {
        this.regActasPK = regActasPK;
    }

    public RegActas(String periodo, String codNiv, String codCur, String codMat, String codPro, String codEmpresa, int quimestre, int parcial) {
        this.regActasPK = new RegActasPK(periodo, codNiv, codCur, codMat, codPro, codEmpresa, quimestre, parcial);
    }

    public RegActasPK getRegActasPK() {
        return regActasPK;
    }

    public void setRegActasPK(RegActasPK regActasPK) {
        this.regActasPK = regActasPK;
    }

    public Integer getEstAsen() {
        return estAsen;
    }

    public void setEstAsen(Integer estAsen) {
        this.estAsen = estAsen;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Periodo getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(Periodo periodo1) {
        this.periodo1 = periodo1;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        hash += (regActasPK != null ? regActasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegActas)) {
            return false;
        }
        RegActas other = (RegActas) object;
        if ((this.regActasPK == null && other.regActasPK != null) || (this.regActasPK != null && !this.regActasPK.equals(other.regActasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.RegActas[ regActasPK=" + regActasPK + " ]";
    }
    
}
