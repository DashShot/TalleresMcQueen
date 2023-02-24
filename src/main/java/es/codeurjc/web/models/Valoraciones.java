package es.codeurjc.web.models;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.stereotype.Indexed;
//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Valoraciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JsonIgnore
    private Usuario usuario;

    private Reparacion reparacion;
    
    private String texto;
    private int puntuacion; //Las valoraciones va acompañado de un texto y un numero de 1 - 10

    public Valoraciones(){}
    public Valoraciones (Usuario usuario,Reparacion reparacion, String texto, int puntuacion){
        super();
        this.usuario = usuario;
        this.reparacion = reparacion;
        this.texto = texto;
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario(){return usuario;}
    public Reparacion getReparacion(){return reparacion;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
    public String getTexto(){return texto;}
    public void setTexto(String texto){this.texto =texto;}
    public int getPuntuacion(){return puntuacion;}
    public void setPuntuacion(int puntuacion){this.puntuacion = puntuacion;}

    @Override
    public String toString(){
        return this.usuario.toString() + "\n ->Comentario: "+ this.texto +"\n ->Puntuacion: "+ this.puntuacion;
    }
}
