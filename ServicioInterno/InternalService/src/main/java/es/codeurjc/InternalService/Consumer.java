package main.java.es.codeurjc.InternalService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	@Autowired
	EmailSenderService emailService;
	
	@RabbitListener(queues = "mensajes", ackMode = "AUTO")
	public void recv (String message){
		//Mensaje mens = (Mensaje)SerializationUtils.deserialize(message);
		String parts[] = message.split("//");
 		emailService.sendSimpleEmail(parts[0], parts[1], parts[2]);
 		//emailService.sendSimpleEmail("ikersuarez01@gmail.com", "prueba", "eres la ostia");
//		for(int i = 0; i < 3; i++)
//			System.out.println("Mensaje recibido: " + parts[i]);
	}
}