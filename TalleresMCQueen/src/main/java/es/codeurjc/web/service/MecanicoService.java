package es.codeurjc.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.models.Mecanico;

import es.codeurjc.web.repository.MecanicoRepository;
@Service
public class MecanicoService {

    @Autowired
    private MecanicoRepository mecanicoRepository;

    public Optional<Mecanico> findbyID(Long id){
        return mecanicoRepository.findById(id);
    }
    public List<Mecanico> findAll(){
        return mecanicoRepository.findAll();
    } 

    public boolean exist(long id) {
		return mecanicoRepository.existsById(id);
	}

	public void save(Mecanico mecanico) {
		mecanicoRepository.save(mecanico);
	}

	public void delete(long id) {
		mecanicoRepository.deleteById(id);
	}
    
}
