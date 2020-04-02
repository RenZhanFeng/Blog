package cr.clown.blog.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Encoding
 */
@WebFilter("/Encoding")
public class Encoding implements Filter {
	
	// 设置过滤器使用的编码为utf-8
	private String charsetName = "UTF-8";

    /**
     * Default constructor. 
     */
    public Encoding() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("开始过滤请求数据的编码...");
		//转型为与协议相关对象
		HttpServletRequest req = (HttpServletRequest)request;
		//获取请求方法
		String method = req.getMethod();
		if ("post".equalsIgnoreCase(method)) {
			//解决post
			req.setCharacterEncoding(charsetName);
		}else {
			//解决get
			req.setCharacterEncoding(charsetName);
		}
		// 解决响应乱码
		// 设置响应数据和响应的页面编码格式
		response.setContentType("text/html; charset=" + charsetName);
		
		// pass the request along the filter chain
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
