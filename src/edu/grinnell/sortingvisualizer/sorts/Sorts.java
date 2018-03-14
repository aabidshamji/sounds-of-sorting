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
	
		int i, j, k;
		int l1 = mid - lo + 1;
		int l2 = hi - mid;

		/* create temp arrays */
		Object[] left = new Object[l1];
		Object[] right = new Object[l2];

		/* Copy data to temp arrays left[] and right[] */
		for (i = 0; i < l1; i++)
			left[i] = arr[lo + i];
		for (j = 0; j < l2; j++)
			right[j] = arr[mid + 1+ j];

		/* Merge the temp arrays back into arr[l..r]*/
		i = 0; // Initial index of first subarray
		j = 0; // Initial index of second subarray
		k = lo; // Initial index of merged subarray
		while (i < l1 && j < l2)
		{
			if (((T)left[i]).compareTo((T)right[j]) <= 0)
			{
				events.add(new CompareEvent<T>(i, j));
				arr[k] = (T) left[i];
				events.add(new CopyEvent<T>(k, (T) left[i]));
				i++;
			}
			else
			{
				arr[k] = (T) right[j];
				events.add(new CopyEvent<T>(k, (T) right[i]));
				j++;
			}
			k++;
		}

		/* Copy the remaining elements of L[], if there
	       are any */
		while (i < l1)
		{
			arr[k] = (T) left[i];
			events.add(new CopyEvent<T>(k, (T) left[i]));
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there
	       are any */
		while (j < l2)
		{
			arr[k] = (T) right[j];
			events.add(new CopyEvent<T>(k, (T) right[i]));
			j++;
			k++;
		}
	} // merge

	public static <T extends Comparable<T>> void mergeSortHelper
	(T[] arr, int lo, int hi, List<SortEvent<T>> events) {
		if (lo < hi) {
			// Find the middle point
			int mid = (lo + hi) / 2;

			// Sort 1st and 2nd halves
			mergeSortHelper(arr, lo, mid, events);
			mergeSortHelper(arr, mid + 1, hi, events);

			// Merge the sorted halves
			merge(arr, lo, mid, hi, events);
		}
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		mergeSortHelper(arr, 0, arr.length - 1, events);
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

	public static <T extends Comparable<T>> void Qsort(T arr[], int low, int high, List<SortEvent<T>> events)
	{
		if (low < high)
		{
			int pi = partition(arr, low, high, events);
			// Recursively sort elements before and after the partition
			Qsort(arr, low, pi-1, events);
			Qsort(arr, pi+1, high, events);
		}
	}

	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		Qsort(arr, 0, arr.length-1, events);
		return events;
	}

	// Bogo Sort
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

	public static <T extends Comparable<T>> List<SortEvent<T>> BogoSort(T[] arr)  {  
		Random rand = new Random();
		int nextInt = rand.nextInt(arr.length);
		List<SortEvent<T>> events = new ArrayList<>();
		
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


}
