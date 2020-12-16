/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa20201;

import Algoritmos.Fibonacci;
import static Algoritmos.Fibonacci.fibonacciIterativo;
import static Algoritmos.Fibonacci.fibonacciRecursivo;
import Mochila.Articulo;
import Mochila.Mochila;
import Mochila.Solucion;
import aa20201.data.Grafica;
import aa20201.data.LeerDatos;
import busquedas.BusquedaSecuencial;
import busquedas.Busquedas;
import busquedas.GeneradorDatos;
import java.util.ArrayList;
import ordenamiento.Burbuja;
import ordenamiento.BurbujaOptimizado;
import ordenamiento.GeneradorDatosSort;
import ordenamiento.InsertionSort;
import ordenamiento.MergeSort;
import ordenamiento.QuickSort;

/**
 *
 * @author working
 */
public class AA20201 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    ArrayList<Articulo> elementos;
    elementos = LeerDatos.tokenizarDataSet();
    Mochila mochila = new Mochila(elementos , elementos.size());
    mochila.display();
    Solucion solucion = mochila.calcular();
    solucion.display();

    }

}
