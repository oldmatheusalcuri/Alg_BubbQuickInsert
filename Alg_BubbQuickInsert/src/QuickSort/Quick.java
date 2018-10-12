package QuickSort;

public class Quick {
	   static int pivo(int vetQ[], int menor, int maior) 
	    { 
		   int pivot = vetQ[maior];  
	        int i = (menor-1); // index of smaller element 
	        for (int j=menor; j<maior; j++) 
	        { 
	            // If current element is smaller than or 
	            // equal to pivot 
	            if (vetQ[j] <= pivot) 
	            { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                int temp = vetQ[i]; 
	                vetQ[i] = vetQ[j]; 
	                vetQ[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        int temp = vetQ[i+1]; 
	        vetQ[i+1] = vetQ[maior]; 
	        vetQ[maior] = temp; 
	  
	        return i+1; 
	    } 
	  
	  
	    /* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	   public static void quickSort(int vetQ[], int menor, int maior)
	    { 
		   
		   if (menor < maior) 
	        { 
	            /* pi is partitioning index, arr[pi] is  
	              now at right place */
	            int pi = pivo(vetQ, menor, maior); 
	  
	            // Recursively sort elements before 
	            // partition and after partition 
	            quickSort(vetQ, menor, pi-1); 
	            quickSort(vetQ, pi+1, maior); 
	        } 
	        
	    } 
}
