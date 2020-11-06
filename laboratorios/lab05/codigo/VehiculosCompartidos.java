import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Esta clase implementa un algoritmo para disminuir el tráfico mediante la estrategia de vehículos compartidos.
 * Estructura de datos utilizada: Grafo con Matrices de Adyacencia.
 * Complejidad: Peor Caso y Mejor Caso O(n*n).
 * Nota --> este código tiene como base el codigo_estudiante dado por el docente.
 *
 * @author Mauricio Toro, Valentina Moreno y Alejandra Palacio
 * @version 1
 */
public class VehiculosCompartidos
{
    /**
    * Este método sirve para leer un archivo con los duenos de vehiculos y la empresa respectiva.
    * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de vehiculos y la empresa.
    *
    * @param  numeroDePuntos - El numero de puntos es 1 de la empresa y n-1 de los duenos de vehiculos.
    * @return un grafo completo con la distancia mas corta entre todos los vertices.
    */
    public static DigraphAM leerArchivo(int numeroDePuntos, float p){
          final String nombreDelArchivo = "Datos.txt";
          DigraphAM grafo = new DigraphAM(numeroDePuntos);
          try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 3; i++){ // Descarta las primeras 3 lineas
                lineaActual = br.readLine();
            }
            lineaActual = br.readLine(); 
            for (int i = 1; i <= numeroDePuntos; i++){ //Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }          
            for (int i = 1; i <= 3; i++){ // Descarta las siguientes 3 lineas
                lineaActual = br.readLine();  
            }
            while (lineaActual != null){ // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String [] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0])-1, Integer.parseInt(cadenaParticionada[1])-1, Integer.parseInt(cadenaParticionada[2]));
                lineaActual = br.readLine();
            }
          }
          catch(IOException ioe) {
              System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
          }
          return grafo;
    }
    
    /**
    * Este algoritmo sirve para asignar vehiculos compartidos (no tiene en cuenta la restriccion que hay en el problema).
    * Lo que hace es agrupar los duenos de vehiculos en permutaciones de maximo 5 elementos.
    * Complejidad: Mejor y Peor Caso O(n), donde n son los duenos de vehiculos y la empresa.
    *
    * @param grafo - Un grafo que puede estar implementado con matrices o con listas de adyacencia.
    * @return una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo.
    */
    public static LinkedList<LinkedList<Integer>> asignarVehiculos(Graph grafo, float p){
          LinkedList<LinkedList<Integer>> permutacionSubconjunto = new LinkedList<LinkedList<Integer>>();
          LinkedList<Integer> permutacion = new LinkedList<Integer>();
          int dueno = 2;
          int cont = 1;
          for(int i = dueno; i<=grafo.size(); i++){
              if (cont == 1){ 
                  permutacion = new LinkedList<Integer>();
                  permutacion.add(dueno);
                  dueno++; 
                  cont++;
              }else{
                  permutacion.add(dueno);
                  dueno++; 
                  cont++;
                  if (cont == 6 || dueno == grafo.size()){ 
                      cont = 1;
                      permutacionSubconjunto.add(permutacion);
                  }                    
              }
          }
          return permutacionSubconjunto;
    }
        
    /**
    * Este método sirve para escribir un archivo con la respuesta al problema.
    * Complejidad: Mejor y peor caso es O(n), donde n son los duenos de vehiculo y la empresa.
    *
    * @param  permutacionSubconjunto es una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo.
    */
    public static void guardarArchivo(LinkedList<LinkedList<Integer>> permutacionSubconjunto){
          final String nombreDelArchivo = "respuesta.txt";
          try {
             PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
             for (LinkedList<Integer> lista: permutacionSubconjunto){
                  for (Integer duenoDeVehiculo: lista)
                       escritor.print(duenoDeVehiculo + " ");
                  escritor.println();
             }             
             escritor.close();
          }
          catch(IOException ioe) {
              System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
          }  
    }

    /**
     * Este método principal prueba los métodos realizados anteriormente y en general el algoritmo realizado para los vehículos compartidos.
     */
    public static void main(String[] args){
          final int numeroDePuntos = args.length == 0 ? 205 : Integer.parseInt(args[0]);
          final float p = args.length < 2 ? 1.3f : Float.parseFloat(args[1]);
          DigraphAM grafo = leerArchivo(numeroDePuntos, p);
          LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto = asignarVehiculos(grafo,p);     
          guardarArchivo(permutacionParaCadaSubconjunto);     
   }
    }