package com.mycompany.taller9;
import java.util.HashMap;
/**
 *Esta clase implementa un algoritmo que asigna ciertas empresas al país al que pertenecen. Para esto, se 
 * utiliza una Tabla Hash.
 * @author Valentina Moreno Ramírez y Alejandra Palacio jaramillo
 * @version 9/10/2020
 */
public class Punto2 {
    
    private final HashMap <String, String> empresas;
    
    /**
     * Este constructor inicializa el HashMap empresas.
     */
    public Punto2(){
        empresas = new HashMap <String,String> ();
    }
    
    /**
     * Este método inserta una entrada en la tabla Hash empresas, indicando la llave (empresa) y el país (valor). 
     * @param empresas es el HashMap creado donde se guardaran los valores.
     * @param empresa es la llave en el conjunto.
     * @param pais es el valor asociado a la llave empresa.
     */
    public static void add(HashMap empresas,String empresa, String pais){
        empresas.put(empresa,pais);
    }
    
     /**
      * Este método busca si determinada empresa se encuentra en la tabla Hash empresas. Si esta se encuentra, imprime
      * el país asociado a esta empresa.
      * @param empresas es el HashMap creado donde se guardaran los valores.
      * @param empresa es la llave en el conjunto.
      * @return true si lo encuentra, de lo contrario, false.
      */
    public static boolean getEmpresa(HashMap empresas, String empresa){
        boolean get = false;
        if(empresas.containsKey(empresa)){
            get = true;
            System.out.println("Empresa: "+empresa+" --> "+empresas.get(empresa));
        }else{
            get = false;
            System.out.println("La empresa "+empresa+" no se encuentra registrada");
        }
        return get;
    }
    
    /**
     * Este método busca la llave asociada al valor determinado, es decir, busca una empresa en cierto país.
     * @param empresas es el HashMap creado donde se guardaran los valores.
     * @param pais es el valor asociado a la llave empresa.
     * @return true si lo encuentra, de lo contrario, false.
     */
    public static boolean getPais(HashMap empresas, String pais){
        boolean get = false;
        for (Object x : empresas.entrySet()){
            if (empresas.containsValue(pais)){
                get = true;
                break;
            }else{
                get = false;
                break;
            }
        }
        return get;
    }
    
    /**
     * Este método principal sirve para hacer pruebas del funcionamiento de los métodos anteriores.
     */
    public static void main(String[]args){
        HashMap <String, String> test = new HashMap <> ();
        add(test, "Google", "Estados Unidos");
        add(test, "La locura", "Colombia");
        add(test, "Nokia", "Finlandia");
        add(test, "Sony", "Japón");
        getEmpresa(test, "Motorola");
        getEmpresa(test, "Nokia");
        getPais(test, "Colombia");
        getPais(test, "Canada");
    }
}
