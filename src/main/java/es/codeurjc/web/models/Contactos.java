package es.codeurjc.web.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Contactos {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) ///EXISTEN VARIOS TALLERESX
    private long id;

    private String direccion;
    private String email;
    private long telefono;

    @OneToMany(mappedBy = "Mecanicos")
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
    }
    public void remuveMecanico(Mecanico aux){
         listamecanico.remove(aux);
    }
    
    
    @Override
    public String toString(){
        return this.toString() + "Email del taller: "+ email + "/ Telefono del taller: "+ telefono;
    }

}