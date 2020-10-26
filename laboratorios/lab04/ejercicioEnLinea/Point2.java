import java.util.ArrayList;
/**
Esta clase es una de las soluciones propuestas para el ejercicio 2.1 del laboratorio 4, en la cual 
* imprimirá un árbol de manera postordenada 
*/
public class Point2
{
    /**
     * Esta clase interna nos ayudará a crear cada Nodo que tendrá el árbol
     */
    public class Node {
        /**
         * Este será el dato que se tendrá a la izquierda del nodo actual
         */
        public Node left;
        /**
         * Este será el dato que se tendrá a la derecha del nodo actual 
         */
        public Node right;
        /**
         * Valor que tendrá el nodo
         */
        public int data;
        /**
         * Este será el constructor del nodo, tendrá por defecto el nodo derecho e izquierdo en null y se le agregará
         * el valor pedido 
         * @param data valor que se le agregará al nodo 
         */
        public Node (int data) {
            this.data=data;
        }
    }
    /** 
     * Raíz del árbol o el inicio de este
     */
    public Node root;

    /**
     * Este método nos agregará un nuevo nodo en nuestro árbol
     * @param data valor que tendrá el nodo 
     */
    public void insert (int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        insertarAux(root, data, null);
    }

    /**
     * Este método auxiliar nos ayudará con el proceso de agregación del nodo en el árbol
     * @param node raíz del ðabol
     * @param n valor que se agregará al nuevo nodo 
     * @param ant nodo anterior
     */
    private void insertarAux(Node node, int n, Node ant) { //Complejidad O(log(n))
        //...
        if (node == null) {
            if (n >= ant.data) {
                ant.right = new Node(n); 
            } else {
                ant.left = new Node(n);
            }
        }
        else if (n < node.data) insertarAux(node.left , n, node); //T(n) = T(n/2)
        else insertarAux(node.right, n, node);                    //T(n) = T(n/2)        
    } 

    /**
     * Este método nos permitirá crear el árbol recibiendo los valores de este de una manera preordenada
     * @param preOrder arreglo con los valores preorder del árbol
     */
    public void buildingTree (int [] preOrder) {
        for(int i = 0; i< preOrder.length; i++){
            insert(preOrder[i]);
        }
    }

    /**
     * Este método nos permitirá imprimir el árbol realizando las siguientes operaciones recursivamente en cada nodo, comenzando con el nodo de raíz:
     * 1.Visite la raíz
     * 2.Atraviese el sub-árbol izquierdo
     * 3.Atraviese el sub-árbol derecho
     * @param nodo inicio del árbol
     */
    public void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);               
        }
    }


    /**
     * Este método nos permitirá imprimir el arbol realizando las siguientes operaciones recursivamente en cada nodo:
     * Atraviese el sub-árbol izquierdo
     * Atraviese el sub-árbol derecho
     * Visite la raíz
     * @param nodo inicio del árbol
     */
    public void posOrder(Node node) {
        if (node == null) {
            return;
        } else {
            posOrder(node.left);
            posOrder(node.right);           
            System.out.println(node.data);          
        }
    }

    /**
     * Ejercicio 2.1 resuelto 
     * @param input valores preorder que serán organizados de manera postordenada
     */
    public void exercise21 (int [] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(root);
        System.out.println();
    }

    /**
     * Método para probar que nuestro código está correcto 
     * @param args
     */
    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}
