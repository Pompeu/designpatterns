package br.com.locadora.models.factory;

import br.com.locadora.models.AcademyAdministrator;
import br.com.locadora.models.AcademyStudent;
import br.com.locadora.models.AcademyTeacher;

public interface FactoryUser {
	AcademyAdministrator createAdmin(String name, String password, String cpf);
	AcademyStudent createStudent(String name, String password, String cpf);
	AcademyTeacher createTeacher(String name, String password, String cpf);
}
