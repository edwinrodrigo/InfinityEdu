/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio.seguridad;

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
public class OpcionesRolesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_opcion")
    private int codOpcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_rol")
    private int codRol;

    public OpcionesRolesPK() {
    }

    public OpcionesRolesPK(int codOpcion, int codRol) {
        this.codOpcion = codOpcion;
        this.codRol = codRol;
    }

    public int getCodOpcion() {
        return codOpcion;
    }

    public void setCodOpcion(int codOpcion) {
        this.codOpcion = codOpcion;
    }

    public int getCodRol() {
        return codRol;
    }

    public void setCodRol(int codRol) {
        this.codRol = codRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codOpcion;
        hash += (int) codRol;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionesRolesPK)) {
            return false;
        }
        OpcionesRolesPK other = (OpcionesRolesPK) object;
        if (this.codOpcion != other.codOpcion) {
            return false;
        }
        if (this.codRol != other.codRol) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.ec.infinity.OpcionesRolesPK[ codOpcion=" + codOpcion + ", codRol=" + codRol + " ]";
    }
    
}