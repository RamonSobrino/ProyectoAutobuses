package impl.miw.persistence.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.miw.model.Usuario;
import com.miw.persistence.UsuarioDataService;

import impl.miw.persistence.util.ConnectionHsqldbFactory;

public class UsuarioDAO implements UsuarioDataService {

	public Usuario findById(long id) throws Exception {
		Usuario resultado = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from USUARIO where ID = ? ");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return null;
			}
			resultado = obtenerUsuarioFromResultSet(rs);

			if (rs.next()) {
				throw new Exception("Mas de un resultado en la query");
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

	private Usuario obtenerUsuarioFromResultSet(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario(rs.getInt("ID"));
		usuario.setUser(rs.getString("USER"));
		usuario.setPassword(rs.getString("PASSWORD"));
		usuario.setNombre(rs.getString("NOMBRE"));
		usuario.setApellidos(rs.getString("APELLIDOS"));
		usuario.setDni(rs.getString("DNI"));
		usuario.setMail(rs.getString("MAIL"));
		return usuario;
	}

	public List<Usuario> findAllUsuarios() throws Exception {
		// Inicializamos el Vector de retorno.
		List<Usuario> resultado = new ArrayList<>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from USUARIO");
			rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = obtenerUsuarioFromResultSet(rs);
				resultado.add(usuario);
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

	public Usuario findByUserandPassword(String user, String password) throws Exception {
		Usuario resultado = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from USUARIO where USER = ? and PASSWORD = ?");
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				return null;
			}
			resultado = obtenerUsuarioFromResultSet(rs);

			if (rs.next()) {
				throw new Exception("Mas de un resultado en la query");
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

	public Usuario findByUser(String user) throws Exception {
		Usuario resultado = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from USUARIO where USER = ?");
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				resultado = obtenerUsuarioFromResultSet(rs);
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
