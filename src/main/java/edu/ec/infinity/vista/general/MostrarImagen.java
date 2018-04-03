package edu.ec.infinity.vista.general;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostrarImagen")
public class MostrarImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MostrarImagen() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rutaLogo = request.getParameter("rutaLogo");
		String type = rutaLogo.substring(rutaLogo.indexOf(".") + 1);
		response.setContentType("image/" + type);

		BufferedInputStream in = new BufferedInputStream(new FileInputStream(rutaLogo));
		byte[] bytes = new byte[in.available()];

		in.read(bytes);
		in.close();

		response.getOutputStream().write(bytes);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
