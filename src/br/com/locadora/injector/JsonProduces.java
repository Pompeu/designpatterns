package br.com.locadora.injector;
import javax.enterprise.inject.Produces;

import com.google.gson.Gson;


public class JsonProduces {
	@Produces 
	public Gson criarJson(){
		return new Gson();
	}
}
