package edu.grinnell.sortingvisualizer.sorts;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;

public class SortsTest {

	public <T extends Comparable<T>> List<SortEvent<T>> generalTest (String sortType, T[] arr) {
		switch (sortType) {
		case "selection":
			return Sorts.selectionSort(arr);
		case "insertion":
			return Sorts.<T>insertionSort(arr);
		case "bubble":
			return Sorts.bubbleSort(arr);
		case "merge":
			return Sorts.mergeSort(arr);
		case "quick":
			return Sorts.quickSort(arr);
		case "bogo":
			return Sorts.cycleSort(arr);
		default:
			throw new IllegalArgumentException("generateEvents");
		} // switch
	}

	public <T> void testSort(String sortType) {
		// Empty array
		Integer[] arr1 = new Integer[0];
		Integer[] arr1a = new Integer[0];
		List<SortEvent<Integer>> events1 = generalTest(sortType, arr1);
		Sorts.eventSort(arr1a, events1);
		assertArrayEquals("empty array", arr1, arr1a);

		// One element
		Integer[] arr2 = {56350896};
		Integer[] arr2a = {56350896};
		List<SortEvent<Integer>> events2 = generalTest(sortType, arr2);
		Sorts.eventSort(arr2a, events2);
		assertArrayEquals("one element", arr2, arr2a);

		// Null input
		Integer[] arr3 = null;
		Integer[] arr3a = null;
		List<SortEvent<Integer>> events3 = generalTest(sortType, arr3);
		Sorts.eventSort(arr3a, events3);
		assertArrayEquals("null array", arr3, arr3a);

		// Duplicate elements and even number of elements
		Integer[] arr4 = {5,8,3,6,9,3,1,0,8,5,6,1};
		Integer[] arr4a = {5,8,3,6,9,3,1,0,8,5,6,1};
		List<SortEvent<Integer>> events4 = generalTest(sortType, arr4);
		Sorts.eventSort(arr4a, events4);
		assertArrayEquals("duplicate elements & even number of elements", arr4, arr4a);

		// Negative elements
		Integer[] arr5 = {-100,-200,60,50,-30,0,1};
		Integer[] arr5a = {-100,-200,60,50,-30,0,1};
		List<SortEvent<Integer>> events5 = generalTest(sortType, arr5);
		Sorts.eventSort(arr5a, events5);
		assertArrayEquals("negative elements", arr5, arr5a);

		// Long array with smallest element on the right and odd number of elements
		Integer[] arr6 = new Integer[1001];
		Integer[] arr6a = new Integer[1001];

		for (int i = 1000; i >= 0; i--) {
			arr6[1000 - i] = i;
			arr6a[1000 - i] = i;
		}

		List<SortEvent<Integer>> events6 = generalTest(sortType, arr6);
		Sorts.eventSort(arr6a, events6);
		assertArrayEquals("long array with smallest element "
				+ "on the right and odd number of elements", arr6, arr6a);
	} //testSort
	
	@Test
	public void testSelectionSort() {
		testSort("selection");
	}
	
	@Test
	public void testInsertionSort() {
		testSort("insertion");
	}
	
	@Test
	public void testBubbleSort() {
		testSort("bubble");
	}
	
	@Test
	public void testMergeSort() {
		testSort("merge");
	}
	
	@Test
	public void testQuickSort() {
		testSort("quick");
	}
	
	@Test
	public void testBogoSort() {
		testSort("cycle");
	}

}