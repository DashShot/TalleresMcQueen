package es.codeurjc.web.controller;

//import java.util.List;

//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpServletRequest;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import es.codeurjc.web.models.Usuario;
//import es.codeurjc.web.repository.*;

@Controller
public class McQueenWebController {
	/* 
    @Autowired
    //private UsuarioRepository userRepository;
    //Pagina inicial
    @GetMapping("/")
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpServletRequest req){
        if(req.getUserPrincipal() != null){
            //String nombre = req.getUserPrincipal().getName();
            //Usuario nuevo = userRepository.getByNombre(nombre);
            //model.addAttribute("nombreuser", nuevo.getNombre());
        }else model.addAttribute("nombreuser", "INVITADO");
        model.addAttribute("notauser", req.getUserPrincipal() == null);
		model.addAttribute("auser", req.getUserPrincipal() != null);
		model.addAttribute("admin", req.isUserInRole("ADMIN"));

		model.addAttribute("tipo", "inicio");
		model.addAttribute("contenido", "los posts más recientes");

		return "index";
    }
	*/
	@GetMapping("/")
	public String verWeb(Model model){
		model.addAttribute(, model)
		return "login";
	}

    // Inicio de sesion
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// error de inicio de sesion
	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	// Registro
	@GetMapping("/signup")
	public String registro() {
		return "registro";
	}

}
/* 
@GetMapping("/")
public String showReparaciones(Model model){
    model.addAttribute(attributeName: "Reparaciones", McQueenService.findAll());
}

@GetMapping("/reparaciones/{id}")
public String showReparacion(Model model, @PathVariable long id){
    
}
*/