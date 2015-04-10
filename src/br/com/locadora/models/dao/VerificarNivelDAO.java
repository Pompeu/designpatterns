package br.com.locadora.models.dao;

import java.sql.SQLException;

import br.com.locadora.models.User;
import br.com.locadora.models.factory.ConectionFactoryJDBC;

public class VerificarNivelDAO extends ServicoAbstrato<User> {

	private DAO<User> dao;
		
	public VerificarNivelDAO() {

	}

	@Override
	public DAO<User> getDao() {
		if (dao == null)
			dao = new UserDaoImpl(new ConectionFactoryJDBC().getCon());
		return dao;
	}

	public boolean isAdmin(Integer id) {
		
		try {
			return getDao().retriveById(id).getNivel().name().equals("ADMIN");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
