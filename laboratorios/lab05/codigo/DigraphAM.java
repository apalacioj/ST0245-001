
import java.util.ArrayList;
/**
 * Esta clase implementa un dígrafo mediante matrices de adyacencia.
 * Nota --> este código tiene como base el codigo_estudiante dado por el docente.
 * @author Mauricio Toro, Valentina Moreno y Alejandra Palacio.
 * @version 1
 */
public class DigraphAM extends Graph{
    private int [][] grafoAM;

    /**
     * Este constructor inicializa un dígrafo con su número de vértices.
     * @param vertices - número de vértices del dígrafo.
     */
    public DigraphAM(int vertices) {
        super(vertices);
        grafoAM = new int[size][size];
    }

    /**
     * Este método agrega un arco entre dos vertices.
     * @param source - representa el inicio del arco.
     * @param destination - representa hacia donde va el arco.
     * @param weight - representa el valor o peso entre source y destination.
     */
    public void addArc(int source, int destination, int weight){
        grafoAM[source][destination] = weight;
    }

    /**
     * Este método retorna el número de todos los vértices que tengan conexión con uno.
     * @param vertice - nodo al cual se le buscan los nodos con los cuales tiene conexión.
     * @return vector dinámico con todos los nodos con los cuales vertice tiene conexion.
     */
    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> sucesores = new ArrayList<>();
        for (int i = 1; i < size(); i++) {
            if(grafoAM[vertice][i] == 0){
                continue;
            }else{
                sucesores.add(grafoAM[0][i]);
            }
        }
        return sucesores;
    }

    /**
     * Este método retorna el valor o peso que hay entre source y destination.
     * @param source - representa el inicio del arco.
     * @param destination - representa hacia donde va el arco.
     */
    public int getWeight(int source, int destination){
        int weight = grafoAM[source][destination];
        return weight;
    }
}