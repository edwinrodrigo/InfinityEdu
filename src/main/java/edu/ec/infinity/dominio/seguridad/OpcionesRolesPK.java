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
public class OpcionesRolesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_opcion")
    private Long codOpcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_rol")
    private Long codRol;

    public OpcionesRolesPK() {
    }

    public OpcionesRolesPK(Long codOpcion, Long codRol) {
        this.codOpcion = codOpcion;
        this.codRol = codRol;
    }

    public Long getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(Long codOpcion) {
        this.codOpcion = codOpcion;
    }

    public Long getCodRol() {
        return codRol;
    }

    public void setCodRol(Long codRol) {
        this.codRol = codRol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codOpcion);
        hash = 37 * hash + Objects.hashCode(this.codRol);
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
        final OpcionesRolesPK other = (OpcionesRolesPK) obj;
        if (!Objects.equals(this.codOpcion, other.codOpcion)) {
            return false;
        }
        if (!Objects.equals(this.codRol, other.codRol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OpcionesRolesPK{" + "codOpcion=" + codOpcion + ", codRol=" + codRol + '}';
    }
    
}