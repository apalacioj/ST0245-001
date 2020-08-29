/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.taller5;

/**
 *
 * @author aleja
 */
public class Taller5 {
    /**
     * El siguiente método es también conocido como el algoritmo insertion sort, el cual ordena los elementos de un arreglo
     * @param array es el arreglo que se organizará
     */
    public static void punto1(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {// T(n) = c1 + c2*(n-1), donde c1 = 3 y c2 = 3 
			int max = 0;  // T(n) = c3*(n-1), donde c3 = 1
			for (int j = 0; j < i; j++) {   // T(n) = c4 + c5*(n-1)*(n-1), donde c4 = 1 Y c5 = 3
				if (array[j + 1] > array[max]) {
					max = j + 1; // T(n) = c6*(n-1)*(n-1), donde c6  = 7
				}
			}
                swap(array, i, max); // T(n) = c7*(n-1), donde c7 = 1
		}
    }

    /**
     * Este método permite intercambiar de posición los elementos de un arreglo para ordenarlo.
     * @param array el arreglo en donde están los valores a cambiar
     * @param a  posición del primer elemento 
     * @param b  posición del segundo elemento 
     */
    private static void swap(int[] array, int a, int b) {
		int value = array[b];
		array[b] = array[a];
		array[a] = value;  
	}
    
    /**
     * Este algoritmo suma los elementos de un arreglo utilizando ciclos.
     * @param array arreglo en dónde estan los elementos a sumar.
     * @return suma de los elementos del arreglo.
     */
    public static int punto2(int[] array){
        int acum = 0; // T(n) = c1, donde c1 = 1
        for(int i = 0; i < array.length; i++){ // T(n) = c2 + c3*n, donde c2 = 1 y c3 = 4
            acum += array[i];   // T(n) = c4*n, donde c4 = 3
        }
        return acum; // T(n) = c5*n, donde c5 = 1
    }
   
    public static void main (String args[]){
        for(int i = 1000000; i <= 500000000; i = i +1000000){
           long ti = System.currentTimeMillis();
           punto2(new int[i]);
           long tf = System.currentTimeMillis();
           System.out.println(tf - ti);
        }
    }
}

