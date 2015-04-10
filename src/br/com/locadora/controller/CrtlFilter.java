package br.com.locadora.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.models.User;
import br.com.locadora.models.dao.VerificarNivelDAO;

@WebFilter("/ctrl.do")
public class CrtlFilter implements Filter {

	private VerificarNivelDAO verificarNilvel;
	private HttpSession session;

	public CrtlFilter() {
		verificarNilvel = new VerificarNivelDAO();
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		String param = ((HttpServletRequest) req).getParameter("ctrl");

		session = ((HttpServletRequest) req).getSession();

		User user = (User) session.getAttribute("usuLogado");

		if (session.getAttribute("usuLogado") != null && user != null
				|| param.equals("LoginForm") || param.equals("LoginService")) {
			verificarNilvel.academiaLoguer(user);
			chain.doFilter(req, res);
		} else {
			if (user != null)
				verificarNilvel.academiaLoguer(user);
			req.setAttribute("result", "Cadastro Somente Administrado");
			((HttpServletResponse) res).sendRedirect("ctrl.do?ctrl=LoginForm");
		}

	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
