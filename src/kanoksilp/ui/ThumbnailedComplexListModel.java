package kanoksilp.ui;

import javax.swing.*;
import java.util.ArrayList;

public class ThumbnailedComplexListModel
		extends AbstractListModel<ThumbnailedComplexListItem> {

	private ArrayList<? extends ThumbnailedComplexListItem> data;

	public ThumbnailedComplexListModel(
			ArrayList<? extends ThumbnailedComplexListItem> data) {
		this.data = data;
	}

	@Override
	public int getSize() {
		return data.size();
	}

	@Override
	public ThumbnailedComplexListItem getElementAt(int index) {
		return data.get(index);
	}
}
