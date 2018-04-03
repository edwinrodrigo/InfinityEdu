package edu.ec.infinity.dominio.general;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.util.constantes.ICamposTablas;
import edu.ec.infinity.util.constantes.IEsquemas;
import edu.ec.infinity.util.constantes.ITablas;

@Entity
@Table(name = ITablas.PERSONA, schema = IEsquemas.GENERAL)
public class Persona extends GeneralGeneric<Persona> {

	private static final long serialVersionUID = -4638153087320043590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 15)
	private String identificacion;

	@Size(max = 50)
	private String primerNombre;

	@Size(max = 50)
	private String segundoNombre;

	@Size(max = 50)
	private String primerApellido;

	@Size(max = 50)
	private String segundoApellido;

	@Type(type = Sexo.TYPE)
	private Sexo sexo;

	@Size(max = 300)
	private String domicilio;

	@Size(max = 50)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Size(max = 50)
	private String profesion;

	@Size(max = 50)
	private String ocupacion;

	@Type(type = EstadoCivil.TYPE)
	private EstadoCivil estadoCivil;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = EMPRESA_ID)
	private Empresa empresa;
	
	@Size(max = 300)
	private String urlAvatar;

	@OneToOne(mappedBy = ICamposTablas.PERSONA)
	private Usuario usuario;

	@Transient
	private String nombrePila;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getUrlAvatar() {
		return urlAvatar;
	}

	public void setUrlAvatar(String urlAvatar) {
		this.urlAvatar = urlAvatar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombrePila() {
		return this.primerNombre + " " + this.primerApellido;
	}

	public void setNombrePila(String nombrePila) {
		this.nombrePila = nombrePila;
	}

}