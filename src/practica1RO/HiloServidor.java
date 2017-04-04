package practica1RO;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HiloServidor extends Thread{
	
	protected String mensajeServidor,fichero;
	protected Socket cs; 
	protected ServerSocket ss; 
	protected DataOutputStream salidaServidor;
	
public HiloServidor(Socket cs,String mensajeServidor,ServerSocket ss,DataOutputStream salidaServidor,String fichero){
	
	this.fichero=fichero;
	this.cs=cs;
	this.mensajeServidor=mensajeServidor;
	this.ss=ss;
	this.salidaServidor=salidaServidor;
       }
public void run(){
	              try{
	            	  
	                int y=0;
	            	DataInputStream entradaServidor = new DataInputStream(cs.getInputStream());
	  	        	String protocolo = entradaServidor.readUTF();
	  	        	 if (protocolo.equalsIgnoreCase("UDP")){  
	                        System.out.println("\n Cliente con el protocolo " + protocolo + " en línea.");
	                        leerFichero fichero = new leerFichero(this.fichero);
	   	                    String[] m = fichero.getLista();
	   	                    int longitudFichero = fichero.getLongitudLista();
	   	                    int rand = (int) (Math.random() * longitudFichero);
	   	                    salidaServidor = new DataOutputStream(cs.getOutputStream());
	   	                    salidaServidor.writeUTF( m[rand] ); 
	  	        	       }
	  	        	 
	  	        	 else{ //protocolo TCP
	  	        		System.out.println("\n Cliente con el protocolo " + protocolo + " en línea.");
                        leerFichero fichero = new leerFichero(this.fichero);
   	                    String[] m = fichero.getLista();
   	                  
   	                 while(y < fichero.getLongitudLista()){
   	                	 
   	                	salidaServidor = new DataOutputStream(cs.getOutputStream());
   	                    salidaServidor.writeUTF( m[y] );
   	                    if( y == fichero.getLongitudLista()-1){
	                		salidaServidor = new DataOutputStream(cs.getOutputStream());
	   	                    salidaServidor.writeUTF( "\n ¡ No quedan mas refranes ! " );
	   	                    break;
	                	 }
   	                	DataInputStream respuestaCliente = new DataInputStream(cs.getInputStream());
   		  	        	String respuesta = respuestaCliente.readUTF();   
   		  	            if (respuesta.equalsIgnoreCase("no")) {;break;}
   	                    y++;
   	                              }                      
   	                         } 	  	        		 	  	        		 
                      }
	              catch (Exception e){
                           System.out.println(e.getMessage());
                         }
	              
                }
}
