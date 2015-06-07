package kanoksilp.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kanoksilp
 */
public class Util {

	public static void toClipboard(String text) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
				new StringSelection(text), null);
	}

	public static void setSystemLookAndFeel() {
		try {
			javax.swing.UIManager.setLookAndFeel(
					javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException |
				InstantiationException |
				IllegalAccessException |
				UnsupportedLookAndFeelException e) {
			System.err.println("Util.setSystemLookAndFeel() :\n\t" + e);
		}
	}

}
