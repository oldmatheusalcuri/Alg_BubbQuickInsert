package InsertionSort;

public class Insertion {
	public static void interstionSort(int[] vetI){
	    int j;
		int key;
		int i;
    
		for (j = 1; j < vetI.length; j++){
			key = vetI[j];
		
				for (i = j - 1; (i >= 0) && (vetI[i] > key); i--){
					vetI[i + 1] = vetI[i];
				}	
				vetI[i + 1] = key;
		}
	}
}
