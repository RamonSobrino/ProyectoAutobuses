package impl.miw.persistence.billlete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.miw.model.Billete;
import com.miw.model.Estado;
import com.miw.persistence.BilleteDataService;

import impl.miw.persistence.util.ConnectionHsqldbFactory;

public class BilleteDAO implements BilleteDataService {

	@Override
	public Billete findById(long id) throws Exception {
		Billete resultado = null;

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("select * from BILLETE where ID = ? ");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return null;
			}
			resultado = obtenerBilleteFromResultSet(rs);

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

	private Billete obtenerBilleteFromResultSet(ResultSet rs) throws Exception {
		Billete billete = new Billete(rs.getInt("ID"));
		billete.setIdViaje(rs.getLong("ID_VIAJE"));
		billete.setNumPlazas(rs.getInt("NUM_PLAZAS"));
		billete.setIdUsuario(rs.getLong("ID_USUARIO"));
		billete.setNumBicis(rs.getInt("NUM_BICIS"));
		billete.setNumMascotas(rs.getInt("NUM_MASCOTAS"));
		billete.setNumTablaSurf(rs.getInt("NUM_TABLAS_SURF"));
		billete.setNumEsquies(rs.getInt("NUM_ESQUIES"));
		billete.setEstado(Estado.getEstado(rs.getString("ESTADO")));
		billete.setSeguro(rs.getBoolean("SEGURO"));

		return billete;
	}

	@Override
	public boolean create(Billete billete) throws Exception {
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
			System.out.println(billete);

			billete.setId((id + 1));

			ps.close();

			ps = con.prepareStatement("insert into BILLETE values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setLong(1, billete.getId());
			ps.setLong(2, billete.getIdViaje());
			ps.setInt(3, billete.getNumPlazas());
			ps.setLong(4, billete.getIdUsuario());
			ps.setString(5, billete.getEstado().getLabel());
			ps.setBoolean(6, billete.isSeguro());
			ps.setInt(7, billete.getNumBicis());
			ps.setInt(8, billete.getNumMascotas());
			ps.setInt(9, billete.getNumTablaSurf());
			ps.setInt(10, billete.getNumEsquies());

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
	public boolean edit(Billete billete) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();

			ps = con.prepareStatement("update BILLETE set ID_VIAJE = ?, NUM_PLAZAS = ?, ID_USUARIO = ?, "
					+ "ESTADO = ?, NUM_BICIS = ?, NUM_MASCOTAS = ?, NUM_TABLAS_SURF = ?, NUM_ESQUIES = ?, "
					+ " SEGURO = ?  where ID = ? ");
			ps.setLong(1, billete.getIdViaje());
			ps.setInt(2, billete.getNumPlazas());
			ps.setLong(3, billete.getIdUsuario());
			ps.setString(4, billete.getEstado().getLabel());
			ps.setInt(5, billete.getNumBicis());
			ps.setInt(6, billete.getNumMascotas());
			ps.setInt(7, billete.getNumTablaSurf());
			ps.setInt(8, billete.getNumEsquies());
			ps.setBoolean(9, billete.isSeguro());

			ps.setLong(10, billete.getId());

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
	public boolean delete(Billete billete) throws Exception {
		PreparedStatement ps = null;
		Connection con = null;
		boolean resultado = false;

		try {
			con = ConnectionHsqldbFactory.getInstance().conectarBase();
			ps = con.prepareStatement("remove  from BILLETE where ID = ? ");
			ps.setLong(1, billete.getId());
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
