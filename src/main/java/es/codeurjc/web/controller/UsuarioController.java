package es.codeurjc.web.controller;

import es.codeurjc.web.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsuarioController {
    @Autowired
    private UsuarioRepository userRepository;

}
