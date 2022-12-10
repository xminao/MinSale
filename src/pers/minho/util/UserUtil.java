package pers.minho.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
	// 判断是否已经登录
	public static boolean isLogined(HttpServletRequest request) {
		HttpSession ses = request.getSession();
		if(ses.getAttribute("isLogined")!=null && ses.getAttribute("isLogined").equals(true) && ses.getAttribute("loginUser")!=null){
			return true;
		}
		return false;
	}
}
