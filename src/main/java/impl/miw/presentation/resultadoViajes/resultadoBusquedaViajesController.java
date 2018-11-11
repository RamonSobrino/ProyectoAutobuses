package impl.miw.presentation.resultadoViajes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.model.EleccionViajeRequest;

@Controller
@RequestMapping("/private")
public class resultadoBusquedaViajesController {

	@RequestMapping(value = "/resultadoBusquedaViajes", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("eleccionViajeRequest ", new EleccionViajeRequest());
		return "private/index";
	}
}
