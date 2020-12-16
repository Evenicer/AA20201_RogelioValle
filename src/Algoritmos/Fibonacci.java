/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

/**
 *
 * @author MI PC
 */
public class Fibonacci {
    
public int tamaño;
public long tInicio;
public long tFinal;
public long tTotal;
public String nombre;

     public Fibonacci() {}

    public Fibonacci(String nombre, int tamaño){
        this.nombre = nombre;
        this.tamaño = tamaño;
     }

    
    public void fiboIterativo(long posicion){
        this.tInicio = System.currentTimeMillis();
        fibonacciIterativo(posicion);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public void fiboRecursivo(int posicion){
        this.tInicio = System.currentTimeMillis();
        Fibonacci f1 = new Fibonacci("fibo" , posicion);
        f1.mostrarSerie();
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    public void fiboRecursivoDinamico(int posicion){
        this.tInicio = System.currentTimeMillis();
        fibonacciDinamico(posicion);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    
    
    public static int fibonacciDinamico(int n){
    
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;
      
        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;
     
        for (i = 2; i <= n; i++)
        {
         /* Add the previous 2 numbers in the series
         and store it */
         f[i] = f[i-1] + f[i-2];
         }
       return f[n];
    }
    
	public static long fibonacciIterativo(long posicion) {
		long siguiente = 1, actual = 0, temporal = 0;
		for (long x = 1; x <= posicion; x++) {
			// Si no quieres imprimirla, comenta la siguiente línea:
			System.out.print(actual + ", ");
			temporal = actual;
			actual = siguiente;
			siguiente = siguiente + temporal;
		}
		// Si no quieres imprimirla, comenta la siguiente línea:
		System.out.println(actual);
		return actual;
	}
        
        public static long fibonacciRecursivo(long posicion) {
		if (posicion < 2)
			return posicion;
		return fibonacciRecursivo(posicion - 1) + fibonacciRecursivo(posicion - 2);
	}



    
int fibonacci(int n){
    if (n>1){
       return fibonacci(n-1) + fibonacci(n-2);  //función recursiva
    }
    else if (n==1) {  // caso base
        return 1;
    }
    else if (n==0){  // caso base
        return 0;
    }
    else{ //error
        System.out.println("Debes ingresar un tamaño mayor o igual a 1");
        return -1; 
    }
}

public void mostrarSerie(){
    System.out.println(this.nombre+" de tamaño "+this.tamaño+":");
    for (int i = 0; i < tamaño; i++) {
        System.out.print(fibonacci(i)+" ");
    }
    System.out.println();
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getTamaño() {
    return tamaño;
}

public void setTamaño(int tamaño) {
    this.tamaño = tamaño;
}

public long gettInicio() {
        return tInicio;
    }

    public long gettTotal() {
        return tTotal;
    }

    
}


