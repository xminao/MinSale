package pers.minho.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static String getCookie(Cookie[] cookies, String cookiename) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookiename)) {
				String cookieValue = cookie.getValue();
				return cookieValue;
			}
		}
		return null;
	}
}
