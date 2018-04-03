package edu.ec.infinity.servicio.general.impl;

import java.util.List;

import javax.ejb.Stateless;

import edu.ec.infinity.dominio.general.DivisionGeopolitica;
import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.servicio.general.IServicioGeneral;
import edu.ec.infinity.servicio.generic.ServicioGeneric;

@Stateless
public class ServicioGeneral extends ServicioGeneric implements IServicioGeneral {

	private static final long serialVersionUID = 8843366802454143833L;

	@Override
	public List<DivisionGeopolitica> obtenerPaises() {
		return divisionGeopoliticaDAO.obtenerPaises();
	}

	@Override
	public List<DivisionGeopolitica> obtenerPorPadre(DivisionGeopolitica padre) {
		return divisionGeopoliticaDAO.obtenerPorPadre(padre);
	}

	@Override
	public List<Empresa> obtenerEmpresas(Empresa empresa) {
		return empresaDAO.obtenerEmpresas(empresa);
	}

	@Override
	public Empresa obtenerEmpresa(Empresa empresa) {
		return empresaDAO.obtenerEmpresa(empresa);
	}

	@Override
	public void guardarEmpresa(Empresa empresa) throws Exception {
		try {
			if(empresa.getCiudad() != null)
				empresa.setCiudadId(empresa.getCiudad().getId());
			if(empresa.getLogo()!=null)
				guardarImagenEmpresa(empresa);
			if (empresa.getId() == null)
				empresaDAO.create(empresa);
			else
				empresaDAO.edit(empresa);
		} catch (Exception e) {
			throw e;
		}

	}

}
