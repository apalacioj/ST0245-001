
/**
 * Esta clase crea un punto en 2D y mediante sus métodos, realiza diferentes cálculos.
 * 
 * @author Valentina Moreno Ramírez y Alejandra Palacio. 
 * @version 27/07/2020
 */
public class Punto
{
    /**
     * La variable x es un atributo privado y representa la posición del punto respecto al eje x.
     */
    private double x;
    /**
     * La variable y es un atributo privado y representa la posición del punto respecto al eje y.
     */
    private double y;
    
    /**
     * Este constructor inicializa los valores de x e y.
     */
    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Este método devuelve el valor que se le tenga asignado a x.
     * @return x
     */
    public double x(){
        return this.x;
    }
    
    /**
     * Este método devuelve el valor que se le tenga asignado a y.
     * @return y
     */
    public double y(){
        return this.y;
    }
    
    /**
     * Este método calcula el radio polar desde el origen.
     * @return radio polar
     */
    public double radioPolar(){
        return Math.round(Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2))*1000d)/1000d;
    }
    
    /**
     * Este método calcula el ángulo polar desde el eje x.
     * @return ángulo polar
     */
    public double anguloPolar(){
        return Math.round(Math.atan2(y,x)*1000d)/1000d;
    }
    
    /**
     * Este método la distancia euclidiana entre dos puntos.
     * @param Punto otro
     * @return distancia euclidiana
     */
    public double distanciaEuclidiana(Punto otro){
        double distanciaX = this.x - otro.x();
        double distanciaY = this.y - otro.y();
        return Math.round(Math.sqrt(Math.pow(distanciaX,2) + Math.pow(distanciaY,2))*1000d)/1000d;
    }
}
