/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

/**
 *
 * @author Rogelio Valle
 */
public class MergeSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;
    
    public MergeSort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
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
    
   // Mezcla dos subarreglos de un arreglo arr[]. 
    // El primer arreglo es arr[l..m] 
    // El segundo arreglo es arr[m+1..r] 
    public void merge(int arr[], int l, int m, int r) 
    { 
        // Encuentra el tamaño de los dos subarreglos a mezclar
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Creamos arreglos temporales */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
  
        /*Copiamos los datos a los arreglos temporales*/
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
  
        /* Mezclar los arreglos  */
  
        // Inicializo los indices del primer y segundo subarreglo 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public void sort(int arr[], int l, int r){ 
        if (l < r) { 
            // Find the middle point 
            int m = (l + r) / 2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr, m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
    
    public void ordenar(int arr[]){
    
        this.tInicio = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1); 
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    
    }
  
    /* A utility function to print array of size n */
    public void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
}
