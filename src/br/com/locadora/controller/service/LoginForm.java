package br.com.locadora.controller.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.locadora.controller.Servico;

public class LoginForm implements Servico {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		
		return "/WEB-INF/jsp/users/logar-form.jsp";
	}

}
