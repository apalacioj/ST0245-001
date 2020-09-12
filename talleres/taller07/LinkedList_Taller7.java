
import java.lang.IndexOutOfBoundsException;

/**
 *Esta clase representa una lista simplemente enlazada que almacena coordenadas de abeja.
 *Permite realizar diferentes operaciones como insertar, borrar, buscar y decir si una coordenada está contenida en la lista enlazada o no.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo
 * @version 10/09/2020
 */
public class LinkedList_Taller7 {
    private Nodo first;
    private int size;

    public LinkedList_Taller7(){
        size = 0;
        first = null;	
    }

    /**
     * Este método retorna un nodo en una posición determinada
     * @param index índice del nodo que se retornará
     * @return nodo en el índice determinado por el usuario.
     * @throws IndexOutOfBoundsException
     */
    private Nodo getNodo(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && size > index) {
            Nodo temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }                                                                                     //Complejidad --> O(n), donde n es la longitud de la Linked List.

    /**
     * Este método retorna la coordenada de una abeja contenida en un índice determinado
     * @param index índice de la coordenada de la abeja a retornar
     * @return coordenadas de la abeja en el índice determinado
     * @throws IndexOutOfBoundsException
     */
    public abeja getAbeja(int index) throws IndexOutOfBoundsException {
        Nodo temp = getNodo(index);
        return temp.data;
    }                                                                                     //Complejidad --> O(n), donde n es la longitud de la Linked List.

    /**
     * Este método retorna la longitud de la lista actual.
     * @return tamaño de la lista
     */
    public int size(){
        return size;
    }

    /**
     * Este método agregar una coordenada de abeja en la lista en un índice dado por el usuario.
     * @param a coordenada de abeja que se quiere agregar a la lista.
     * @param index índice en el cual se quiere agregar la coordenada de la abeja. 
     */
    public void add(Nodo a, int index){
        if(index == 0){
            Nodo vertice = a;
            vertice.apuntar(first);
            first = vertice;

        }
        else if(index == size){
            Nodo vertice = a;
            Nodo temp = first;
            for (int i = 0; i < size; i++) {                                                //Complejidad --> O(n), donde n es la longitud de la Linked List.        
                temp = temp.next;
            }
            temp.apuntar(vertice);
            
        }
        else if(index >= 0){                                            
            Nodo temp = first;
            for(int i = 0; i < index-1; i++){                                                //Complejidad --> O(n), donde n es la longitud de la Linked List.
                temp = temp.getNext();
            }
            Nodo temp2 = temp.getNext();
            Nodo vertice = a;
            vertice.apuntar(temp2);
            temp.apuntar(vertice);
            
        }
        else return;
    }                                                                                       //La complejidad asintótica del algoritmo para el peor de los casos es O(n), donde                                         
                                                                                            // n es la longitud de la Linked List. Si se tienen millones de coordenadas de abejas
                                                                                            // el algoritmo resultaría ineficiente para cuando se quieran agregar abejas en la
                                                                                            // mitad de la lista, por tanto, resultaría mejor un algoritmo con una complejidad 
                                                                                            // que implique menor tiempo de ejecución como una complejidad logarítmica o constante.
    /**
     * Este método elimina una coordenada de abeja en la lista en un índice dado por el usuario.
     * @param index índice de la coordenada de abeja que se quiere eliminar.
     */
    public void remove(int index){
        if(size == 0){
            return;
        }
        else if(index == 0){
            Nodo temp = first;
            first = first.getNext();
            temp.remove();
            
        } 
        else if(index == size){
            Nodo temp = first;
            Nodo temp2 = first.getNext();
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp2.setNext(null);
            temp.remove();
        }
        else if(index >= 0){
            Nodo temp = first;
            for(int i = 0; i < index-1; i++){
                temp = temp.getNext();
            }
            Nodo temp2 = temp.getNext();
            Nodo temp3 = temp2.getNext();
            temp2.remove();
            temp.apuntar(temp3);

        }

    }                                                                                        //Complejidad --> O(n), donde n es la longitud de la Linked List.                                        

    /**
     * Este método revisa si la lista contiene cierta coordenada de una abeja.
     * @param a coordenada de la abeja que se buscará en la lista para saber si está o no.
     * @return true, si la coordenada se encuentra en la lista, de lo contrario, false. 
     */
    public boolean contains(abeja a){
        Nodo temp = first;
        for(int i = 0; i<size ; i++){
            if(temp.data == a){
                return true;
            }
            temp = temp.next;
        }
        return false;

    }                                                                                        //Complejidad --> O(n), donde n es la longitud de la Linked List.

    public void containsPosition(abeja a){
        Nodo temp = first;
        int cont = 0;
        for(int i = 0; i<size ; i++){
            if(temp.data == a){
                System.out.println("Abeja encontrada en la posición: " + cont);
                break;
            }
            temp = temp.next;
        }
        System.out.println("Abeja no encontrada");;

    }                                                                                        //Complejidad --> O(n), donde n es la longitud de la Linked List.
}
