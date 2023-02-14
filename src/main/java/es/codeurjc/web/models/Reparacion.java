package es.codeurjc.web.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reparacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private Usuario usuario;
    private List<Mecanico> listamecanico = new ArrayList<>();
    private long tiempo;

    public Reparacion(){}
    public Reparacion(Usuario usuario,long tiempo){
        this.usuario = usuario;
        this.tiempo = tiempo;
    }
 
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){ this.usuario = usuario;}
    public long getTiempo(){return tiempo;}
    public void setTiempo(long tiempo){this.tiempo = tiempo;}
    
    public List<Mecanico> getMecanicos(){return listamecanico;}
    public void addMecanico(Mecanico aux){
        listamecanico.add(aux);
   //     aux.setReparacion(this);
    }
    public void remuveMecanico(Mecanico aux){
         listamecanico.remove(aux);
    //     aux.setReparacion(null);
    }
    

}
