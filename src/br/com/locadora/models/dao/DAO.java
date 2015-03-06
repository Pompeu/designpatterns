package br.com.locadora.models.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	
	T create(T obj) throws SQLException;
	T update(T obj) throws SQLException;
	T retriveById(Integer id) throws SQLException;
	List<T> retriveAll() throws SQLException;	
	Boolean remove(Integer id) throws SQLException;
	
}
