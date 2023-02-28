package es.codeurjc.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import es.codeurjc.web.repository.UsuarioRepository;

//import es.codeurjc.web.service.UsuarioService;


@Controller
public class WebTallerController {

    //@Autowired
    //private UsuarioRepository usuarioRepository;
    /* 
    @ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
        
        //         SIN LOGIN DEMOMENTO 
		Principal principal = request.getUserPrincipal();  

		if (principal != null) {

			model.addAttribute("sesionIniciada", true);
		//	model.addAttribute("userName", principal.getName());
		//	model.addAttribute("admin", request.isUserInRole("ADMIN"));

		} else {
			model.addAttribute("sesionIniciada", false);
        }
    
	}
    */
    //--------------- Pantalla inicial ----------------------------------// 
    
    @GetMapping("/")
    public String inicio(){

        //model.addAttribute("Imgen",false);
        
        return "inicio";
    }
    /* 
    @GetMapping("/")
    @RequestMapping(method = RequestMethod.GET)
    public String inicio(Model model, HttpServletRequest request){
        if(request.getUserPrincipal() != null){
            String nombre = request.getUserPrincipal().getName();
            Usuario usr = usuarioRepository.getByNombre(nombre);

            model.addAttribute("nombre", usr.getNombre());
        }else{
            model.addAttribute("nombre", "INVITADO");
        }
        return "inicio";
    }
    */
    //------------------------ Login ----------------------------------------//
    /* 
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginerror")
    public String loginerror(){
        return "loginerror";
    }
    */
    //------------------ Registro ------------------------------------------------//
    
   //---------------------- Usuario -----------------------------------------------//
   //@Autowired
   // private UsuarioService userService;

    @GetMapping("/verDatosUsuario")
    public String verDatos(Model model, HttpServletRequest request){
        
        Principal principal = request.getUserPrincipal();
        
        model.addAttribute("Nombre",principal.getName());
     
        return "verDatosUsuario";
    }

    @PostMapping("/editarDatos")
    public String editarDatos(Model model, HttpServletRequest req) {
        
        
        return "cambiarDatosUsuario";
    }
    
}
