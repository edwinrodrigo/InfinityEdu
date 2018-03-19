package edu.ec.infinity.eao.seguridad;

import javax.ejb.Remote;

import edu.ec.infinity.dominio.seguridad.RolesUsuarios;
import edu.ec.infinity.dominio.seguridad.RolesUsuariosPK;
import edu.ec.infinity.eao.generic.GenericDAO;

@Remote
public interface IRolesUsuariosEAO extends GenericDAO<RolesUsuarios, RolesUsuariosPK>{

}