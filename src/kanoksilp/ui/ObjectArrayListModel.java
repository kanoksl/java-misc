package kanoksilp.ui;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class ObjectArrayListModel extends AbstractListModel<Object> {

	private ArrayList<? extends Object> data;

	public ObjectArrayListModel(ArrayList<? extends Object> data) {
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
}
