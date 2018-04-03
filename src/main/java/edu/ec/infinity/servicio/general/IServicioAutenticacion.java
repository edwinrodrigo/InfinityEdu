package edu.ec.infinity.servicio.general;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.Usuario;

@Remote
public interface IServicioAutenticacion extends Serializable {

	public List<Opcion> obtenerOpcionesPorUsuario(Usuario usuario);

	public Usuario autenticar(String usuario, String password);

}
