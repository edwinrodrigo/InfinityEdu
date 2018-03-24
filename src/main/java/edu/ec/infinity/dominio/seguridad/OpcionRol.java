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
@Table(name = ITablas.OPCION_ROL, schema = IEsquemas.SEGURIDAD)
public class OpcionRol extends SeguridadGeneric<OpcionRol> {

	private static final long serialVersionUID = -2660492556872829290L;

	@EmbeddedId
	protected OpcionRolPK opcionesRolesPK;

	@Size(max = 1)
	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;

	@JoinColumn(name = ICamposTablas.ROL_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Rol rol;

	@JoinColumn(name = ICamposTablas.OPCION_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Opcion opcion;

	public OpcionRolPK getOpcionesRolesPK() {
		return opcionesRolesPK;
	}

	public void setOpcionesRolesPK(OpcionRolPK opcionesRolesPK) {
		this.opcionesRolesPK = opcionesRolesPK;
	}

	public EstadoAI getEstado() {
		return estado;
	}

	public void setEstado(EstadoAI estado) {
		this.estado = estado;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
	}

}
