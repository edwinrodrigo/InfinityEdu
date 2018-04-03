package edu.ec.infinity.servicio.general;

import java.io.Serializable;

import javax.ejb.Remote;

import edu.ec.infinity.dominio.seguridad.Usuario;

@Remote
public interface IServicioSeguridad extends Serializable {

	public void guardarUsuario(Usuario usuario);

	public Usuario actualizarUsuario(Usuario usuario);

}
