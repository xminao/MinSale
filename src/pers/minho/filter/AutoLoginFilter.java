package pers.minho.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import pers.minho.entity.User;
import pers.minho.service.UserService;

@WebFilter("/AutoLogin")
public class AutoLoginFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public AutoLoginFilter() {
        super();
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession ses = req.getSession();

//		if(LoginVerify.isLogin(req)){
//			chain.doFilter(request, response);
//			return;
//		}


		Cookie[] cookies = req.getCookies();
		UserService service = new UserService();
		String emailCookie = null;
		/*
		 * 这里仅用了email作为cookie并用于验证，极不安全
		 */
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("LOGIN_EMAIL_COOKIE".equals(cookie.getName())) {
					emailCookie = cookie.getValue();
					try {
						if (service.findByEmail(emailCookie) != null) {
							User user = service.findByEmail(emailCookie);
							ses.setAttribute("loginUser", user);
							ses.setAttribute("isLogined", true);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
