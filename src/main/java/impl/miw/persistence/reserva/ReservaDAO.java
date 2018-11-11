package impl.miw.persistence.reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.Reserva;
import com.miw.persistence.ReservaDataService;

import impl.miw.persistence.util.ConnectionHsqldbFactory;

public class ReservaDAO implements ReservaDataService {

	@Override
	public Reserva findById(long id) throws Exception {
		Reserva resultado = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from RESERVA where ID = ? ");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return null;
			}
			resultado = obtenerReservaFromResultSet(rs);

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

	private Reserva obtenerReservaFromResultSet(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Reserva reserva) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select max(id) as maximo from BILLETE");
			rs = ps.executeQuery();
			Integer id = 0;
			while (rs.next()) {
				id = rs.getInt("maximo");
			}

			System.out.println("Máximo id encontrado: " + id);
			System.out.println(reserva);

			reserva.setId((id + 1));

			ps.close();

			ps = con.prepareStatement("insert into RESERVA values(?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, reserva.getId());
			ps.setString(2, reserva.getCodigoReserva());
			ps.setLong(3, reserva.getIdBilleteIda());
			ps.setLong(4, reserva.getIdBilleteVuelta());
			ps.setString(5, reserva.getNombre());
			ps.setString(6, reserva.getApellidos());
			ps.setString(7, reserva.getDni());
			ps.setString(8, reserva.getCorreo());

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

	@Override
	public boolean edit(Reserva reserva) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement(
					"update RESERVA set CODIGO_RESERVA = ?, ID_BILLETE_IDA = ?, ID_BILLETE_VUELTA = ?, "
							+ "NOMBRE = ?, APELLIDOS = ?, DNI = ?, CORREO = ?  where ID = ? ");
			ps.setString(1, reserva.getCodigoReserva());
			ps.setLong(2, reserva.getIdBilleteIda());
			ps.setLong(3, reserva.getIdBilleteVuelta());
			ps.setString(4, reserva.getNombre());
			ps.setString(5, reserva.getApellidos());
			ps.setString(6, reserva.getDni());
			ps.setString(7, reserva.getCorreo());

			ps.setLong(8, reserva.getId());

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

	@Override
	public boolean delete(Reserva reserva) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();
			ps = con.prepareStatement("remove  from RESERVA where ID = ? ");
			ps.setLong(1, reserva.getId());
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
