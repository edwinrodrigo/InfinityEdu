package edu.ec.infinity.dominio.general;

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

import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.EMPRESA, schema = IEsquemas.GENERAL)
public class Empresa extends GeneralGeneric<Empresa> {

	private static final long serialVersionUID = -8852352468261507963L;

	@Id
	private Long id;

	@Size(max = 20)
	private String codigo;

	@Size(max = 200)
	private String nombre;

	@Column(name = ICamposTablas.CIUDAD_ID)
	private Long ciudadId;

	@JoinColumn(name = ICamposTablas.PADRE_ID)
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa padre;

	@Size(max = 100)
	private String rector;

	@Size(max = 100)
	private String profesionRector;

	@Size(max = 100)
	private String vicerrector;

	@Size(max = 100)
	private String profesionVicerrector;

	@Size(max = 100)
	private String secretario;

	@Size(max = 100)
	private String profesionSecretario;

	@Size(max = 100)
	private String representanteLegal;

	@Size(max = 100)
	private String profesionRepresentanteLegal;

	@Size(max = 100)
	private String ubicacion;

	@Size(max = 1)
	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;

	@JoinColumn(name = ICamposTablas.CIUDAD_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private DivisionGeopolitica ciudad;

	@OneToMany(mappedBy = ICamposTablas.PADRE, fetch = FetchType.LAZY)
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(Long ciudadId) {
		this.ciudadId = ciudadId;
	}

	public Empresa getPadre() {
		return padre;
	}

	public void setPadre(Empresa padre) {
		this.padre = padre;
	}

	public String getRector() {
		return rector;
	}

	public void setRector(String rector) {
		this.rector = rector;
	}

	public String getProfesionRector() {
		return profesionRector;
	}

	public void setProfesionRector(String profesionRector) {
		this.profesionRector = profesionRector;
	}

	public String getVicerrector() {
		return vicerrector;
	}

	public void setVicerrector(String vicerrector) {
		this.vicerrector = vicerrector;
	}

	public String getProfesionVicerrector() {
		return profesionVicerrector;
	}

	public void setProfesionVicerrector(String profesionVicerrector) {
		this.profesionVicerrector = profesionVicerrector;
	}

	public String getSecretario() {
		return secretario;
	}

	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	public String getProfesionSecretario() {
		return profesionSecretario;
	}

	public void setProfesionSecretario(String profesionSecretario) {
		this.profesionSecretario = profesionSecretario;
	}

	public String getRepresentanteLegal() {
		return representanteLegal;
	}

	public void setRepresentanteLegal(String representanteLegal) {
		this.representanteLegal = representanteLegal;
	}

	public String getProfesionRepresentanteLegal() {
		return profesionRepresentanteLegal;
	}

	public void setProfesionRepresentanteLegal(String profesionRepresentanteLegal) {
		this.profesionRepresentanteLegal = profesionRepresentanteLegal;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public EstadoAI getEstado() {
		return estado;
	}

	public void setEstado(EstadoAI estado) {
		this.estado = estado;
	}

	public DivisionGeopolitica getCiudad() {
		return ciudad;
	}

	public void setCiudad(DivisionGeopolitica ciudad) {
		this.ciudad = ciudad;
	}

	public List<Empresa> getEmpresaList() {
		return empresaList;
	}

	public void setEmpresaList(List<Empresa> empresaList) {
		this.empresaList = empresaList;
	}
	
	

}
