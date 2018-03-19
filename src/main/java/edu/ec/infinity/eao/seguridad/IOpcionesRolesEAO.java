package edu.ec.infinity.eao.seguridad;

import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.OpcionesRoles;
import edu.ec.infinity.dominio.seguridad.OpcionesRolesPK;
import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.eao.generic.GenericDAO;

@Remote
public interface IOpcionesRolesEAO extends GenericDAO<OpcionesRoles, OpcionesRolesPK>{
	
	List<Opcion> findOpcionesBy(Usuario usuario);

}
