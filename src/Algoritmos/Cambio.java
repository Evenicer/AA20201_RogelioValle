/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

/**
 *
 * @author Rogelio Valle
 */
public class Cambio
{
    private int[][] matrizCambio;
    private int[] vectorMonedas;
    private int cantidad;
    private int[] vectorSeleccion;

    Cambio(int cantidad, int[]  monedas){
        this.cantidad = cantidad;
        this.vectorMonedas = monedas;
        matrizCambio = calcularMonedas(cantidad, monedas);
        vectorSeleccion = seleccionarMonedas(cantidad, monedas, matrizCambio);
    }

    public int[] getVectorSeleccion(){
        return this.vectorSeleccion;
    }

    private int[][] calcularMonedas(int cantidad, int[]  monedas){

        int[][] matrizCambio = new int[monedas.length + 1][cantidad + 1];

        for (int i = 0; i < monedas.length; i++)
            matrizCambio[i][0] = 0;

        for (int j = 1; j <= cantidad; j++)
            matrizCambio[0][j] = 99;

        for (int i = 1; i <= monedas.length; i++)
            for (int j = 1; j <= cantidad; j++) {
                if (j < monedas[i - 1]) {

                    matrizCambio[i][j] = matrizCambio[i - 1][j];
                } else {

                    int minimo = 0;

                    minimo = min(matrizCambio[i - 1][j] , matrizCambio[i][j- monedas[i - 1]] + 1);
                    matrizCambio[i][j] = minimo;

                }
        }

        return matrizCambio;
    }

    private int[] seleccionarMonedas(int c, int[] monedas, int[][]tabla ){
        int i,j;
        int[] seleccion = new int[monedas.length];
        for(i = 0; i< monedas.length; i++){
            seleccion[i]=0; 
        }
        
        i= monedas.length;
        j= c;  
        
        while(j>0){
            if(i>1 && tabla[i][j]==tabla[i-1][j]){
                i--;
            }
            else{
                seleccion[i-1]++;
                j = j - monedas[i-1];
            }
        }
        return seleccion;
    }

    private int min(int a, int b){
        if(a<b)
            return a;

        else
            return b;
    }
    
    public static void main(String[] args) {
        int x = 177;
        int moneda1 , moneda2, moneda3, moneda4;
        
        moneda1 = 100;
        moneda2 = 20;
        moneda3 = 5;
        moneda4 = 1;
        
        Cambio c = new Cambio(x, new int[]{moneda1 , moneda2 , moneda3, moneda4});
        
        System.out.println ("¿Cuántos billetes hacen falta para cambiar un cheque de "+x+"?" );

        System.out.println("Monedas de "+moneda1+": "+c.getVectorSeleccion()[0]);
        System.out.println("Monedas de "+moneda2+": "+c.getVectorSeleccion()[1]);
        System.out.println("Monedas de "+moneda3+": "+c.getVectorSeleccion()[2]);
        System.out.println("Monedas de "+moneda4+": "+c.getVectorSeleccion()[3]);
    }

}
