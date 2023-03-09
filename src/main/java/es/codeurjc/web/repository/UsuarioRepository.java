package es.codeurjc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import antlr.collections.List;
import es.codeurjc.web.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
   // @Query("select u from User u where UPPER(u.nombre) LIKE UPPER(CONCAT ('%',?1,'%'))")
	//List<Usuario> findByUsuario(String texto);
    List<Usuario> findByUsuario(String nombre);
    //Usuario getByNombre(String nombre);
    
}
