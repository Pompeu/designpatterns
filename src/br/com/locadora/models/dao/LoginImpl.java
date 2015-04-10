package br.com.locadora.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;

import br.com.locadora.models.Nivel;
import br.com.locadora.models.User;
import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

public class LoginImpl implements LoginDAO {

	private Connection con;
	private PreparedStatement stm;
	private FactoryUser factory;

	@Inject
	public LoginImpl(Connection con) {
		this.con = con;
		factory = new FactoryUserImpl();
	}

	@Override
	public User logar(String cpf) {
		User createUser = null;
		String sql = "select * from users where cpf = ?";

		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, cpf);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				createUser = factory.createUser(rs.getString("name"),
						rs.getString("password"), rs.getString("cpf"),
						Nivel.valueOf(rs.getString("nivel")));
				createUser.setId(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return createUser;
	}

}
