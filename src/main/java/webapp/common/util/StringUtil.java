package webapp.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Hold functions commonly used for string specific operations.
 * @author YHY
 *
 */
public class StringUtil {
	public static boolean isEmptyString(String string){
		return (string==null || string.trim()=="" || string.equalsIgnoreCase("'NULL'"));
	}
	
public static List<String> tokenize(final String s, final String delim) {
	List<String> res = new ArrayList<>();
	if (null != s && null != delim && s.trim().length() > 0) {
		StringTokenizer strTokenizer = new StringTokenizer(s, delim);

		while (strTokenizer.hasMoreTokens()) {
			res.add(strTokenizer.nextToken().trim());
		}
	}
	return res;
}	
}
