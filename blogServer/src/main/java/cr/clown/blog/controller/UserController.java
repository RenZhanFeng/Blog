package cr.clown.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.clown.blog.entity.User;
import cr.clown.blog.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping()
	public String index() {
		return "admin/userList.html";
	}

	@RequestMapping(value = "/sel/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> userLists(){
		
		return userService.queryAllUser();
	}
	
	@RequestMapping(value = "/sel/userId/{uid}")
	@ResponseBody
	public User queryUserById(@PathVariable("uid") Integer uid){
		return userService.queryUserById(uid);
	}
	
	@RequestMapping(value = "/sel")
	@ResponseBody
	public List<User> queryUserByName(String username){
		return userService.queryUserByName(username);
	}
	
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String insertUser(User user) {
		/*
		 * //判空 if (user.equals(null)) { throw new Exception("添加用户信息失败"); }
		 */
		boolean flag = userService.insertUser(user);
		
		return flag?"添加用户信息成功":"添加用户信息失败";
	}
	
	@RequestMapping(value = "/update")
	@ResponseBody
	public String updateUser(User user) {
		
		boolean flag = userService.insertUser(user);
		
		return flag?"更新用户信息成功":"更新用户信息失败";
	}
	
	@RequestMapping(value = "/del")
	@ResponseBody
	public String delUser(Integer uid) {
		
		boolean flag = userService.delUserById(uid);
		
		return flag?"删除用户信息成功":"删除用户信息失败";
	}
}
