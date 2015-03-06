package br.com.locadora.models;

public class AcademyStudent extends User {
	public AcademyStudent(String name, String password, String cpf) {
		super(name, password, cpf, Nivel.STUDIENT);
	}
	@Override
	public User showInformatins() {
		return this;		
	}
}
