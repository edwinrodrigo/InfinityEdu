package edu.ec.infinity.dao.seguridad.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.criterion.DetachedCriteria;

import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dao.seguridad.IOpcionDAO;
import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.Usuario;

@Stateless
public class OpcionDAO extends GenericDAO<Opcion, Long> implements IOpcionDAO {

	public List<Opcion> findOpciones(Usuario usuario) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Opcion.class);
		addInnerJoins(criteria, OPCIONROLLIST+"@opl", "opl.rol", ROL+"."+USUARIOROLLIST+"@url");
		addEquals(criteria, "url.usuario", usuario);
		addOrderAsc(criteria, ORDEN);
		return findByCriteria(criteria);
	}

}