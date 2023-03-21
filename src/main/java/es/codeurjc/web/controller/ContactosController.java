package es.codeurjc.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.codeurjc.web.models.Contactos;
import es.codeurjc.web.service.ContactosService;
import es.codeurjc.web.service.MecanicoService;

@Controller
public class ContactosController {
    
    @Autowired
    private ContactosService contactosService;
    @Autowired
    private MecanicoService mecanicoService;

    @GetMapping("/contactos")
    public String mostrarContactos(Model model){
        model.addAttribute("talleres",contactosService.findAll());
        model.addAttribute("mecanicos", mecanicoService.findAll());
        return "contactos/vercontactos";
    }

    
    @GetMapping("/contactos/{id}")
    public String mostrarContacto(Model model, @PathVariable long id){
        Optional<Contactos> Contacto = contactosService.findbyID(id);
        if (Contacto.isPresent()){
            model.addAttribute("Contacto", Contacto.get());
            return "contacto";
        }
        return "contactos";
        
    }
    

}
