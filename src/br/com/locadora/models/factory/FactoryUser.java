package br.com.locadora.models.factory;

import br.com.locadora.models.Nivel;
import br.com.locadora.models.User;
	
public interface FactoryUser {
	User createUser(String name, String password, String cpf, Nivel nivel);
}
