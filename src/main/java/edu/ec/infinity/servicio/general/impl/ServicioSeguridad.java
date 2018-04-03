package edu.ec.infinity.servicio.general.impl;

import javax.ejb.Stateless;

import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.servicio.general.IServicioSeguridad;
import edu.ec.infinity.servicio.generic.ServicioGeneric;

@Stateless
public class ServicioSeguridad extends ServicioGeneric implements IServicioSeguridad {

	private static final long serialVersionUID = 2581786131158976483L;

	public void guardarUsuario(Usuario usuario) {
		usuarioDAO.create(usuario);
	}

	public Usuario actualizarUsuario(Usuario usuario) {
		return usuarioDAO.edit(usuario);
	}
	
}
