import java.util.Scanner;
/**
 * Esta clase contiene la implementación de los algoritmos recursivos propuestos en el taller.
 * Adicionalmente, hay otros métodos que muestran en pantalla su resultado al usuario.
 * 
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 03/08/2020
 */
public class Taller02
{
    /**
     * Este método calcula el mcd entre dos números enteros.
     * @param int a
     * @param int b
     * @see mcd()
     */
    private static int punto1(int a, int b){
        if(a>b){
            if(b==0){
                return a;
            }else{
                return punto1(b,a%b);
            }
        }else if(b>a){
            if(a==0){
                return b;
            }else{
                return punto1(a,b%a);
            }
        }else{
            return a;
        }
    }

    /**
     * Este método permite observar las opciones y el resultado en pantalla.
     */
    public static void mcd(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese las dimensiones de la habitación para calcular el tamaño de las baldosas:");
        int a = scan.nextInt();
        int b = scan.nextInt();
        if(a==0 & b==0){
            System.out.println("ERROR");
            System.out.println("Fin del programa");
        }
        System.out.println("El lado de la baldosa cuadrada para la habitación dada es: "+punto1(a,b));
        System.out.println("Fin del programa");
    }

    /**
     * Este método nos permite atravesar por un arreglo de pesos de elementos de un jugador
     * y calculará si la combinación de alguno de estos logra llegar al objetivo.
     * @param int start
     * @param int[] nums
     * @param int target
     * @return boolean
     * 
     * @see sumaGrupo
     */
    private static boolean punto2(int start, int[] nums, int target){
        if(start<nums.length & target!=0){
            return punto2(start+1, nums, target) || punto2(start+1, nums, target-nums[start]);
        } else if(target == 0){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Este método no permitirá calcular el los elementos de una lista de pesos que
     * logran cumplir con el target
     * @param int[] nums
     * @param int target
     * 
     * @return boolean
     */
    public static boolean sumaGrupo(int [] nums, int target){
        return punto2(0, nums, target);
    }

    /**
     * Este método recibe un grupo de elementos y muestra en pantalla, todos los posibles 
     * subgrupos que se pueden formar con esos elementos.
     * 
     * @param String prefix
     * @param String s
     */
    private static void punto3(String prefix, String s) {
        if(s.length() == 0) {
            System.out.println(prefix);
        }else{
            punto3(prefix + s.charAt(0), s.substring(1));
            punto3(prefix, s.substring(1));
        }
    }

    /**
     * Este método recibe un grupo de elementos y muestra en pantalla, todos los posibles 
     * subgrupos que se pueden formar con esos elementos.
     * @param String s
     */ 
    public static void combinations(String s) {
        punto3("", s);
    }

    /**
     * Este método calcula la longitud de la subsecuencia común más larga a dos 
     * cadenas de caracteres.
     * @param String s1
     * @param String s2
     * @param int n1
     * @param int n2
     * 
     * @return int
     */
    public static int punto4(String s1, String s2, int n1, int n2){
        if(n1 == 0 || n2 == 0 ){
            return 0;
        }

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return 1 + punto4(s1, s2, n1-1, n2-1);
        }
        else return Math.max(punto4(s1, s2, n1-1, n2), punto4(s1, s2, n1, n2-1));
    }  
}
