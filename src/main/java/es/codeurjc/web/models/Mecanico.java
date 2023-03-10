package es.codeurjc.web.models;


import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mecanico {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
  
    @ManyToMany
    @JsonIgnore
    private List<Reparacion> listaReparaciones;

    public Mecanico(){}
    public Mecanico(String nombre){
        super();
        this.nombre = nombre;

    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public List<Reparacion> getReparaciones(){return listaReparaciones;}
    public void setReparaciones(List<Reparacion> listaReparaciones){this.listaReparaciones = listaReparaciones;}
    
    public void addReparacion(Reparacion aux){
        listaReparaciones.add(aux);
    }

    public void remuveReparacion(Reparacion aux){
         listaReparaciones.remove(aux);
    }
    
    @Override
    public String toString(){
        return ("Mecanico: "+ nombre);
    }

}