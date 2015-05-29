package kanoksilp.ui;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import static kanoksilp.util.TestingUtil.out;

/**
 * A custom ListCellRender for JList with a single text field and a line number.
 *
 * @author Kanoksilp
 */
public class SimpleLineNumberedListCellRenderer
		extends JPanel implements ListCellRenderer {

	private final JPanel lineNumberPanel;

	private final JLabel mainTextLabel;
	private final JLabel lineNumberLabel;

	private static final Font FONT_TEXT_MAIN = new Font(
			"Segoe UI", Font.PLAIN, 11);
	private static final Font FONT_TEXT_LINE_NUMBER = new Font(
			"Segoe UI", Font.BOLD, 11);

	private static final int LAYOUT_THIS_HGAP = 0;
	private static final int LAYOUT_THIS_VGAP = 0;
	private static final int LAYOUT_LINE_NUMBER_HGAP = 7;
	private static final int LAYOUT_LINE_NUMBER_VGAP = 5;

	private static final Color COLOR_LINE_NUMBER_BG = Color.decode("#E8E8E6");
	private static final Color COLOR_LINE_NUMBER_FG = Color.decode("#989494");
	private static final Color COLOR_LINE_NUMBER_SELECTED_BG = Color.decode("#8790B5");

	private static final Color COLOR_SEPARATOR = Color.decode("#e9e8e7");
	private static final Color COLOR_SELECTED_ITEM_BG = Color.decode("#737CA1");
	private static final Color COLOR_SELECTED_ITEM_FG = Color.WHITE;

	public SimpleLineNumberedListCellRenderer() {
		lineNumberPanel = new JPanel();

		mainTextLabel = new JLabel();
		lineNumberLabel = new JLabel();

		this.setLayout(new FlowLayout(FlowLayout.LEFT,
				LAYOUT_THIS_HGAP, LAYOUT_THIS_VGAP));

		lineNumberPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,
				LAYOUT_LINE_NUMBER_HGAP, LAYOUT_LINE_NUMBER_VGAP));

		lineNumberLabel.setFont(FONT_TEXT_LINE_NUMBER);
		lineNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lineNumberLabel.setOpaque(false);

		lineNumberLabel.setForeground(COLOR_SELECTED_ITEM_FG);
		lineNumberPanel.setBackground(COLOR_LINE_NUMBER_SELECTED_BG);

		lineNumberPanel.add(lineNumberLabel);
		this.add(lineNumberPanel);

		mainTextLabel.setFont(FONT_TEXT_MAIN);
		mainTextLabel.setOpaque(false);
		this.add(mainTextLabel);

		this.setBorder(new MatteBorder(0, 0, 1, 0, COLOR_SEPARATOR));
		this.setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		lineNumberLabel.setText(((SimpleLineNumberedListModel) list.getModel())
				.lineNumberOf(value));
		mainTextLabel.setText("  " + value.toString());

		if (isSelected) {
			this.setBackground(COLOR_SELECTED_ITEM_BG);
			lineNumberPanel.setBackground(COLOR_LINE_NUMBER_SELECTED_BG);
			mainTextLabel.setForeground(COLOR_SELECTED_ITEM_FG);
			lineNumberLabel.setForeground(COLOR_SELECTED_ITEM_FG);
		} else {
			this.setBackground(list.getBackground());
			lineNumberPanel.setBackground(COLOR_LINE_NUMBER_BG);
			mainTextLabel.setForeground(list.getForeground());
			lineNumberLabel.setForeground(COLOR_LINE_NUMBER_FG);
		}

		return this;
	}
}
