package edu.ec.infinity.vista.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ec.infinity.dominio.seguridad.Usuario;
import edu.ec.infinity.vista.configuracion.ConstantsAplication;


@WebFilter( dispatcherTypes = { DispatcherType.ERROR, DispatcherType.REQUEST },
			urlPatterns = {"/modulos/*", "/template/*"}, description = "Session Chek Filter")
public class FiltroAplicacion implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Usuario userLogged = null;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(req.getSession(false)!=null) {
			userLogged = (Usuario) req.getSession(false).getAttribute("usuario");
		}
		if(userLogged==null) {
			res.sendRedirect(req.getContextPath() + ConstantsAplication.PAGINA_REDIRECCION_FILTRO);
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	
	}
}
