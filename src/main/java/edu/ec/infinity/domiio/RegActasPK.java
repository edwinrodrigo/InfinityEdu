/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.domiio;

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
public class RegActasPK implements Serializable {
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
    @Size(min = 1, max = 4)
    @Column(name = "cod_cur")
    private String codCur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_mat")
    private String codMat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_pro")
    private String codPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quimestre")
    private int quimestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parcial")
    private int parcial;

    public RegActasPK() {
    }

    public RegActasPK(String periodo, String codNiv, String codCur, String codMat, String codPro, String codEmpresa, int quimestre, int parcial) {
        this.periodo = periodo;
        this.codNiv = codNiv;
        this.codCur = codCur;
        this.codMat = codMat;
        this.codPro = codPro;
        this.codEmpresa = codEmpresa;
        this.quimestre = quimestre;
        this.parcial = parcial;
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

    public String getCodCur() {
        return codCur;
    }

    public void setCodCur(String codCur) {
        this.codCur = codCur;
    }

    public String getCodMat() {
        return codMat;
    }

    public void setCodMat(String codMat) {
        this.codMat = codMat;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
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

    public int getParcial() {
        return parcial;
    }

    public void setParcial(int parcial) {
        this.parcial = parcial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (codNiv != null ? codNiv.hashCode() : 0);
        hash += (codCur != null ? codCur.hashCode() : 0);
        hash += (codMat != null ? codMat.hashCode() : 0);
        hash += (codPro != null ? codPro.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (int) quimestre;
        hash += (int) parcial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegActasPK)) {
            return false;
        }
        RegActasPK other = (RegActasPK) object;
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if ((this.codNiv == null && other.codNiv != null) || (this.codNiv != null && !this.codNiv.equals(other.codNiv))) {
            return false;
        }
        if ((this.codCur == null && other.codCur != null) || (this.codCur != null && !this.codCur.equals(other.codCur))) {
            return false;
        }
        if ((this.codMat == null && other.codMat != null) || (this.codMat != null && !this.codMat.equals(other.codMat))) {
            return false;
        }
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if (this.quimestre != other.quimestre) {
            return false;
        }
        if (this.parcial != other.parcial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.RegActasPK[ periodo=" + periodo + ", codNiv=" + codNiv + ", codCur=" + codCur + ", codMat=" + codMat + ", codPro=" + codPro + ", codEmpresa=" + codEmpresa + ", quimestre=" + quimestre + ", parcial=" + parcial + " ]";
    }
    
}
