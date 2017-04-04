package practica1RO;

import java.io.IOException;

public class HiloCliente extends Thread {
	
	String tipo;
	int puerto;
	String ip_servidor;
	
	public HiloCliente(String tipo,String ip_servidor,int puerto){
		
		this.tipo=tipo;
		this.ip_servidor=ip_servidor;
		this.puerto=puerto;
	}

    public void run(){
    	
    	String respuesta=tipo;
    	 if (respuesta.equalsIgnoreCase("TCP")){
             ClienteTCP cli = null;
			try {
				cli = new ClienteTCP(ip_servidor,puerto);
				} 
			catch (IOException e) {
				e.printStackTrace();
			    } 
             System.out.println("\nIniciando cliente TCP \n");
             cli.startClient(); 
          }
    
         else if((respuesta.equalsIgnoreCase("UDP"))){
        	 ClienteUDP cli = null;
 			try {
 				cli = new ClienteUDP(ip_servidor,puerto);
 			    } 
 			catch (IOException e) {
 				e.printStackTrace();
 			} 
         System.out.println("\n Iniciando cliente UDP \n");
         cli.startClienteUDP(); //Se inicia el cliente  
        }
        else{System.out.println("\nProtocolo incorrecto");
         }
    }
  }