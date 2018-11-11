package com.miw.business;

import java.util.List;

import com.miw.model.BusquedaViajeRequest;
import com.miw.model.Viaje;

public interface ViajeManagerService {

	List<Viaje> findViajes(BusquedaViajeRequest request, boolean ida) throws Exception;

}
