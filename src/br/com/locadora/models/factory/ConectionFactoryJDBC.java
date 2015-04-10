package br.com.locadora.models.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ConectionFactoryJDBC {

	private Connection con = null;
	private static final String DRIVER = "org.postgresql.Driver";

	@RequestScoped
	@Produces
	public Connection getCon() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/academia", "postgres",
					"123");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeCon(@Disposes Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
