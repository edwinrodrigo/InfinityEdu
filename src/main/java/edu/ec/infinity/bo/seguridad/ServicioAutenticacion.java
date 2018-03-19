package edu.ec.infinity.bo.seguridad;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.ec.infinity.dominio.seguridad.Opcion;
import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.eao.seguridad.IOpcionesRolesEAO;
import edu.ec.infinity.eao.seguridad.IRolesUsuariosEAO;
import edu.ec.infinity.eao.seguridad.IUsuarioEAO;

/**
 * 
 * @author Edwin Amaguaya
 * @date 18/03/2018
 * 
 */

@Stateless
public class ServicioAutenticacion {

	@EJB
	private IOpcionesRolesEAO opcionesRolesEAO;
	
	@EJB
	private IRolesUsuariosEAO rolesUsuariosEAO;
	
	@EJB
	private IUsuarioEAO usuarioEAO;
	
	@PostConstruct
	public void init() {
		
	}
	
	public List<Opcion> obtenerOpcionesPorUsuario(Usuario usuario) {		
		return opcionesRolesEAO.findOpcionesBy(usuario);
	}
	
	public Usuario autenticar(String usuario, String password) {
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("usuario", usuario);
		parametros.put("clave", password);
		return usuarioEAO.findUniqueByProperties(parametros);
	}
}