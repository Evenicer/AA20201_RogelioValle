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
  public class Caballo {
    static int N = 8;
 
    //Funcion para checar que i,j sean indices validos para un tablero N*N de Ajedrez
    static boolean tableroValido(int x, int y, int sol[][])
    {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }
 
    //Funcion para imprimir la matriz de la solucion
    static void printSolucion(int sol[][])
    {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + "\t");
            System.out.println();
        }
    }
 
    /*Esta funcion resuelve el problema del caballo
    usando Backtracking. Utiliza solveKTUtil() para
    solucionar el problema. Retorna falso si no es 
    posible completar el tour, si si retorna verdadero
    e imprime el tour.
    Puede haber mas de una solucion, esta funcion
    imprime una de las posibles soluciones.*/
    static boolean solveKT()
    {
        int sol[][] = new int[8][8];
        
        //Inicializo la matriz
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;
 
        /*xMove[] y yMove[] definen el siguiente movimiento del caballo.
        xMove[] es para el valor de la coordenada en x
        yMove[] es para el valor de la coordenada en y*/
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
 
        // El cabalo inicia en la coordenada 0,0
        sol[0][0] = 0;
 
        //Inicia en 0,0 y explora todos los posibles caminos usando solveKTUtil
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("La solucion no existe");
            return false;
        }
        else{
            printSolucion(sol);
        }
 
        return true;
    }
 
    //Una funcion recursiva para resolver el problema del caballo
    static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[])
    {
        int k, next_x, next_y;
        if (movei == N * N){
            return true;
        }
 
        //Intenta todos los movimientos desde la coordenada en que se encuentre
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            
            if (tableroValido(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove)){
                    return true;
                }else{
                    sol[next_x][next_y] = -1; // Backtracking
                }
            }
        }
        return false;
    }
 
    public static void main(String args[])
    {
        // Llamo la funcion para resovler el problema
        solveKT();
    }
}
