package br.com.locadora.models.factory;

import br.com.locadora.models.AcademyAdministrator;
import br.com.locadora.models.AcademyStudent;
import br.com.locadora.models.AcademyTeacher;

public class FactoryUserImpl implements FactoryUser {

	@Override
	public AcademyAdministrator createAdmin(String name, String password,
			String cpf) {
		return new AcademyAdministrator(name, password, cpf);
	}

	@Override
	public AcademyStudent createStudent(String name, String password, String cpf) {

		return new AcademyStudent(name, password, cpf);
	}

	@Override
	public AcademyTeacher createTeacher(String name, String password, String cpf) {

		return new AcademyTeacher(name, password, cpf);
	}

}
