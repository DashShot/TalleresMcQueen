
//package es.codeurjc.web.controller;

//import java.util.List;

/*import javax.annotation.PostConstruct;
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
	@PostConstruct
	public void init(){}
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