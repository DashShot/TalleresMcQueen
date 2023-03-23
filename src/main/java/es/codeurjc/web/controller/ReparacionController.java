package es.codeurjc.web.controller;



import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.repository.ReparacionesRepository;
import es.codeurjc.web.repository.UsuarioRepository;
import es.codeurjc.web.service.ReparacionService;


@Controller
public class ReparacionController {
    
  @Autowired
  private ReparacionService reparacionService;
  @Autowired
  private ReparacionesRepository reparacionesRepository;

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
          model.addAttribute("userName", "Invitado");
          model.addAttribute("admin", request.isUserInRole("ADMIN"));
      }
  }

//--------------------- Reparaciones Realizadas ---------------------------//
  @GetMapping("/reparaciones")
  public String reparaciones(Model model){
      model.addAttribute("reparaciones", reparacionService.findAll());
      return "reparaciones/ver_reparaciones";

  }
// ------------------------- Realizar una Nueva Reparación --------------------//

  @GetMapping("/reparaciones/nuevareparacion")
  public String nuevareparacion(){
    return "reparaciones/nueva_reparacion";
  }


  @PostMapping("/reparaciones/nuevareparacion")
  public String reparacion(@RequestParam Integer num, @RequestParam String resultado, HttpServletRequest req){
  
      Reparacion reparacion = new Reparacion(num, resultado);
      String nombre =req.getUserPrincipal().getName();
      Usuario u = usuarioRepository.getByNombre(nombre);

      usuarioRepository.getByNombre(nombre).addReparaciones(reparacion);
      reparacion.setUsuario(u);

      reparacionesRepository.save(reparacion);

    
    return "redirect:/reparaciones";
  }
  /* 
 
  @GetMapping ("/Reparaciones/{id}")//cambiar por {id}
  public String verReparacion(Model model, @PathVariable long id){
    return "reparaciones/reparando";
  }

  */
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
