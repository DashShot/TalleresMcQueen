package es.codeurjc.web.repository;

import java.util.List;



import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.codeurjc.web.models.Valoraciones;

@CacheConfig(cacheNames="valoraciones")
@Repository
public interface ValoracionesRepository extends  JpaRepository<Valoraciones, Long>{
   
    @CacheEvict(allEntries = true)
    Valoraciones save(Valoraciones valoracion);


    void delete(Valoraciones valoracion);

    @Cacheable
    Valoraciones getValoracionesByTexto(String texto);
 
    @Cacheable
    List<Valoraciones> findByTexto(String texto);

    
} 
