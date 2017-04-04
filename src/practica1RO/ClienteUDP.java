package practica1RO;

import java.io.*;


public class ClienteUDP   extends Conexion{
	static String fichero=null;
	
	public ClienteUDP(String ip_servidor,int puerto) throws IOException{
		
		super("cliente",ip_servidor,puerto,fichero);}
	
	 public void startClienteUDP(){
	        try{
	        	salidaCliente = new DataOutputStream(cs.getOutputStream());
                salidaCliente.writeUTF( "UDP" ); 
	        	DataInputStream entradaCliente = new DataInputStream(cs.getInputStream());
	        	String mensajeRecibido = entradaCliente.readUTF();
	        	System.out.println(mensajeRecibido);
	            cs.close();
	            System.out.println("\n Fin de conexión del cliente \n "); 
	        }
	        catch (Exception e){
	            System.out.println(e.getMessage());
	        }
	    }
}

