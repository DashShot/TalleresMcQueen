package es.codeurjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.web.service.ReparacionService;

@Controller
public class ReparacionController {
    
  @Autowired
  private ReparacionService reparacionService;

  @GetMapping("/Reparaciones")
  public String reparaciones(Model model){
      model.addAttribute("Reparaciones", reparacionService.)
  }
}
