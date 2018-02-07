/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author danielPC
 */
@Embeddable
public class TareaInsumoParaleoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_nivel")
    private String codNivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_curso")
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_materia")
    private String codMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_insumo")
    private int codInsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_est")
    private String codEst;

    public TareaInsumoParaleoPK() {
    }

    public TareaInsumoParaleoPK(String periodo, String codNivel, String codCurso, String codMateria, int codInsumo, String codEmpresa, String codEst) {
        this.periodo = periodo;
        this.codNivel = codNivel;
        this.codCurso = codCurso;
        this.codMateria = codMateria;
        this.codInsumo = codInsumo;
        this.codEmpresa = codEmpresa;
        this.codEst = codEst;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(String codNivel) {
        this.codNivel = codNivel;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public int getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(int codInsumo) {
        this.codInsumo = codInsumo;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getCodEst() {
        return codEst;
    }

    public void setCodEst(String codEst) {
        this.codEst = codEst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (codNivel != null ? codNivel.hashCode() : 0);
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        hash += (int) codInsumo;
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (codEst != null ? codEst.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaInsumoParaleoPK)) {
            return false;
        }
        TareaInsumoParaleoPK other = (TareaInsumoParaleoPK) object;
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if ((this.codNivel == null && other.codNivel != null) || (this.codNivel != null && !this.codNivel.equals(other.codNivel))) {
            return false;
        }
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        if (this.codInsumo != other.codInsumo) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if ((this.codEst == null && other.codEst != null) || (this.codEst != null && !this.codEst.equals(other.codEst))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.TareaInsumoParaleoPK[ periodo=" + periodo + ", codNivel=" + codNivel + ", codCurso=" + codCurso + ", codMateria=" + codMateria + ", codInsumo=" + codInsumo + ", codEmpresa=" + codEmpresa + ", codEst=" + codEst + " ]";
    }
    
}
