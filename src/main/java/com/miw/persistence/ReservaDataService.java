package com.miw.persistence;

import com.miw.model.Reserva;

public interface ReservaDataService {

	Reserva findById(long id) throws Exception;

	boolean create(Reserva reserva) throws Exception;

	boolean edit(Reserva reserva) throws Exception;

	boolean delete(Reserva reserva) throws Exception;

}
