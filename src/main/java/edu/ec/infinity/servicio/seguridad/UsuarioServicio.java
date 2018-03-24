package edu.ec.infinity.servicio.seguridad;

import javax.ejb.Stateless;

import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.servicio.generic.ServicioGeneric;

/**
 *
 * @author Edwin
 */
@Stateless
public class UsuarioServicio extends ServicioGeneric {

	public void guardar(Usuario usuario) {
		usuarioDAO.create(usuario);
	}

	public Usuario merge(Usuario usuario) {
		return usuarioDAO.edit(usuario);
	}
}