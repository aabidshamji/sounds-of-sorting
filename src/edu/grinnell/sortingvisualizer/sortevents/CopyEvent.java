package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {
	public int index;
	public T copy;
	
	public CopyEvent (int index, T val) {
		this.index = index;
		copy = val;
	}
	
	public void apply(T[] arr) {
		arr[index] = this.copy;
	}
	
	public List<Integer> getAffectedIndices() {
		List<Integer> list = new ArrayList<Integer> ();
		list.add(index);
		
		return list;
	}
	
	public boolean isEmphasized() {
		return true;
	}

}
