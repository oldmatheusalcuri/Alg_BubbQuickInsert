package BubbleSort;

public class Bubble {
	public static void bubbleSort(int[] vetB){
		int i =0;
		int aux = 0;
		
	    for(i = 0; i<vetB.length; i++){
	        for(int j = 0; j<vetB.length-1; j++){
	            if(vetB[j] > vetB[j + 1]){
	                aux = vetB[j];
	                vetB[j] = vetB[j+1];
	                vetB[j+1] = aux;
	            }
	        }
	    }
	}
}
