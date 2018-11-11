package impl.miw.persistence.viaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.miw.model.Viaje;
import com.miw.persistence.ViajeDataService;

import impl.miw.persistence.util.ConnectionHsqldbFactory;

public class ViajeDAO implements ViajeDataService {

	public List<Viaje> findAllViajes() throws Exception {
		// Inicializamos el Vector de retorno.
		List<Viaje> resultado = new ArrayList<Viaje>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from VIAJE");
			rs = ps.executeQuery();

			while (rs.next()) {
				Viaje viaje = obtenerViajeFromResultSet(rs);
				resultado.add(viaje);
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

	public List<Viaje> findViajesByOrigenDestinoFecha(String origen, String destino, int numeroPlazas,
			LocalDateTime fechaHora) throws Exception {
		// Inicializamos el Vector de retorno.
		List<Viaje> resultado = new ArrayList<Viaje>();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from VIAJE where ORIGEN = ? and DESTINO = ? and PLAZAS_RESTANTES >= ?"
					+ " and cast(FECHA_SALIDA as date) = ? order by FECHA_SALIDA");
			ps.setString(1, origen);
			ps.setString(2, destino);
			ps.setInt(3, numeroPlazas);
			ps.setDate(4, java.sql.Date.valueOf(fechaHora.toLocalDate()));

			rs = ps.executeQuery();

			while (rs.next()) {
				// Completamos los datos del Libro en la entidad
				Viaje viaje = obtenerViajeFromResultSet(rs);
				resultado.add(viaje);
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

	private Viaje obtenerViajeFromResultSet(ResultSet rs) throws SQLException {
		Viaje viaje = new Viaje();

		viaje.setId(rs.getInt("ID"));
		viaje.setOrigen(rs.getString("ORIGEN"));
		viaje.setDestino(rs.getString("DESTINO"));
		viaje.setFechaSalida(rs.getTimestamp("FECHA_SALIDA").toLocalDateTime());
		viaje.setPlazasTotales(rs.getInt("PLAZAS_TOTALES"));
		viaje.setPlazasRestantes(rs.getInt("PLAZAS_RESTANTES"));
		viaje.setPrecio(rs.getDouble("PRECIO"));
		return viaje;
	}

	public boolean edit(Viaje viaje) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("update VIAJE set ORIGEN = ?, DESTINO = ?, PLAZAS_TOTALES = ?, "
					+ "PLAZAS_RESTANTES = ?, PRECIO = ?  where ID = ? ");
			ps.setString(1, viaje.getOrigen());
			ps.setString(2, viaje.getDestino());
			ps.setInt(3, viaje.getPlazasTotales());
			ps.setInt(4, viaje.getPlazasRestantes());
			ps.setDouble(5, viaje.getPrecio());
			ps.setLong(6, viaje.getId());

			ps.executeUpdate();
			resultado = true;
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

	public boolean delete(Viaje viaje) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();
			ps = con.prepareStatement("remove  from VIAJE where ID = ? ");
			ps.setLong(1, viaje.getId());
			ps.executeUpdate();
			resultado = true;
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
