package impl.miw.presentation;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.model.Usuario;

import impl.miw.business.usuariomanager.UsuarioManager;

@SessionAttributes({ "loginCounter" })
@Controller
public class WelcomeController {

	@Autowired
	private UsuarioManager usuarioManager;

	/*
	 * Setting / as request mapping url we are setting the default controller for
	 * the application.
	 */
	@RequestMapping("/")
	public String welcome() {
		System.out.println("Executing Welcome controller");
		return "redirect:/private/index";
	}

	@RequestMapping("/private/index")
	public String index(Principal p, @ModelAttribute("loginCounter") LoginCounter loginCounter, Model model,
			HttpSession session) {
		loginCounter.inc();
		SecurityContextImpl userToken = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
		User usuarioLogueado = (User) userToken.getAuthentication().getPrincipal();

		String login = usuarioLogueado.getUsername();

		try {
			List<Usuario> usuarios = usuarioManager.findAllUsuarios();

			Usuario usuario = usuarios.stream().filter(us -> us.getUser().equals(login)).findFirst().orElse(null);
			if (usuario != null) {
				session.setAttribute("usuario", usuario);
				return "private/index";
			} else {
				model.addAttribute("message", "Credentials are not valid");
				return "login_page";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("message", "Credentials are not valid");
			return "login_page";
		}

	}

	@ModelAttribute("loginCounter")
	public LoginCounter getLoginCounter() {
		System.out.println("Initializing loginCounter");
		return new LoginCounter();
	}

	@RequestMapping("loginError")
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login_page";
	}
}
