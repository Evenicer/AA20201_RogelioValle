/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

import aa20201.data.LeerDatos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rogelio Valle
 */
public class Mochila {
    
    // items of our problem
  //private Item[] items;
  private ArrayList<Articulo> instancias = new ArrayList<>();
  // capacity of the bag
  private int capacidad;

  public Mochila(ArrayList<Articulo> instancias, int capacidad) {
    this.instancias = instancias;
    this.capacidad = capacidad;
  }

  public void display() {
    if (instancias != null  &&  instancias.size() > 0) {
      System.out.println("Problema de la mochila");
      System.out.println("Capacidad : " + capacidad);
      System.out.println("Articulos :");

      instancias.forEach((articulo) -> {
          System.out.println("- " + articulo.str());
        });
    }
  }

  //Alhoritmo para la solucion
  public Solucion calcular() {
      
    int NB_ITEMS = instancias.size();
    
    //Usamos una matriz para guardar el valor maximo de cada objeto en cada iteracion
    int[][] mat = new int[NB_ITEMS + 1][capacidad + 1];

    //Hacemos el recorrido en la matriz
    for (int i = 0; i <= capacidad; i++)
      mat[0][i] = 0;

    //Iteramos en los articulos
    for (int i = 1; i <= NB_ITEMS; i++) {
      
      //Iteramos en cada capacidad
      for (int j = 0; j <= capacidad; j++) {
        if (instancias.get(i-1).peso > j)
          mat[i][j] = mat[i-1][j];
        else
          
            //Encontramos el valor maximo en la matriz con la funcion max
          mat[i][j] = Math.max(mat[i-1][j], mat[i-1][j - instancias.get(i-1).peso] 
				  + instancias.get(i-1).valor);
      }
    }

    int res = mat[NB_ITEMS][capacidad];
    int c = capacidad;
    List<Articulo> itemsSolution = new ArrayList<>();

    for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
      if (res != mat[i-1][c]) {
        itemsSolution.add(instancias.get(i-1));
        // we remove items value and weight
        res -= instancias.get(i-1).valor;
        c -= instancias.get(i-1).peso;
      }
    }

    return new Solucion(itemsSolution, mat[NB_ITEMS][capacidad]);
  }
    
}
