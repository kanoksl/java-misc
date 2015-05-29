package kanoksilp.util;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Kanoksilp
 */
public class Util {

	public static void toClipboard(String text) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
				new StringSelection(text), null);
	}

}
