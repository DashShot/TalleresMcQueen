package es.codeurjc.web.controller;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.sql.SQLException;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.jdbc.Blob;

import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.service.ReparacionService;

@Controller
@RequestMapping("/reparaciones")
public class ReparacionController {
    
  @Autowired
  private ReparacionService reparacionService;

  @GetMapping
  public String reparaciones(Model model){
      model.addAttribute("reparaciones", reparacionService.findAll());
      return "reparaciones";
  }

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
  @GetMapping("/nueva_reparacion")
    public String nuevaReparacion(Model model) {
        model.addAttribute("reparacion", new Reparacion());
        return "nueva_reparacion";
    }

    @PostMapping("/guardar_reparacion")
    public String guardarReparacion(@ModelAttribute Reparacion reparacion) {
        reparacionService.save(reparacion);
        return "redirect:/reparaciones";
    }
  
}