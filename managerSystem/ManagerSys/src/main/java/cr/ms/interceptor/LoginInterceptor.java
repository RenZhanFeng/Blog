/*
 * package cr.ms.interceptor;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.apache.commons.lang.StringUtils; import
 * org.springframework.web.servlet.HandlerInterceptor;
 * 
 * import cr.ms.pojo.User;
 * 
 *//**
	 * 登录拦截器
	 * 
	 * @author Clown
	 *
	 *//*
		 * public class LoginInterceptor implements HandlerInterceptor {
		 * 
		 * @Override public boolean preHandle(HttpServletRequest request,
		 * HttpServletResponse response, Object handler) throws Exception {
		 * //获取请求的用户session HttpSession session = request.getSession(); //获取请求路径 String
		 * contextPath = session.getServletContext().getContextPath(); String[]
		 * requireAuthPages = new String[] {//需要身份验证的页面 "index", }; String uri =
		 * request.getRequestURI();
		 * 
		 * uri = StringUtils.remove(uri, contextPath + "/"); String page = uri;
		 * System.out.println("session:" + session + " - contextPath" + contextPath +
		 * "\n uri " + uri);
		 * 
		 * if (begingWith(page, requireAuthPages)) { //获取用户session User user = (User)
		 * session.getAttribute("user"); if (user == null) {//判空
		 * response.sendRedirect("login"); return false; } } return
		 * HandlerInterceptor.super.preHandle(request, response, handler); }
		 * 
		 * 
		 * private boolean begingWith(String page, String[] requireAuthPages) { boolean
		 * result = false; for (String requireAuthPage : requireAuthPages) { if
		 * (StringUtils.startsWith(page, requireAuthPage)) { result = true; break; } }
		 * return result; }
		 * 
		 * }
		 */