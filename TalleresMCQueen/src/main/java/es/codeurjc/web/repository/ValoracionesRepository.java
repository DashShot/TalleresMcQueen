package es.codeurjc.web.repository;

import java.util.List;

import javax.persistence.Cacheable;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codeurjc.web.models.Valoraciones;

@CacheConfig(cacheNames="valoraciones")
@Repository
public interface ValoracionesRepository extends  JpaRepository<Valoraciones, Long>{
    @CacheEvict(key = "#valoracion.getTexto()")
    Valoraciones save(Valoraciones valoracion);

    @CacheEvict(key = "#valoracion.getTexto()")
    void delete(Valoraciones valoracion);

    Valoraciones getValoracionesByTexto(String texto);
 
    @Cacheable
    List<Valoraciones> findByTexto(String texto);

    
} 
