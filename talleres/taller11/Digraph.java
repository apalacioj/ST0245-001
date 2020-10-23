import java.util.ArrayList;
/**
 * Esta clase sirve como base para representar un grafo dirigido, ya sea con listas de adyacencia o matrices de adyacencia.
 * Hace parte de la solución al taller 11 de ED1.
 */
public abstract class Digraph {
    protected int size;

    /**
     * Este constructor inicializa los vértices del grafo dirigido.
     * @param vertices numero de vértices que tendrá el grafo dirigido.
     */
    public Digraph(int vertices) {
        size = vertices;
    }

    /**
     * Método para añadir un arco nuevo, donde se representa cada nodo con un entero.
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino.   
     * @param source representa el inicio del arco.
     * @param destination representa hacia donde va el arco.
     * @param weight peso de la longitud entre source y destination.
     */
    public abstract void addArc(int source, int destination, int weight);

    /**
     * Método para obtener una lista de hijos desde un nodo, es decir, todos los nodos
     * asociados al nodo pasado como argumento.
     * @param vertex nodo al cual se le busca los asociados o hijos.
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList.
     */
    public abstract ArrayList<Integer> getSuccessors(int vertex);

    /**
     * Este método permite obtener el peso entre dos nodos.
     * @param source representa el inicio del arco.
     * @param destination representa hacia donde va el arco.
     * @return entero que representa el peso entre los dos nodos determinados.
     */  
    public abstract int getWeight(int source, int destination);

    /**
     * Método que permite obtener el tamaño del grafo.
     * @return entero que representa el tamaño del grafo.
     */
    public int size() {
        return size;
    }
}