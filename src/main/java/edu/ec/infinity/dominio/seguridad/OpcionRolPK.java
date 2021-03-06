package edu.ec.infinity.dominio.seguridad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import edu.ec.infinity.util.constantes.ICamposTablas;

@Embeddable
public class OpcionRolPK extends SeguridadGeneric<OpcionRolPK> {

	private static final long serialVersionUID = -7258294981607602531L;

	@Column(name = ICamposTablas.OPCION_ID)
	private Long opcionId;

	@Column(name = ICamposTablas.ROL_ID)
	private Long rolId;

	public Long getOpcionId() {
		return opcionId;
	}

	public void setOpcionId(Long opcionId) {
		this.opcionId = opcionId;
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.opcionId);
		hash = 37 * hash + Objects.hashCode(this.rolId);
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
		final OpcionRolPK other = (OpcionRolPK) obj;
		if (!Objects.equals(this.opcionId, other.opcionId)) {
			return false;
		}
		if (!Objects.equals(this.rolId, other.rolId)) {
			return false;
		}
		return true;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
	}

}