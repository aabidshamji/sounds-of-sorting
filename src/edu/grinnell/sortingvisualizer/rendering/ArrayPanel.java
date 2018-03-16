package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

	private NoteIndices notes;

	/**
	 * Constructs a new ArrayPanel that renders the given note indices to
	 * the screen.
	 * @param notes the indices to render
	 * @param width the width of the panel
	 * @param height the height of the panel
	 */
	public ArrayPanel(NoteIndices notes, int width, int height) {
		this.notes = notes;
		this.setPreferredSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics g) {
		Integer[] noteIndices = notes.getNotes();
		int noteWidth = this.getWidth()/notes.length();
		int heightIncre = this.getHeight()/notes.length();
		int colorIncre = 173/notes.length();

		for (int i = 0; i < notes.length(); i++) {
			int noteHeight = heightIncre + Math.abs(noteIndices[i]) * heightIncre;
			if (notes.isHighlighted(i)) {
				g.setColor(Color.PINK);
			} else {
				int comp = noteIndices[i] * colorIncre;
				Color color = new Color(0, comp, comp);
				g.setColor(color);
			}
			g.fillRect(noteWidth*i, this.getHeight() - noteHeight, noteWidth, noteHeight);
		}
		notes.clearAllHighlighted();
	} // paintComponent
}