package ex03.tomcat;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Cookie;
/**
 * @author victorr
 *  this class provide parsing functions for the request strings.
 */
public class RequestUtil {
	
	
	public static Cookie[] parseCookieHeader(String header) {
		if ((header == null) || (header.length() < 1))
			return new Cookie[0];
		List<Cookie> cookies = new ArrayList<Cookie>();
		while (header.length() > 0) {
			int semicolon = header.indexOf(';');
			if (semicolon < 0)
				semicolon = header.length();
			if (semicolon == 0)
				break;
			String token = header.substring(0, semicolon);
			if (semicolon < header.length())
				header = header.substring(semicolon + 1);
			else
				header = "";
			try {
				int equals = token.indexOf('=');
				if (equals > 0) {
					String name = token.substring(0, equals).trim();
					String value = token.substring(equals + 1).trim();
					cookies.add(new Cookie(name, value));
				}
			}
			catch (Exception e) {
			}
		}
		Cookie[] result=new Cookie[cookies.size()];
		cookies.toArray(result);
		return result;

	}
}
