package es.codeurjc.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.codeurjc.web.models.Contactos;
import es.codeurjc.web.service.ContactosService;

@Controller
public class ContactosController {
    
    @Autowired
    private ContactosService contactosService;

    @GetMapping("/Contactos")
    public String mostrarContactos(Model model){
        model.addAttribute("talleres",contactosService.findAll());
        return "contactos/vercontactos";
    }

    @GetMapping("/Contactos/{id}")
    public String mostrarContacto(Model model, @PathVariable long id){
        Optional<Contactos> Contacto = contactosService.findbyID(id);
        if (Contacto.isPresent()){
            model.addAttribute("Contacto", Contacto.get());
            return "Contacto";
        }
        return "Contactos";
    }

}
