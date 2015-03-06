package br.com.locadora.models;

public class AcademyTeacher extends User {
	public AcademyTeacher(String name, String password, String cpf) {
		super(name, password, cpf, Nivel.TEACHER);
	}

	@Override
	public User showInformatins() {
		return this;
	}
}
