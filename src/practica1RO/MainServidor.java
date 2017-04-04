package practica1RO;

import java.io.IOException;

public class MainServidor
{
    public static void main(String[] args) throws IOException
    {    
        int puerto = Integer.parseInt(args[0]);
  	    String fichero = args[1];
        Servidor serv = new Servidor(puerto,fichero);
        System.out.println("Iniciando servidor\n");
        serv.startServer();
    }
}