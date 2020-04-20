package cr.clown.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.clown.blog.entity.User;
import cr.clown.blog.enums.UserEnum;
import cr.clown.blog.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping()
	public String index(Model model) {
		model.addAttribute("uLists", userService.queryAllUser());
		return "admin/userList";
	}

	@RequestMapping(value = "/sel/all", method = RequestMethod.GET)
	@ResponseBody
	public List<User> userLists(){
		
		return userService.queryAllUser();
	}
	
	@RequestMapping(value = "/sel/userId/{uid}")
	@ResponseBody
	public User queryUserById(@PathVariable("uid") String uid){
		return userService.queryUserById(uid);
	}
	
	@RequestMapping(value = "/sel")
	@ResponseBody
	public User queryUserByName(String username){
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
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(User user) {
		
		boolean flag = userService.insertUser(user);
		
		return flag?"更新用户信息成功":"更新用户信息失败";
	}
	
	/**
	 * 删除用户信息API
	 * @param model
	 * @param uid
	 * @return
	 */
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delUser(String uid) {
		boolean flag = userService.delUserById(uid);
		if (!flag) {
			throw new RuntimeException("删除用户信息API" + UserEnum.DEL_USER_INFO_FAIl.getMessage());
		}
		return "redirect:/user";
	}
}
