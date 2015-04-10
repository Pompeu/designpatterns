package br.com.locadora.controller.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import br.com.locadora.controller.Servico;
import br.com.locadora.models.User;
import br.com.locadora.models.dao.LoginDAO;
import br.com.locadora.models.dao.LoginImpl;
import br.com.locadora.models.factory.ConectionFactoryJDBC;

public class LoginService implements Servico {

	private LoginDAO login;

	public LoginService() {
		login = new LoginImpl(new ConectionFactoryJDBC().getCon());
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		HttpSession session = req.getSession();

		String cpf = req.getParameter("cpf");
		String password = req.getParameter("password");

		User usuLogado = login.logar(cpf);

		if (BCrypt.checkpw(password, usuLogado.getPassword())) {
			session.setMaxInactiveInterval(30 * 60);
			session.setAttribute("usuLogado", usuLogado);
		} else {
			req.setAttribute("result", "login ou senha invalidos");
			return "/WEB-INF/jsp/users/logar-form.jsp";
		}

		return "/dashboard.jsp";
	}

}
