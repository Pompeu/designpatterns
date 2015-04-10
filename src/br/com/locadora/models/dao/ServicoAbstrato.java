package br.com.locadora.models.dao;

public abstract class ServicoAbstrato<T> {

	
	public ServicoAbstrato() {

	}

	public abstract DAO<T> getDao();	

	public void academiaLoguer(Object obj , String url, String param) {
		 new GeradorLog(obj , url , param);
	}

}
