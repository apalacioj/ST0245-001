import java.util.Scanner;
/**
 * Esta clase es una opción alternativa al ejercicio de 2.1 del laboratorio 4
 * @author Alejandra Palacio y Valentina Moreno 
 * @version 24/10/2020
 * 
 */
public class pruebaArbol {
    /**
    * El método main será la prueba final para ver si lo métodos de la clase 
    * BinaryTree y BinaryTreeNode son exitosos.
    * @param String args[]
    */
    public static void main(String args[]){
        BinaryTree arbol = new BinaryTree();
        int valor;
        BinaryTreeNode root = new BinaryTreeNode(0);

        System.out.println( "Insertando los siguientes valores: ");
    
        for (int i = 1; i<=10 ; i++){
            valor = (int) (Math.random() * 100);
            System.out.print(valor + " ");
            arbol.insertBinaryTreeNode(root,valor);
        }
        
        System.out.println("\n\nRecorrido preorden");
        arbol.showPreorder(root);
        
        System.out.println("\n\nRecorrido posorden");
        arbol.showPostorder(root);
    }
}
