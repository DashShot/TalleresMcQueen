package es.codeurjc.web.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;



@Entity
@Table
public class Reparacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private Usuario usuario;

    @ManyToMany
    private List<Mecanico> listamecanico;
    private long tiempo;
    
    @Lob
    @JsonIgnore
    private Blob imageFile;

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
