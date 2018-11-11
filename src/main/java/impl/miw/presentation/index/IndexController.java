package impl.miw.presentation.index;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.ViajeManagerService;
import com.miw.model.BusquedaViajeRequest;
import com.miw.model.EleccionViajeRequest;
import com.miw.model.Viaje;

@Controller
@RequestMapping("/private")
public class IndexController {

	@Autowired
	private ViajeManagerService viajeManagerService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("busquedaViajeRequest", new BusquedaViajeRequest());
		return "private/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String buscarViaje(@Valid @ModelAttribute BusquedaViajeRequest busquedaViajeRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			System.out.println("---- Has Errors -----");
			return "index";

		} else {
			// new ParamBusquedaViaje();
			System.out.println("----- POST ------");
			System.out.println("Contenido: " + busquedaViajeRequest.toString());

			List<Viaje> viajesIda;
			try {
				viajesIda = viajeManagerService.findViajes(busquedaViajeRequest, true);

				// Colocamos la lista de viajes en el modelo
				model.addAttribute("viajesIdaList", viajesIda);

				if (viajesIda != null && viajesIda.isEmpty()) {
					boolean hayViajes = viajesIda.stream().anyMatch(vi -> vi.getPlazasRestantes() > 0);
					if (hayViajes) { // Si hay viajes para esa fecha pero no se nos han devuelto resultados, es que
										// no hay plazas libres.
						model.addAttribute("mensajeViajesIda", "buscarViaje.mensaje.noPlazasLibres");
					} else {
						model.addAttribute("mensajeViajesIda", "buscarViaje.mensaje.noViajes");
						// "No hay viajes para ese Origen, Destino y fecha de salida."
					}
				}

				if (busquedaViajeRequest.isIdaYVuelta()) {

					List<Viaje> viajesVuelta = viajeManagerService.findViajes(busquedaViajeRequest, false);
					model.addAttribute("viajesVueltaList", viajesVuelta);

					if (viajesVuelta != null && viajesVuelta.isEmpty()) {
						boolean hayViajes = viajesVuelta.stream().anyMatch(vi -> vi.getPlazasRestantes() > 0);
						if (hayViajes) { // Si hay viajes para esa fecha pero no se nos han devuelto resultados, es que
											// no hay plazas libres.
							model.addAttribute("mensajeViajesVuelta", "No hay " + busquedaViajeRequest.getPlazas()
									+ " plazas libres en los viajes disponibles.");
						} else {
							model.addAttribute("mensajeViajesVuelta",
									"No hay viajes para ese Origen, Destino y fecha de salida.");
						}
					}
				}
				model.addAttribute("busquedaViajeRequest", new BusquedaViajeRequest());
				model.addAttribute("eleccionViajeRequest ", new EleccionViajeRequest());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "/private/resultadoBusquedaViajes";
	}

	@ModelAttribute
	BusquedaViajeRequest getBusquedaViajeRequest() {
		return new BusquedaViajeRequest();
	}
}
