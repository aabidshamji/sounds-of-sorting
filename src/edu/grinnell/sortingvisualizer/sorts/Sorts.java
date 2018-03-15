package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class Sorts {
	// Swap
	public static <T> void swap (T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} //swap

	// Selection Sort
	public static <T extends Comparable<T>>  List<SortEvent<T>> selectionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		if (arr == null) {return events;}

		for (int i = 0; i < arr.length - 1; i++) {
			int lowestIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j].compareTo(arr[lowestIndex]) < 0) {
					events.add(new CompareEvent<T>(j, lowestIndex));
					lowestIndex = j;
				}
			} // for j
			swap(arr, i, lowestIndex);
			events.add(new SwapEvent<T>(i, lowestIndex));
		} // for i

		return events;
	} // selectionSort

	// InsertionSort
	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort (T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();

		if (arr == null) {return events;}

		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j-1].compareTo(arr[j]) > 0; j--) {
				events.add(new CompareEvent<T>(j-1, j));
				swap(arr, j, j - 1);
				events.add(new SwapEvent<T>(j - 1, j));
			} // for j
		} // for i

		return events;
	} // insertionSort

	// Bubble Sort
	public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort (T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();

		if (arr == null) {return events;}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j].compareTo(arr[j+1]) > 0) {
					events.add(new CompareEvent<T>(j, j+1));
					swap(arr, j, j + 1);
					events.add(new SwapEvent<T>(j, j+1));
				} // if
			} // for j
		} // for i

		return events;
	} // bubbleSort

	// Merge Sort
	@SuppressWarnings("unchecked")
	private static <T extends Comparable <? super T>> void merge 
	(T[] arr, int lo, int mid, int hi, List<SortEvent<T>> events) {
		Object[] temp = new Object[hi-lo];

		int i = lo, j = mid, k = 0;

		while (i < mid && j < hi) {
			if (arr[i].compareTo(arr[j]) <= 0) {
				events.add(new CompareEvent<T>(i, j));
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		} // while

		while (i < mid) {
			temp[k++] = arr[i++];
		}

		while (j < hi) {
			temp[k++] = arr[j++];
		}

		for (int g = 0; g < temp.length; g++) {
			arr[g + lo] = (T) temp[g];
			events.add(new CopyEvent<T>(g, (T) temp[g]));
		}
	} // merge 
	
	public static <T extends Comparable<T>> void mergeSortHelper
	(T[] arr, int lo, int hi, List<SortEvent<T>> events) {
		if (lo < hi - 1) {
			// Find the middle point
			int mid = lo + (hi - lo) / 2;
			
			// Sort 1st and 2nd halves
			mergeSortHelper(arr, lo, mid, events);
			mergeSortHelper(arr, mid, hi, events);

			// Merge the sorted halves
			merge(arr, lo, mid, hi, events);
		}
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		if (arr == null) {return events;}
		mergeSortHelper(arr, 0, arr.length, events);
		return events;
	}

	// Quick Sort
	public static <T extends Comparable<T>> int partition(T arr[], int low, int high, List<SortEvent<T>> events)
	{
		T pivot = arr[high]; 
		int i = (low-1); 
		for (int j=low; j<high; j++)
		{
			if (arr[j].compareTo(pivot) <= 0)
			{
				events.add(new CompareEvent<T>(j, high));
				i++;
				// swap 
				swap(arr, i, j);
				events.add(new SwapEvent<T>(i, j));
			}
		}
		// swap elements
		swap(arr, i+1, high);
		events.add(new SwapEvent<T>(i+1, high));
		return i+1;
	}

	public static <T extends Comparable<T>> void quickSortHelper(T arr[], int low, int high, List<SortEvent<T>> events)
	{
		if (low < high)
		{
			int pi = partition(arr, low, high, events);
			// Recursively sort elements before and after the partition
			quickSortHelper(arr, low, pi-1, events);
			quickSortHelper(arr, pi+1, high, events);
		}
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		if (arr == null) {return events;}
		quickSortHelper(arr, 0, arr.length-1, events);
		return events;
	}

	// Check if the array is sorted
	public static <T extends Comparable<T>> boolean bogoSortHelper(T[] arr, List<SortEvent<T>> events)  {  
		for (int i = 1; i < arr.length; i++){
			if (arr[i].compareTo(arr[i-1]) < 0) {
				events.add(new CompareEvent<T>(i, i-1));
				return false;  
			}
		}
		return true;  
	} 

	public static <T extends Comparable<T>> List<SortEvent<T>> bogoSort(T[] arr)  {  
		List<SortEvent<T>> events = new ArrayList<>();
		if (arr == null) {return events;}
		
		Random rand = new Random();
		int nextInt = rand.nextInt(arr.length);
		
		while (!bogoSortHelper(arr, events)) {  
			for (int i = 0; i < arr.length; i++){  
				swap(arr, i, nextInt); 
				nextInt = rand.nextInt(arr.length);
			}  
		}
		return events;
	} // bogoSort

	// eventSort
	public static <T> void eventSort(T[] arr, List<SortEvent<T>> events) {
		for (int i = 0; i < events.size(); i++) {
			events.get(i).apply(arr);
		}
	} // eventSort

		static <T> void printArray(T[] arr)
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
		
		public static <T> void main (String[] args) {
			Integer[] arr6 = new Integer[11];
			Integer[] arr6a = new Integer[11];
			
			for (int i = 10; i >= 0; i--) {
				arr6[10 - i] = i;
				arr6a[i] = i;
			}
			
			printArray(arr6);
			bogoSort(arr6);
			printArray(arr6);
			printArray(arr6a);
		}

}
