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
import es.codeurjc.web.service.ReparacionService;
import es.codeurjc.web.service.UsuarioService;

@Controller
public class ReparacionController {
    
  @Autowired
  private ReparacionService reparacionService;
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
      }
  }

  @GetMapping("/reparaciones")
  public String reparaciones(Model model){
      model.addAttribute("reparaciones", reparacionService.findAll());
      return "reparaciones/ver_reparaciones";

  }

  @GetMapping("/reparaciones/nuevareparacion")
  public String nuevareparacion(Model model){
    model.addAttribute("usuario", usuarioService.findAll());
    return "reparaciones/nueva_reparacion";
  }




  @PostMapping("/reparaciones/nuevareparacion")
  public String reparacion(@RequestParam Long usuarioID ,@RequestParam String resultado, @RequestParam Integer num){
    Reparacion reparacion = new Reparacion();
    reparacion.setUsuario(usuarioService.findbyID(usuarioID).get());
    reparacion.setTipo(resultado);
    reparacion.setTiempo(num);

    reparacionService.save(reparacion);
    
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
