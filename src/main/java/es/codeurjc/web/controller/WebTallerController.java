package es.codeurjc.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.codeurjc.web.repository.UsuarioRepository;

//import es.codeurjc.web.repository.UsuarioRepository;

import es.codeurjc.web.service.UsuarioService;

@Controller
public class WebTallerController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        if (principal != null) {

            model.addAttribute("sesionIniciada", true);
            model.addAttribute("userName", principal.getName());
            model.addAttribute("admin", request.isUserInRole("ADMIN"));

        } else {
            model.addAttribute("sesionIniciada", false);
        }

    }

    // --------------- Pantalla inicial ----------------------------------//

    @GetMapping("/")
    public String inicio() {

        // model.addAttribute("Imgen",false);

        return "inicio";
    }

    // ------------------------ Login ----------------------------------------//

    @RequestMapping("/login")
    public String login() {
        return "iniciarsesion";
    }


    @RequestMapping("/loginerror")
    public String loginerror() {
        return "iniciosesionerror";
    }

    // ------------------ Registro
    // ------------------------------------------------//

    @GetMapping("/registro")
    public String registro() {
        return "registrosesion";
    }

    @PostMapping("/registro-ok")
    public String registroOk() {

        return "redirect:inicio";
    }

    // ---------------------- Usuario
    // -----------------------------------------------//

    @GetMapping("/verdatos_usuario")
    public String verDatos(Model model, HttpServletRequest request) {

        Principal principal = request.getUserPrincipal();

        model.addAttribute("Nombre", principal.getName());

        return "verdatos_usuario";
    }

    @PostMapping("/editardatos")
    public String editarDatos(Model model, HttpServletRequest req) {

        return "cambiardato_susuario";
    }

}
