package com.miw.persistence;

import com.miw.model.Billete;

public interface BilleteDataService {

	Billete findById(long id) throws Exception;

	boolean create(Billete billete) throws Exception;

	boolean edit(Billete billete) throws Exception;

	boolean delete(Billete billete) throws Exception;

}
