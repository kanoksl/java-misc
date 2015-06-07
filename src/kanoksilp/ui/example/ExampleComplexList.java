package kanoksilp.ui.example;

import kanoksilp.ui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Example usage of ComplexList.
 * <p/>
 * Created by Kanoksilp on 15/05/28.
 */
@SuppressWarnings("unchecked")
class ExampleComplexList {

	// Data class must implement ComplexListItem interface.
	private class Item implements ComplexListItem {

		private String mainText;
		private String infoText;
		private Color color;

		public Item(String mainText, String infoText, Color color) {
			this.mainText = mainText;
			this.infoText = infoText;
			this.color = color;
		}

		@Override
		public String getMainText() {
			return this.mainText;
		}

		@Override
		public String getInfoText() {
			return this.infoText;
		}

		@Override
		public Color getColor() {
			return this.color;
		}
	}

	private JList list = new JList();

	// Data can be stored in an ArrayList of ComplexListItem.
	// private ArrayList<ComplexListItem> data = new ArrayList<ComplexListItem>();
	// Or an ArrayList of subclass of ComplexListItem.
	private ArrayList<Item> data = new ArrayList<Item>();

	private void initializeList() {
		data.add(new Item("Item 1", "info text for item 1", Color.BLUE));
		data.add(new Item("Item 2", "info text for item 2", Color.RED));
		data.add(new Item("Item 3", "info text for item 3", Color.GREEN));

		// Set the cell renderer and model:
		this.list.setCellRenderer(new ComplexListCellRenderer());
		this.list.setModel(new ObjectArrayListModel(data));

		// Also some example event listeners:
		this.list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !list.isSelectionEmpty()) {
					// TODO: When double-clicked an item
				}
			}
		});
		this.list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// TODO: When 'ENTER' key is pressed
				}
			}
		});
	}

}
