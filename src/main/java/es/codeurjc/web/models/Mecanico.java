package es.codeurjc.web.models;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.stereotype.Indexed;
//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonIgnore;


public class Mecanico {
    
    private long id;
    private String nombre;
    private String apellidos;
    private Reparacion reparacion;

    public Mecanico(){}
    public Mecanico(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    

}