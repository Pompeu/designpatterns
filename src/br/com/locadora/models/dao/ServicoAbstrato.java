package br.com.locadora.models.dao;


public abstract class ServicoAbstrato<T> {
	
	
	public abstract DAO<T> getDao();

	public void academiaLoguer(T obj) {
		new GeradorLog<T>(obj);
	}

}
