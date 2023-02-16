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
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String contrasena;
    private List<Valoraciones> listaValoraciones = new ArrayList<>();
    private List<Reparacion> listaReparaciones = new ArrayList<>();

    public Usuario(){}
    public Usuario(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getContrasena(){return contrasena;}
    public void setContrasena(String contrasena){this.contrasena = contrasena;}
    

    //Listas de valoraciones
    public List<Valoraciones> getValoraciones(){return listaValoraciones;}
    public void addValoraciones(Valoraciones aux){
        listaValoraciones.add(aux);
        aux.setUsuario(this);
    }
    public void remuveValoraciones(Valoraciones aux){
        listaValoraciones.remove(aux);
        aux.setUsuario(null);
    }
     //Listas de Reparaciones
     public List<Reparacion> getReparaciones(){return listaReparaciones;}
     public void addReparaciones(Reparacion aux){
         listaReparaciones.add(aux);
         aux.setUsuario(this);
     }
     public void remuveReparaciones(Reparacion aux){
         listaReparaciones.remove(aux);
         aux.setUsuario(null);
     }
    
    @Override
    public String toString(){
        return "Nombre de usuario: " + nombre;
    }
    

}
