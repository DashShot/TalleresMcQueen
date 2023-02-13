package es.codeurjc.web.models;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.stereotype.Indexed;
//import javax.annotation.Generated;
//import com.fasterxml.jackson.annotation.JsonIgnore;

public class Valoraciones {
    //private long id;
    private Usuario usuario;
    private String texto;
    private int puntuacion; //Las valoraciones va acompañado de un texto y un numero de 1 - 10

    public Valoraciones(){}
    public Valoraciones (Usuario usuario, String texto, int puntuacion){
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
