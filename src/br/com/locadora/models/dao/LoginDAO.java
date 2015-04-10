package br.com.locadora.models.dao;

import br.com.locadora.models.User;

public interface LoginDAO {
	public User logar(String cpf);
}
