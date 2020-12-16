/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import java.util.Random;

/**
 *
 * @author MI PC
 */
public class GeneradorDatosSort {
    
    // "aleatorio"
    public static int[] generarArregloIntSort(int dim, int bound){
        int[] arreglo = new int[dim];
        Random ran = new Random();
       
        for(int y=0; y < dim; y++){
            arreglo[y] = ran.nextInt(bound);
        }
       return arreglo;
    }
    
    // peor de los casos / Arreglo con datos ordenamos descentendemente
    public static int[] generarArregloIntPeorCasoSort(int dim){
        int[] arreglo = new int[dim];
        
        for(int i=0; i < dim; i++){
            arreglo[i] = dim - i;
        }
       return arreglo;
    }
    
    // medio de los casos / Arreglo con datos ordenamos ascendentemente
    public static int[] generarArregloIntMediocasoSort(int dim , int bound){
        int[] arreglo = new int[dim];
        Random ran = new Random();
        
        for(int i=0; i<dim/2; i++){
            for(int j=dim-1; j>dim/2; j--){
                arreglo[i] = i;
                arreglo[j] = ran.nextInt(bound);
            }
        }
       return arreglo;
    }
    
    // mejor de los casos / Arreglo con datos ordenamos ascendentemente
    public static int[] generarArregloIntMejorCasoSort(int dim){
        int[] arreglo = new int[dim];
        
        for(int i=0; i < dim; i++){
            arreglo[i] = dim;
        }
       return arreglo;
    }
   
    
    
    
}
