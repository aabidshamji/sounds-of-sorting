package edu.grinnell.sortingvisualizer.audio;

import java.util.Arrays;
import java.util.Collections;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
	//public int n;
	private Integer[] indices;
	private boolean[] isHighlightedNotes;

	/**
	 * @param n the size of the scale object that these indices map into
	 */
	public NoteIndices(int n) {
		//this.n = n;
		initializeAndShuffle(n);
	}

	/**
	 * Reinitializes this collection of indices to map into a new scale object
	 * of the given size.  The collection is also shuffled to provide an
	 * initial starting point for the sorting process.
	 * @param n the size of the scale object that these indices map into
	 */
	public void initializeAndShuffle(int n) {
		//this.n = n;
		indices = new Integer[n];
		for (int i = 0; i < n; i++) {
			indices[i] = i;
		}
		Collections.shuffle(Arrays.asList(indices));
		isHighlightedNotes = new boolean[indices.length];
	}

	/** @return the indices of this NoteIndices object */
	public Integer[] getNotes() { 
		return indices;
	}

	/**
	 * Highlights the given index of the note array
	 * @param index the index to highlight
	 */
	public void highlightNote(int index) {
//		if (!(isHighlighted(index))) {
//			indices[index] = -indices[index];
//		}
		isHighlightedNotes[index] = true;
	}

	/** @return true if the given index is highlighted */
	public boolean isHighlighted(int index) {
//		if (indices[index] < 0) {
//			return true;
//		}
//		return false;
		return isHighlightedNotes[index];
	}

	/** Clears all highlighted indices from this collection */
	public void clearAllHighlighted() {
		for (int i = 0; i < indices.length; i++) {
//			indices[i] = Math.abs(indices[i]);
			isHighlightedNotes[i] = false;
		}
	}
	
	public int length () {
		return indices.length;
	}
}
