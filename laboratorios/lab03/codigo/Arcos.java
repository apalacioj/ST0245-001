 /** 
 * Esta clase nos servirá de base para cada arco dado en un archivo. 
 * @author Valentina Moreno y Alejandra Palacio
 * @version 27/09/2020
 */
public class Arcos{
    /**
     * El valor de la identificación del primer vértice.
     */
    private int ID1;
    /**
     * El valor de la identificación del segundo vértice.
     */
    private int ID2 ;
    /**
     * Distancia ente los dos vértices.
     */
    private double distance;
    /**
     * Nombre del arco.
     */
     private String nombre;
    
    /**
     * El constructor recibirá los atributos mencionados anteriormente y estos serán declarados en cada instancia que se cree de la clase.
     * @param ID1 El valor de la identificación del primer vértice.
     * @param ID2 El valor de la identificación del segundo vértice.
     * @param distance Distancia ente los dos vértices.
     * @param nombre nombre del arco
     */
    public Vertices(int ID1, int ID2, double distance, String nombre){
        this.ID1 = ID1;
        this.ID2 = ID2;
        this.distance = distance;
        this.nombre = nombre;
    }

    /**
     * Este es un setter que reemplaza el valor de ID1 en la instancia
     * @param ID1 El valor de la identificación del primer vértice para el que se quiere cambiar.
     */
    public void setID1(int ID1){
        this.ID1 = ID1;
    }

     /**
     * Este es un setter que reemplaza el valor de ID2 en la instancia
     * @param ID2 El valor de la identificación del segundo vértice para el que se quiere cambiar.
     */
    public void setID2(int ID2){
        this.ID2 = ID2;
    }
    
    /**
     * Este es un setter que reemplaza el valor de distance en la instancia
     * @param distance El valor de la identificación del primer vértice para el que se quiere cambiar.
     */
    public void setDistance(double distance){
        this.distance = distance;
    }
    
    /**
     * Este es un setter que reemplaza el nombre del arco en la instancia
     * @param nombre nombre del arco por el que se quiere cambiar el de la instancia.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

     /**
     * Este es un getter que retorna el valor de ID1 en la instancia
     * @return valor de la identificación del primer vértice en la instancia.
     */
    public int getID1(){
        return this.ID1;
    }
    
    /**
     * Este es un getter que retorna el valor de ID2 en la instancia
     * @return valor de la identificación del segundo vértice en la instancia.
     */
    public int getID2(){
        return this.ID2;
    }
    
    /**
     * Este es un getter que retorna el valor de distance en la instancia
     * @return valor de la distancia entre el primer y el segundo vértice.
     */
    public double getDistance(){
        return this.distance;
    }
    
     /**
     * Este es un getter que retorna el nombre del arco en la instancia.
     * @return nombre del arco.
     */
    public String setNombre(){
        return this.nombre;
    }
    
}
