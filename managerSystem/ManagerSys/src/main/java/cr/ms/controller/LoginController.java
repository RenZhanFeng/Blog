package cr.ms.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import cr.ms.pojo.User;
import cr.ms.result.Result;

@Controller
public class LoginController {
	
	
	@RequestMapping("/s")
	@ResponseBody
	public String index() {
		return "indexsss";
	}

	@CrossOrigin
	@PostMapping(value = "api/login")
	@ResponseBody
	public Result Login(@RequestBody User requestUser) {
		//对html标签进行转义，防止xss攻击
		String username = requestUser.getUsername();
		username = HtmlUtils.htmlEscape(username);
		
		if( !Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword()) ) {
			String message = "账号密码错误";
			System.out.println("test");
			return new Result(400, message);
		}else {
			return new Result(200, "用户" + username + "登录成功");
		}
	}
	
}
