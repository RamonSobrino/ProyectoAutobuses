package impl.miw.persistence.iva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.Iva;
import com.miw.persistence.IvaDataService;

public class IvaDAO implements IvaDataService{
	/**
	 * M�todo que accede a la base de datos para recuerar la lista de libros
	 * presentes en la base de datos.
	 */
	public Vector<Iva> getIvas() throws Exception {
		// Inicializamos el Vector de retorno.
		Vector<Iva> resultado = new Vector<Iva>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select * from iva");
			rs = ps.executeQuery();

			while (rs.next()) {
				// Completamos los datos del Libro en la entidad
				Iva iva = new Iva();
				iva.setId(rs.getInt("id"));
				iva.setFamily(rs.getInt("familia"));
				iva.setValue(rs.getDouble("valor"));
				// La añadimos al Vector de resultado
				resultado.add(iva);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw (e);
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
			}
		}
		// Retornamos el vector de resultado.
		return resultado;
	}
}