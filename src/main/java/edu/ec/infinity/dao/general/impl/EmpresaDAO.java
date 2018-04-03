package edu.ec.infinity.dao.general.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.criterion.DetachedCriteria;

import edu.ec.infinity.dao.general.IEmpresaDAO;
import edu.ec.infinity.dao.generic.impl.GenericDAO;
import edu.ec.infinity.dominio.general.Empresa;

@Stateless
public class EmpresaDAO extends GenericDAO<Empresa, Long> implements IEmpresaDAO {

	@Override
	public List<Empresa> obtenerEmpresas(Empresa empresa) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Empresa.class);
		if (empresa != null)
			addEqualsIfNotNull(criteria, ID, empresa.getId());
		return findByCriteria(criteria);
	}

	@Override
	public Empresa obtenerEmpresa(Empresa empresa) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Empresa.class);
		addEquals(criteria, ID, empresa.getId());
		return findFirstByCriteria(criteria);
	}

}
