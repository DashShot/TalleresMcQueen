package es.codeurjc.web.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.cj.jdbc.Blob;



@Entity
//@Table
public class Reparacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany(mappedBy = "nombre", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Mecanico> listamecanico;

    @Column(columnDefinition = "TEXT")
    private String tipo;

    private long tiempo;
    
    @Lob
    @JsonIgnore
    private Blob imageFile;

    

    public Reparacion(){}
    public Reparacion(Usuario usuario,String tipo,long tiempo){
        super();
        this.tipo = tipo;
        this.usuario = usuario;
        this.tiempo = tiempo;
    }
 
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public Usuario getUsuario(){return usuario;}
    public void setUsuario(Usuario usuario){ this.usuario = usuario;}
    public long getTiempo(){return tiempo;}
    public void setTiempo(long tiempo){this.tiempo = tiempo;}
    public Blob getImagen(){return this.imageFile;}
    public void setImagen(Blob imagen){ this.imageFile = imagen;}
    public String getTipo(){ return this.tipo;}
    public void setTipo(String tipo){ this.tipo = tipo;}

    public List<Mecanico> getMecanicos(){return listamecanico;}
    public void setMecanicos(List<Mecanico> listameMecanicos){ this.listamecanico = listameMecanicos;}
   
    public void addMecanico(Mecanico aux){
        listamecanico.add(aux);
        aux.getReparaciones().add(this); //ManyToMany Mapped-by: Reparacion
    }
    public void remuveMecanico(Mecanico aux){
         listamecanico.remove(aux);
         aux.getReparaciones().remove(null); //ManyToMany
    }
    
    @Override
    public String toString(){
        return("Reparacion: " + id);
    }

}
