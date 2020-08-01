/**
 * Esta clase crea un punto en 3D y mediante sus métodos, realiza diferentes cálculos.
 * 
 * @author Valentina Moreno Ramírez y Alejandra Palacio. 
 * @version 27/07/2020
 */
public class Punto3D
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
     * La variable z es un atributo privado y representa la posición del punto respecto al eje z.
     */
    private double z;

    /**
     * Este constructor inicializa los valores de x, y, z.
     */
    public Punto3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
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
     * Este método devuelve el valor que se le tenga asignado a z.
     * @return z
     */
    public double z(){
        return this.z;
    }

    /**
     * Este método calcula el radio polar desde el origen.
     * @return radio polar
     */
    public double radio(){
        return Math.round(Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2) + Math.pow(this.z,2))*1000d)/1000d;
    }

    /**
     * Este método calcula el ángulo de dos vectores.
     * @return ángulo 
     */
    public double angulo(Punto3D otro){
        double num = (this.x*otro.x())+(this.y*otro.y())+(this.z*otro.z());
        double den1 = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2)+Math.pow(this.z,2));
        double den2 = Math.sqrt(Math.pow(otro.x(),2)+Math.pow(otro.y(),2)+Math.pow(otro.z(),2));
        return Math.round(Math.acos(num/(den1*den2))*1000d)/1000d;
    }

    /**
     * Este método la distancia euclidiana entre dos puntos.
     * @param Punto otro
     * @return distancia euclidiana
     */
    public double distancia(Punto3D otro){
        double distanciaX = this.x - otro.x();
        double distanciaY = this.y - otro.y();
        double distanciaZ = this.z - otro.z();
        return Math.round(Math.sqrt(Math.pow(distanciaX,2) + Math.pow(distanciaY,2) + Math.pow(distanciaZ,2))*1000d)/1000d;
    }
}
