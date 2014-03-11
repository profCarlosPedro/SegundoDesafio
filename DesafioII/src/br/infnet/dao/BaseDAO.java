package br.infnet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

protected Connection getConexao() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(
				"jdbc:postgresql://localhost:5432/Controle", "postgres", "1234");

	}
	
}
