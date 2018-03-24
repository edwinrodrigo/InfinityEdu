package edu.ec.infinity.dominio.seguridad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;

import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.ROL, schema = IEsquemas.SEGURIDAD)
public class Rol extends SeguridadGeneric<Rol> {

	private static final long serialVersionUID = 6830349103511548397L;

	@Id
	private Long id;

	@Size(max = 100)
	private String nombre;

	@Size(max = 1)
	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;

	@Column(name = ICamposTablas.EMPRESA_ID)
	private Long empresaId;

	@JoinColumn(name = ICamposTablas.EMPRESA_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;

	@OneToMany(mappedBy = ICamposTablas.ROL, fetch = FetchType.LAZY)
	private List<OpcionRol> opcionRolList;

	@OneToMany(mappedBy = ICamposTablas.ROL, fetch = FetchType.LAZY)
	private List<UsuarioRol> usuarioRolList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoAI getEstado() {
		return estado;
	}

	public void setEstado(EstadoAI estado) {
		this.estado = estado;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<OpcionRol> getOpcionRolList() {
		return opcionRolList;
	}

	public void setOpcionRolList(List<OpcionRol> opcionRolList) {
		this.opcionRolList = opcionRolList;
	}

	public List<UsuarioRol> getUsuarioRolList() {
		return usuarioRolList;
	}

	public void setUsuarioRolList(List<UsuarioRol> usuarioRolList) {
		this.usuarioRolList = usuarioRolList;
	}

}
