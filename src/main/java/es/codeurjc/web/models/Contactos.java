package es.codeurjc.web.models;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.stereotype.Indexed;

//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonIgnore;


public class Contactos extends Usuario {
    
    private String email;
    private long telefono;

    public Contactos(){}
    public Contactos(String email, long telefono){
        super();
        this.email = email;
        this.telefono = telefono;
    }
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public long getTelefono(){return telefono;}
    public void setTelefono(long telefono){this.telefono = telefono;}
    
    @Override
    public String toString(){
        return this.toString() + "Email del usuario: "+ email + "/ Telefono del usuario: "+ telefono;
    }

}