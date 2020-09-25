package ejerciciosLab3;

/**
 *Esta clase crea una nevera con sus respectivas características.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 23/09/2020
 */
public class Neveras {
    
    private final int codigo;
    private final String descripcion;
    
    /**
     * Este constructo inicializa los atributos de una nevera.
     * @param codigo - código de la nevera.
     * @param descripcion - descripción de una nevera en específico.
     */
    public Neveras(int codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
}
