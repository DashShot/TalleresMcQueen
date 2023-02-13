package es.codeurjc.web.controller;
/* 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.codeurjc.web.service.McQueenService;
/*
@Controller
public class McQueenWebController {

    @Autowired
    private McQueenService mcQueenService;
   
    
    
}

@GetMapping("/")
public String showReparaciones(Model model){
    model.addAttribute(attributeName: "Reparaciones", McQueenService.findAll());
}

@GetMapping("/reparaciones/{id}")
public String showReparacion(Model model, @PathVariable long id){
    
}