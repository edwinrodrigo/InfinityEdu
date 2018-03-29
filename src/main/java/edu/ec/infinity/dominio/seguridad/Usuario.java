
package edu.ec.infinity.dominio.seguridad;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;

import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.dominio.general.Persona;
import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.USUARIO, schema = IEsquemas.SEGURIDAD)
public class Usuario extends SeguridadGeneric<Usuario> {

	private static final long serialVersionUID = -7726450263816992046L;

	@Id
	private Long id;

	@Size(max = 100)
	private String usuario;

	@Size(max = 200)
	private String clave;
	
	@Size(max = 300)
	private String urlAvatar;

	@JoinColumn(name = ICamposTablas.EMPRESA_ID)
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;

	@Size(max = 1)
	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="persona_id")
	private Persona persona;

	@OneToMany(mappedBy = ICamposTablas.USUARIO, fetch = FetchType.LAZY)
	private List<UsuarioRol> usuarioRolList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public EstadoAI getEstado() {
		return estado;
	}

	public void setEstado(EstadoAI estado) {
		this.estado = estado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<UsuarioRol> getUsuarioRolList() {
		return usuarioRolList;
	}

	public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
		this.usuarioRolList = usuarioRolList;
	}

	public String getUrlAvatar() {
		return urlAvatar;
	}

	public void setUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
	}
}
