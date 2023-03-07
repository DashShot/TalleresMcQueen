package es.codeurjc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.web.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
   // @Query("select u from User u where UPPER(u.nombre) LIKE UPPER(CONCAT ('%',?1,'%'))")
	//List<Usuario> findByUsuario(String texto);
    
    Usuario getByNombre(String nombre);
    
}
