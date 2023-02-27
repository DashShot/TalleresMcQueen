package es.codeurjc.web.models;

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
    
    private String texto;
    private int puntuacion; //Las valoraciones va acompañado de un texto y un numero de 1 - 10

    public Valoraciones(){}
    public Valoraciones (Usuario usuario, String texto, int puntuacion){
        super();
        this.usuario = usuario;
        this.texto = texto;
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario(){return usuario;}
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
