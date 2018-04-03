package edu.ec.infinity.vista.seguridad;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(eager = true)
@SessionScoped
public class LocaleMB implements Serializable {

	private static final long serialVersionUID = 8750982500380392749L;

	private Locale locale;

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public void setEspanol() {
		setLanguage("es");
	}

	public void setIngles() {
		setLanguage("en");
	}

}
