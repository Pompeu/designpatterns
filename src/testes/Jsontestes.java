package testes;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.apache.taglibs.standard.lang.jstl.Coercions;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;
import org.junit.Test;

import br.com.locadora.models.User;
import br.com.locadora.models.dao.DAO;
import br.com.locadora.models.dao.UserDaoImpl;
import br.com.locadora.models.factory.ConectionFactoryJDBC;
import br.com.locadora.models.factory.FactoryUser;
import br.com.locadora.models.factory.FactoryUserImpl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Jsontestes {
	User user;
	FactoryUser facUser = new FactoryUserImpl();
	DAO<User> userDao = new UserDaoImpl(new ConectionFactoryJDBC().getCon());
	@Test
	public void test() {
		try {
			System.err.println(userDao.retriveById(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
