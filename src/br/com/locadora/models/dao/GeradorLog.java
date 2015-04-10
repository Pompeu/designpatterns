package br.com.locadora.models.dao;

public class GeradorLog<T> {

	public GeradorLog(T obj) {
		gravarLog(obj);
	}

	private void gravarLog(T obj) {
		System.out.println(obj);
	}
}
