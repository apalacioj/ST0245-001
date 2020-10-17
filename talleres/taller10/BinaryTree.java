
/**
 * Esta clase contiene la solución al taller 10 sobre árboles binarios de búsqueda.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo
 * @version 2
 */
public class BinaryTree
{
    public Node root;

    public BinaryTree(Node root){
        this.root = root;
    }

    /**
     * Este método inserta un dato en un árbol binario de búsqueda.
     * @param n el dato del nodo que se quiere insertar.
     * @see método insertarAux
     */
    public void insertar(int n) {
        if (root == null) {
            root = new Node(n);
            return;
        }
        insertarAux(root, n, null);
    }

    /**
     * Este método inserta un dato en el árbol binario de búsqueda de acuerdo con las desigualdades.
     * Agrega a la izquierda del nodo los valores menores que el que contiene el nodo y a la derecha, los mayores o iguales.
     * @param node es la raíz del arbol.
     * @param n el dato del nodo que se quiere insertar.
     * Inserta un dato respetando claro las desigualdades en el árbol
     */
    private void insertarAux(Node node, int n, Node anterior) { 
        if (node == null) {
            if (n >= anterior.data) {
                anterior.right = new Node(n); 
            } else {
                anterior.left = new Node(n);
            }
        }else if (n < node.data){
            insertarAux(node.left , n, node);
        }else{
            insertarAux(node.right, n, node);      
        }
        //Complejidad O(log(n))
    }                                                        

    /**
     * Este método busca si un dato específico se encuentra en el árbol.
     * @param n el dato del nodo que se busca.
     * @return true si el metodo buscarAux es true, es decir, si se encuentra el elemento.
     * @see método buscarAux
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * Este método busca en un árbol si cierto elemento se encuentra en él.
     * @param node es la raíz del arbol.
     * @param n el data del nodo que se busca.
     * @return true si se encuentra el elemento en el árbol, de lo contrario, false.
     */ 

    private boolean buscarAux(Node node, int n) { //Complejidad O(log(n))
        if (node == null){ 
            return false;
        }
        if (node.data == n){
            return true; 
        }
        if (n > node.data) {
            return buscarAux(node.right, n);
        }
        return buscarAux(node.left, n); 
    }

    /**
     * Este método imprime el resultado del método codigoAux, lo cual se debe insertar en la página www.webgraphviz.com para ver el árbol dibujado.
     * @see método codigoAux
     */
    public void codigo() {
        System.out.println("Inserta el siguiente codigo en la pagina: ");
        System.out.println("http://www.webgraphviz.com/");
        codigoAux(root);
    }

    /**
     * Este método imprime en determinado formato la manera en que están organizados los nodos en el árbol, de acuerdo a las desigualdades del mismo.
     * @param n es la raíz del árbol.
     */
    private void codigoAux(Node n) {
        boolean a = false;
        boolean b = false;
        if(n.left != null && n.right != null){
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.left.data + "\"");
           codigoAux(n.left);
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.right.data + "\"");
            codigoAux(n.right);
        }else if(n.left == null && n.right !=null){
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.right.data + "\"");
            codigoAux(n.right);
        }else if(n.left != null && n.right == null){
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.left.data + "\"");
            codigoAux(n.left);
        }
        //T(n) = 2T(n/2) + c
        //Complejidad = O(n)
    }                           

    public static void main(String [] args){
        BinaryTree Tree = new BinaryTree(new Node(4));
        Tree.insertar(3);
        Tree.insertar(7);
        Tree.insertar(2);
        Tree.insertar(6);
        Tree.insertar(3);
        Tree.insertar(1);
        Tree.insertar(9);
        Tree.insertar(10);
        Tree.codigo();
        System.out.println(Tree.buscar(7));
        System.out.println(Tree.buscar(10));
        System.out.println(Tree.buscar(20));
    }
}
