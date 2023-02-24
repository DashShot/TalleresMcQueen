package es.codeurjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.codeurjc.web.service.MecanicoService;

@Controller
public class MecanicoController {
    
    @Autowired
    private MecanicoService mecanicoService;


}
