package impl.miw.presentation.resultadoViajes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.model.EleccionViajeRequest;

@Controller
public class resultadoBusquedaViajesController {

	@RequestMapping(value = "private/resultadoBusquedaViajes", method = RequestMethod.GET)
	public String displayResultado(Model model) {
		model.addAttribute("eleccionViajeRequest ", new EleccionViajeRequest());
		return "private/resultadoBusquedaViajes";
	}

	@ModelAttribute
	EleccionViajeRequest getEleccionViajeRequest() {
		return new EleccionViajeRequest();
	}
}
