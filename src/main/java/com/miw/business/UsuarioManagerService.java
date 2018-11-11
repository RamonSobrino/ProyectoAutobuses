package com.miw.business;

import java.util.List;

import com.miw.model.LoginData;
import com.miw.model.Usuario;

public interface UsuarioManagerService {

	Usuario validarUsuario(LoginData loginData) throws Exception;

	Usuario validarUsuario(String user) throws Exception;

	List<Usuario> findAllUsuarios() throws Exception;

}
