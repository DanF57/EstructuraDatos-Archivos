package creaciondearchivos;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class CreacionDeArchivos {

    Scanner entrada = new Scanner(System.in);
    File archivo = new File("myArchivo.txt");

    public int menu() {
        int opc;
        System.out.println("Escribir en el archivo [1]:");
        System.out.println("Leer el archivo        [2]:");
        System.out.println("Salir        [0]:");
        opc = entrada.nextInt();
        return opc;
    }

    public void escribir() {
        FileWriter escribir;
        PrintWriter linea;
        int Id;
        String nombre = "", correo = "";
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (Exception e) {

            }
        }
        
        try {
            System.out.println("Ingrese Id: ");            
            Id = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Ingrese nombre: ");
            nombre = entrada.nextLine();
            System.out.println("Ingrese correo: ");
            correo = entrada.nextLine();
            escribir = new FileWriter(archivo, true); //True = aumentar contenido -- False = Sobreescribir
            linea = new PrintWriter(escribir);
            linea.println(Id+"\n"+nombre+"\n"+correo);
            linea.close();
        } catch (Exception e) {
            
        }
    }
    
    public void leer(){
        FileReader leer;
        String cadena = "", id = "", nombre = "", correo = "";
        BufferedReader alm;
        try {
            leer = new FileReader(archivo);
            alm = new BufferedReader(leer);
            while(cadena != null){
                cadena = alm.readLine();
                id = cadena;
                
                cadena = alm.readLine();
                nombre = cadena;
                
                cadena = alm.readLine();
                correo = cadena;
                if(cadena != null){
                    System.out.println(id+"\t"+nombre+"\t"+correo);
                }
            }
            alm.close();
            leer.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CreacionDeArchivos obj = new CreacionDeArchivos();
        int op;
        do {
            op = obj.menu();
            switch (op) {
                case 1 -> obj.escribir();
                case 2 -> obj.leer();
            }
        } while (op != 0);
    }

}
