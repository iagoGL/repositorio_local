package practica1RO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ClienteTCP extends Conexion
{
	static String fichero=null;
	
    public ClienteTCP(String ip_servidor,int puerto) throws IOException{
    	
    	
    	super("cliente",ip_servidor,puerto,fichero);} 

    public void startClient() 
    {
        try{ 
        	String fin = "\n ¡ No quedan mas refranes ! ";
            String respuesta;
        	salidaCliente = new DataOutputStream(cs.getOutputStream());
            salidaCliente.writeUTF( "TCP" );
            DataInputStream entradaCliente = new DataInputStream(cs.getInputStream());
            do{     
        	        String mensajeRecibido = entradaCliente.readUTF();
        	        System.out.println(mensajeRecibido); 
        	        if (mensajeRecibido.equalsIgnoreCase(fin)){break;}
                    System.out.println("\n Si quiere otro refrán, responda 'si', en caso contrario 'no'  \n");
                    @SuppressWarnings("resource")
			        Scanner sc = new Scanner(System.in); 
                    respuesta = sc.next(); 
                    if(respuesta.equalsIgnoreCase("si")){
                    	salidaCliente = new DataOutputStream(cs.getOutputStream());
                        salidaCliente.writeUTF( "si" );
                    	continue;
                    }
                    
                    else if (respuesta.equalsIgnoreCase("no")){
                    	salidaCliente = new DataOutputStream(cs.getOutputStream());
                        salidaCliente.writeUTF( "no" );
                        break;
                    }
                    else  {
                    	salidaCliente = new DataOutputStream(cs.getOutputStream());
                        salidaCliente.writeUTF( "no" );
	            	    System.out.println("Respuesta incorrecta,cerrando conexión \n");
	                    break;
	                           }
                    
               }while(1>0);
           cs.close(); 
           System.out.println("\n Fin de conexión del cliente \n "); 
            }
        catch (Exception e){
            System.out.println(e.getMessage());
           }
    }
}