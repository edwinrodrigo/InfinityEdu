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
public class InsumoParaleloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_materia")
    private String codMateria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_curso")
    private String codCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "cod_nivel")
    private String codNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_insumo")
    private int codInsumo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;

    public InsumoParaleloPK() {
    }

    public InsumoParaleloPK(String codMateria, String codCurso, String codNivel, int codInsumo, String periodo, String codEmpresa) {
        this.codMateria = codMateria;
        this.codCurso = codCurso;
        this.codNivel = codNivel;
        this.codInsumo = codInsumo;
        this.periodo = periodo;
        this.codEmpresa = codEmpresa;
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(String codCurso) {
        this.codCurso = codCurso;
    }

    public String getCodNivel() {
        return codNivel;
    }

    public void setCodNivel(String codNivel) {
        this.codNivel = codNivel;
    }

    public int getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(int codInsumo) {
        this.codInsumo = codInsumo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        hash += (codNivel != null ? codNivel.hashCode() : 0);
        hash += (int) codInsumo;
        hash += (periodo != null ? periodo.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsumoParaleloPK)) {
            return false;
        }
        InsumoParaleloPK other = (InsumoParaleloPK) object;
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        if ((this.codNivel == null && other.codNivel != null) || (this.codNivel != null && !this.codNivel.equals(other.codNivel))) {
            return false;
        }
        if (this.codInsumo != other.codInsumo) {
            return false;
        }
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.InsumoParaleloPK[ codMateria=" + codMateria + ", codCurso=" + codCurso + ", codNivel=" + codNivel + ", codInsumo=" + codInsumo + ", periodo=" + periodo + ", codEmpresa=" + codEmpresa + " ]";
    }
    
}
