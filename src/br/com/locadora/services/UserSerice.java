package br.com.locadora.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.models.User;

import com.google.gson.Gson;

@WebServlet("/api/users")
@RequestScoped
public class UserSerice extends HttpServlet {

	@Inject private Gson json;
	private PrintWriter saida;
	private static final long serialVersionUID = 1L;
	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		saida = resp.getWriter();
		resp.setContentType("application/json");
		String id = req.getParameter("id");
		String name = req.getParameter("name");

		if (id != null && id.matches("^\\d+$")) {
			saida.println(json.toJson("Error"));
			saida.flush();
		} else if (name != null && name.matches("^[a-zA-Z]{3,8}$")) {
			saida.println(json.toJson("Error"));
			saida.flush();
		} else if (id == null && name == null) {
			saida.println(json.toJson(new ArrayList<User>()));
			saida.flush();
		} else {
			resp.setStatus(404);
			saida.println(json.toJson("Error : " + resp.getStatus()));
			saida.flush();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getContentType());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getContentType());
	}

}
