package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {
	public int i;
	public int j;
	
	public SwapEvent (int index1, int index2) {
		i = index1;
		j = index2;
	}
	
	public void apply(T[] arr) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public List<Integer> getAffectedIndices() {
		List<Integer> list = new ArrayList<Integer> ();
		list.add(i);
		list.add(j);
		
		return list;
	}
	
	public boolean isEmphasized() {
		return true;
	}

}
