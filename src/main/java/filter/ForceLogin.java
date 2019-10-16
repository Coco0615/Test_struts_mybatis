package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ForceLogin implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest requ = (HttpServletRequest)req;
		HttpServletResponse resp = (HttpServletResponse)res;
		HttpSession session = requ.getSession();
		Object o = session.getAttribute("value1");
		//System.out.println(o);
		if(o!=null){
			chain.doFilter(req, res);
			
		}else{
			resp.sendRedirect(requ.getContextPath()+"/user/login_form.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
