package br.com.locadora.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Servico {
	
	String executa(HttpServletRequest req, HttpServletResponse res)
			throws IOException;
}