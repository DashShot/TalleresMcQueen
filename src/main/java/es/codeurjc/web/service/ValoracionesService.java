package es.codeurjc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.repository.ValoracionesRepository;

@Service
public class ValoracionesService {
    @Autowired
    private ValoracionesRepository valoracionesRepository;
}
