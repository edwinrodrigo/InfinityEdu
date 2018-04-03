package edu.ec.infinity.dao.general.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.criterion.DetachedCriteria;

import edu.ec.infinity.dao.general.IDivisionGeopoliticaDAO;
import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dominio.general.DivisionGeopolitica;

@Stateless
public class DivisionGeopoliticaDAO extends GenericDAO<DivisionGeopolitica, Long> implements IDivisionGeopoliticaDAO {

	public List<DivisionGeopolitica> obtenerPaises() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DivisionGeopolitica.class);
		addEquals(criteria, NIVEL, DivisionGeopolitica.NIVEL_UNO);
		return findByCriteria(criteria);
	}

	public List<DivisionGeopolitica> obtenerPorPadre(DivisionGeopolitica padre) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DivisionGeopolitica.class);
		addEquals(criteria, PADRE, padre);
		return findByCriteria(criteria);
	}

}
