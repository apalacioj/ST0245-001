import java.util.Scanner;
/**
 * Esta clase prueba la funcionalidad de los ejericicios 1 y 2 del taller 3.
 * 
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo. 
 * @version 12/08/2020
 */
public class TestTaller03
{
    /**
     * Este método permite probar el algoritmo relacionado con las torres de Hanoi.
     */
    public static void ejercicio1(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el número de discos con los que va a jugar a las torres de Hanoi: ");
        int a = scan.nextInt();
        System.out.println("Para el número ingresado, los movimientos que debe ejecutar son: ");
        Taller03.torresDeHannoi(a);
    }
    
    /**
     * Este método permite probar el algoritmo relacionado con las permutaciones de una cadena de caracteres.
     */
    public static void ejercicio2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese la cadena de caracteres a la cual le quiere hallar las permutaciones: ");
        String a = scan.next();
        System.out.println("Las permutaciones de esta cadena son: ");
        Taller03.permutations(a);
    }
    
    /**
     * Este método permite probar los algoritmos realizados en la clase Taller03.
     */
    public static void main(String [] args){
        System.out.println("Ejercicio 1: ");
        ejercicio1();
        System.out.println("");
        System.out.println("Ejercicio 2: ");
        ejercicio2();
    }
}
