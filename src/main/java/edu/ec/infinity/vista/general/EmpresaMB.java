package edu.ec.infinity.vista.general;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import edu.ec.infinity.dominio.general.DivisionGeopolitica;
import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.vista.generic.GenericMB;

@ManagedBean
@ViewScoped
public class EmpresaMB extends GenericMB {

	private static final long serialVersionUID = -8358628863259546232L;

	private static final BigDecimal SIZE_LIMIT = new BigDecimal(1000000);
	private static final BigDecimal FILE_LIMIT = new BigDecimal(3);
	private static final String ALLOW_TYPES = "/(\\.|\\/)(jpe?g|png)$/";

	private List<Empresa> listaEmpresas;
	private List<DivisionGeopolitica> listaPaises;
	private List<DivisionGeopolitica> listaProvincias;
	private List<DivisionGeopolitica> listaCiudades;
	private Empresa empresaSeleccion;
	private MapModel mapModel;

	@PostConstruct
	public void init() {
		empresaSeleccion = new Empresa();
		mapModel = null;
		obtenerPaises();
		if(getUsuario().getEmpresa() != null) {
			empresaSeleccion = new Empresa(getEmpresa());
			empresaSeleccion.setProvincia(empresaSeleccion.getCiudad().getPadre());
			empresaSeleccion.setPais(empresaSeleccion.getProvincia().getPadre());
			listaProvincias = servicioGeneral.obtenerPorPadre(empresaSeleccion.getPais());
			listaCiudades = servicioGeneral.obtenerPorPadre(empresaSeleccion.getProvincia());
			cargarEmpresa();
		} else {
			listaEmpresas = servicioGeneral.obtenerEmpresas(getEmpresa());
		}
	}

	public void cargarEmpresa() {
		mapModel = new DefaultMapModel();
		LatLng ubicacion = new LatLng(Double.parseDouble(empresaSeleccion.getLatitud()),
				Double.parseDouble(empresaSeleccion.getLongitud()));
		Marker marker = new Marker(ubicacion);
		marker.setDraggable(true);
		mapModel.addOverlay(marker);
	}

	public void obtenerPaises() {
		listaPaises = servicioGeneral.obtenerPaises();
	}

	public void obtenerProvincias() {
		empresaSeleccion.setProvincia(null);
		listaProvincias = servicioGeneral.obtenerPorPadre(empresaSeleccion.getPais());
	}
	
	public void obtenerCiudades() {
		empresaSeleccion.setCiudad(null);
		listaCiudades = servicioGeneral.obtenerPorPadre(empresaSeleccion.getProvincia());
	}

	public void actionUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		empresaSeleccion.setLogo(file.getContents());
		empresaSeleccion.setLogoContentType(file.getContentType());
		empresaSeleccion.setLogoFileName(file.getFileName());
		empresaSeleccion.setUrlLogo("//logo."+file.getContentType().substring(file.getContentType().indexOf("/") + 1));
	}
	
	public void actualizarUbicacion(MarkerDragEvent event) {
		Marker marker = event.getMarker();
		LatLng ubicacion = marker.getLatlng();
		empresaSeleccion.setUbicacion(ubicacion.getLat() + "," + ubicacion.getLng());
	}

	public void actionSave() {
		try {
			servicioGeneral.guardarEmpresa(empresaSeleccion);
			if(getUsuario().getEmpresa() != null) {
				Empresa empresaActualizada = servicioGeneral.obtenerEmpresa(getUsuario().getEmpresa());
				getUsuario().setEmpresa(empresaActualizada);
			}
			init();
			addMessageInfo(TAG_EMPRESA_INFO_GUARDAR);
		} catch (Exception e) {
			addMessageError(TAG_EMPRESA_ERROR_GUARDAR);
		}
	}

	public List<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public List<DivisionGeopolitica> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<DivisionGeopolitica> listaPaises) {
		this.listaPaises = listaPaises;
	}

	public List<DivisionGeopolitica> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<DivisionGeopolitica> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<DivisionGeopolitica> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<DivisionGeopolitica> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public Empresa getEmpresaSeleccion() {
		return empresaSeleccion;
	}

	public void setEmpresaSeleccion(Empresa empresaSeleccion) {
		this.empresaSeleccion = empresaSeleccion;
	}

	public MapModel getMapModel() {
		return mapModel;
	}

	public void setMapModel(MapModel mapModel) {
		this.mapModel = mapModel;
	}

	public BigDecimal getSizeLimit() {
		return SIZE_LIMIT;
	}

	public BigDecimal getFileLimit() {
		return FILE_LIMIT;
	}

	public String getAllowTypes() {
		return ALLOW_TYPES;
	}

}
