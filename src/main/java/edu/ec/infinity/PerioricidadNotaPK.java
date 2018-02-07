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
public class PerioricidadNotaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_niv")
    private String codNiv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_est")
    private String codEst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_mat")
    private String codMat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quimestre")
    private int quimestre;

    public PerioricidadNotaPK() {
    }

    public PerioricidadNotaPK(String periodo, String codNiv, String codEst, String codMat, String codEmpresa, int quimestre) {
        this.periodo = periodo;
        this.codNiv = codNiv;
        this.codEst = codEst;
        this.codMat = codMat;
        this.codEmpresa = codEmpresa;
        this.quimestre = quimestre;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCodNiv() {
        return codNiv;
    }

    public void setCodNiv(String codNiv) {
        this.codNiv = codNiv;
    }

    public String getCodEst() {
        return codEst;
    }

    public void setCodEst(String codEst) {
        this.codEst = codEst;
    }

    public String getCodMat() {
        return codMat;
    }

    public void setCodMat(String codMat) {
        this.codMat = codMat;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public int getQuimestre() {
        return quimestre;
    }

    public void setQuimestre(int quimestre) {
        this.quimestre = quimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (codNiv != null ? codNiv.hashCode() : 0);
        hash += (codEst != null ? codEst.hashCode() : 0);
        hash += (codMat != null ? codMat.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (int) quimestre;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerioricidadNotaPK)) {
            return false;
        }
        PerioricidadNotaPK other = (PerioricidadNotaPK) object;
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if ((this.codNiv == null && other.codNiv != null) || (this.codNiv != null && !this.codNiv.equals(other.codNiv))) {
            return false;
        }
        if ((this.codEst == null && other.codEst != null) || (this.codEst != null && !this.codEst.equals(other.codEst))) {
            return false;
        }
        if ((this.codMat == null && other.codMat != null) || (this.codMat != null && !this.codMat.equals(other.codMat))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if (this.quimestre != other.quimestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.PerioricidadNotaPK[ periodo=" + periodo + ", codNiv=" + codNiv + ", codEst=" + codEst + ", codMat=" + codMat + ", codEmpresa=" + codEmpresa + ", quimestre=" + quimestre + " ]";
    }
    
}
