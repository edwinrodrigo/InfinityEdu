package edu.ec.infinity.dao.seguridad;

import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dao.generic.IGenericDAO;
import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.Usuario;

@Remote
public interface IOpcionDAO extends IGenericDAO<Opcion, Long> {

	List<Opcion> findOpciones(Usuario usuario);

}