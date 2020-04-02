package cr.clown.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.clown.blog.entity.User;
import cr.clown.blog.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "")
	public String index() {
		return "test";
	}

	@RequestMapping(value = "/all")
	@ResponseBody
	public List<User> userLists(){
		
		return userService.queryAllUser();
	}
	
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String insertUser(User user) throws Exception{
		//判空
		if (user.equals(null)) {
			throw new Exception("添加用户信息失败");
		}
		boolean flag = userService.insertUser(user);
		
		return flag?"添加用户成功":"添加失败";
	}
}
