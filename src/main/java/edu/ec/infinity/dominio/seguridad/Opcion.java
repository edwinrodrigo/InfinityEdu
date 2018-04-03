/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.dominio.seguridad;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;

import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.OPCION, schema = IEsquemas.SEGURIDAD)
public class Opcion extends SeguridadGeneric<Opcion> {

	private static final long serialVersionUID = -4320734775653184545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 100)
	private String nombre;

	@Size(max = 200)
	private String descripcion;

	@Size(max = 20)
	private String icono;

	@Size(max = 200)
	private String url;

	private BigDecimal orden;

	@JoinColumn(name = ICamposTablas.PADRE_ID)
	@ManyToOne(fetch = FetchType.EAGER)
	private Opcion padre;

	@Size(max = 1)
	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;

	@OneToMany(mappedBy = ICamposTablas.PADRE, fetch = FetchType.LAZY)
	private List<Opcion> opcionList;
	
	@OneToMany(mappedBy = ICamposTablas.OPCION, fetch = FetchType.LAZY)
	private List<OpcionRol> opcionRolList;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public BigDecimal getOrden() {
		return orden;
	}

	public void setOrden(BigDecimal orden) {
		this.orden = orden;
	}

	public Opcion getPadre() {
		return padre;
	}

	public void setPadre(Opcion padre) {
		this.padre = padre;
	}

	public EstadoAI getEstado() {
		return estado;
	}

	public void setEstado(EstadoAI estado) {
		this.estado = estado;
	}

	public List<Opcion> getOpcionList() {
		return opcionList;
	}

	public void setOpcionList(List<Opcion> opcionList) {
		this.opcionList = opcionList;
	}

	public List<OpcionRol> getOpcionRolList() {
		return opcionRolList;
	}

	public void setOpcionRolList(List<OpcionRol> opcionRolList) {
		this.opcionRolList = opcionRolList;
	}

}
