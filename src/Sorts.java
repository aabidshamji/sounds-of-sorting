import java.util.Random;

public class Sorts {
	
	public static <T> void swap(T arr[], int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public static <T extends Comparable<T>> int partition(T arr[], int low, int high)
	{
	    T pivot = arr[high]; 
	    int i = (low-1); 
	    for (int j=low; j<high; j++)
	    {
	        if (arr[j].compareTo(pivot) <= 0)
	        {
	            i++;
	            // swap 
	            swap(arr, i, j);
	        }
	    }
	    // swap elements
	    swap(arr, i+1, high);

	    return i+1;
	}
	
	public static <T extends Comparable<T>> void Qsort(T arr[], int low, int high)
	{
	    if (low < high)
	    {
	        int pi = partition(arr, low, high);
	        // Recursively sort elements before and after the partition
	        Qsort(arr, low, pi-1);
	        Qsort(arr, pi+1, high);
	    }
	}
	
	public static <T extends Comparable<T>> void QuickSort(T[] arr) {
		Qsort(arr, 0, arr.length-1);
	}

	  

	public static <T extends Comparable<T>> void BogoSort(T[] arr)  {  
		Random rand = new Random();
		int nextInt = rand.nextInt(arr.length);
		while (!checkSort(arr)) {  
			for (int i = 0; i < arr.length; i++){  
				swap(arr, i, nextInt); 
				nextInt = rand.nextInt(arr.length);
			}  
		}  
	}  

	public static <T extends Comparable<T>> boolean checkSort(T[] arr)  {  
		for (int i = 1; i < arr.length; i++){
			if (arr[i].compareTo(arr[i-1]) < 0) {
				return false;  
			}
		}
		return true;  
	} 
	
	public static <T> void printArr(T[] arr){
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("]");
	}
	
	public static void main(String args[]) {
		Integer[] array = {2, 3, 6, 1, 5, 6, 9};
		printArr(array);
		BogoSort(array);
		printArr(array);
		Integer[] array2 = {2, 3, 6, 1, 5, 6, 9};
		printArr(array2);
		QuickSort(array2);
		printArr(array2);
		
	}


}

