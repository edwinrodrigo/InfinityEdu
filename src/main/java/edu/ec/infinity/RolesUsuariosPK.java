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

/**
 *
 * @author danielPC
 */
@Embeddable
public class RolesUsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_rol")
    private int codRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario")
    private int codUsuario;

    public RolesUsuariosPK() {
    }

    public RolesUsuariosPK(int codRol, int codUsuario) {
        this.codRol = codRol;
        this.codUsuario = codUsuario;
    }

    public int getCodRol() {
        return codRol;
    }

    public void setCodRol(int codRol) {
        this.codRol = codRol;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codRol;
        hash += (int) codUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesUsuariosPK)) {
            return false;
        }
        RolesUsuariosPK other = (RolesUsuariosPK) object;
        if (this.codRol != other.codRol) {
            return false;
        }
        if (this.codUsuario != other.codUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.RolesUsuariosPK[ codRol=" + codRol + ", codUsuario=" + codUsuario + " ]";
    }
    
}
