package br.com.locadora.models.dao;

public class GeradorLog {

	private Object obj = new String("Visitante");
	private String url;
	private String param;

	public GeradorLog(Object obj, String url, String param) {
		if (obj != null)
			this.obj = obj;
		this.url = url;
		this.param = param;
		gravarLog();
	}

	private void gravarLog() {

		System.out.println(obj + " acessou " + url +"/"+ param);
	}
}
