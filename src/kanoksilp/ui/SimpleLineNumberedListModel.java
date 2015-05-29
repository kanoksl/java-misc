/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kanoksilp.ui;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Kanoksilp
 */
public class SimpleLineNumberedListModel extends AbstractListModel<Object> {

	private ArrayList<? extends Object> data;
	private int digits = 0;

	public SimpleLineNumberedListModel(ArrayList<? extends Object> data) {
		this.data = data;
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public Object getElementAt(int index) {
		return data.get(index);
	}

	public String lineNumberOf(Object o) {
		if (digits == 0) {
			int max = data.size();
			while (max > 0) {
				max /= 10;
				digits++;
			}
		}
		return String.format("%0" + digits + "d", data.indexOf(o) + 1);
	}
}
