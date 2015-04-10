package br.com.locadora.models.factory;

import br.com.locadora.models.AcademyAdministrator;
import br.com.locadora.models.AcademyStudent;
import br.com.locadora.models.AcademyTeacher;
import br.com.locadora.models.Nivel;
import br.com.locadora.models.User;

public class FactoryUserImpl implements FactoryUser {
	
	
	@Override
	public User createUser(String name, String password, String cpf, Nivel nivel) {

		switch (nivel.name()) {
		case "ADMIN":
			return new AcademyAdministrator(name, password, cpf, nivel);

		case "STUDIENT":
			return new AcademyStudent(name, password, cpf, nivel);

		case "TEACHER":
			return new AcademyTeacher(name, password, cpf, nivel);

		default:
			return null;	
		}

	}

}
