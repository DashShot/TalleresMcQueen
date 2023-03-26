package es.codeurjc.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.repository.ReparacionesRepository;
import es.codeurjc.web.repository.UsuarioRepository;

//import es.codeurjc.web.repository.UsuarioRepository;

//import es.codeurjc.web.service.UsuarioService;

@Controller
public class WebTallerController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReparacionesRepository reparacionesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    


    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if (principal != null) {

            model.addAttribute("sesionIniciada", true);
            model.addAttribute("userName", principal.getName());
            model.addAttribute("admin", request.isUserInRole("ADMIN"));

        } else {
            model.addAttribute("sesionIniciada", false);
            model.addAttribute("userName", "Invitado");
            model.addAttribute("admin", request.isUserInRole("ADMIN"));
        }

    }

    // --------------- Pantalla inicial ----------------------------------//

    @GetMapping("/")
    public String inicio() {


        return "inicio";
    }

    // ------------------------ Login ----------------------------------------//
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @RequestMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }

    //----------------------- Logout --------------------------------------//

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }
    // ------------------ Registro -------------------------------------//

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    
    @PostMapping("/registro")
	public String registrar(@RequestParam String nombre, @RequestParam String contrasena) {

		if (usuarioRepository.getByNombre(nombre) != null || nombre == "" || contrasena == ""){
            return "registroerror";
        }else{
            Usuario u = new Usuario(nombre,passwordEncoder.encode(contrasena),("USER"));
		    usuarioRepository.save(u);
		    return "registroexito";
        }
        
	}
    
    // --------------------------- Admin --------------------//

    @GetMapping("/menuadmin")
    public String verDatos(Model model) {

        model.addAttribute("reparaciones",reparacionesRepository.findAll());

        return "menuadmin";
    }

    @PostMapping("/")
    public String editarDatos() {

        return "";
    }

}
