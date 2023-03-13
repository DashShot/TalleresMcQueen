package es.codeurjc.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.codeurjc.web.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    @Query("select u from Usuario u where UPPER(u.nombre) LIKE UPPER(CONCAT ('%',?1,'%'))")
    List<Usuario> findByUsuario(String nombre);
    
    Usuario getByNombre(String nombre);
}
