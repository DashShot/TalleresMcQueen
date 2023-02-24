package es.codeurjc.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.models.Reparacion;

import es.codeurjc.web.repository.MecanicoRepository;
@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    public void repararCoche(Reparacion reparacion){

    }
    
}
