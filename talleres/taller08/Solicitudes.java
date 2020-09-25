/**
 *Esta clase crea una solicitud de nevras con sus respectivos datos.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 23/09/2020
 */
public class Solicitudes {
    private final String tienda;
    private final int cantidadNeveras;
    
    /**
     * Este constructor inicializa una solicitud.
     * @param tienda - nombre de la tienda que realizó la solicitud.
     * @param cantidadNeveras - cantidad de neveras que solicitó determinada tienda.
     */
    public Solicitudes(String tienda, int cantidadNeveras){
        this.tienda = tienda;
        this.cantidadNeveras = cantidadNeveras;
    }
    
    public int getCantidadNeveras(){
        return cantidadNeveras;
    }
    
    public String getTienda(){
        return tienda;
    }
}

