package edu.ec.infinity.vista.seguridad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import edu.ec.infinity.dominio.seguridad.Opcion;

@RequestScoped
@ManagedBean
public class MenuMB extends CommonController implements Serializable {

	private static final long serialVersionUID = 5538285286840627041L;

	private MenuModel model;

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		contruirMenu();
	}

	public void contruirMenu() {
		List<Opcion> padres = new ArrayList<Opcion>();
		List<Opcion> opcionesDisponibles = servicioAutenticacion.obtenerOpcionesPorUsuario(getUsuario());
		for (Opcion opcion : opcionesDisponibles) {
			if (opcion.getPadre() == null) {
				padres.add(opcion);
			}
		}

		for (Opcion padre : padres) {
			if(padre.getUrl() != null && !"".equals(padre.getUrl())) {
				DefaultMenuItem menuhija = new DefaultMenuItem(padre.getNombre());
				menuhija.setOutcome(padre.getUrl());
				menuhija.setIcon(padre.getIcono());
				model.addElement(menuhija);
			}else {
				DefaultSubMenu menuPadre = new DefaultSubMenu(padre.getNombre(), padre.getIcono());
				for (Opcion hija : opcionesDisponibles) {
					if (hija.getPadre() != null && hija.getPadre().getId().equals(padre.getId())) {
						DefaultMenuItem menuhija = new DefaultMenuItem(hija.getNombre());
						menuhija.setOutcome(hija.getUrl());
						menuhija.setIcon(hija.getIcono());
						menuPadre.addElement(menuhija);
					}
				}
				model.addElement(menuPadre);
			}
		}
	}

	public MenuModel getModel() {
		return model;
	}
}