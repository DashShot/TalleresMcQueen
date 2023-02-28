package es.codeurjc.web.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;


//import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.service.ReparacionService;

@Controller
public class ReparacionController {
    
  @Autowired
  private ReparacionService reparacionService;

  @GetMapping("/Reparacion")
  public String reparaciones(Model model){
      model.addAttribute("reparaciones", reparacionService.findAll());
      return "reparaciones/ver_reparaciones";

  }



  @GetMapping("/Reparacion/HacerReparacion")
    public String nuevaReparacion() {
        
      return "reparaciones/nueva_reparacion";
    }

  /* 
  @GetMapping("/{id}")
  public String verReparacion(Model model, @PathVariable long id){
    Optional<Reparacion> reparacion = reparacionService.findbyID(id);
    if (reparacion.isPresent()){
        model.addAttribute("reparacion", reparacion.get());
        model.addAttribute("Imagen", reparacion.get().getImagen());
        return "reparacion";
    }
    return "reparaciones";
  }
*/

  /*   @PostMapping("/guardar_reparacion")
    public String guardarReparacion(@ModelAttribute Reparacion reparacion) {
        reparacionService.save(reparacion);
        return "redirect:/reparaciones";
    }
  */
}
