package practica1RO;

import java.io.IOException;

public class MainCliente{
    public static void main(String[] args) throws IOException{  
    	 String tipo = args[0];
    	 String ip_servidor = args[1];
         int puerto = Integer.parseInt(args[2]);
    	 HiloCliente miHilo = new HiloCliente(tipo,ip_servidor,puerto);
    	 miHilo.start();
    }
}
    