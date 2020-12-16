/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author MI PC
 */
public class InsertionSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public InsertionSort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
  
    public void ordenar(int[] datos){
        this.tInicio = System.currentTimeMillis();
        InsertSort(datos);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }
    public long gettFinal() {
        return tFinal;
    }

    public long gettInicio() {
        return tInicio;
    }

    public long gettTotal() {
        return tTotal;
    }

    private void InsertSort(int[] datos) { // peor de los casos = 2 + 12n + 9n2  notación "O" grande O(n2)
        
        int n = datos.length; //2
        for (int i = 1; i < n; i++) { // 3(n) = 12n
            int x = datos[i]; //3
            int j = i - 1; //3
            //Se colocan los datos en el arreglo mayores a x 
            while (j >= 0 && datos[j] > x) { //3(n)(n)  9(n2) = 9n2
                datos[j + 1] = datos[j]; //4
                j = j - 1; //2
            } 
            datos[j + 1] = x; //3
        } 
    } 
}


