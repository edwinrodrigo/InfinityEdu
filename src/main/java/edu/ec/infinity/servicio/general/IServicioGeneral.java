package edu.ec.infinity.servicio.general;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dominio.general.DivisionGeopolitica;
import edu.ec.infinity.dominio.general.Empresa;

@Remote
public interface IServicioGeneral extends Serializable {

	public List<DivisionGeopolitica> obtenerPaises();

	public List<DivisionGeopolitica> obtenerPorPadre(DivisionGeopolitica padre);

	public List<Empresa> obtenerEmpresas(Empresa empresa);

	public Empresa obtenerEmpresa(Empresa empresa);
	
	public void guardarEmpresa(Empresa empresa) throws Exception;

}
