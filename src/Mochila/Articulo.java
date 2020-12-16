/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mochila;

/**
 *
 * @author Rogelio Valle
 */
public class Articulo {
    
    public int valor;
    public int peso;
	
	public Articulo(int valor, int peso) {
		this.valor = valor;
		this.peso = peso;
	}
	
	public String str() {
		return " [Valor = " + valor + ", Peso = " + peso + "]";
	}
    
}
