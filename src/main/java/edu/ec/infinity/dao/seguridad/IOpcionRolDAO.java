package edu.ec.infinity.dao.seguridad;

import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.OpcionRol;
import edu.ec.infinity.dominio.seguridad.OpcionRolPK;
import edu.ec.infinity.dominio.seguridad.Usuario;

@Remote
public interface IOpcionRolDAO extends IGenericDAO<OpcionRol, OpcionRolPK>{
	
//	List<Opcion> findOpcionesBy(Usuario usuario);

}
