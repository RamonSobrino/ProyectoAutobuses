package com.miw.persistence;

import java.time.LocalDateTime;
import java.util.List;

import com.miw.model.Viaje;

public interface ViajeDataService {

	public List<Viaje> findAllViajes() throws Exception;

	public List<Viaje> findViajesByOrigenDestinoFecha(String origen, String destino, int numeroPlazas,
			LocalDateTime fechaHora) throws Exception;

	public boolean edit(Viaje viaje)throws Exception;
	
	public boolean delete(Viaje viaje) throws Exception;
}
