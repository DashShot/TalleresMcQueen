package es.codeurjc.InternalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.utils.SerializationUtils;

import es.codeurjc.web.models.Usuario;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.tools.json.JSONWriter;

@Component
public class Producer {
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    //@Scheduled(fixedRate = 5000)
    /* 
	public void sendCompra(String usu, Double precio){
        String email = usu;
        String asunto = "Compra realizada";
        String texto = "Usted ha realizado correctamente una compra en Massive Gaming por " + precio.toString()+ "€";
        //Mensaje mens = new Mensaje(email,asunto,texto);
        //byte[] data = SerializationUtils.serialize(mens);
        String allTogether = email + "//" + asunto + "//" + texto;
        rabbitTemplate.convertAndSend("mensajes", allTogether);
        System.out.println("Mensaje Enviado");
	}
    */
	
	public void sendNuevaCuenta(Usuario usu){
        String email = usu.getCorreo();
        String asunto = "Nueva Cuenta";
        String texto = usu.getNombre() + " su cuenta ha sido creada correctamente.";
        //Mensaje mens = new Mensaje(email,asunto,texto);
        //byte[] data = SerializationUtils.serialize(mens);
        String allTogether = email + "//" + asunto + "//" + texto;
        rabbitTemplate.convertAndSend("mensajes", allTogether);
        System.out.println("Mensaje Enviado");
	}
    /* 
	public void sendDatosModificados(Usuario usu){
        String email = usu.getCorreo();
        String asunto = "Datos de la cuenta actualizados";
        String texto = "Datos actualizados:\nNombre: "+usu.getNombre();
        //Mensaje mens = new Mensaje(email,asunto,texto);
        //byte[] data = SerializationUtils.serialize(mens);
        String allTogether = email + "//" + asunto + "//" + texto;
        rabbitTemplate.convertAndSend("mensajes", allTogether);
        System.out.println("Mensaje Enviado");
	}
    */

}