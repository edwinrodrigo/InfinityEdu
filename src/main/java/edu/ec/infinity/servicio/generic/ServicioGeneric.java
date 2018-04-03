package edu.ec.infinity.servicio.generic;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.EJB;
import javax.imageio.ImageIO;

import edu.ec.infinity.dao.general.IDivisionGeopoliticaDAO;
import edu.ec.infinity.dao.general.IEmpresaDAO;
import edu.ec.infinity.dao.seguridad.IOpcionDAO;
import edu.ec.infinity.dao.seguridad.IOpcionRolDAO;
import edu.ec.infinity.dao.seguridad.IUsuarioDAO;
import edu.ec.infinity.dao.seguridad.IUsuarioRolDAO;
import edu.ec.infinity.dominio.general.Empresa;
import edu.ec.infinity.util.constantes.IRutas;

public class ServicioGeneric {

	@EJB
	protected IOpcionRolDAO opcionRolDAO;
	@EJB
	protected IOpcionDAO opcionDAO;
	@EJB
	protected IUsuarioRolDAO rolUsuarioDAO;
	@EJB
	protected IUsuarioDAO usuarioDAO;
	@EJB
	protected IDivisionGeopoliticaDAO divisionGeopoliticaDAO;
	@EJB
	protected IEmpresaDAO empresaDAO;

	public void guardarImagenEmpresa(Empresa empresa) throws IOException {
		String path = IRutas.PATH_EMPRESAS + "//" + empresa.getCodigo();
		File file = new File(path);
		if (!file.exists())
			file.mkdirs();
		InputStream in = new ByteArrayInputStream(empresa.getLogo());
		BufferedImage bImageFromConvert = ImageIO.read(in);
		boolean result = ImageIO.write(bImageFromConvert, "png", new File(path + empresa.getUrlLogo()));
		in.close();
	}

}
