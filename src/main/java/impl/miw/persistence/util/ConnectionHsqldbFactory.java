package impl.miw.persistence.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHsqldbFactory {

	public static ConnectionHsqldbFactory instance = null;

	private ConnectionHsqldbFactory() {

	}

	public static ConnectionHsqldbFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionHsqldbFactory();
		}
		return instance;
	}

	public Connection conectarBase() throws ClassNotFoundException, SQLException {
		Connection con;
		String SQL_DRV = "org.hsqldb.jdbcDriver";
		String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

		// Obtenemos la conexi�n a la base de datos.
		Class.forName(SQL_DRV);
		con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");
		return con;
	}
}
