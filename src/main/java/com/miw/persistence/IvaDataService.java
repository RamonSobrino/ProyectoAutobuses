package com.miw.persistence;

import java.util.Vector;

import com.miw.model.Iva;

public interface IvaDataService {
		public Vector<Iva> getIvas() throws Exception;
}
