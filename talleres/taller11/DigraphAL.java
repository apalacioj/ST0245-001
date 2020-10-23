import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * Esta clase implementa un grafo dirigido con listas de adyacencia.
 */
public class DigraphAL extends Digraph { 
    private ArrayList<LinkedList< Pair<Integer, Integer> >> arregloDeListas;

    /**
     * Este constructor inicializa el grafo dirigido implementado con listas de adyacencia.
     * @param vertices número de vértices que tendrá el grafo dirigido.
     */
    public DigraphAL(int size) {
        super(size);
        arregloDeListas = new ArrayList<LinkedList< Pair<Integer, Integer> >>();
        for (int i = 0; i < size; i++) {
            arregloDeListas.add(new LinkedList<Pair<Integer, Integer>>()); 
        }
    }

    /**
     * Método para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino.
     * @param source representa el inicio del arco.
     * @param destination representa hacia donde va el arco.
     * @param weight el peso de la longitud entre source y destination.
     */
    public void addArc(int source, int destination, int weight) {
        /*if(arregloDeListas.get(source) == null){
        arregloDeListas.add(source, new LinkedList<Pair<Integer, Integer>>());       
        }*/
        int n = 0;
        if (source >= this.size) {
            for (int i = 0; i < this.size - source + 1; i++) {
                arregloDeListas.add(new LinkedList<Pair<Integer, Integer>>());
                n++;
            }
        } else if (destination >= this.size) {
            for (int i = 0; i < this.size - destination + 1; i++) {
                arregloDeListas.add(new LinkedList<Pair<Integer, Integer>>());
                n++;
            }
        }
        this.size += n;
        arregloDeListas.get(source).add(new Pair(destination, weight));
    }

    /**
     * Método para obtener una lista de hijos desde un nodo, es decir, todos los nodos
     * asociados al nodo pasado como argumento.
     * @param vertex nodo al cual se le busca los asociados o hijos.
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList.
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> sucesores = new ArrayList<>();
        LinkedList< Pair<Integer, Integer> > destinos = arregloDeListas.get(vertex);
        for (int i = 0; i < destinos.size(); i++) {
            sucesores.add(destinos.get(i).getKey());
        }
        return sucesores;
    }

    /**
     * Método para obtener el peso o longitud entre dos nodos.
     * @param source representa el inicio del arco.
     * @param destination representa el final del arco.
     * @return entero que representa el peso entre los dos nodos determinados.
     */
    public int getWeight(int source, int destination) {
        //ArrayList<LinkedList< Pair<Integer, Integer> >> arregloDeListas;
        LinkedList< Pair<Integer, Integer> > destinos = arregloDeListas.get(source);
        for (int i = 0; i < destinos.size(); i++){
            if (destinos.get(i).getKey() == destination){
                return destinos.get(i).getValue();
            }
        }
        return -1;
    }
}