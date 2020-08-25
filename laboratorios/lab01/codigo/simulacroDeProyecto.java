import java.util.Scanner;
import java.io.*;
import java.util.Random;
/**
 * Esta clase contiene los algoritmos correspondientes a la primera parte del laboratorio n°1 de estructuras de 
 * datos y algoritmos 1. Además, contiene métodos complementarios que permiten tomar los tiempos de ejecución
 * de un algoritmo, leer cadenas de caracteres, entre otros.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 24/08/2020
 */
public class simulacroDeProyecto{
    //Ejercicio 1.1
    /**
     * Este método calcula la longitud de la subsecuencia común más larga de dos cadenas de caracteres.
     * @param String s1, primera cadena de caracteres.
     * @param String s2, segunda cadena de caracteres.
     * @param int n1, longitud de la primera cadena de caracteres.
     * @param int n2, longitud de la segunda cadena de caracteres.
     * 
     * @return int: número de caracteres que tendrá la subsecuencia común más larga.
     */
    private static int punto1(String s1, String s2, int n1, int n2){
        if(n1 == 0 || n2 == 0 ){
            return 0; //T(n1,n2) = c1, donde c1 = 5.
        }
        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return 1 + punto1(s1, s2, n1-1, n2-1); //T(n1,n2) = c2 + T(n1-1,n2-1), donde c2 = 10.
        }else{
            return Math.max(punto1(s1, s2, n1-1, n2), punto1(s1, s2, n1, n2-1)); //T(n1,n2) = c3 + T(n1-1) + T(n2-1), donde c3 = 5.
        } 
    }

    /**
     * Este método calcula la longitud de la subsecuencia común más larga de dos cadenas de caracteres.
     * @param String s1, primera cadena de caracteres.
     * @param String s2, segunda cadena de caracteres.
     * 
     * @return int: número de caracteres que tendrá la subsecuencia común más larga.
     */
    public static int lcs(String s1, String s2){
        return punto1(s1, s2, s1.length(), s2.length());
    }

    /**
     * Este método lee los datasets que contienen las cadenas de caracteres de los ADNs mitocondriales.
     * @param String, archivo nombre del archivo que contiene la cadena de caracteres.
     * 
     * @return String: cadena de caracteres de ADN mitocondrial.
     * @throws FileNotFoundException
     */
    private static String leerCadenas(String archivo) throws FileNotFoundException{
        String cadena = "";
        try{
            File file = new File(archivo + ".txt");
            Scanner scan = new Scanner(file);
            cadena = scan.next();
            scan.close();
        }catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
            e.printStackTrace();
        }
        return cadena;
    }

    /**
     * Este método lee las cadenas de caracteres del ADN mitocondrial y calcula longitud de la subsecuencia común más larga entre ellas.
     * 
     * @return int: número de caracteres que tendrá la subsecuencia común más larga.
     * @throws FileNotFoundException
     */
    public static int subcadenaMasLarga() throws FileNotFoundException{
        String cadena1 = leerCadenas("cadena1");
        String cadena2 = leerCadenas("cadena2");
        return lcs(cadena1, cadena2);
    }

    /**
     * Este método crea cadenas aleatorias de caracteres con la longitud y los caracteres que el usuario determine.
     * @param int, longitud es el número de caracteres de la cadena que se creará.
     * @param String c, contiene los caracteres que serán utilizados en la cadena creada.
     * 
     * @return String: cadena con caracteres aleatorios de acuerdo a las especificaciones del usuario
     */
    private static String generarCadena(int longitud, String c){
        Random r = new Random();
        String cadena = "";
        for(int i = 0; i<longitud; i++){
            cadena+=c.charAt(r.nextInt(c.length()));
        }
        return cadena;
    }

    /**
     * Este método principal calcula el tiempo de ejecución del algoritmo que calcula la longitud de la subsecuencia más larga de dos cadenas
     * de caracteres y lo imprime para cada longitud n de las cadenas.
     */
    public static void main(String[] args){
        for(int n = 0; n < 30; n++){
            String a1 = generarCadena(n, "gtca");
            String b1 = generarCadena(n, "gtca");
            long inicio = System.currentTimeMillis();
            lcs(a1,b1);
            long fin = System.currentTimeMillis();
            System.out.println(fin - inicio);
        }       
    }

    //Ejercicio 1.2
    /**
     * Este método calcula el número de maneras en las que se puede llenar un tablero 2xn cm^2 con rectaculos de área 2x1 cm^2.
     * @param int n, entero positivo que hace referencia a la altura del tablero.
     * 
     * @return int: número de maneras distintas en las que se puede rellenar el rectángulo.
     */
    public static int ways(int n){
        if(n>0 && n<=2){
            return n; //T(n) = c1, donde c1 = 5
        }else{
            return ways(n-1) + ways(n-2);// T(n) = c2 + T(n-1) + T(n-2), donde c2 = 3
        }
    }
}
