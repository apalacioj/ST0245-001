package ejerciciosLab3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *Esta clase contiene el ejercicio 2 propuesot en el Taller8.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 23/09/2020
 */
public class almacenNeveras {
    
    /**
     * Este método recibe las neveras en la forma que están almacenadas en el almacén y las solicitudes en el orden 
     * que llegaron e imprime qué neveras quedan almacenadas a qué almacén según la solicitud y la disponibilidad de
     * las mismas.
     * @param neveras - neveras disponibles en el almacén.
     * @param solicitudes - solicitudes con su respectiva cantidad de neveras para cada tienda.
     * @throws Exception 
     */
    public static void almacen(Stack<Neveras> neveras, Queue<Solicitudes> solicitudes) throws Exception{
       int longitud = solicitudes.size();
       if(solicitudes.size() != 0 && neveras.size() != 0){
            for(int i = 0; i<longitud; i++){
                Solicitudes sol = solicitudes.poll();
                System.out.println("Solicitud "+(i+1)+": tienda -->"+sol.getTienda());
                for(int j = 0; j<sol.getCantidadNeveras(); j++){
                    if(neveras.size() == 0){
                        System.out.println("No hay suficientes neveras para completar la(s) solicitud(es)");
                        break;
                    }
                    Neveras nev = neveras.pop();
                    System.out.println("Nevera "+(1+j)+": "+nev.getCodigo()+","+nev.getDescripcion());
                }
            }  
        }else{
            throw new Exception("No hay neveras o solicitudes");
        } 
    }
    
    /**
     * Este método principal realiza un test al método anterior.
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception{
        Stack <Neveras> neveras = new Stack <>();
        LinkedList <Solicitudes> solicitudes = new LinkedList <>();
        
        Neveras nev1 = new Neveras(1, "Haceb");
        Neveras nev2 = new Neveras(2, "lg");
        Neveras nev3 = new Neveras(3, "Samsung");
        Neveras nev4 = new Neveras(4, "Ibm");
        Neveras nev5 = new Neveras(5, "Haceb");
        Neveras nev6 = new Neveras(6, "Samsung");
        
        neveras.push(nev1);
        neveras.push(nev2);
        neveras.push(nev3);
        neveras.push(nev4);
        neveras.push(nev5);
        neveras.push(nev6);
        
        Solicitudes sol1 = new Solicitudes("Exito", 1);
        Solicitudes sol2 = new Solicitudes("Olímpica", 1);
        Solicitudes sol3 = new Solicitudes("Jumbo", 2);
        Solicitudes sol4 = new Solicitudes("Flamingo", 2);
        
        solicitudes.add(sol1);
        solicitudes.add(sol2);
        solicitudes.add(sol3);
        solicitudes.add(sol4);
        
        almacen(neveras, solicitudes);
    }
}
