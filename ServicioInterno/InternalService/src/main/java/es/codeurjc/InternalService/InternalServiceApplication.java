package main.java.es.codeurjc.InternalService;

@SpringBootApplication
@EnableScheduling
public class InternalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalServiceApplication.class, args);
	}
	@Bean
	public Queue myQueue() {
    	return new Queue("mensajes", false);
	}
}