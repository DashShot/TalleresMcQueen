package es.codeurjc.web.controller;

import es.codeurjc.web.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    
}
