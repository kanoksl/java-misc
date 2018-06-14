package kanoksilp.ui;

import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Kanoksilp
 */
public class LineNumberedListModel extends AbstractListModel<Object> {

	private List<? extends Object> data;
	private int digits = 0;

	public LineNumberedListModel(List<? extends Object> data) {
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

	/**
	 * Get a string representing line number of the object in the list.
	 * @param o An object (item) to look up.
	 * @return Line number string, zero-padded according to max number of items.
	 */
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
