package edu.ec.infinity.dominio.general;

import java.io.File;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Size(max = 300)
	private String urlLogo;

	@Check(constraints = ICamposTablas.ESTADOAI_CHECK)
	@Type(type = EstadoAI.TYPE)
	private EstadoAI estado;

	@JoinColumn(name = ICamposTablas.CIUDAD_ID, referencedColumnName = ICamposTablas.ID, insertable = false, updatable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private DivisionGeopolitica ciudad;

	@OneToMany(mappedBy = ICamposTablas.PADRE, fetch = FetchType.LAZY)
	private List<Empresa> empresaList;

	@Transient
	private byte[] logo;
	
	@Transient
	private String urlLogoCompleto;
	
	@Transient
	private String logoContentType;
	
	@Transient
	private String logoFileName;
	
	@Transient
	private String latitud;
	
	@Transient
	private String longitud;
	
	@Transient
	private DivisionGeopolitica pais;
	
	@Transient
	private DivisionGeopolitica provincia;

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

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
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

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	public String getUrlLogoCompleto() {
		String ruta = PATH_EMPRESAS + "//" + getCodigo() + getUrlLogo();
		File file = new File(ruta);
		if(file.exists())
			return ruta;
		else
			return PATH_INFINITY+"//logo-company.png";
	}

	public void setUrlLogoCompleto(String urlLogoCompleto) {
		this.urlLogoCompleto = urlLogoCompleto;
	}

	public String getLogoContentType() {
		return logoContentType;
	}

	public void setLogoContentType(String logoContentType) {
		this.logoContentType = logoContentType;
	}

	public String getLogoFileName() {
		return logoFileName;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	public String getLatitud() {
		if(getUbicacion()!=null)
			return getUbicacion().split(",")[0];
		return "-2.1681399";
	}

	public String getLongitud() {
		if(getUbicacion()!=null)
			return getUbicacion().split(",")[1];
		return "-79.9126491";
	}

	public DivisionGeopolitica getPais() {
		return pais;
	}

	public void setPais(DivisionGeopolitica pais) {
		this.pais = pais;
	}

	public DivisionGeopolitica getProvincia() {
		return provincia;
	}

	public void setProvincia(DivisionGeopolitica provincia) {
		this.provincia = provincia;
	}

	public Empresa() {
		super();
	}

	public Empresa(Empresa empresa) {
		this.id = empresa.getId();
		this.codigo = empresa.getCodigo();
		this.nombre = empresa.getNombre();
		this.ciudadId = empresa.getCiudadId();
		this.padre = empresa.getPadre();
		this.rector = empresa.getRector();
		this.profesionRector = empresa.getProfesionRector();
		this.vicerrector = empresa.getVicerrector();
		this.profesionVicerrector = empresa.getProfesionVicerrector();
		this.secretario = empresa.getSecretario();
		this.profesionSecretario = empresa.getProfesionSecretario();
		this.representanteLegal = empresa.getRepresentanteLegal();
		this.profesionRepresentanteLegal = empresa.getProfesionRepresentanteLegal();
		this.ubicacion = empresa.getUbicacion();
		this.urlLogo = empresa.getUrlLogo();
		this.estado = empresa.getEstado();
		this.ciudad = empresa.getCiudad();
		this.empresaList = empresa.getEmpresaList();
		this.logo = empresa.getLogo();
		this.urlLogoCompleto = empresa.getUrlLogoCompleto();
		this.logoContentType = empresa.getLogoContentType();
		this.logoFileName = empresa.getLogoFileName();
		this.latitud = empresa.getLatitud();
		this.longitud = empresa.getLongitud();
		this.pais = empresa.getPais();
		this.provincia = empresa.getProvincia();
	}

}
