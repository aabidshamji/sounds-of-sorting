package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {
	// Fields
	public int i;
	public int j;
	
	// Constructor
	public SwapEvent (int index1, int index2) {
		i = index1;
		j = index2;
	}
	
	// Methods
	/**
	 * Applies this sort event to the given list
	 */
	public void apply(T[] arr) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} // apply
	
	/**
	 * Returns a list containing all of the indices that this event affects
	 */
	public List<Integer> getAffectedIndices() {
		List<Integer> list = new ArrayList<Integer> ();
		list.add(i);
		list.add(j);
		
		return list;
	} // getAffectedIndices
	
	/**
	 * Returns true if this event should be emphasized by the visualizer/audibilizer
	 */
	public boolean isEmphasized() {
		return true;
	} // isEmphasized
} // class SwapEvent
