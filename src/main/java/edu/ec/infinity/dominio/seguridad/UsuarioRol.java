package edu.ec.infinity.dominio.seguridad;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;

import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.USUARIO_ROL, schema = IEsquemas.SEGURIDAD)
public class UsuarioRol extends SeguridadGeneric<UsuarioRol> {

	private static final long serialVersionUID = 7069267552743724507L;

	@EmbeddedId
	protected UsuarioRolPK usuarioRolPK;

	@Size(max = 1)
	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;

	@JoinColumn(name = ICamposTablas.USUARIO_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Usuario usuario;

	@JoinColumn(name = ICamposTablas.ROL_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Rol rol;

	public UsuarioRolPK getUsuarioRolPK() {
		return usuarioRolPK;
	}

	public void setUsuarioRolPK(UsuarioRolPK usuarioRolPK) {
		this.usuarioRolPK = usuarioRolPK;
	}

	public EstadoAI getEstado() {
		return estado;
	}

	public void setEstado(EstadoAI estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
	}

}
