package br.com.locadora.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.locadora.models.User;
import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

@RequestScoped
public class UserImpl implements DAO<User> {

	private FactoryUser factory;
	private Connection con;
	private PreparedStatement stm;

	@Inject
	public UserImpl(Connection con) {
		this.con = con;
		factory = new FactoryUserImpl();
	}

	@Deprecated
	public UserImpl() {
		this(null);
	}

	@Override
	public User create(User obj) throws SQLException {
		String sql = "insert into Users(name , cpf , password , nivel)"
				+ "values (?, ?, ?,?)";

		stm = con.prepareStatement(sql);

		stm.setString(1, obj.getNome());
		stm.setString(2, obj.getCpf());
		stm.setString(3, obj.getPassword());
		stm.setString(4, obj.getNivel().name());

		stm.execute();
		stm.close();

		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			obj.setId(rs.getInt(1));
		}

		return obj;
	}

	@Override
	public User update(User obj) throws SQLException {

		String sql = "update Users set (name=? , cpf=? , password=? , nivel=  ?)";

		stm = con.prepareStatement(sql);

		stm.setString(1, obj.getNome());
		stm.setString(2, obj.getCpf());
		stm.setString(3, obj.getPassword());
		stm.setString(4, obj.getNivel().name());

		stm.execute();
		stm.close();

		ResultSet rs = stm.getGeneratedKeys();

		if (rs.next()) {
			obj.setId(rs.getInt(1));
		}

		return obj;
	}

	@Override
	public User retriveById(Integer id) throws SQLException {
		String sql = "select * from Users  where id=?";
		User user = null;
		stm = con.prepareStatement(sql);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			switch (rs.getString("nivel")) {
			case "Admin":
				user = factory.createAdmin(rs.getString("name"),
						rs.getString("password"), rs.getString("cpf"));
				break;
			case "Studient":
				user = factory.createAdmin(rs.getString("name"),
						rs.getString("password"), rs.getString("cpf"));
				break;
			case "Theacher":
				user = factory.createAdmin(rs.getString("name"),
						rs.getString("password"), rs.getString("cpf"));
				break;
			default:
				break;
			}

		}

		return user;
	}

	@Override
	public List<User> retriveAll() throws SQLException {

		List<User> users = new ArrayList<User>();

		String sql = "select * from Users";

		stm = con.prepareStatement(sql);

		ResultSet rs = stm.executeQuery();
		while (rs.next()) {
			while (rs.next()) {
				switch (rs.getString("nivel")) {
				case "Admin":
					users.add(factory.createAdmin(rs.getString("name"),
							rs.getString("password"), rs.getString("cpf")));
					break;
				case "Studient":
					users.add(factory.createAdmin(rs.getString("name"),
							rs.getString("password"), rs.getString("cpf")));
					break;
				case "Theacher":
					users.add(factory.createAdmin(rs.getString("name"),
							rs.getString("password"), rs.getString("cpf")));
					break;
				default:
					break;
				}

			}
		}
		return users;
	}

	@Override
	public Boolean remove(Integer id) throws SQLException {
		String sql = "DELETE FROM Users WHERE id=?";

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
