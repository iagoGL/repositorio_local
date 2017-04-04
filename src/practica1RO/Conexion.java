package practica1RO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion 
{
              String HOST,fichero; 
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaServidor;
    protected DataOutputStream salidaCliente;
    protected int PUERTO;
    
    public Conexion(){}; 
    
    public Conexion(String tipo,String ip_servidor,int PUERTO,String fichero) throws IOException
    {
    	this.fichero=fichero;
    	this.PUERTO=PUERTO;
    	HOST=ip_servidor;
        if(tipo.equalsIgnoreCase("servidor")){
            ss = new ServerSocket(PUERTO);
            cs = new Socket(); 
        }
        else{
            cs = new Socket(HOST, PUERTO);
        }
    }
}