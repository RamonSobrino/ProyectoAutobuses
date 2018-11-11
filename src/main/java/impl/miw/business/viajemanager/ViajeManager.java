package impl.miw.business.viajemanager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.ViajeManagerService;
import com.miw.model.BusquedaViajeRequest;
import com.miw.model.Viaje;
import com.miw.persistence.ViajeDataService;

public class ViajeManager implements ViajeManagerService {

	@Autowired
	private ViajeDataService viajeDataService;

	public ViajeDataService getViajeDataService() {
		return viajeDataService;
	}

	public void setViajeDataService(ViajeDataService viajeDataService) {
		this.viajeDataService = viajeDataService;
	}

	@Override
	public List<Viaje> findViajes(BusquedaViajeRequest request, boolean ida) throws Exception {
		String origen = request.getOrigen();
		String destino = request.getDestino();
		int numeroPlazas = request.getPlazas();
		LocalDateTime fechaHora;

		if (ida) {
			fechaHora = request.getFechaIda().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		} else {
			fechaHora = request.getFechaVuelta().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			destino = request.getOrigen();
			origen = request.getDestino();
		}
		return viajeDataService.findViajesByOrigenDestinoFecha(origen, destino, numeroPlazas, fechaHora);
	}

}
