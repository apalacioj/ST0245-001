package com.mycompany.taller9;
import java.util.Hashtable;

/**
 *Esta clase contiene la solución al punto 1.1 del taller 9. 
 *Implementa una Tabla de Hash que permite asociar nombres de personas con números enteros.
 * @author Valentina Moreno Ramírez y Alejandra Palacio Jaramillo.
 * @version 9/10/2020
 */
public class Punto1{
    private final Hashtable<String, Integer> contactos;
    
    /**
     *Este constructor inicializa la tabla de Hash contactos.
     */
    public Punto1(){
        contactos = new Hashtable<>();
    }
    
    /**
     * Este método obtiene el número de un contacto determinado.
     * @param nombre nombre del contacto que se quiere obtener el número de teléfono.
     * @return número de teléfono
     */
    public int getNumero(String nombre){
        return contactos.get(nombre);
    }
    
    /**
     * Este método permite agregar un nuevo contacto a la lista de contactos.
     * @param nombre nombre del contacto que quiere agregar.
     * @param numeroTelefonico número de teléfono del contacto que quiere agregar.
     */
    public void newContacto(String nombre, int numeroTelefonico){
        contactos.put(nombre, new Integer(numeroTelefonico));
    }
    
    /**
     * Esta clase principal sirve para probar los métodos anteriores.
     */
    public static void main(String[]args){
        Punto1 test = new Punto1();
        test.newContacto("Alejandra", 1234);
        test.newContacto("Valentina", 5896);
        test.newContacto("Camilo", 88963);
        test.newContacto("Adrián", 7402);
        test.getNumero("Alejandra");
        test.getNumero("Camilo");
    }
    
}
