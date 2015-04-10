package br.com.locadora.controller.api;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.models.AcademyAdministrator;
import br.com.locadora.models.Nivel;
import br.com.locadora.models.User;
import br.com.locadora.models.UserAcademy;
import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/api/users")
@RequestScoped
public class UserSerice extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private Gson json;
	private FactoryUser factory;
	private Set<User> users;

	private ServletOutputStream outputStream;

	public UserSerice() {
		factory = new FactoryUserImpl();
		users = new HashSet<>();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		resp.setContentType("application/json");
		outputStream = resp.getOutputStream();

		String nivel = req.getParameter("nivel");

		if (nivel != null) {
			outputStream.println(json.toJson(users.parallelStream()
					.filter((u -> u.getNivel().equals(Nivel.valueOf(nivel))))
					.collect(Collectors.toSet())));
		} else {
			outputStream.println(json.toJson(users));
			outputStream.flush();
			outputStream.close();

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<String> listkey = req.getParameterMap().keySet().stream()
				.collect(Collectors.toList());
		
		JsonParser parser = new JsonParser();
		
		
		User user =
				json.fromJson(parser.parse(listkey.get(0)).toString(),AcademyAdministrator.class);
		
		System.out.println(user);
		
		outputStream = resp.getOutputStream();
		outputStream.println(json.toJson(user));
		outputStream.flush();
		outputStream.close();
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
