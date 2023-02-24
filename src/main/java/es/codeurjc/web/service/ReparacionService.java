package es.codeurjc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.repository.ReparacionesRepository;

@Service
public class ReparacionService {
    @Autowired
    private ReparacionesRepository reparacionesRepository;
}
