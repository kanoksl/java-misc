package kanoksilp.ui;

import java.util.List;
import javax.swing.AbstractListModel;

public class ObjectListModel extends AbstractListModel<Object> {

	private List<? extends Object> data;

	public ObjectListModel(List<? extends Object> data) {
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
