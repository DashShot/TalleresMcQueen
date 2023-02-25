package es.codeurjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.web.service.ContactosService;

@Controller
public class ContactosController {
    
    @Autowired
    private ContactosService contactosService;

    @GetMapping("/Contactos")
    public String mostrarContactos(Model model){
        model.addAttribute("talleres",contactosService.findAll());
        return "Contactos";
    }
}
