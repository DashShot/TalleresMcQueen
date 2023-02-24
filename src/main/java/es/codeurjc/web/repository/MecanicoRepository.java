package es.codeurjc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.web.models.Mecanico;

public interface MecanicoRepository extends JpaRepository<Mecanico, Long>{
    
}
