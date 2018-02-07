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
public class EstudianteMateriaParaleloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_estudiante")
    private String codEstudiante;
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
    @Size(min = 1, max = 1)
    @Column(name = "cod_paralelo")
    private String codParalelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_mat")
    private String codMat;

    public EstudianteMateriaParaleloPK() {
    }

    public EstudianteMateriaParaleloPK(String codEstudiante, String periodo, String codNiv, String codCur, String codParalelo, String codEmpresa, String codMat) {
        this.codEstudiante = codEstudiante;
        this.periodo = periodo;
        this.codNiv = codNiv;
        this.codCur = codCur;
        this.codParalelo = codParalelo;
        this.codEmpresa = codEmpresa;
        this.codMat = codMat;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
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

    public String getCodParalelo() {
        return codParalelo;
    }

    public void setCodParalelo(String codParalelo) {
        this.codParalelo = codParalelo;
    }

    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getCodMat() {
        return codMat;
    }

    public void setCodMat(String codMat) {
        this.codMat = codMat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstudiante != null ? codEstudiante.hashCode() : 0);
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (codNiv != null ? codNiv.hashCode() : 0);
        hash += (codCur != null ? codCur.hashCode() : 0);
        hash += (codParalelo != null ? codParalelo.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        hash += (codMat != null ? codMat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteMateriaParaleloPK)) {
            return false;
        }
        EstudianteMateriaParaleloPK other = (EstudianteMateriaParaleloPK) object;
        if ((this.codEstudiante == null && other.codEstudiante != null) || (this.codEstudiante != null && !this.codEstudiante.equals(other.codEstudiante))) {
            return false;
        }
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if ((this.codNiv == null && other.codNiv != null) || (this.codNiv != null && !this.codNiv.equals(other.codNiv))) {
            return false;
        }
        if ((this.codCur == null && other.codCur != null) || (this.codCur != null && !this.codCur.equals(other.codCur))) {
            return false;
        }
        if ((this.codParalelo == null && other.codParalelo != null) || (this.codParalelo != null && !this.codParalelo.equals(other.codParalelo))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        if ((this.codMat == null && other.codMat != null) || (this.codMat != null && !this.codMat.equals(other.codMat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.EstudianteMateriaParaleloPK[ codEstudiante=" + codEstudiante + ", periodo=" + periodo + ", codNiv=" + codNiv + ", codCur=" + codCur + ", codParalelo=" + codParalelo + ", codEmpresa=" + codEmpresa + ", codMat=" + codMat + " ]";
    }
    
}
