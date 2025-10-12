package com.rdfj;

import java.io.Reader;

import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

public class Main {

	public static void main(String[]args) {
		String servidor = "pop.gmail.com";
		String usuario = "ejemplo@gmail.com";
		String contraseña = "1234";
		
		try {
			POP3SClient cliente = new POP3SClient(true);
			cliente.setDefaultTimeout(1000);
			cliente.connect(servidor);
			
			System.out.println("Conexion establecida");
			
			Boolean login = cliente.login(usuario, contraseña);
			System.out.println("Login: " +(login?"valido":"rechazado"));
			
			if (login) {
				POP3MessageInfo[] mensajeInfo = cliente.listMessages();
				
				if (mensajeInfo != null) {
					
					for(POP3MessageInfo mensaje : mensajeInfo) {
						System.out.println("==============Inicio mensaje==============" +mensaje.number);
						System.out.println(mensaje.number + "-" + mensaje.size);
						System.out.println("------------------------------------------");
						Reader reader = cliente.retrieveMessageTop(mensaje.number, 1);
						char[] texto = new char[200];
						System.out.println("[");
						while (reader.read(texto)!= -1) {
							System.out.println(new String (texto));
							
						}
						System.out.println("]\n");
						System.out.println("==============Inicio mensaje==============" +mensaje.number);
					}
				}
				
			}
			cliente.logout();
			cliente.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
