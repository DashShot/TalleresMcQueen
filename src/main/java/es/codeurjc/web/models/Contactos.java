package es.codeurjc.web.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.stereotype.Indexed;

//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Contactos {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String direccion;
    private String email;
    private long telefono;

    @ManyToMany
    private List<Mecanico> listamecanico;


    public Contactos(){}
    public Contactos(String direccon,String email, long telefono){
        super();
        this.direccion = direccon;
        this.email = email;
        this.telefono = telefono;
    }
    public String getDireccion(){return direccion;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public long getTelefono(){return telefono;}
    public void setTelefono(long telefono){this.telefono = telefono;}
      
    public List<Mecanico> getMecanicos(){return listamecanico;}
    public void addMecanico(Mecanico aux){
        listamecanico.add(aux);
   //     aux.setReparacion(this);
    }
    public void remuveMecanico(Mecanico aux){
         listamecanico.remove(aux);
    //     aux.setReparacion(null);
    }
    
    
    @Override
    public String toString(){
        return this.toString() + "Email del usuario: "+ email + "/ Telefono del usuario: "+ telefono;
    }

}