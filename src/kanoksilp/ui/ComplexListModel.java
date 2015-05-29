package kanoksilp.ui;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Kanoksilp on 15/05/28.
 */
public class ComplexListModel extends AbstractListModel<ComplexListItem> {

	private ArrayList<? extends ComplexListItem> data;

	public ComplexListModel(ArrayList<? extends ComplexListItem> data) {
		this.data = data;
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public ComplexListItem getElementAt(int index) {
		return data.get(index);
	}
}
