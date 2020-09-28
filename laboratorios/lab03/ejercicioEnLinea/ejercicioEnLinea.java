import java.util.LinkedList;

/**
 * Esta clase contiene el algoritmo que soluciona el ejercicio 2.1 del Lab03.
 * 
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 26/09/2020
 */
public class ejercicioEnLinea
{
    /**
     * Este método soluciona el ejercicio del teclado roto, el cual plantea que, cuando aparece '[', la tecla inicio se oprime internamente, mientras que
     * cuando se oprime ']', la tecla fin se oprime internamente. El objetivo del método es retornar el texto en la forma que quedaría con las
     * especificaciones anteriores.
     * @param s - cadena de caracteres, los cuales se ordenarán de acuerdo a los '[' y ']' que contengan.
     * @return cadena de caracteres de acuerdo a lo mencionado anteriormente.
     */
    public static String tecladoRoto(String s){
        LinkedList <Character> texto = new LinkedList <>();
        boolean inicio = true;
        String texto1 = "";
        boolean firstTime = true;
        int j = 0;
        StringBuilder s1 = new StringBuilder(s);

        for(int i = 0; i<s1.length(); i++){ //O(n)
            if(s1.charAt(i) == '['){
                j=0;
                StringBuilder aux = s1.deleteCharAt(i); //O(n)
                if(i<aux.length()){
                    if(aux.charAt(i) == '[' || aux.charAt(i) == ']'){
                        i = i-1;
                        s1=aux;
                        continue;                    
                    }
                    s1 = aux;
                    texto.addFirst(s1.charAt(i));
                    inicio = true;
                    firstTime = false;
                    j++;
                }
            }else if(s1.charAt(i) == ']'){
                StringBuilder aux = s1.deleteCharAt(i); //O(n)
                if(i<aux.length()){
                    if(aux.charAt(i) == '[' || s1.charAt(i) == ']'){
                        i = i-1;
                        s1=aux;
                        continue;
                    }
                    s1 = aux;
                    texto.addLast(s1.charAt(i));
                    inicio = false;
                    firstTime = true;
                }
            }else{
                if(inicio && !firstTime){
                    texto.add(j,s1.charAt(i)); //O(n)
                    firstTime = false;
                    j++;
                }else{
                    texto.addLast(s1.charAt(i));
                }
            } 
        }
        for(int i = 0; i<texto.size(); i++){ //O(m)
            texto1 += texto.get(i); 
        }

        return texto1;
        //Complejidad asintótica para el peor de los casos --> O(n^2 + m), donde n es la longitud de la cadena de 
        //caracteres a organizar de acuerdo a los '[' y ']' que contenga y m es la longitud de la lista resultante
        //al organizar la cadena de caracteres. Como m puede ser menor que n porque para obtener la lista resultante 
        //se eliminan '[' o ']', entonces la complejidad asintótica para el peor de los casos del algoritmo es O(n^2),
        //es decir, cuadrática. Por otro lado, n y m pueden ser iguales (en este caso, la cadena de caracteres inicial 
        //no tenía '[' o ']'), donde también se obtiene que la complejidad asintótica para el peor de los casos es 
        //O(n^2).
    }

    /**
     * Este método principal es para probar la funcionalidad del algoritmo anterior. Para esto, se imprime el texto obtenido en el llamado al método 
     * en cada caso.
     * @param args.
     */
    public static void main(String [] args){
        System.out.println(tecladoRoto("This_is_a_[Beiju]_text"));
        System.out.println(tecladoRoto("[[]][][]Happy_Birthday_to_Tsinghua_University"));
        System.out.println(tecladoRoto("asd[fgh[jkl"));
        System.out.println(tecladoRoto("asd[fgh[jkl["));
        System.out.println(tecladoRoto("[[a[[d[f[[g[g[h[h[dgd[fgsfa[f"));
        System.out.println(tecladoRoto("asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg"));
    }
}
