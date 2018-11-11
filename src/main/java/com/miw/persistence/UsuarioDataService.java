package com.miw.persistence;

import java.util.List;

import com.miw.model.Usuario;

public interface UsuarioDataService {

	Usuario findById(long id) throws Exception;

	Usuario findByUserandPassword(String user, String password) throws Exception;

	Usuario findByUser(String user) throws Exception;

	List<Usuario> findAllUsuarios() throws Exception;

}
