package es.codeurjc.web.controller;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.models.Valoraciones;
import es.codeurjc.web.service.UsuarioService;
import es.codeurjc.web.service.ValoracionesService;

@Controller
public class ValoracionesController {
    @Autowired
    private ValoracionesService valoracionesService;
    @Autowired
    private UsuarioService usuarioService;
    
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

//------------------- Ver Valoraciones -----------------------------//
    @GetMapping("/valoraciones")
    public String verValoraciones(Model model){
        model.addAttribute("valoraciones",valoracionesService.findAll());
        return "valoraciones/ver_valoraciones";
    }

// ---------------- Crear una Valoracion -----------------------------//
     @GetMapping("/valoraciones/crearvaloracion")
     public String crearValoracion(Model model){

         return "valoraciones/nueva_valoracion";
     }

     @PostMapping("/valoraciones/crearvaloracion/exito")
     public String  crearvaloracion( Valoraciones valoraciones,HttpServletRequest req){
        
        String nombre =req.getUserPrincipal().getName();
        Usuario u = usuarioService.getByNombre(nombre);
        u.addValoraciones(valoraciones);

        valoraciones.setUsuario(u);
        valoracionesService.save(valoraciones);
        
        return "redirect:/valoraciones";
     }
    
}
