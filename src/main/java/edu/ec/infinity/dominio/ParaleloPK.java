/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio;

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
public class ParaleloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "cod_paralelo")
    private String codParalelo;
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
    @Column(name = "cod_curso")
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;

    public ParaleloPK() {
    }

    public ParaleloPK(String codParalelo, String periodo, String codNiv, String codCurso, String codEmpresa) {
        this.codParalelo = codParalelo;
        this.periodo = periodo;
        this.codNiv = codNiv;
        this.codCurso = codCurso;
        this.codEmpresa = codEmpresa;
    }

    public String getCodParalelo() {
        return codParalelo;
    }

    public void setCodParalelo(String codParalelo) {
        this.codParalelo = codParalelo;
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

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParalelo != null ? codParalelo.hashCode() : 0);
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (codNiv != null ? codNiv.hashCode() : 0);
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParaleloPK)) {
            return false;
        }
        ParaleloPK other = (ParaleloPK) object;
        if ((this.codParalelo == null && other.codParalelo != null) || (this.codParalelo != null && !this.codParalelo.equals(other.codParalelo))) {
            return false;
        }
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if ((this.codNiv == null && other.codNiv != null) || (this.codNiv != null && !this.codNiv.equals(other.codNiv))) {
            return false;
        }
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.ParaleloPK[ codParalelo=" + codParalelo + ", periodo=" + periodo + ", codNiv=" + codNiv + ", codCurso=" + codCurso + ", codEmpresa=" + codEmpresa + " ]";
    }
    
}
