package es.codeurjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import es.codeurjc.web.service.ContactosService;

@Controller
public class ContactosController {
    
    @Autowired
    private ContactosService contactosService;

    @GetMapping
    
}
