/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio.seguridad;

import java.io.Serializable;
import java.util.Objects;
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
    private Long codRol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_usuario")
    private Long codUsuario;

    public RolesUsuariosPK() {
    }

    public RolesUsuariosPK(Long codRol, Long codUsuario) {
        this.codRol = codRol;
        this.codUsuario = codUsuario;
    }

    public Long getCodRol() {
        return codRol;
    }

    public void setCodRol(Long codRol) {
        this.codRol = codRol;
    }

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codRol);
        hash = 37 * hash + Objects.hashCode(this.codUsuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RolesUsuariosPK other = (RolesUsuariosPK) obj;
        if (!Objects.equals(this.codRol, other.codRol)) {
            return false;
        }
        if (!Objects.equals(this.codUsuario, other.codUsuario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolesUsuariosPK{" + "codRol=" + codRol + ", codUsuario=" + codUsuario + '}';
    }

    
}
