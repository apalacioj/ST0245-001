 

 /**
 *Esta clase crea la coordenada de una abeja robótica, lo cual hace parte del primer ejercicio
 *propuesto en el taller 6.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 10/09/2020
 */
public class abeja {
    private final double x;
    private final double y;
    private final double z;
    
   /**
    * Este constructor inicializa los atributos de la clase abeja, es decir, la coordenada de una abeja.
    * @param x coordenada en x de la abeja.
    * @param y coordenada en y de la abeja.
    * @param z coordenada en z de la abeja.
    */
   public abeja(double x, double y, double z){
       this.x = x;
       this.y = y;
       this.z = z;
   }
   
    /**
     * Este método muestra en una cadena de craacteres las coordenadas de una abeja.
     * @return coordenada de una abeja (x, y, z).
     */
    public String mostrarCoordenada(){
    String coordenada = "";
    coordenada = "(" + x + ", " + y + ", " + z + ")";
    return coordenada;
    }
}
