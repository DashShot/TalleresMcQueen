package es.codeurjc.web.controller;

import org.springframework.stereotype.Controller;

import es.codeurjc.web.service.ValoracionesService;

@Controller
public class ValoracionesController {
    @Autowired
    private ValoracionesService valoracionesService;

    @GetMapping("/post/crear-valoracion{id}")
    public String crearValoracion(Model model){
        model.addAttribute("valoraciones",valoracionesService.findAll());
        return "valoraciones/nueva_valoracion";
    }

    @GetMapping("post/crear-valoracion/valoracion-creada/{id}")
    public String ratingCreate(Model model){
        model.addAttribute("valoraciones",valoracionesService.findAll());
        return "valoraciones/solicitud_completada";
    }

    @GetMapping("/post/ver-valoraciones/{id}")
    public String mostrarContacto(Model model, @PathVariable long id){
        Optional<Contactos> Contacto = contactosService.findbyID(id);
        if (Contacto.isPresent()){
            model.addAttribute("Contacto", Contacto.get());
            return "Contacto";
        }
        return "ver_valoraciones";
    }
}
