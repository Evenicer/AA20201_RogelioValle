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
    
    // lista de articulos para meter en la mochila en base a su valor
	public List<Articulo> articulos;
	// maximo valor posible
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
