package br.com.locadora.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.locadora.models.Nivel;
import br.com.locadora.models.User;
import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

@RequestScoped
public class UserDaoImpl implements DAO<User> {

	private FactoryUser factory;
	private Connection con;
	private PreparedStatement stm;

	@Inject
	public UserDaoImpl(Connection con) {
		this.con = con;
		this.factory = new FactoryUserImpl();
	}

	@Deprecated
	public UserDaoImpl() {
		this(null);
	}

	@Override
	public User create(User obj) throws SQLException {
		String sql = "insert into users(name , cpf , password , nivel)"
				+ "values (?, ?, ?,?)";

		stm = con.prepareStatement(sql);

		stm.setString(1, obj.getNome());
		stm.setString(2, obj.getCpf());
		stm.setString(3, obj.getPassword());
		stm.setString(4, obj.getNivel().name());

		stm.execute();

		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			obj.setId(rs.getInt(1));
		}
		stm.close();
		return obj;
	}

	@Override
	public User update(User obj) throws SQLException {

		String sql = "update users set name=? , cpf=? , password=? , nivel=? where id = ?";

		stm = con.prepareStatement(sql);

		stm.setString(1, obj.getNome());
		stm.setString(2, obj.getCpf());
		stm.setString(3, obj.getPassword());
		stm.setString(4, obj.getNivel().name());
		stm.setLong(5, obj.getId());

		stm.execute();
		stm.close();

		return obj;
	}

	@Override
	public User retriveById(Integer id) throws SQLException {
		String sql = "select * from users  where id=?";
		User user = null;

		stm = con.prepareStatement(sql);
		stm.setInt(1, id);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			user = factory.createUser(rs.getString("name"),
					rs.getString("password"), rs.getString("cpf"),
					Nivel.valueOf(rs.getString("nivel")));
		}
		System.out.println(user);
		return user;
	}

	@Override
	public List<User> retriveAll() throws SQLException {

		List<User> users = new ArrayList<User>();

		String sql = "select * from users";

		stm = con.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			while (rs.next()) {
				users.add(factory.createUser(rs.getString("name"),
						rs.getString("password"), rs.getString("cpf"),
						Nivel.valueOf(rs.getString("nivel"))));

			}
		}
		return users;
	}

	@Override
	public Boolean remove(Integer id) throws SQLException {
		String sql = "DELETE FROM users WHERE id=?";

		stm = con.prepareStatement(sql);
		stm.setLong(1, id);

		stm.execute();

		stm.close();

		if (retriveById(id) == null) {
			return Boolean.FALSE;
		}

		return Boolean.FALSE;
	}

}
