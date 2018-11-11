package impl.miw.presentation.login;

import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.model.LoginData;
import com.miw.model.Usuario;

import impl.miw.business.usuariomanager.UsuarioManager;

@Controller
@RequestMapping("login")
public class LoginController {

	private String seed = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM1234567890";

	@Autowired
	private UsuarioManager usuarioManager;

	@RequestMapping(method = RequestMethod.GET)
	public String getForm(Model model, HttpSession session) {
		System.out.println("Preparing the model for Login");
		// We could prepare the model here instead of using @ModelAttribute

		// We generate the Catcha code
		String captcha = generateCaptcha();
		model.addAttribute("captcha", captcha);
		session.setAttribute("captcha", captcha);
		return "login_page";
	}

	/**
	 * Private method to generate the captcha code
	 * 
	 * @return
	 */
	private String generateCaptcha() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			sb.append(seed.charAt(((new Random()).nextInt(seed.length()))));
		}
		System.out.println("Generating Captcha: " + sb.toString());
		return sb.toString();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("login") LoginData login, BindingResult result, Model model,
			HttpSession session) {
		System.out.println("Login in with " + login);

		// We validate with the Validator
		LoginValidator validator = new LoginValidator();
		validator.validate(login, result);

		if (result.hasErrors()) {
			return "login_page";
		}

		if (login.getCaptcha().equals(session.getAttribute("captcha"))) {

			try {
				Usuario usuario = usuarioManager.validarUsuario(login);
				if (usuario != null) {
					session.setAttribute("usuario", usuario);
					return "index";
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

		} else {
			model.addAttribute("message", "Captcha is wrong");
			login.setCaptcha("");
			return "login_page";
		}
	}

	@ModelAttribute("login")
	public LoginData prepareModel() {
		System.out.println("Invoking prepareModel()");
		return new LoginData();
	}

}
