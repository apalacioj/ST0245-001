import java.util.LinkedList;
import java.util.Queue;
/**
 * Esta clase será la base de un arbol binario que tendrá todos lo métodos que este requiere
 * @author Alejandra Palacio y Valentina Moreno 
 * @version 25/10/2020
 * 
 */
;public class BinaryTree {


    /**
     * Este método nos permitirá buscar el valor máximo en todas las hojas de un árbol binario
     * @param root inicio del árbol
     * @return el número más grande encontrado en la raíz
     */
    public int maxValueBinaryTree(BinaryTreeNode root){
        int maxValue = Integer.MIN_VALUE;
        
        if(root != null){
            int leftMax = maxValueBinaryTree(root.left);
            int rightMax = maxValueBinaryTree(root.right);

            if(leftMax > rightMax){
                maxValue = leftMax;
            }
            else{
                maxValue = rightMax;
            }
            if(root.data > maxValue){
                maxValue = root.data;
            }

        }                                       ///O(n)
        return maxValue;
    }

    /**
     * Este método nos permitirá saber si un elemento buscado se encuentra o no en el árbol
     * @param root inicio del árbol
     * @param data valor a buscar
     * @return true si el elemento fue hallado, false si este no existe.
     */
    public boolean findElement(BinaryTreeNode root, int data){
        if(root == null){
            return false;
        }
        if(root.getData() == data){           //O(n)
            return true;
        }
        return findElement(root.getLeft(), data) || findElement(root.getRight(), data);
    }

    /**
     * Este método sirve para agregar un nodo a nuestro árbol
     * @param root inicio del árbol
     * @param data dato que se agregará
     * @return la nueva raíz del árbol con el valor ya agregado 
     */
    public BinaryTreeNode insertBinaryTreeNode(BinaryTreeNode root, int data){
        if(root == null){
            return null;
        }

        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();

        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode temp = q.poll();
            if(temp != null){
                if(temp.getLeft() != null){
                    q.offer(temp.getLeft());
                }
                else{
                    temp.left = new BinaryTreeNode(data);
                    return root;
                }
            }
            if(temp.right != null){
                q.offer(temp.right);
            }
            else{
                temp.right = new BinaryTreeNode(data);
                return root;
            }
        }
        return root;
    }

    /**
     * Este método nos permitirá saber el tamaño del árbol
     * @param root inicio del árbol
     * @return entero con el tamaño del árbol
     */
    public int size(BinaryTreeNode root){
        int leftCont = root.left == null? 0: size(root.left);
        int rightCont = root.right == null? 0: size(root.right);
        return 1 + leftCont + rightCont;
    }

    /**
     * Este método nos permitirá imprimir el árbol realizando las siguientes operaciones recursivamente en cada nodo, comenzando con el nodo de raíz:
     * 1.Visite la raíz
     * 2.Atraviese el sub-árbol izquierdo
     * 3.Atraviese el sub-árbol derecho
     * @param nodo inicio del árbol
     */
    public  void showPreorder(BinaryTreeNode nodo){
        if (nodo == null){
            return;
        }
    
        System.out.println(nodo.data); 
        showPreorder(nodo.left); 
        showPreorder(nodo.right);
    }

    /**
     * Este método nos permitirá imprimir el arbol realizando las siguientes operaciones recursivamente en cada nodo:
     * Atraviese el sub-árbol izquierdo
     * Atraviese el sub-árbol derecho
     * Visite la raíz
     * @param nodo inicio del árbol
     */
    public void showPostorder(BinaryTreeNode nodo){
        if (nodo == null)
            return;

        showPostorder(nodo.left);
        showPostorder(nodo.right);
        System.out.println(nodo.data);
    }
}
