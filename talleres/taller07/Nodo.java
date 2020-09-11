 

/**
 *Esta clase inicializa un nodo para nuestra Linked List.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 10/09/2020
 */
public class Nodo {
    public abeja data;
    public Nodo next;
    
    /**
     * Este constructor inicializa un nodo para la lista simplemente enlazada. 
     * @param data coordenada de abeja que contiene el nodo
     */
    public Nodo(abeja data){
	next = null;
	this.data = data;
    }

    /**
     * Este método retorna el nodo que le sigue al nodo actual. 
     * @return Nodo, nodo siguiente.
     */
    public Nodo getNext(){
        return next;
    }

    /**
     * Este método retorna los datos almacenados en el nodo
     * @return datos guardados, en este caso serían coordenadas
     */
    public abeja getData(){
        return this.data;
    }
    
    /**
     * Este método establece un nuevo nodo que le sigue al nodo actual 
     * @param n, nodo que le seguirá
     */
    public void setNext(Nodo n ){
        next = n;
    }

     /**
     * Este método establece el valor de las coordenadas del nodo
     * @param n, datos que tendrá el nodo
     */
    public void setData(abeja a){
        this.data = a;
    }

    /**
     * Este método nos permite relacionar dos nodos.
     * @param n nodo al que se dirigirá el nodo actual
     */
    public void apuntar(Nodo n){
        next = n;
    }

    /**
     * Este método elimina el nodo 
     */
    public void remove(){
        this.data = null;
        next = null;
    }

}
