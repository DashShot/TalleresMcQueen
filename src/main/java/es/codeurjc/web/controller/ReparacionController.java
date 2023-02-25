package es.codeurjc.web.controller;

import java.sql.SQLException;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.service.ReparacionService;

@Controller
public class ReparacionController {
    
  @Autowired
  private ReparacionService reparacionService;

  @GetMapping("/Reparaciones")
  public String reparaciones(Model model){
      model.addAttribute("Reparaciones", reparacionService.findAll());
      return "Reparaciones";
  }

  @GetMapping("/Reparaciones/{id}")
  public String verReparacion(Model model, @PathParam long id){
    Optional<Reparacion> Reparacion = reparacionService.findbyID(id);
    if (Reparacion.isPresent()){
        model.addAttribute("Reparacion", Reparacion.get());
        return "Reparacion";
    }
    return "Reparaciones";
  }

  @GetMapping("/Reparaciones/{id}/imagenes")
  public ResponseEntity<Object> verImagen(@PathVariable Long id) throws SQLException{

      Optional<Reparacion> Reparacion = reparacionService.findbyID(id);
      if (Reparacion.isPresent() && Reparacion.get().getImagenIni()){
        
      }
  }
}
