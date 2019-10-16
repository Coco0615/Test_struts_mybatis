package filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
	ServletContext context = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		String encoding = context.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		res.setCharacterEncoding(encoding);
		res.setContentType("text/html");
		
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		context = conf.getServletContext();
	}

}
