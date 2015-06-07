package kanoksilp.ui;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * A custom ListCellRender for JList with two text fields, a standard main text
 * and a smaller info text, a color label, and a thumbnail.
 *
 * @author Kanoksilp
 */
public class ThumbnailedComplexListCellRenderer
		extends JPanel implements ListCellRenderer {

	private final JPanel textPanel;

	private final JLabel titleLabel;
	private final JLabel infoLabel;

	private final JLabel colorLabel;
	private final JLabel spaceLabel;
	
	private final JLabel thumbnailLabel;

	private static final Font FONT_TEXT_MAIN = new Font(
			"Segoe UI", Font.BOLD, 12);
	private static final Font FONT_TEXT_INFO = new Font(
			"Segoe UI", Font.PLAIN, 10);

	private static final int LAYOUT_THIS_HGAP = 0;
	private static final int LAYOUT_THIS_VGAP = 0;
	private static final int LAYOUT_COLOR_LABEL_WIDTH = 4;
	private static final int LAYOUT_SPACE_LABEL_WIDTH = 6;
	private static final int LAYOUT_COLOR_LABEL_HEIGHT = 48;
	
	private static final int LAYOUT_THUMBNAIL_SIZE = 48;

	private static final Dimension DIMENSION_COLOR_LABEL
			= new Dimension(LAYOUT_COLOR_LABEL_WIDTH, LAYOUT_COLOR_LABEL_HEIGHT);
	private static final Dimension DIMENSION_SPACE_LABEL
			= new Dimension(LAYOUT_SPACE_LABEL_WIDTH, LAYOUT_COLOR_LABEL_HEIGHT);
	private static final Dimension DIMENSION_THUMBNAIL_LABEL
			= new Dimension(LAYOUT_THUMBNAIL_SIZE, LAYOUT_THUMBNAIL_SIZE);

	private static final Color COLOR_TEXT_INFO = Color.GRAY;
	private static final Color COLOR_SEPARATOR = Color.decode("#e9e8e7");
	private static final Color COLOR_SELECTED_ITEM_BG = Color.decode("#737ca1");
	private static final Color COLOR_SELECTED_ITEM_FG = Color.WHITE;

	public ThumbnailedComplexListCellRenderer() {

		textPanel = new JPanel();
		titleLabel = new JLabel();
		infoLabel = new JLabel();
		colorLabel = new JLabel();
		spaceLabel = new JLabel();
		thumbnailLabel = new JLabel();

		this.setLayout(new FlowLayout(FlowLayout.LEFT,
				LAYOUT_THIS_HGAP, LAYOUT_THIS_VGAP));

		colorLabel.setOpaque(true);
		colorLabel.setMinimumSize(DIMENSION_COLOR_LABEL);
		colorLabel.setPreferredSize(DIMENSION_COLOR_LABEL);
		spaceLabel.setMinimumSize(DIMENSION_SPACE_LABEL);
		spaceLabel.setPreferredSize(DIMENSION_SPACE_LABEL);
		this.add(colorLabel);
		//this.add(spaceLabel);
		
		thumbnailLabel.setMinimumSize(DIMENSION_THUMBNAIL_LABEL);
		thumbnailLabel.setPreferredSize(DIMENSION_THUMBNAIL_LABEL);
		thumbnailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thumbnailLabel.setVerticalAlignment(SwingConstants.CENTER);
		this.add(thumbnailLabel);
		this.add(spaceLabel);

		// GridLayout(ROW, COL, hGap, vGap)
		textPanel.setLayout(new GridLayout(2, 0, 0, 4));
		textPanel.setOpaque(true);

		titleLabel.setFont(FONT_TEXT_MAIN);
		titleLabel.setText("Main Text");
		titleLabel.setOpaque(true);
		textPanel.add(titleLabel);

		infoLabel.setFont(FONT_TEXT_INFO);
		infoLabel.setText("Info Text");
		infoLabel.setOpaque(true);
		textPanel.add(infoLabel);

		this.add(textPanel);

		this.setBorder(new MatteBorder(0, 0, 1, 0, COLOR_SEPARATOR));

		this.setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		ThumbnailedComplexListItem item = (ThumbnailedComplexListItem) value;
		titleLabel.setText(item.getMainText());
		infoLabel.setText(item.getInfoText());

		colorLabel.setBackground(item.getColor());
		thumbnailLabel.setIcon(item.getThumbnail(LAYOUT_THUMBNAIL_SIZE));

		if (isSelected) {
			this.adjustColors(COLOR_SELECTED_ITEM_BG, COLOR_SELECTED_ITEM_FG,
					this, textPanel, titleLabel, infoLabel);
		} else {
			this.adjustColors(list.getBackground(), list.getForeground(),
					this, textPanel, titleLabel, infoLabel);
			infoLabel.setForeground(COLOR_TEXT_INFO);
		}

		return this;
	}

	private void adjustColors(Color bg, Color fg, Component... components) {
		for (Component c : components) {
			c.setForeground(fg);
			c.setBackground(bg);
		}
	}

}
