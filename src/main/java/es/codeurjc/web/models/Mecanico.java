package es.codeurjc.web.models;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.stereotype.Indexed;
//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mecanico {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String apellidos;
    private List<Reparacion> listaReparaciones = new ArrayList<>();

    public Mecanico(){}
    public Mecanico(String nombre, String apellidos){
        this.nombre = nombre;

    }
    public List<Reparacion> getReparaciones(){return listaReparaciones;}
    public void addReparacion(Reparacion aux){
        listaReparaciones.add(aux);
    }
    public void remuveReparacion(Reparacion aux){
         listaReparaciones.remove(aux);
      //   aux.setReparacion(null);
    }
    

}