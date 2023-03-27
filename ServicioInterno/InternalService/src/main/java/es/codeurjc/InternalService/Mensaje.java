package es.codeurjc.internalservice;

import java.io.Serializable;

public class Mensaje implements Serializable{
	
	String email;
	String asunto;
	String texto;
	
	public Mensaje(String email,String asunto,String texto) {
		this.email=email;
		this.asunto=asunto;
		this.texto=texto;
	}
}