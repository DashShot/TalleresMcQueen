package es.codeurjc.web.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import es.codeurjc.web.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{ 
   Usuario getByNombre(String nombre);
}
