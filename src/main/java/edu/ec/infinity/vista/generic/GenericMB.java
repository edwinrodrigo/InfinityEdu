package edu.ec.infinity.vista.generic;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.servicio.seguridad.ServicioAutenticacion;
import edu.ec.infinity.servicio.seguridad.UsuarioServicio;

public class GenericMB {
	
	private static final String KEYUSUARIOSESSION = "usuario";

	@EJB
	protected ServicioAutenticacion servicioAutenticacion;

	@EJB
	protected UsuarioServicio usuarioServicio;

	protected FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public Object getParameterSession(String parameter) {
		return getContext().getExternalContext().getSessionMap().get(parameter);
	}

	public void setParameterSession(Object parameter, String name) {
		getContext().getExternalContext().getSessionMap().put(name, parameter);
	}
	
	public Usuario getUsuario() {
		return  (Usuario) getContext().getExternalContext().getSessionMap().get(KEYUSUARIOSESSION); 
	}

	public Empresa getEmpresa() {
		return  ((Usuario) getContext().getExternalContext().getSessionMap().get(KEYUSUARIOSESSION)).getEmpresa(); 
	}
}
