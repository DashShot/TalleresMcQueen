package es.codeurjc.web.controller;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.web.models.Usuario;
//import es.codeurjc.web.models.Usuario;
import es.codeurjc.web.models.Valoraciones;
import es.codeurjc.web.repository.UsuarioRepository;
import es.codeurjc.web.service.UsuarioService;
import es.codeurjc.web.service.ValoracionesService;
import io.micrometer.core.ipc.http.HttpSender.Response;

@Controller
public class ValoracionesController {
    @Autowired
    private ValoracionesService valoracionesService;
    @Autowired
    private UsuarioService usuarioService;

    //Todas las valoraciones
    @GetMapping("/Valoraciones")
    public String verValoraciones(Model model){
        model.addAttribute("valoraciones",valoracionesService.findAll());
        return "valoraciones/ver_valoraciones";
    }

     //Pagina de crear una Valoracion
     @GetMapping("/Valoraciones/CrearValoracion")
     public String crearValoracion(Model model){

        model.addAttribute("usuario", usuarioService.findAll());
         return "valoraciones/nueva_valoracion";
     }

     @PostMapping("/Valoraciones/CrearValoracion/Exito")
     public String  crearValoracion(@RequestParam Long usuarioID , Valoraciones valoraciones){
        
        valoraciones.setUsuario(usuarioService.findbyID(usuarioID).get());
        valoracionesService.save(valoraciones);
        
        return "redirect:/Valoraciones";
     }
/* 
    //Guardado de una Valoracion
    @PostMapping("/Valoraciones/CrearValoracion/Exito")
    public String crearValoracion(Model model , Valoraciones val){
       
       // valoracionesService.save(val);
     
        
        model.addAttribute("solicitud", "Valoracion registrada con Exito");

        return "valoraciones/solicitud_completada";
    }
    /* 
    @PostMapping("/Valoraciones/CrearValoracion/Exito")
    public String crearValoracion(Model model ,@RequestParam String usuario, @RequestParam String texto, @RequestParam String puntuacion, @){
    
        
        int puntos = Integer.parseInt(puntuacion);
        Usuario user = usuarioRepository.getByNombre(usuario); 
        Valoraciones val = new Valoraciones(user,texto,puntos);

        valoracionesService.save(val);

        user.addValoraciones(val);
        
        model.addAttribute("solicitud", "Valoracion registrada con Exito");

        return "valoraciones/solicitud_completada";
    }
    */


    

}
