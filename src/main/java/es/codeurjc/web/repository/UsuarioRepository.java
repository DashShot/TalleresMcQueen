package es.codeurjc.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.codeurjc.web.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
   // @Query("select u from Usuario u where UPPER(u.nombre) LIKE UPPER(CONCAT ('%',?1,'%'))")
    
  // Optional<Usuario> findByNombre(String nombre);
    
   Usuario getByNombre(String nombre);
}
