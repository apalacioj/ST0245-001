import java.util.ArrayList;
/**
 * Esta clase representa una línea en 2D en un videojuego.
 * 
 * @author Valentina Moreno y Alejandra Palacio 
 * @version 27/07/2020
 */
public class Line2D
{
    /**
     * Esta variable es un atributo privado y representa un Punto en el que iniciará la línea.
     */
    private Punto inicio;
    /**
     * Esta variable es un atributo privado y representa un Punto en el que terminará la línea.
     */
    private Punto fin;

    /**
     * El constructor inicializa los puntos de inicio y de fin de la línea.
     * @param Punto inicio
     * @param Punto fin
     */
    public Line2D(Punto inicio,Punto fin){
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     *Este método calcula y retorna los puntos intermedios en la línea que son coordenadas enteras.
     *@return ArrayList con referencias a Punto.
     */
    public ArrayList puntosIntermedios(){
        ArrayList <Punto> p = new ArrayList<>();
        double y = 0;
        double pendiente = (fin.y()-inicio.y())/(fin.x()-inicio.x());
        double b = inicio.y()-(pendiente*inicio.x());

        if(inicio.x() < fin.x()){
            for(double i = inicio.x()+1; i < fin.x(); i++){
                y = (pendiente*i) + b;
                if(y % 1 == 0){
                    p.add(new Punto(i,y));
                }
            }
        }

        if(inicio.x() > fin.x()){
            for(double i = fin.x()+1; i < inicio.x(); i++){
                y = (pendiente*i) + b;
                if(y % 1 == 0){
                    p.add(new Punto(i,y));
                }
            }
        }
        return p;
    }
    
    public void imprimirCoordenadas(ArrayList <Punto> p){
        for(Punto punto: p){
            System.out.println("("+punto.x()+","+punto.y()+")");
        }
    }
}

