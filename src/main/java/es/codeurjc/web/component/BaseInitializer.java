package es.codeurjc.web.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import es.codeurjc.web.models.Contactos;
import es.codeurjc.web.models.Mecanico;
import es.codeurjc.web.models.Reparacion;
import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.models.Valoraciones;
import es.codeurjc.web.service.MecanicoService;
import es.codeurjc.web.service.ReparacionService;
import es.codeurjc.web.service.UsuarioService;
import es.codeurjc.web.service.ValoracionesService;
import es.codeurjc.web.service.ContactosService;


@Component
public class BaseInitializer implements CommandLineRunner {

    @Autowired
    private MecanicoService mecanicoService;

    @Autowired
    private ReparacionService reparacionService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ValoracionesService valoracionesService;

    @Autowired
    private ContactosService contactosService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        insertMecanicos();
        insertReparaciones();
        insertUsuarios();
        insertValoraciones();
        insertContactos();
    }


    private Usuario user1 = new Usuario("Pedro", "contrasena1", "USER");
	private Usuario user2 =new Usuario("Maria", "contrasena2", "USER");
	private Usuario user3 =new Usuario("Juan", "contrasena1", "USER");
	private Usuario user4 =new Usuario("Jose", "contrasena2", "USER");
	private Usuario user5 =new Usuario("Jose", "contrasena1", "USER");
	private Usuario user6 =new Usuario("Aitor", "contrasena2", "USER");
	private Usuario user7 =new Usuario("Alejandro", "contrasena3", "USER");
	private Usuario user8 =new Usuario("JoseLuis", "contrasena4", "USER");


    private void insertMecanicos() {
        mecanicoService.save(new Mecanico("Juan Pérez"));
        mecanicoService.save(new Mecanico("María González"));
        mecanicoService.save(new Mecanico("Pedro García"));
        mecanicoService.save(new Mecanico("Laura Fernández"));
        mecanicoService.save(new Mecanico("Carlos Ruiz"));
        mecanicoService.save(new Mecanico("Ana López"));
        mecanicoService.save(new Mecanico("José Martínez"));
        mecanicoService.save(new Mecanico("Sara Sánchez"));
    }

    private void insertReparaciones() {
        reparacionService.save(new Reparacion(user1, "Cambio de aceite", 60));
        reparacionService.save(new Reparacion(user2, "Reparación de frenos", 120));
        reparacionService.save(new Reparacion(user3, "Cambio de neumáticos", 90));
        reparacionService.save(new Reparacion(user4, "Reparación de la suspensión", 180));
        reparacionService.save(new Reparacion(user5, "Reparación de motor", 240));
        reparacionService.save(new Reparacion(user6, "Reparación de transmisión", 240));
        reparacionService.save(new Reparacion(user7, "Cambio de aceite", 120));
        reparacionService.save(new Reparacion(user8, "Reparación de sistemas electrónicos", 60));
    }

    private void insertUsuarios() {
        usuarioService.save(user1);
        usuarioService.save(user2);
        usuarioService.save(user3);
        usuarioService.save(user4);
        usuarioService.save(user5);
        usuarioService.save(user6);
        usuarioService.save(user7);
        usuarioService.save(user8);
     }

     private void insertValoraciones() {
	valoracionesService.save(new Valoraciones(user1, "Excelente servicio, personal amable y trabajo impecable. Recomendado", 5));
	valoracionesService.save(new Valoraciones(user2, "Buen trabajo, pero precios un poco altos. Personal amable.", 4));
	valoracionesService.save(new Valoraciones(user3, "Problemas con reparación, personal sin conocimiento técnico. Mala experiencia.", 2));
	valoracionesService.save(new Valoraciones(user4, "No recomendaría este taller. Personal poco amable, trabajo de baja calidad y precios altos.", 1));
	valoracionesService.save(new Valoraciones(user5, "Satisfecho con servicio. Personal profesional y trabajo de alta calidad. Volveré.", 5));
	valoracionesService.save(new Valoraciones(user6, "Experiencia positiva. Personal amable, precios razonables y trabajo excelente. Recomendado", 5));
	valoracionesService.save(new Valoraciones(user7, "No completamente satisfecho con reparación. Personal amable, pero problemas no resueltos.", 3));
	valoracionesService.save(new Valoraciones(user8, "Increíble taller, personal extremadamente amable y trabajo excepcional. Altamente recomendado.", 5));

     }

     private void insertContactos(){
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








