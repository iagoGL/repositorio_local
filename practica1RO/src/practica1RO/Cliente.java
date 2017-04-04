package practica1RO;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
//import sockets.conexion.Conexion;

public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {            
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            String respuesta;
            Scanner sc = new Scanner(System.in);
            String cadena;
            File f = new File("C:/Users/IagoGL/workspace/practica1RO/src/practica1RO/refranes");
            FileReader f2 = new FileReader(f);
            BufferedReader b = new BufferedReader(f2);
            while((cadena = b.readLine())!=null) {
                salidaServidor.writeUTF(cadena);
                System.out.println(cadena);
                System.out.println("Si quiere otro refrán, responda 'si', en caso contrario 'no'  ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("no")){break;}
                else if((respuesta.equalsIgnoreCase("si"))){continue;}
                else {System.out.println("Respuesta incorrecta,cerrando conexión");break;}
            }
            b.close();
            
          

            cs.close();//Fin de la conexión
            
           System.out.println("Fin de conexión del cliente"); 

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}