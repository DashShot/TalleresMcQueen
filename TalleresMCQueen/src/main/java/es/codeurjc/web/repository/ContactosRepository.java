package es.codeurjc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.web.models.Contactos;

public interface ContactosRepository extends JpaRepository<Contactos, Long>{
    
}
