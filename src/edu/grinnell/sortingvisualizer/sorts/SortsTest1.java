package edu.grinnell.sortingvisualizer.sorts;
import static org.junit.Assert.*;
import org.junit.Test;

public class SortsTest1 {
	
	public static <T> void compareArr(T[] arr1, T[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			assertEquals("", arr1[i], arr2[i]);
		}
	}
	@Test
	public void testSelectionSort() {
		Integer[] arr1 = {};
		selectionSort(arr1);
		
	}

}
