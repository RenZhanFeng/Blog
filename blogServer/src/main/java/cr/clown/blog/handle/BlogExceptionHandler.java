package cr.clown.blog.handle;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cr.clown.blog.exception.BlogException;

@ControllerAdvice
public class BlogExceptionHandler {
	
	@ExceptionHandler(BlogException.class)
	public String jsonErrorHandler(HttpServletRequest request, Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		request.setAttribute("java.servlet.error.status_code", 500);
		map.put("code", -1);
		map.put("message", e.getMessage());
		//转发到error
		return "forward:/error";
	}
}
