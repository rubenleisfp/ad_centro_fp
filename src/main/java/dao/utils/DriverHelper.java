package dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para obtener la conexión del driver
 */
public class DriverHelper {

	public static Connection getConnection() throws SQLException { 
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ad_centro_fp?serverTimezone=Europe/Madrid",
			"root", "castelao");
		return conn;
	}
}
