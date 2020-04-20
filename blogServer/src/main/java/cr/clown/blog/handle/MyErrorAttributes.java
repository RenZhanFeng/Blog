package cr.clown.blog.handle;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

public class MyErrorAttributes extends DefaultErrorAttributes {
	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
		if ((int)map.get("status") == 500) {
			//这里根据自己需求设置
			map.put("message", "服务器内部错误！！！");
		}
		if ((int)map.get("status") == 404) {
			map.put("message", "路径不存在！");
		}
		return map;
	}

}
