package br.com.locadora.controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/api/*")
public class ApiFilter implements Filter {

	public ApiFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		((HttpServletResponse) res).setHeader("Access-Control-Allow-Origin",
				"*");
		((HttpServletResponse) res).setHeader("Access-Control-Allow-Headers",
				"Content-Type");
		((HttpServletResponse) res).setHeader("Access-Control-Allow-Methods",
				"POST , GET , PUT,  DELETE , OPTIONS");

		((HttpServletResponse) res).setContentType("application/json");
		Map<String, String[]> parameterMap = ((HttpServletRequest) req).getParameterMap();
		parameterMap.forEach((K, V) -> System.out.printf("%s %s\n",K , V[0]));
		chain.doFilter(req, res);
		String method = ((HttpServletRequest) req).getMethod();
		
		
		System.out.printf("%s\n",method);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
