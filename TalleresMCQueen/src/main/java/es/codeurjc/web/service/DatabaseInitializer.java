package es.codeurjc.web.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import es.codeurjc.web.models.Contactos;
import es.codeurjc.web.models.Mecanico;
import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.models.Valoraciones;

@Service
public class DatabaseInitializer {
    @Autowired
    private MecanicoService mecanicoService;

    @Autowired
    private ReparacionService reparacionService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValoracionesService valoracionesService;

    @Autowired
    private ContactosService contactosService;

    @PostConstruct
    public void init() throws IOException, URISyntaxException{

        Usuario user1 = new Usuario("Pedro", passwordEncoder.encode("pass1"),"correo1", "USER");
        Usuario user2 =new Usuario("Maria", passwordEncoder.encode("pass2"), "correo2","USER");
        Usuario user3 =new Usuario("Juan", passwordEncoder.encode("pass3"), "correo3","USER");
        Usuario user4 =new Usuario("Jose", passwordEncoder.encode("pass4"), "correo4","USER");
        Usuario user5 =new Usuario("Jose", passwordEncoder.encode("pass5"), "correo5","USER");
        Usuario user6 =new Usuario("Aitor", passwordEncoder.encode("pass6"), "correo6","USER");
        Usuario user7 =new Usuario("Alejandro", passwordEncoder.encode("pass7"), "correo7","USER");
        Usuario user8 =new Usuario("JoseLuis", passwordEncoder.encode("pass8"), "correo8","USER");

        Usuario admin = new Usuario("Admin",passwordEncoder.encode("admin"),"ADMIN");

        usuarioService.save(user1);
        usuarioService.save(user2);
        usuarioService.save(user3);
        usuarioService.save(user4);
        usuarioService.save(user5);
        usuarioService.save(user6);
        usuarioService.save(user7);
        usuarioService.save(user8);
        usuarioService.save(admin);


        mecanicoService.save(new Mecanico("Juan Pérez"));
        mecanicoService.save(new Mecanico("María González"));
        mecanicoService.save(new Mecanico("Pedro García"));
        mecanicoService.save(new Mecanico("Laura Fernández"));
        mecanicoService.save(new Mecanico("Carlos Ruiz"));
        mecanicoService.save(new Mecanico("Ana López"));
        mecanicoService.save(new Mecanico("José Martínez"));
        mecanicoService.save(new Mecanico("Sara Sánchez"));
    
        reparacionService.save(new Reparacion(user1, "Cambio de aceite", 60));
        reparacionService.save(new Reparacion(user2, "Reparación de frenos", 120));
        reparacionService.save(new Reparacion(user3, "Cambio de neumáticos", 90));
        reparacionService.save(new Reparacion(user4, "Reparación de la suspensión", 180));
        reparacionService.save(new Reparacion(user5, "Reparación de motor", 240));
        reparacionService.save(new Reparacion(user6, "Reparación de transmisión", 240));
        reparacionService.save(new Reparacion(user7, "Cambio de aceite", 120));
        reparacionService.save(new Reparacion(user8, "Reparación de sistemas electrónicos", 60));
    

        
     
        valoracionesService.save(new Valoraciones(user1, "Excelente servicio, personal amable y trabajo impecable. Recomendado", 5));
        valoracionesService.save(new Valoraciones(user2, "Buen trabajo, pero precios un poco altos. Personal amable.", 4));
        valoracionesService.save(new Valoraciones(user3, "Problemas con reparación, personal sin conocimiento técnico. Mala experiencia.", 2));
        valoracionesService.save(new Valoraciones(user4, "No recomendaría este taller. Personal poco amable, trabajo de baja calidad y precios altos.", 1));
        valoracionesService.save(new Valoraciones(user5, "Satisfecho con servicio. Personal profesional y trabajo de alta calidad. Volveré.", 5));
        valoracionesService.save(new Valoraciones(user6, "Experiencia positiva. Personal amable, precios razonables y trabajo excelente. Recomendado", 5));
        valoracionesService.save(new Valoraciones(user7, "No completamente satisfecho con reparación. Personal amable, pero problemas no resueltos.", 3));
        valoracionesService.save(new Valoraciones(user8, "Increíble taller, personal extremadamente amable y trabajo excepcional. Altamente recomendado.", 5));

     

        contactosService.save(new Contactos("Calle 1 - Ciudad 1", "contacto1@example.com", 123456789));
        contactosService.save(new Contactos("Calle 2 - Ciudad 1", "contacto2@example.com", 223456789));
        contactosService.save(new Contactos("Calle 3 - Ciudad 1", "contacto3@example.com", 323456789));
        contactosService.save(new Contactos("Calle 4 - Ciudad 1", "contacto4@example.com", 423456789));
        contactosService.save(new Contactos("Calle 5 - Ciudad 1", "contacto5@example.com", 523456789));
        contactosService.save(new Contactos("Calle 6 - Ciudad 1", "contacto6@example.com", 623456789));
        contactosService.save(new Contactos("Calle 7 - Ciudad 1", "contacto7@example.com", 723456789));
        contactosService.save(new Contactos("Calle 8 - Ciudad 1", "contacto8@example.com", 823456789));

    }
}
