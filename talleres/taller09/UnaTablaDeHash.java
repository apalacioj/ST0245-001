
/**
 *La clase UnaTablaDeHash permite crear una estructura de una Tabbla Hash propia.
 *Dentro de sus características esta que tiene un string como llave (key) y un entero
 *como valor (value).
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 9/10/2020
 */
public class UnaTablaDeHash {

    private final int[] tablaHash;
    private int longitud;

    /**
     * Este constructor inicializa la tabla de Hash que se creará.
     */
    public UnaTablaDeHash(int longitud){
        tablaHash = new int [longitud];
    }

    /**
     * Este método calcula la posición del elemento dentro de la tabla.
     * @param k llave del elemento que servirá como referencia al buscar.
     * @return posición que tomará el elemento en el arreglo.
     */
    private int funcionHash(String k){
        return ((int) k.charAt(0)) % tablaHash.length;
    }

    /**
     * Este método busca un elemento determinado en la tabla.
     * @param k llave del elemento que servirá como referencia al buscar.
     * @return valor asociado a la llave dada.
     */
    public int get(String k){
        int pos = funcionHash(k);
        int num = tablaHash[pos];
        return num;
    }

    /**
     * Este método agrega un nuevo elemento a la tabla.
     * @param k llave del elemento que servirá como referencia al buscar.
     * @param num valor asociado a la llave k.
     */
    public void put(String k, int num){
        int pos = funcionHash(k);
        tablaHash[pos] = num;
    }   

    /**
     * Este método principal sirve para probar la funcionalidad de los métodos anteriores.
     */
    public static void main(String [] args){
        UnaTablaDeHash test = new UnaTablaDeHash(15);
        test.put("10", 1);
        test.put("8", 2);
        test.put("6", 3);
        test.put("4", 4);
        test.put("2", 5);
        test.put("3", 6);
        test.put("5", 7);
        test.put("7", 8);
        test.put("9", 9);
        test.put("20", 10);

        System.out.println(test.get("10"));
        System.out.println(test.get("3"));
        System.out.println(test.get("5"));
    }
}