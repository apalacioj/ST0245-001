/** 
 * Esta clase nos servirá de base para cada vertice dado en un archivo 
 * @author Valentina Moreno y Alejandra Palacio
 * @version 27/09/2020
 */
public class Vertices{
    /**
     * El valor del vértice
     */
    private long vertice;
    /**
     * La coordenada X del vértice
     */
    private double x;
    /**
     * La coordenada Y del vértice
     */
    private double y;
    
    /**
     * El constructor recibirá los atributos mencionados anteriormente y estos serán declarados en cada instancia que se cree de la clase
     * @param vertice
     * @param x
     * @param y
     */
    public Vertices(long vertice, double x, double y){
        this.vertice = vertice;
        this.x = x;
        this.y = y;
    }

    /**
     * Ese es un setter que reemplaza el valor de el vértice en la instancia
     * @param vertice 
     */
    public void setVertice(long vertice){
        this.vertice = vertice;
    }

     /**
     * Ese es un setter que reemplaza el valor de la coordenada X en la instancia
     * @param x
     */
    public void setX(double x){
        this.x = x;
    }

    /**
     * Ese es un setter que reemplaza el valor de la coordenada Y en la instancia
     * @param y
     */
    public void setY(double y){
        this.y = x;
    }

    /**
     * Ese es un getter que retorna de el vértice
     * @return vértice de la instancia
     */
    public long getVertice(){
        return this.vertice;
    }
    /**
     * Ese es un getter que retorna la coordenada X
     * @return el X de la instancia
     */
    public double getX(){
        return this.x;
    }
    /**
     * Ese es un getter que retorna la coordenada y
     * @return el Y de la instancia
     */
    public double getY(){
        return this.y;
    }
    

    
}