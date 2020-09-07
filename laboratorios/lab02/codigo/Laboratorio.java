/**
Esta clase contiene los algoritmos merge sort e insertion sort, los cuales fueron propuestos en el Laboratorio 2.
@author Valentina Moreno y Alejandra Palacio
@version 06/09/2020
*/
public class Laboratorio {
 
 /**
 *Este método permite ordenar un arreglo empleando el concepto de "divide y vencerás" (algoritmo merge sort).
 *@param int[] a arreglo que se organizará.
 *@see merge(int[] a, int[] a1, int[] a2, int izq, int der)
 */
 public static void mergeSort(int[] a) {
        if (a.length > 1) {                                                     // T(n) = c1
        int[] a1 = new int[a.length/2];                                         // T(n) = c2
        int[] a2 = new int[a.length - a1.length];                               // T(n) = c3
     
        System.arraycopy(a, 0, a1, 0, a1.length);                               // T(n) = c4*(n/2) + c5
        System.arraycopy(a, a1.length, a2, 0, a2.length);                       // T(n) = c5*(n/2) + c6
        mergeSort(a1);                                                          // T(n) = T(n/2) + c7
        mergeSort(a2);                                                          // T(n) = T(n/2) + c8
        merge(a, a1, a2, a1.length, a2.length);                                 // T(n) = T(n-1) + c9
       }                                                                       
    }                                                                           //Luego de  T(n) = O(n)logn

 
/** 
*Este método une los arreglos que se separan en el método mergSort(int [] a) en un solo arreglo y realiza las comparaciones
*correspondientes para ordenarlo.
@param int[]a arreglo original.
@param int[]a1 primera "mitad" del arreglo separado.
@param int[]a2 segunda "mitad" del arreglo separado.
@param int izq longitud del arreglo a1.
@param int der longitud del arreglo a2.

*/
 private static void merge(int[] a, int[] a1, int[] a2, int izq, int der) {  
    int x = 0;
    int y = 0;
    int z = 0;
    while (x < izq && y < der) {                                                
        if (a1[x] <= a2[y]){
            a[z] = a1[x];
            x++;
        }
        else{
            a[z] = a2[y];
            y++;
        }
        z++;
    }
    while (y < der) {
        a[z] = a2[y];
        y++;
        z++;
    }
    while (x < izq) {
        a[z] = a1[x];
        x++;
        z++;
    }
}
 

/**
* Este método organiza un arreglo comparando si el elemento a organizar es mayor que los elementos anteriores.
* para determinar su posición para que quede en orden.
* @param int [] array arreglo que se organizará
*/
public static void insertionSort(int[] array) {
    for (int i = array.length - 1; i > 0; i--) {                                                 // T(n) = c1 + c2*(n-1)
        int mayor = 0;                                                                           // T(n) = c3*(n-1)
        for (int j = 0; j < i; j++) {                                                            // T(n) = c4 + c5*(n-1)*(n-1)
            if (array[j + 1] > array[mayor]) {
                mayor = j + 1;                                                                   // T(n) = c6*(n-1)*(n-1)
            }
        }
        swap(array, i, mayor);                                                                   // T(n) = c7*(n-1)
    }
}

/**
* Este método permite intercambiar de posición los elementos de un arreglo.
* @param int [] arrayarreglo donde están los valores a cambiar.
* @param int a posición del primer elemento. 
* @param int b posición del segundo elemento 
*/
private static void swap(int[] array, int a, int b) {
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;  
	}

/**
*Este método permite tomar el tiempo de ejecución del algoritmo que se desee
*/
public static void main (String args[]){
   for(int i = 110000; i <= 300000; i = i + 10000){
      long ti = System.currentTimeMillis();
      mergeSort(new int[i]);
      long tf = System.currentTimeMillis();
      System.out.println(tf - ti);
        }
    }
}
