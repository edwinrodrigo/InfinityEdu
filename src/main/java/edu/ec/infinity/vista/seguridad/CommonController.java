package edu.ec.infinity.vista.seguridad;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.vista.generic.GenericMB;

/**
 * @author Edwin
 * @date 18/03/2018
 *
 */

public class CommonController extends GenericMB {

	public Usuario getUsuario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return (Usuario) session.getAttribute("usuario");
	}

}