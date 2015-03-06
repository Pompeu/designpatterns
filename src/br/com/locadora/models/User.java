package br.com.locadora.models;


	
public abstract class  User implements UserAcademy{
	
	private Integer id;
	private String name;
	private String password;
	private String cpf;
	private Nivel nivel;
	
	User(){
		
	}
	public User(String name,String password, String cpf, Nivel nivel) {
		this.setNome(name);
		this.setPassword(password);
		this.setCpf(cpf);
		this.setNivel(nivel);
	}
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return name;
	}
	
	public void setNome(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password
				+ ", cpf=" + cpf + ", nivel=" + nivel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
}
