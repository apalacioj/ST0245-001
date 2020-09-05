import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
/**
 *Esta clase contiene la implementación de un ArrayList con referencias a "abeja". Además, tiene métodos que permiten leer coordenadas
 *de abejas, agregar abejas y eliminarlas del ArrayList.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo
 * @version 2/09/2020
 */
public class coordenadasAbejas{

    private static int longitud;
    private static final int capacidad_inicial = 10;
    private static abeja [] coordenadas; 

    /**
     * Este constructor inicializa el ArrayList de coordenadas de abejas.
     */
    public coordenadasAbejas(){
        longitud = 0;
        coordenadas = new abeja[capacidad_inicial];
    }

    /**
     * Este método permite leer un archivo .txt con coordenadas de abejas para luego agregarlas al ArrayList de
     * coordenadas.
     * @throws FileNotFoundException 
     */
    private static void leerdatos() throws FileNotFoundException, Exception{
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo que contiene las coordenadas de las abejas:");
        String nombre = scan.next();
        try{
            File archivo = new File("D:\\Datos\\"+nombre+".txt");
            try (Scanner scan1 = new Scanner(archivo)) {
                while(scan1.hasNextLine()){
                    String [] data = scan1.nextLine().split(",");
                    if(data.length != 0){
                        double x = Double.parseDouble(data[0]);
                        double y = Double.parseDouble(data[1]);
                        double z = Double.parseDouble(data[2]);
                        add(new abeja(x,y,z));
                    }
                }
            }
        }

        catch(FileNotFoundException e){
            System.out.println("No se encuentra el archivo");
        }
    }

    /**
     * Este método retorna la longitud del arreglo de coordenadas de abejas.
     * @return longitud del arreglo.
     */
    public static int longitud(){
        return longitud;                                                                               //O(1)         
    }

    /**
     * Este método retorna la coordenada de la abeja en la posición dada.
     * @param indice posición de la coordenada que se retornará.
     * @return coordenada de la abeja en la posición indice.
     * @throws java.lang.Exception
     */
    public static abeja getAbeja(int indice) throws Exception{
        if(indice >= longitud || indice < 0){                                                         //O(1)
            throw new Exception("índice: " + indice);                                                 //O(1)
        }
        for (int i = 0; i < coordenadas.length; i++){                                                 //O(n)             
            if (indice == i)                                                                          //O(1)
                return coordenadas[i];                                                                //O(1)
        }
        return coordenadas[indice];                                                                   //O(1)
        //Luego de aplicar la regla de reflexividad, de la suma y del producto,
        //se obtiene que la complejidad de este algoritmo es O(n), es decir, lineal,
        //lo cual permite que su implementación sea óptima. En este caso, n es la 
        //longitud del arreglo.
    }

    /**                                                                                              
     * Este método permite agregar una coordenada de abeja en un índice determinado.
     * @param indice posición en la que agregará la abeja.
     * @param a coordenada de abeja que agregará.
     * @throws Exception 
     */
    public static void addindex(int indice, abeja a) throws Exception {
        if (indice > longitud || indice < 0){                                                          // O(1)
            throw new Exception("índice: " + indice);                                                  // O(1)
        }
        abeja[] coordenadas1;                                                                          // O(1)

        if (longitud == coordenadas.length){                                                           // O(1)
            coordenadas1 = new abeja[coordenadas.length+1];                                            // O(1)
        }else{
            coordenadas1 = new abeja[coordenadas.length+1];                                            // O(1)
        }
        System.arraycopy(coordenadas, 0, coordenadas1, 0, indice);                                     // O(n)
        coordenadas1[indice] = a;                                                                      // O(1)
        System.arraycopy(coordenadas, indice, coordenadas1, indice+1, coordenadas1.length - (indice+2)); // O(n)
        coordenadas = coordenadas1;                                                                     // O(n)
        longitud++;                                                                                     // O(1)
        //Luego de aplicar la regla de reflexividad, de la suma y del producto,
        //se obtiene que la complejidad de este algoritmo es O(n), es decir, lineal,
        // lo cual permite que su implementación sea óptima. En este caso, n es la 
        //longitud del arreglo.
    }

    /**                                                                                               
     * Este método permite agregar una coordenada de abeja en su última posición.
     * @param a coordenada de abeja que agregará al arreglo.
     * @throws Exception 
     */
    public static void add(abeja a)throws Exception{
        if (longitud < 0){                                                                             // O(1)
            throw new Exception("índice: " + longitud);                                                // O(1)
        }
        abeja[] coordenadas1;                                                                          // O(1)

        if (longitud == coordenadas.length){                                                           // O(1)
            coordenadas1 = new abeja[coordenadas.length+1];                                            // O(1)
        }else{
            coordenadas1 = new abeja[coordenadas.length];                                              // O(1)
        }
        System.arraycopy(coordenadas, 0, coordenadas1, 0, longitud);                                   // O(n)
        coordenadas1[longitud] = a;                                                                    // O(1)
        System.arraycopy(coordenadas1, longitud, coordenadas, longitud, coordenadas1.length - longitud);     // O(n)
        longitud++;                                                                                    // O(1)
        //Luego de aplicar la regla de reflexividad, de la suma y del producto,
        //se obtiene que la complejidad de este algoritmo es O(n), es decir, lineal,
        // lo cual permite que su implementación sea óptima. En este caso, n es la 
        //longitud del arreglo. 
    }

    /**
     * Este método elimina una coordenada de abeja en una posición determinada.
     * @param indice posición de la coordenada que se quiere eliminar.
     * @throws Exception 
     */
    public static void remove(int indice) throws Exception{
        if (indice > longitud || indice < 0){                                                          // O(1)
            throw new Exception("índice: " + indice);                                                  // O(1)
        }      
        abeja[] coordenadas1 = new abeja[coordenadas.length-1];                                        // O(1)
        System.arraycopy(coordenadas, 0, coordenadas1, 0, indice);                                     // O(n)
        System.arraycopy(coordenadas, indice+1, coordenadas1, indice, coordenadas1.length - indice);   // O(n)
        System.arraycopy(coordenadas1, 0, coordenadas, 0, coordenadas1.length);                        // O(n)
        longitud--;                                                                                    // O(1)
        //Luego de aplicar la regla de reflexividad, de la suma y del producto,
        //se obtiene que la complejidad de este algoritmo es O(n), es decir, lineal,
        // lo cual permite que su implementación sea óptima. En este caso, n es la
        //longitud del arreglo.
    }

    /**
     * Este método principal permite probar los métodos creados anteriormente con uno de los datasets dados por el profesor.
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[]args) throws FileNotFoundException, Exception{
        new coordenadasAbejas();
        leerdatos();
        remove(3);
        addindex(4, new abeja(4, 7, 8));
    }  
}