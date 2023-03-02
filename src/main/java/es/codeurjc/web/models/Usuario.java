package es.codeurjc.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Nombre")
    private String nombre;

    private String contrasena;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL ,orphanRemoval = true) //Cambiar en valoraciones
    private List<Valoraciones> listaValoraciones;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<Reparacion> listaReparaciones;


    public Usuario(){}
    public Usuario(String nombre, String contrasena, String... roles){
        super();
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.roles = List.of(roles);
    }
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    public String getNombre(){return nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getContrasena(){return contrasena;}
    public void setContrasena(String contrasena){this.contrasena = contrasena;}
    public List<String> getRoles(){ return this.roles;}
    public void setRoles(List<String> roles){this.roles = roles;}

    //Listas de valoraciones
    public List<Valoraciones> getValoraciones(){return listaValoraciones;}
    public void addValoraciones(Valoraciones aux){
        listaValoraciones.add(aux);
        aux.setUsuario(this);
    }
    public void remuveValoraciones(Valoraciones aux){
        listaValoraciones.remove(aux);
        aux.setUsuario(null);
    }
     //Listas de Reparaciones
     public List<Reparacion> getReparaciones(){return listaReparaciones;}
     public void addReparaciones(Reparacion aux){
         listaReparaciones.add(aux);
         aux.setUsuario(this);
     }
     public void remuveReparaciones(Reparacion aux){
         listaReparaciones.remove(aux);
         aux.setUsuario(null);
     }
    
    @Override
    public String toString(){
        return "Nombre de usuario: " + nombre;
    }
    

}
