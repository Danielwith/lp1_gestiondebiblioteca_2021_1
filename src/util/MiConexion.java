package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Permite crer una conexion a la BD
 * Se debe tener:
 * 1) Driver JDBC
 * 2) Ip del Servidor
 * 3) puerto
 * 4) Nombre de la BD
 * 5) Usuario
 * 6) Password  
 * 
 */
public class MiConexion {

	static {
		try {
			// permite crear objetos (Hace new)
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * IP :localhost PUERTO: 3306 BD: mydb USUARIO: root PASSWORD: mysql
	 * 
	 */
	public Connection getConexion(){
		Connection conn = null;
		
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_biblioteca_simple_2021_02?serverTimezone=America/Lima","root","mysql");           
			           

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
