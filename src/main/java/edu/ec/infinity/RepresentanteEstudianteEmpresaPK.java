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
public class RepresentanteEstudianteEmpresaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_persona")
    private String codPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "cod_estudiante")
    private String codEstudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "cod_empresa")
    private String codEmpresa;

    public RepresentanteEstudianteEmpresaPK() {
    }

    public RepresentanteEstudianteEmpresaPK(String codPersona, String codEstudiante, String codEmpresa) {
        this.codPersona = codPersona;
        this.codEstudiante = codEstudiante;
        this.codEmpresa = codEmpresa;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(String codEstudiante) {
        this.codEstudiante = codEstudiante;
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
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        hash += (codEstudiante != null ? codEstudiante.hashCode() : 0);
        hash += (codEmpresa != null ? codEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteEstudianteEmpresaPK)) {
            return false;
        }
        RepresentanteEstudianteEmpresaPK other = (RepresentanteEstudianteEmpresaPK) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        if ((this.codEstudiante == null && other.codEstudiante != null) || (this.codEstudiante != null && !this.codEstudiante.equals(other.codEstudiante))) {
            return false;
        }
        if ((this.codEmpresa == null && other.codEmpresa != null) || (this.codEmpresa != null && !this.codEmpresa.equals(other.codEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.RepresentanteEstudianteEmpresaPK[ codPersona=" + codPersona + ", codEstudiante=" + codEstudiante + ", codEmpresa=" + codEmpresa + " ]";
    }
    
}
