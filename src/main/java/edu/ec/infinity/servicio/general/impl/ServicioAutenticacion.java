package edu.ec.infinity.servicio.general.impl;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.servicio.general.IServicioAutenticacion;
import edu.ec.infinity.servicio.generic.ServicioGeneric;

/**
 * 
 * @author Edwin Amaguaya
 * @date 18/03/2018
 * 
 */
@Stateless
public class ServicioAutenticacion extends ServicioGeneric implements IServicioAutenticacion {

	private static final long serialVersionUID = -3740843706060732623L;

	public List<Opcion> obtenerOpcionesPorUsuario(Usuario usuario) {
		return opcionDAO.findOpciones(usuario);
	}

	public Usuario autenticar(String usuario, String password) {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("usuario", usuario);
		parametros.put("clave", password);
		Usuario usuarioReturn = usuarioDAO.findUniqueByProperties(parametros);
		return usuarioReturn;
	}
}