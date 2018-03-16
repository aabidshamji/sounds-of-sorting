package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {
	// Fields
	public int index;
	public T copy;
	
	// Constructor
	public CopyEvent (int index, T val) {
		this.index = index;
		copy = val;
	}
	
	// Methods
	/**
	 * Applies this sort event to the given list
	 */
	public void apply(T[] arr) {
		arr[index] = this.copy;
	} // apply
	
	/**
	 * returns a list containing all of the indices that this event affects
	 */
	public List<Integer> getAffectedIndices() {
		List<Integer> list = new ArrayList<Integer> ();
		list.add(index);
		
		return list;
	} // getAffectedIndices
	
	/**
	 * Returns true if this event should be emphasized by the visualizer/audibilizer
	 */
	public boolean isEmphasized() {
		return true;
	} // isEmphasized
} // class CopyEvents
