package es.codeurjc.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.web.models.Reparacion;

public interface ReparacionesRepository extends JpaRepository<Reparacion, Long>{
    
}
