package cr.clown.blog.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.clown.blog.exception.BlogException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public BlogException error(Exception exception) {
		System.out.println("全局异常");
		exception.printStackTrace();
		return new BlogException("20001","错误消息","方法（method）","描述");
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public BlogException error(NullPointerException e) {
		System.out.println("空指针异常");
		e.printStackTrace();
		return new BlogException("20002","错误消息","方法（method）","空指针异常");
	}
	
	
	@ExceptionHandler(BlogException.class)
	@ResponseBody
	public BlogException error(BlogException e) {
		System.out.println("自定义异常");
		e.printStackTrace();
		return new BlogException("20003","错误消息","方法（method）","空指针异常");
	}
	
}
