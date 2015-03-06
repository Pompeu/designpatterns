package br.com.locadora.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FactoryUser factory = new FactoryUserImpl();

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.sendRedirect("user.jsp");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String cpf = req.getParameter("cpf");
		String password = BCrypt.hashpw(req.getParameter("password"),
				BCrypt.gensalt(12));
		String userType = req.getParameter("user");

		switch (userType) {
		case "Admin":

			req.setAttribute("user", factory.createAdmin(name, password, cpf));
			break;
		case "Studient":

			req.setAttribute("user", factory.createAdmin(name, password, cpf));
			break;
		case "Theacher":

				req.setAttribute("user", factory.createAdmin(name, password, cpf));
			break;
		default:
			break;
		}
		getServletConfig().getServletContext()
				.getRequestDispatcher("/index.jsp").forward(req, res);

	}

}
