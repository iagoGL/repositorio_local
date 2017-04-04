package practica1RO;
import java.io.IOException;

public class Servidor extends Conexion
{
	static String ip_servidor="localhost"; 
    public Servidor(int puerto,String fichero) throws IOException{
    	super("servidor",ip_servidor,puerto,fichero);}

    public void startServer()
    {
        try{
        	while (true){
            System.out.println("\n Esperando..."); 
            cs = ss.accept();
            System.out.println("\n Nueva conexión entrante: ");
            ((HiloServidor) new HiloServidor(cs,mensajeServidor,ss,salidaCliente,fichero)).start();
        	}
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}