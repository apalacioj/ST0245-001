/**
 *Esta clase crea la ubicación geodésica de una abeja robótica.
 * @author (Valentina Moreno Ramírez y Alejandra Palacio Jaramillo)
 * @version (2)
 */
public class abeja {
    private final double x;
    private final double y;
    private final double z;
    
   /**
    * Este constructor inicializa los atributos de la clase abeja, es decir, la ubicación geodésica
    * de una abeja robótica.
    * @param x latitud en grados de la abeja.
    * @param y longitud en grados de la abeja.
    * @param z altura sobre el nivel del mar en metros de la abeja.
    */
   public abeja(double x, double y, double z){
       this.x = x;
       this.y = y;
       this.z = z;
   }
   
   /**
    * Este método muestra en una cadena de caracteres la coordenada de una abeja.
    * @return cadena de caracteres con la coordenada de una abeja (x, y, z).
    */
   public String mostrarCoordenada(){
      String coordenada = "(" + x + ", " + y + ", " + z + ")";
      return coordenada;
    }
   
   /**
    * Este método permite obtener la latitud de una abeja robótica.
    * @return latitud en grados de una abeja.
    */
   public double getX(){
      return this.x;
   }
   
   /**
    * Este método permite obtener la longitud de una abeja robótica.
    * @return longitud en grados de una abeja.
    */
   public double getY(){
      return this.y;
   }
   
   /**
    * Este método permite obtener la altura sobre el nivel del mar de una abeja robótica.
    * @return altura en metros de una abeja.
    */
   public double getZ(){
      return this.z;
   }
}