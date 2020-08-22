import java.util.Random;
/**
 * Esta clase contiene las respuestas al taller 4, donde se analiza el comportamiento de un algoritmo para determinar 
 * su complejidad con diferentes tamaños del problema.
 * @Author Alejandra Palacio Jaramillo y Valentina Moreno Ramírez.
 * @Date 20/08/2020
 */
public class Taller4{
    /**
     * Este método permite calcular el elemento con valor máximo en un arreglo de enteros.
     * @param int[] arreglo de enteros donde se buscará el valor máximo.
     * @param n longitud del arreglo anterior.
     * @return entero mayor del arreglo.
     * 
     * @see max()
     */
    private static int punto1(int[] array, int n) {
        int max;
        if (n == 1){
            max = array[0]; // T(n) = c1, donde c1 = 4
        }else{
            max = Math.max(array[n-1], punto1(array, n-1)); // T(n) = c2 + T(n-1), donde c2 = 6
        }
        return max;
        //complejidad: T(n) = c2*n + c1, donde c1 es un parámetro arbitrario.
    }

    public static int max(int[] array){
        return punto1(array, array.length);
    }

    /**
     * Este método permite pasar por las posiciones de un arreglo de volúmenes
     * y calcular si la combinación de alguno de estos es igual al volumen máximo constante.
     * @param start posición en la cual se comienza a recorrer el arreglo.
     * @param int[] arreglo de volúmenes
     * @param volumen máximo.
     * @return boolean: Si existe, True, de lo contrario, False.
     * 
     * @see sumaGrupo()
     */
    private static boolean punto2(int start, int[] volumenes, int volumen){
        if(start<volumenes.length & volumen!=0){
            return punto2(start+1, volumenes, volumen) || punto2(start+1, volumenes, volumen-volumenes[start]); //T(n) = c1 + T(n-1) + T(n-1), donde c1 = 11 
        } else if(volumen == 0){
            return true; //T(n) = c2, donde c2 = 4.
        } else{
            return false; //T(n) = c3, donde c3 = 2.
        }
        //complejidad: T(n) = c1*((2^n)-1)+c2*2^n-1, donde c2 es un parámetro arbitrario.
    }

    /**
     * Este método permite calcular los elementos de una lista de volumenes que suman un volumen máximo.
     * @param int[] arreglo de volúmenes.
     * @param int volúmen máximo.
     * 
     * @return boolean: Si existe, True, de lo contrario, False.
     */
    public static boolean sumaVolumenes(int [] nums, int target){
        return punto2(0, nums, target);
    }

    /**
     * Este método calcula el valor enésimo de la serie de Fibonacci recursivamente.
     * @param n valor enésimo de la serie Fibonacci.
     * @return int fibonacci posición n.
     */
    private static int punto3(int n){
        if (n==0){
            return 0; //T(n) = c1, donde c1 = 3.
        }
        else if (n==1) {
            return 1; //T(n) = c2, donde c2 = 4.
        }
        else {
            return punto3(n-1) + punto3(n-2);  //T(n) = c3 + T(n-1) + T(n-2), donde c3 = 5.
        }
        //complejidad: T(n) = -c3 + c1*Fn + c2*Ln, donde Fn es el valor enésimo de Fibonacci, Ln es el enésimo número de Lucas y, c1 y c2
        //son parámetros arbitrarios.
    }

    /**
     * Este método calcula recursivamente el valor enésimo de la serie de Fibonacci recursivamente.
     * @param n valor enésimo de la serie Fibonacci.
     * @return int fibonacci posición n.
     */
    public static int fibonacci(int n){
        return punto3(n);
    }

    /**
     * Este método crea un arreglo de enteros aleatorios.
     * @param int n longitud del arreglo.
     * @return arreglo creado.
     */
    private static int[] arreglo(int n){
        int max = 500;
        int[] array = new int[n];
        Random generator = new Random();
        for (int i =0; i<n; i++){
            array[i] = generator.nextInt(max);
        }
        return array;
    }

    /**
     * Este método principal calcula el tiempo de ejecución para un tamaño n de un determinado algoritmo
     * y lo muestra por pantalla.
     */
    public static void main(String[] args){
        for (int n = 2; n < 200 ; n++){
            long inicio = System.nanoTime();
            max(new int[n]);
            long fin = System.nanoTime();
            System.out.println(fin - inicio);
        }       
    }
}