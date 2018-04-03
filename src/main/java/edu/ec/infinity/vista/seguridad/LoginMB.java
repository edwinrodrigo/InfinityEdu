package edu.ec.infinity.vista.seguridad;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.servicio.general.IServicioAutenticacion;
import edu.ec.infinity.util.constantes.IRutas;

/**
 *
 * @author Edwin Amaguaya
 * @date 01/03/2018
 */

@ManagedBean
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 8681168264807484623L;

	@EJB
	protected IServicioAutenticacion servicioAutenticacion;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String doLogin() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		Usuario user = servicioAutenticacion.autenticar(username, password);
		if (user != null) {
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
		}
		context.getExternalContext().getSessionMap().put("usuario", user);
		context.addMessage(null, message);
		return loggedIn ? IRutas.PAGINA_HOME : null;
	}

	public String doLogout() {
		ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession) ectx.getSession(false);
		session.invalidate();
		return IRutas.PAGINA_LOGIN;
	}
}