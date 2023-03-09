package es.codeurjc.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.repository.UsuarioRepository;

@Service
public class UserLoginService {
    
    @Autowired
    private UsuarioRepository userRepository;
    
    public Optional<Usuario> findbyID(Long id){
        return userRepository.findById(id);
    }
    public List<Usuario> findAll(){
        return userRepository.findAll();
    } 

    public boolean exist(long id) {
		return userRepository.existsById(id);
	}

	public void save(Usuario usuario) {
		userRepository.save(usuario);
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}
}
