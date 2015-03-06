package br.com.locadora.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/login.do")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PrintWriter saida;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		saida = res.getWriter();
		String name = req.getParameter("name");
		String password =  BCrypt.hashpw(req.getParameter("password"), BCrypt.gensalt(12));
		if (BCrypt.checkpw("123", password))
			saida.println("Ola Sr "+name);
		else
			saida.println("Name or PassWord Invalidos");
		
	}
	
}
