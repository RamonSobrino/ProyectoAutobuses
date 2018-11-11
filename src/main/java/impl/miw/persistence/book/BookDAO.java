package impl.miw.persistence.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import com.miw.model.Book;
import com.miw.persistence.BookDataService;

/**
 * Clase que implementa las operaci�nes de acceso a la base de datos para la
 * entidad LIBRO.
 * 
 * @author Daniel F. Lanvin
 * @since 24/02/2004
 * @version 1.0
 */
public class BookDAO implements BookDataService {
	/**
	 * M�todo que accede a la base de datos para recuerar la lista de libros
	 * presentes en la base de datos.
	 */
	public Vector<Book> getBooks() throws Exception {
		//Inicializamos el Vector de retorno.
		Vector<Book> resultado = new Vector<Book>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
 
		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			//Obtenemos la conexi�n a la base de datos.
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select * from libro");
			rs = ps.executeQuery();

			while (rs.next()) {
				//Completamos los datos del Libro en la entidad
				Book libro = new Book();
				libro.setId(rs.getInt("id"));
				libro.setTitle(rs.getString("titulo"));
				libro.setDescription(rs.getString("descripcion"));
				libro.setAuthor(rs.getString("autor"));
				libro.setFamily(rs.getInt("familia"));
				libro.setBasePrice(rs.getDouble("precioBase"));
				//La a�adimos al Vector de resultado
				resultado.add(libro);
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
		//Retornamos el vector de resultado.
		return resultado;
	}

	public synchronized Book newBook(Book book) throws Exception {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			String SQL_DRV = "org.hsqldb.jdbcDriver";
			String SQL_URL = "jdbc:hsqldb:hsql://localhost/amazin";

			// We crate the database connection
			Class.forName(SQL_DRV);
			con = DriverManager.getConnection(SQL_URL, "DFLANVIN", "AMAZIN");

			ps = con.prepareStatement("select max(id) as maximo from libro");
			rs = ps.executeQuery();
			Integer id=0;
			while (rs.next()) {
				 id = rs.getInt("maximo");
			}
			
			System.out.println("Max id found: "+id);
			
			book.setId(id);
			//Creamos el libro
			ps = con.prepareStatement("insert into libro values (?,?,?,?,?,?)");
			ps.setInt(1, id+1);
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getDescription());
			ps.setString(4, book.getAuthor());
			ps.setInt(5, book.getFamily());
			ps.setDouble(6,  book.getBasePrice());
			ps.executeUpdate();

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

		return book;
	}
}