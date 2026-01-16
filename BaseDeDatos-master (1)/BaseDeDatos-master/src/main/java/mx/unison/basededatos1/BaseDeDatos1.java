/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mx.unison.basededatos1;

/**
 *
 * @author MI PC
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
public class BaseDeDatos1 {

    public static void main(String[] args) {
        //Aqui busca el archivo en la carpeta
        String archivo = "codigos_postales_hmo.csv";
        //aqui se crea el treemap para guardar los codigos y el conteo
        Map<String, Integer> conteo = new TreeMap<>();
        //aqui lee cada linea
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                //esto es para evitar datos incompletos
                if (datos.length < 2) continue;
                //aqui toma el codigo y aumenta el conteo
                String cp = datos[0].trim();  
                conteo.put(cp, conteo.getOrDefault(cp, 0) + 1);
            }
          //excepcion por si hay algun error      
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //con este ciclo se imprimen todos los codigos con el conteo respectivo
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println("Codigo postal: " + entry.getKey() + " -Numero de asentamientos: " + entry.getValue());
        }
    }
}