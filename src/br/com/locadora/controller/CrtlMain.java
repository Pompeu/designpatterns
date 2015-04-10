package br.com.locadora.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ctrl.do")
public class CrtlMain extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String service = req.getParameter("ctrl");
		String className = "br.com.locadora.controller.service." + service;

		try {
			Class<?> classe = Class.forName(className);
			Servico servico = (Servico) classe.newInstance();
			String pagina = servico.executa(req, res);
			res.setCharacterEncoding("UTF-8");
			if (pagina.isEmpty())
				return;
			else
				req.getRequestDispatcher(pagina).forward(req, res);

		} catch (Exception e) {
			throw new ServletException(
					"A lógica de negócios causou uma exceção", e);
		}
	}

}
