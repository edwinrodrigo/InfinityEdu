package edu.ec.infinity.servicio.generic;

import javax.ejb.EJB;

import edu.ec.infinity.dao.seguridad.IOpcionDAO;
import edu.ec.infinity.dao.seguridad.IOpcionRolDAO;
import edu.ec.infinity.dao.seguridad.IUsuarioDAO;
import edu.ec.infinity.dao.seguridad.IUsuarioRolDAO;

public class ServicioGeneric {

	@EJB
	protected IOpcionRolDAO opcionRolDAO;

	@EJB
	protected IOpcionDAO opcionDAO;

	@EJB
	protected IUsuarioRolDAO rolUsuarioDAO;

	@EJB
	protected IUsuarioDAO usuarioDAO;

}
