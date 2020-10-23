import java.util.ArrayList;

/**
 * Esta clase implementa un grafo dirigido con matrices de adyacencia.
 */
public class DigraphAM extends Digraph { 
    private int [][] graph;

    /**
     * Este constructor inicializa el grafo dirigido implementado con matrices de adyacencia.
     * @param vertices número de vértices que tendra el grafo dirigido.
     */
    public DigraphAM(int size) {
        super(size);
        graph = new int [size][size];
        for (int i = 0; i < size; i++) {
            graph[0][i] = i;
            graph[i][0] = i;
        }
    }

    /**
     * Método para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo inicio y uno destino.
     * @param source representa el inicio del arco.
     * @param destination representa el final o hacia donde va el arco.
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        graph[source][destination] = weight; 
    }

    /**
     * Método para obtener una lista de hijos desde un nodo, es decir, todos los nodos
     * asociados al nodo pasado como argumento.
     * @param vertex nodo al cual se le busca los asociados o hijos.
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList.
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> sucesores = new ArrayList<>();
        for (int i = 1; i < size(); i++) {
            if(graph[vertex][i] == 0){
                continue;
            }else{
                sucesores.add(graph[0][i]);
            }
        }
        return sucesores;
    }

    /**
     * Método para obtener el peso o longitud entre dos nodos.
     * @param source representa el incio del arco.
     * @param destination representa el final o donde termina el arco.
     * @return entero que representa el peso entre los dos nodos determinados.
     */
    public int getWeight(int source, int destination) {
        int weight = graph[source][destination];
        return weight;
    }
}