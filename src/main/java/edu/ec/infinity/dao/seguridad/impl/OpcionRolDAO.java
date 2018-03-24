package edu.ec.infinity.dao.seguridad.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dao.seguridad.IOpcionRolDAO;
import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.OpcionRol;
import edu.ec.infinity.dominio.seguridad.OpcionRolPK;
import edu.ec.infinity.dominio.seguridad.Usuario;

@Stateless
public class OpcionRolDAO extends GenericDAO<OpcionRol, OpcionRolPK> implements IOpcionRolDAO{

//	@SuppressWarnings("unchecked")
//	public List<Opcion> findOpcionesBy(Usuario usuario){	
//		
//		Query query = em.createQuery("SELECT opr.opcion "
//									+ " FROM OpcionRol opr "
//									+ "	JOIN opr.rol r "
//									+ "	JOIN r.usuarioRolList url "
//								    + "WHERE 1=1 "
//								    + "  AND url.usuario = :user "
//								    + "ORDER BY opr.opcion.orden asc");
//		query.setParameter("user", usuario);
//		return query.getResultList();
//	}
	
}