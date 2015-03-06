package br.com.locadora.models;

public class AcademyAdministrator extends User {


	public AcademyAdministrator(String name, String password, String cpf) {
		super(name, password, cpf, Nivel.ADMIN);
	}

	@Override
	public User showInformatins() {
		return this;		
	}

}
