package pers.minho.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pers.minho.entity.User;
import pers.minho.service.CartService;
import pers.minho.util.UserUtil;

@WebFilter("/UtilFilter")
public class UtilFilter extends HttpFilter implements Filter {
      
	private static final long serialVersionUID = 1L;

	public UtilFilter() {
        super();
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession ses = req.getSession();

		if(UserUtil.isLogined(req))  {
			User user = (User)ses.getAttribute("loginUser");
			CartService c_service = new CartService();
			ses.setAttribute("cartAmount", c_service.findRowsByUserID(user.getId()));
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
