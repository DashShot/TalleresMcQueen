package es.codeurjc.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.codeurjc.web.models.Valoraciones;
import es.codeurjc.web.service.ValoracionesService;

@Controller
public class ValoracionesController {
    @Autowired
    private ValoracionesService valoracionesService;

    @GetMapping("/crear-valoracion{id}")
    public String crearValoracion(Model model){
        model.addAttribute("valoraciones",valoracionesService.findAll());
        return "valoraciones/nueva_valoracion";
    }

    @GetMapping("/crear-valoracion/valoracion-creada/{id}")
    public String ratingCreate(Model model){
        model.addAttribute("valoraciones",valoracionesService.findAll());
        return "valoraciones/solicitud_completada";
    }

    @GetMapping("/ver-valoraciones/{id}")
    public String mostrarContacto(Model model, @PathVariable long id){
        Optional<Valoraciones> valoracion = valoracionesService.findbyID(id);
        if (valoracion.isPresent()){
            model.addAttribute("valoraciones", valoracion.get());
            return "valoraciones";
        }
        return "ver_valoraciones";
    }
}
