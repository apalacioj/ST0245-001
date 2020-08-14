
/**
 * La clase contiene los algoritmos que resuleven el taller 3 (recursión avanzada).
 * 
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 11/08/2020
 */
public class Taller03
{ 
    /**
     * Este método auxiliar calcula los movimientos que se deben realizar para pasar, en el menor número de pasos, los discos de la torre 1 
     * a la torre 3 en las torres de Hanoi, siguiendo las reglas de juego.
     * @param int n: número de discos.
     * @param int torre1: torre de origen.
     * @param int torre2: torre intermedia o auxiliar.
     * @param int torre3: torre final o de destino.
     */
    private static void torresDeHannoiAux(int n, int torre1, int torre2, int torre3){
        if(n == 0){
            return;
        }else{
            torresDeHannoiAux(n-1, torre1, torre3, torre2);
            System.out.println("Mover un disco de la torre "+torre1+" a la torre "+torre3+".");
            torresDeHannoiAux(n-1, torre2, torre1, torre3);
        }
    }

    /**
     * Este método calcula los movimientos para pasar los discos de la torre 1 a la torre 3 en el juego de las Torres de Hanoi.
     * @param int n: número de discos.
     */
    public static void torresDeHannoi(int n) {
        torresDeHannoiAux(n, 1, 2, 3);
    }

    /**
     * Este método auxiliar halla las permutaciones de una cadena de caracteres.
     * @param String base
     * @param String s: cadena de caracteres.
     */
    private static void permutationsAux(String base, String s){
        if(s.length() == 0){
            System.out.println(base);
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(base));
        }else{
            for(int i = 0; i<s.length(); i++){
                permutationsAux(base + s.charAt(i), s.substring(0, i)+s.substring(i+1, s.length()));
            }
        }
    }

    /**
     * Este método halla las permutaciones de una cadena de caracteres.
     * @param String s: cadena de caracteres.
     */
    public static void permutations(String s){
        permutationsAux("", s);
    }
}

