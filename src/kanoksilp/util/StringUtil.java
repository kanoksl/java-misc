/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kanoksilp.util;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 *
 * @author Kanoksilp
 */
public class StringUtil {

	/**
	 * Count the number of words in string.
	 *
	 * @param text String to be counted.
	 * @return Number of words.
	 */
	public static int getWordCount(String text) {
		int count = 0;

		// delimiters in regex format
		// currently: space, dot, comma
		String delims = " |\\.|,";

		String[] words = text.split(delims);
		for (String s : words) {
			if (!s.isEmpty()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Parse XML String. From: http://stackoverflow.com/questions/562160/
	 *
	 * @param xml An XML-formatted string.
	 * @return A DOM document from the input string.
	 * @throws Exception
	 */
	public static Document loadXMLFromString(String xml)
			throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
	}

	private static final char[] ILLEGAL_CHARACTERS
			= {'/', '\n', '\r', '\t', '\0', '\f', '`',
				'?', '*', '\\', '<', '>', '|', '\"', ':'};

	/**
	 * Convert the input string to a filename-safe string if needed.
	 * @param filename 
	 * @return 
	 */
	public static String getFilenameSafeString(String filename) {
		for (char c : ILLEGAL_CHARACTERS) {
			filename = filename.replace(c, '_');
		}
		return filename;
	}
}
