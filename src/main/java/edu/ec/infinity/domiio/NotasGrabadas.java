/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "notas_grabadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasGrabadas.findAll", query = "SELECT n FROM NotasGrabadas n"),
    @NamedQuery(name = "NotasGrabadas.findByPeriodo", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.periodo = :periodo"),
    @NamedQuery(name = "NotasGrabadas.findByCodNiv", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.codNiv = :codNiv"),
    @NamedQuery(name = "NotasGrabadas.findByCodEst", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.codEst = :codEst"),
    @NamedQuery(name = "NotasGrabadas.findByCodMat", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.codMat = :codMat"),
    @NamedQuery(name = "NotasGrabadas.findByQuimestre", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.quimestre = :quimestre"),
    @NamedQuery(name = "NotasGrabadas.findByParcial", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.parcial = :parcial"),
    @NamedQuery(name = "NotasGrabadas.findByCodEmpresa", query = "SELECT n FROM NotasGrabadas n WHERE n.notasGrabadasPK.codEmpresa = :codEmpresa"),
    @NamedQuery(name = "NotasGrabadas.findByPromedio", query = "SELECT n FROM NotasGrabadas n WHERE n.promedio = :promedio"),
    @NamedQuery(name = "NotasGrabadas.findByUsuarioIngreso", query = "SELECT n FROM NotasGrabadas n WHERE n.usuarioIngreso = :usuarioIngreso"),
    @NamedQuery(name = "NotasGrabadas.findByFechaIngreso", query = "SELECT n FROM NotasGrabadas n WHERE n.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "NotasGrabadas.findByUsuarioModificacion", query = "SELECT n FROM NotasGrabadas n WHERE n.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "NotasGrabadas.findByFechaModificacion", query = "SELECT n FROM NotasGrabadas n WHERE n.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "NotasGrabadas.findByEstado", query = "SELECT n FROM NotasGrabadas n WHERE n.estado = :estado")})
public class NotasGrabadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotasGrabadasPK notasGrabadasPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "promedio")
    private BigDecimal promedio;
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
    @JoinColumn(name = "periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Periodo periodo1;
    @JoinColumn(name = "cod_niv", referencedColumnName = "cod_nivel", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Nivel nivel;
    @JoinColumn(name = "cod_mat", referencedColumnName = "cod_mat", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Materia materia;
    @JoinColumn(name = "cod_est", referencedColumnName = "cod_estudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estudiante estudiante;
    @JoinColumn(name = "cod_empresa", referencedColumnName = "cod_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public NotasGrabadas() {
    }

    public NotasGrabadas(NotasGrabadasPK notasGrabadasPK) {
        this.notasGrabadasPK = notasGrabadasPK;
    }

    public NotasGrabadas(String periodo, String codNiv, String codEst, String codMat, int quimestre, int parcial, String codEmpresa) {
        this.notasGrabadasPK = new NotasGrabadasPK(periodo, codNiv, codEst, codMat, quimestre, parcial, codEmpresa);
    }

    public NotasGrabadasPK getNotasGrabadasPK() {
        return notasGrabadasPK;
    }

    public void setNotasGrabadasPK(NotasGrabadasPK notasGrabadasPK) {
        this.notasGrabadasPK = notasGrabadasPK;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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
        hash += (notasGrabadasPK != null ? notasGrabadasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasGrabadas)) {
            return false;
        }
        NotasGrabadas other = (NotasGrabadas) object;
        if ((this.notasGrabadasPK == null && other.notasGrabadasPK != null) || (this.notasGrabadasPK != null && !this.notasGrabadasPK.equals(other.notasGrabadasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.NotasGrabadas[ notasGrabadasPK=" + notasGrabadasPK + " ]";
    }
    
}
