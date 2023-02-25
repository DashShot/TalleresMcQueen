package es.codeurjc.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import es.codeurjc.web.models.Contactos;
import es.codeurjc.web.repository.ContactosRepository;

@Service
public class ContactosService {
    
    @Autowired
    private ContactosRepository contactosRepository;
    
    public Optional<Contactos> findbyID(Long id){
        return contactosRepository.findById(id);
    }
    public List<Contactos> findAll(){
        return contactosRepository.findAll();
    } 

    public boolean exist(long id) {
		return contactosRepository.existsById(id);
	}

	public void save(Contactos book) {
		contactosRepository.save(book);
	}

	public void delete(long id) {
		contactosRepository.deleteById(id);
	}
}
