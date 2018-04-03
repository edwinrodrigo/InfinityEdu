package edu.ec.infinity.dao.seguridad.impl;

import javax.ejb.Stateless;

import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dao.seguridad.IOpcionRolDAO;
import edu.ec.infinity.dominio.seguridad.OpcionRol;
import edu.ec.infinity.dominio.seguridad.OpcionRolPK;

@Stateless
public class OpcionRolDAO extends GenericDAO<OpcionRol, OpcionRolPK> implements IOpcionRolDAO {

}