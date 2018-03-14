package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {
	public int i;
	public int j;
	
	public CompareEvent(int index1, int index2) {
		i = index1;
		j = index2;
	}
	
	public void apply(T[] arr) {
	}
	
	public List<Integer> getAffectedIndices() {
		List<Integer> list = new ArrayList<Integer> ();
		list.add(i);
		list.add(j);
		
		return list;
	}
	
	public boolean isEmphasized() {
		return false;
	}
}
