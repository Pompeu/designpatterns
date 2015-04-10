package br.com.locadora.controller.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import br.com.locadora.controller.Servico;
import br.com.locadora.models.Nivel;
import br.com.locadora.models.User;
import br.com.locadora.models.dao.DAO;
import br.com.locadora.models.dao.UserDaoImpl;
import br.com.locadora.models.factory.ConectionFactoryJDBC;
import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

public class CreateUser implements Servico {
	private FactoryUser factory;
	private DAO<User> userdao;

	public CreateUser() {
		factory = new FactoryUserImpl();
		userdao = new UserDaoImpl(new ConectionFactoryJDBC().getCon());
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		String name = req.getParameter("name");
		String cpf = req.getParameter("cpf");
		String password = BCrypt.hashpw(req.getParameter("password"),
				BCrypt.gensalt(12));
		String nivel = req.getParameter("user");

		try {
			User create = userdao.create(factory.createUser(name, password,
					cpf, Nivel.valueOf(nivel)));
			req.setAttribute("user", create);
		} catch (SQLException e) {
			return "/WEB-INF/jsp/users/form-user.jsp";
		}
		return "/";
	}
}
