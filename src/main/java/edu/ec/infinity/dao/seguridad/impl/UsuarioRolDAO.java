package edu.ec.infinity.dao.seguridad.impl;

import javax.ejb.Stateless;

import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dao.seguridad.IUsuarioRolDAO;
import edu.ec.infinity.dominio.seguridad.UsuarioRol;
import edu.ec.infinity.dominio.seguridad.UsuarioRolPK;

@Stateless
public class UsuarioRolDAO extends GenericDAO<UsuarioRol, UsuarioRolPK> implements IUsuarioRolDAO {

}
