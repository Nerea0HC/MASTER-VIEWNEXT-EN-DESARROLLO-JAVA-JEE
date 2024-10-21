package com.empresa.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static final String URL = "jdbc:mysql://localhost:3306/04-empresa";
	private static final String USER = "root";
	private static final String PWD = "root";
	
	public Connection conexion() {
		Connection conex = null;
		try {
			conex = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conex;
	}
}