package edu.ec.infinity.dao.general;

import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.dominio.general.DivisionGeopolitica;

@Remote
public interface IDivisionGeopoliticaDAO extends IGenericDAO<DivisionGeopolitica, Long> {

	public List<DivisionGeopolitica> obtenerPaises();

	public List<DivisionGeopolitica> obtenerPorPadre(DivisionGeopolitica padre);

}
