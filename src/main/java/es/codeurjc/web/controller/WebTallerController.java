package es.codeurjc.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebTallerController {
    
    @ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
        
        //         SIN LOGIN DEMOMENTO 
		Principal principal = request.getUserPrincipal();  

		if (principal != null) {

			model.addAttribute("sesionIniciada", true);
		//	model.addAttribute("userName", principal.getName());
		//	model.addAttribute("admin", request.isUserInRole("ADMIN"));

		} else {
			model.addAttribute("sesionIniciada", false);
        }
    
	}

    //--------------- Pantalla inicial -----------------------------// 
    @GetMapping("/")
    public String inicio(Model model){

        //model.addAttribute("sesionIniciada",false);
        
        return "inicio";
    }

    //------------------------ Login ---------------------------------------//
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/")
    public String loginCorrecto(Model model){
        //model.addAttribute("sesionIniciada",true);
        return "inicio";
    }

    @GetMapping("/loginerror")
    public String loginerror(){
        return "loginerror";
    }
    //------------------ Registro -----------------------------------//

   
}
