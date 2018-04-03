package edu.ec.infinity.vista.generic;

import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.servicio.general.IServicioAutenticacion;
import edu.ec.infinity.servicio.general.IServicioGeneral;
import edu.ec.infinity.servicio.general.IServicioSeguridad;
import edu.ec.infinity.util.constantes.IEtiquetas;
import edu.ec.infinity.util.constantes.IRutas;

public class GenericMB implements Serializable, IRutas, IEtiquetas {

	private static final long serialVersionUID = -1967668340398362349L;

	private static final String KEYUSUARIOSESSION = "usuario";

	@EJB
	protected IServicioAutenticacion servicioAutenticacion;
	@EJB
	protected IServicioSeguridad servicioSeguridad;
	@EJB
	protected IServicioGeneral servicioGeneral;

	public String getProperty(String key) {
		String msg = null;
		try {
			ResourceBundle resourceBundle = ResourceBundle.getBundle("edu.ec.infinity.util.tags.etiquetas", getContext().getViewRoot().getLocale());
			msg = resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			return key;
		}
		return msg;
	}

	protected static FacesContext getContext() {
		return FacesContext.getCurrentInstance();
	}

	public Object getParameterSession(String parameter) {
		return getContext().getExternalContext().getSessionMap().get(parameter);
	}

	public void setParameterSession(Object parameter, String name) {
		getContext().getExternalContext().getSessionMap().put(name, parameter);
	}

	public Usuario getUsuario() {
		return (Usuario) getParameterSession(KEYUSUARIOSESSION);
	}

	public Empresa getEmpresa() {
		return ((Usuario) getParameterSession(KEYUSUARIOSESSION)).getEmpresa();
	}

	public void addMessageInfo(String mensaje) {
		addMessage(getProperty(mensaje), FacesMessage.SEVERITY_INFO);
	}

	public void addMessageWarning(String mensaje) {
		addMessage(getProperty(mensaje), FacesMessage.SEVERITY_WARN);
	}

	public void addMessageError(String mensaje) {
		addMessage(getProperty(mensaje), FacesMessage.SEVERITY_ERROR);
	}

	public void addMessageFatal(String mensaje) {
		addMessage(getProperty(mensaje), FacesMessage.SEVERITY_FATAL);
	}

	private void addMessage(String mensaje, FacesMessage.Severity severity) {
		FacesMessage message = new FacesMessage();
		message.setSeverity(severity);
		message.setSummary(mensaje);
		getContext().addMessage(null, message);
	}

}
