package practica1RO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class leerFichero {
	
	int x = 0, z =0;
	String[] m;

	public leerFichero(String nombre_fichero) throws IOException{
         String cadena;
         File f = new File(nombre_fichero);
         FileReader f2 = new FileReader(f);
		 BufferedReader b = new BufferedReader(f2);
         while((cadena = b.readLine())!=null) {       
             z++;
         }
         b.close();
         m = new String[z];
         FileReader f3 = new FileReader(f);
         BufferedReader c = new BufferedReader(f3);
         while((cadena = c.readLine())!=null) {      
         	m[x] = cadena;
             x++;
         }
         c.close();
	}
    public int getLongitudLista () { return z; }
    public String[] getLista () { return m; }
}
