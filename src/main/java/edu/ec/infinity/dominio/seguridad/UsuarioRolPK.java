package edu.ec.infinity.dominio.seguridad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import edu.ec.infinity.util.constantes.ICamposTablas;

@Embeddable
public class UsuarioRolPK extends SeguridadGeneric<UsuarioRolPK> {

	private static final long serialVersionUID = 6816552420617871628L;

	@Column(name = ICamposTablas.USUARIO_ID)
	private Long usuarioId;

	@Column(name = ICamposTablas.ROL_ID)
	private Long rolId;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.rolId);
		hash = 37 * hash + Objects.hashCode(this.usuarioId);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UsuarioRolPK other = (UsuarioRolPK) obj;
		if (!Objects.equals(this.rolId, other.rolId)) {
			return false;
		}
		if (!Objects.equals(this.usuarioId, other.usuarioId)) {
			return false;
		}
		return true;
	}

}
