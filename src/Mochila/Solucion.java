/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;
import java.util.List;
/**
 *
 * @author Rogelio Valle
 */
public class Solucion {
    
    // list of items to put in the bag to have the maximal value
	public List<Articulo> articulos;
	// maximal value possible
	public int valor;
	
	public Solucion(List<Articulo> articulos, int valor) {
		this.articulos = articulos;
		this.valor = valor;
	}
	
	public void display() {
		if (articulos != null  &&  !articulos.isEmpty()){
			System.out.println("\nSolucion:");
			System.out.println("Valor = " + valor);
			System.out.println("Articulos que llevar :");
			
                        articulos.forEach((articulo) -> {
                            System.out.println("- " + articulo.str());
                    });
		}
	}
    
}
