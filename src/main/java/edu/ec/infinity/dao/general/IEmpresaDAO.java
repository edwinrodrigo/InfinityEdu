package edu.ec.infinity.dao.general;

import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.dominio.general.Empresa;

@Remote
public interface IEmpresaDAO extends IGenericDAO<Empresa, Long> {

	public List<Empresa> obtenerEmpresas(Empresa empresa);
	
	public Empresa obtenerEmpresa(Empresa empresa);
	
}
