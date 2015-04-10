package br.com.locadora.controller.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.locadora.controller.Servico;
import br.com.locadora.models.User;

public class LogoutService implements Servico {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("usuLogado");
		session.invalidate();
		req.setAttribute("result", "Ate a proxima " + user.getNome());
		return "/";
	}

}
