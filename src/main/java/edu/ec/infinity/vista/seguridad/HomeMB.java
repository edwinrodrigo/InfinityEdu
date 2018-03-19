package edu.ec.infinity.vista.seguridad;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class HomeMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	
	@PostConstruct
	public void init(){
		this.mensaje = "Mensaje Inicial...";
	}

	public void mensajeGrowl() {
		FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = null;
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", "User...");
        context.addMessage(null, message);
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}