package edu.grinnell.sortingvisualizer.sorts;
import static org.junit.Assert.*;

import java.util.List;
import java.util.function.Function;
import org.junit.Test;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class SortsTest1 {

//	public static <T> void generalTest (Function<T[],List<SortEvent<T>>> func) {
//		// Empty array
//		Integer[] arr1 = new Integer[0];
//		Integer[] arr1a = new Integer[0];
//		Sorts.<T>func(arr1);
//		assertArrayEquals("empty array", arr1, arr1a);
//
//		// One element
//		Integer[] arr2 = {56350896};
//		Integer[] arr2a = {56350896};
//		Sorts.<T>func(arr2);
//		assertArrayEquals("one element", arr2, arr2a);
//
//		// Null input
//		Integer[] arr3 = null;
//		Integer[] arr3a = null;
//		Sorts.<Integer>func(arr3);
//		assertArrayEquals("null array", arr3, arr3a);
//
//		// Duplicate elements and even number of elements
//		Integer[] arr4 = {5,8,3,6,9,3,1,0,8,5,6,1};
//		Integer[] arr4a = {0,1,1,3,3,5,5,6,6,8,8,9};
//		Sorts.<Integer>func(arr4);
//		assertArrayEquals("duplicate elements & even number of elements", arr4, arr4a);
//
//		// Negative elements
//		Integer[] arr5 = {-100,-200,60,50,-30,0,1};
//		Integer[] arr5a = {-200,-100,-30,0,1,50,60};
//		Sorts.<Integer>func(arr5);
//		assertArrayEquals("negative elements", arr5, arr5a);
//
//		// Long array with smallest element on the right and odd number of elements
//		Integer[] arr6 = new Integer[1001];
//		Integer[] arr6a = new Integer[1001];
//
//		for (int i = 1000; i >= 0; i--) {
//			arr6[1000 - i] = i;
//			arr6a[i] = i;
//		}
//
//		Sorts.<Integer>func(arr6);
//		assertArrayEquals("func: long array with smallest element "
//				+ "on the right and odd number of elements", arr6, arr6a);
//	} //testSelectionSort

	
	@Test
	public void testSelectionSort() {
		// Empty array
		Integer[] arr1 = new Integer[0];
		Integer[] arr1a = new Integer[0];
		Sorts.<Integer>selectionSort(arr1);
		assertArrayEquals("selectionSort: empty array", arr1, arr1a);

		// One element
		Integer[] arr2 = {56350896};
		Integer[] arr2a = {56350896};
		Sorts.<Integer>selectionSort(arr2);
		assertArrayEquals("selectionSort: one element", arr2, arr2a);

		// Null input
		Integer[] arr3 = null;
		Integer[] arr3a = null;
		Sorts.<Integer>selectionSort(arr3);
		assertArrayEquals("selectionSort: null array", arr3, arr3a);

		// Duplicate elements and even number of elements
		Integer[] arr4 = {5,8,3,6,9,3,1,0,8,5,6,1};
		Integer[] arr4a = {0,1,1,3,3,5,5,6,6,8,8,9};
		Sorts.<Integer>selectionSort(arr4);
		assertArrayEquals("selectionSort: duplicate elements & even number of elements", arr4, arr4a);

		// Negative elements
		Integer[] arr5 = {-100,-200,60,50,-30,0,1};
		Integer[] arr5a = {-200,-100,-30,0,1,50,60};
		Sorts.<Integer>selectionSort(arr5);
		assertArrayEquals("selectionSort: negative elements", arr5, arr5a);

		// Long array with smallest element on the right and odd number of elements
		Integer[] arr6 = new Integer[1001];
		Integer[] arr6a = new Integer[1001];

		for (int i = 1000; i >= 0; i--) {
			arr6[1000 - i] = i;
			arr6a[i] = i;
		}

		Sorts.<Integer>selectionSort(arr6);
		assertArrayEquals("selectionSort: long array with smallest element "
				+ "on the right and odd number of elements", arr6, arr6a);
	} //testSelectionSort

	public void testInsertionSort() {
		// Empty array
		Integer[] arr1 = new Integer[0];
		Integer[] arr1a = new Integer[0];
		Sorts.<Integer>insertionSort(arr1);
		assertArrayEquals("insertionSort: empty array", arr1, arr1a);

		// One element
		Integer[] arr2 = {56350896};
		Integer[] arr2a = {56350896};
		Sorts.<Integer>insertionSort(arr2);
		assertArrayEquals("insertionSort: one element", arr2, arr2a);

		// Null input
		Integer[] arr3 = null;
		Integer[] arr3a = null;
		Sorts.<Integer>insertionSort(arr3);
		assertArrayEquals("insertionSort: null array", arr3, arr3a);

		// Duplicate elements and even number of elements
		Integer[] arr4 = {5,8,3,6,9,3,1,0,8,5,6,1};
		Integer[] arr4a = {0,1,1,3,3,5,5,6,6,8,8,9};
		Sorts.<Integer>insertionSort(arr4);
		assertArrayEquals("insertionSort: duplicate elements & even number of elements", arr4, arr4a);

		// Negative elements
		Integer[] arr5 = {-100,-200,60,50,-30,0,1};
		Integer[] arr5a = {-200,-100,-30,0,1,50,60};
		Sorts.<Integer>insertionSort(arr5);
		assertArrayEquals("insertionSort: negative elements", arr5, arr5a);

		// Long array with smallest element on the right and odd number of elements
		Integer[] arr6 = new Integer[1001];
		Integer[] arr6a = new Integer[1001];

		for (int i = 1000; i >= 0; i--) {
			arr6[1000 - i] = i;
			arr6a[i] = i;
		}

		Sorts.<Integer>insertionSort(arr6);
		assertArrayEquals("insertionSort: long array with smallest element "
				+ "on the right and odd number of elements", arr6, arr6a);

	} // testInsertionSort
	
	public void testBogoSort() {
		// Empty array
		Integer[] arr1 = new Integer[0];
		Integer[] arr1a = new Integer[0];
		Sorts.<Integer>bogoSort(arr1);
		assertArrayEquals("bogoSort: empty array", arr1, arr1a);

		// One element
		Integer[] arr2 = {56350896};
		Integer[] arr2a = {56350896};
		Sorts.<Integer>bogoSort(arr2);
		assertArrayEquals("bogoSort: one element", arr2, arr2a);

		// Null input
		Integer[] arr3 = null;
		Integer[] arr3a = null;
		Sorts.<Integer>bogoSort(arr3);
		assertArrayEquals("bogoSort: null array", arr3, arr3a);

		// Duplicate elements and even number of elements
		Integer[] arr4 = {5,8,3,6,9,3,1,0,8,5,6,1};
		Integer[] arr4a = {0,1,1,3,3,5,5,6,6,8,8,9};
		Sorts.<Integer>bogoSort(arr4);
		assertArrayEquals("bogoSort: duplicate elements & even number of elements", arr4, arr4a);

		// Negative elements
		Integer[] arr5 = {-100,-200,60,50,-30,0,1};
		Integer[] arr5a = {-200,-100,-30,0,1,50,60};
		Sorts.<Integer>bogoSort(arr5);
		assertArrayEquals("bogoSort: negative elements", arr5, arr5a);

		// Long array with smallest element on the right and odd number of elements
		Integer[] arr6 = new Integer[1001];
		Integer[] arr6a = new Integer[1001];

		for (int i = 1000; i >= 0; i--) {
			arr6[1000 - i] = i;
			arr6a[i] = i;
		}

		Sorts.<Integer>bogoSort(arr6);
		assertArrayEquals("bogoSort: long array with smallest element "
				+ "on the right and odd number of elements", arr6, arr6a);

	} // testbogoSort

}
