package edu.ec.infinity.dominio.general;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.DIVISION_GEOPOLITICA, schema = IEsquemas.GENERAL)
public class DivisionGeopolitica extends GeneralGeneric<DivisionGeopolitica> {

	private static final long serialVersionUID = -5901923687029811563L;

	@Id
	private Long id;

	@Size(max = 50)
	private String codigo;

	@Size(max = 100)
	private String descripcion;

	private BigDecimal nivel;

	@JoinColumn(name = ICamposTablas.PADRE_ID)
	@ManyToOne(fetch = FetchType.EAGER)
	private DivisionGeopolitica padre;

	@OneToMany(mappedBy = ICamposTablas.PADRE, fetch = FetchType.LAZY)
	private List<DivisionGeopolitica> divisionGeopoliticaList;
	
	@OneToMany(mappedBy = ICamposTablas.CIUDAD, fetch = FetchType.LAZY)
	private List<Empresa> empresaList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getNivel() {
		return nivel;
	}

	public void setNivel(BigDecimal nivel) {
		this.nivel = nivel;
	}

	public DivisionGeopolitica getPadre() {
		return padre;
	}

	public void setPadre(DivisionGeopolitica padre) {
		this.padre = padre;
	}

	public List<DivisionGeopolitica> getDivisionGeopoliticaList() {
		return divisionGeopoliticaList;
	}

	public void setDivisionGeopoliticaList(List<DivisionGeopolitica> divisionGeopoliticaList) {
		this.divisionGeopoliticaList = divisionGeopoliticaList;
	}

	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(List<Empresa> empresaList) {
		this.empresaList = empresaList;
	}

}