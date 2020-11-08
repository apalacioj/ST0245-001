import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;
/**
 * Write a description of class isBicolored here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class isBicolored extends Digraph{

    private ArrayList<LinkedList<Integer>> arregloDeListas;

    /**
     * Este constructor inicializa el grafo dirigido implementado con listas de adyacencia.
     * @param vertices número de vértices que tendrá el grafo dirigido.
     */
    public isBicolored(int size) {
        super(size);
        arregloDeListas = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < size; i++) {
            arregloDeListas.add(new LinkedList<Integer>()); 
        }
    }

    /**
     * Método para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino.
     * @param source representa el inicio del arco.
     * @param destination representa hacia donde va el arco.
     * @param weight el peso de la longitud entre source y destination.
     */
    public void addArc(int source, int destination) {
        int n = 0;
        if (source >= this.size) {
            for (int i = 0; i < this.size - source + 1; i++) {
                arregloDeListas.add(new LinkedList<Integer>());
                n++;
            }
        } else if (destination >= this.size) {
            for (int i = 0; i < this.size - destination + 1; i++) {
                arregloDeListas.add(new LinkedList<Integer>());
                n++;
            }
        }
        this.size += n;
        arregloDeListas.get(source).add(destination);
        arregloDeListas.get(destination).add(source);
    }

    /**
     * Método para obtener una lista de hijos desde un nodo, es decir, todos los nodos
     * asociados al nodo pasado como argumento.
     * @param vertex nodo al cual se le busca los asociados o hijos.
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList.
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> sucesores = new ArrayList<>();
        LinkedList<Integer> destinos = arregloDeListas.get(vertex);
        for (int i = 0; i < destinos.size(); i++) {
            sucesores.add(destinos.get(i));
        }
        return sucesores;
    }

    /**
     * Este método determina si un grafo conexo arbitrario se puede colorear con dos colores diferentes, teniendo en cuenta 
     * que no pueden haber 2 nodos adyacentes con el mismo color.
     * @param i - nodo raíz en el cual se comenzará la búsqueda en sus respectivos vecinos.
     */
    public boolean isBicolored(int i){
        String [] a = new String[size()];
        LinkedList<Integer> b = new LinkedList<>();
        b.add(i);
        a[i] = "Rojo";
        while(!b.isEmpty()){
            int c = b.pop();
            LinkedList <Integer> aux = arregloDeListas.get(c);
            for(Integer d : aux){
                if(a[d] == null && a[c] == "Rojo"){
                    b.add(d);
                    a[d] = "Azul";
                }
                if(a[d] == "Azul" && a[c] == "Azul"){
                    return false;      
                }
            }
        }
        return true;
    }

    /**
     * Este método principal permite probar el algoritmo anterior.
     */
    public static void main(String[] args){
        isBicolored z = new isBicolored(3);
        z.addArc(0,1);
        z.addArc(1,2);
        z.addArc(2,0);
        if(z.isBicolored(0)==false){
            System.out.println("IS NOT BICOLORABLE");
        }else{
            System.out.println("IS BICOLORABLE");
        }
        isBicolored y = new isBicolored(3);
        y.addArc(0,1);
        y.addArc(1,2);
        if(y.isBicolored(0)==false){
            System.out.println("IS NOT BICOLORABLE");
        }else{
            System.out.println("IS BICOLORABLE");
        }
        isBicolored x = new isBicolored(9);
        x.addArc(0,1);
        x.addArc(0,2);
        x.addArc(0,3);
        x.addArc(0,4);
        x.addArc(0,5);
        x.addArc(0,6);
        x.addArc(0,7);
        x.addArc(0,8);
        if(x.isBicolored(0)==false){
            System.out.println("IS NOT BICOLORABLE");
        }else{
            System.out.println("IS BICOLORABLE");
        }
    }
}
