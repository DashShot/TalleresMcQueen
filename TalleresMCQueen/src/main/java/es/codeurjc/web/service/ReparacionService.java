package es.codeurjc.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.repository.ReparacionesRepository;

@Service
public class ReparacionService {
    @Autowired
    private ReparacionesRepository reparacionesRepository;

    public Optional<Reparacion> findbyID(Long id){
        return reparacionesRepository.findById(id);
    }
    public List<Reparacion> findAll(){
        return reparacionesRepository.findAll();
    } 

    public boolean exist(long id) {
		return reparacionesRepository.existsById(id);
	}

	public void save(Reparacion reparacion) {
		reparacionesRepository.save(reparacion);
	}

	public void delete(long id) {
		reparacionesRepository.deleteById(id);
	}
}
