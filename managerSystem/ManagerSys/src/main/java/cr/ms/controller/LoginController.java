package cr.ms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import cr.ms.pojo.User;
import cr.ms.result.Result;
import cr.ms.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@PostMapping(value = "/api/login")
	@ResponseBody
	public Result Login(@RequestBody User requestUser, HttpSession session) {
		System.out.println("into login...");
		//对html标签进行转义，防止xss攻击
		String username = requestUser.getUsername();
		username = HtmlUtils.htmlEscape(username);
		
		User user = userService.get(username, requestUser.getPassword());
		if( null == user) {
			return new Result(400, "账号密码错误");
		}else {
			//设置Session对象user
			session.setAttribute("user", user);
			return new Result(200, "用户" + username + "登录成功");
		}
	}
	
}
