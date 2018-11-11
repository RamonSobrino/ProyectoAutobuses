package impl.miw.business.usuariomanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miw.business.UsuarioManagerService;
import com.miw.model.LoginData;
import com.miw.model.Usuario;
import com.miw.persistence.UsuarioDataService;

public class UsuarioManager implements UsuarioManagerService {

	@Autowired
	private UsuarioDataService usuarioDataService;

	public void setUsuarioDataService(UsuarioDataService usuarioDataService) {
		System.out.println("Setting usuarioDataService bean");

		this.usuarioDataService = usuarioDataService;
	}

	@Override
	public Usuario validarUsuario(LoginData loginData) throws Exception {

		return usuarioDataService.findByUserandPassword(loginData.getLogin(), loginData.getPassword());

	}

	@Override
	public Usuario validarUsuario(String user) throws Exception {

		return usuarioDataService.findByUser(user);

	}

	@Override
	public List<Usuario> findAllUsuarios() throws Exception {
		return usuarioDataService.findAllUsuarios();
	}

}
