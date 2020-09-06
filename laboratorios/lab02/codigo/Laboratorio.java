/**
Esta clase contiene los algoritmos merge sort e insertion sort, los cuales fueron propuestos en el Laboratorio 2.
@author Valentina Moreno y Alejandra Palacio
@version 06/09/2020
*/
public class Laboratorio {
 
 /**
 Este método nos permitirá ordenar un arreglo internamente
 
 @param int[] a, el arreglo que se organizará
 @see merge
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
    }

 
/** 
Este método une los arreglos que se separan en el método merge sort en un solo arreglo y realiza las comparaciones
para ordenarlo
@param int[]a arreglo original
@param int[]a1 primera "mitad" del arreglo
@param int[]a2 segunda "mitad" del arreglo
@param int izq longitud del arreglo a1
@param int der longitud del arreglo a2

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
 

    public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }  
    
    
}
