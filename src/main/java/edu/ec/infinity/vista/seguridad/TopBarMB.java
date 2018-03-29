package edu.ec.infinity.vista.seguridad;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import edu.ec.infinity.vista.generic.GenericMB;

@ManagedBean
@RequestScoped
public class TopBarMB extends GenericMB implements Serializable{


	private static final long serialVersionUID = -8776299971827795651L;

	@PostConstruct
	public void init() {
		
	}
	
	
	
}