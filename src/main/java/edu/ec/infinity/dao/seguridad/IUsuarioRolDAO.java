package edu.ec.infinity.dao.seguridad;

import javax.ejb.Remote;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.dominio.seguridad.UsuarioRol;
import edu.ec.infinity.dominio.seguridad.UsuarioRolPK;

@Remote
public interface IUsuarioRolDAO extends IGenericDAO<UsuarioRol, UsuarioRolPK>{

}