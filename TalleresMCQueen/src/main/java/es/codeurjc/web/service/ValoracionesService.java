package es.codeurjc.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.models.Valoraciones;
import es.codeurjc.web.repository.ValoracionesRepository;


@Service
public class ValoracionesService {
    @Autowired
    private ValoracionesRepository valoracionesRepository;
    
    public Optional<Valoraciones> findbyID(Long id){
        return valoracionesRepository.findById(id);
    }
    public List<Valoraciones> findAll(){
        return valoracionesRepository.findAll();
    } 
    
    public boolean exist(long id) {
		return valoracionesRepository.existsById(id);
	}

	public void save(Valoraciones valoraciones) {
		valoracionesRepository.save(valoraciones);
	}

	public void delete(long id) {
		valoracionesRepository.deleteById(id);
	}
}
