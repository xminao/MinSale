package pers.minho.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserUtil {
	// 判断是否已经登录
	public static boolean isLogined(HttpServletRequest request) {
		HttpSession ses = request.getSession();
		if(ses.getAttribute("isLogined")!=null && ses.getAttribute("isLogined").equals(true) && ses.getAttribute("loginUser")!=null){
			System.out.println("已经登录");
			return true;
		}
		return false;
	}
	
	//登出
	public static void loginOut(HttpServletRequest request) {
		HttpSession ses = request.getSession();
		if (isLogined(request)) {
			ses.removeAttribute("isLogined");
			ses.removeAttribute("loginUser");
		}
	}
}
