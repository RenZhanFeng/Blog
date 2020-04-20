package cr.clown.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cr.clown.blog.entity.User;
import cr.clown.blog.enums.UserEnum;
import cr.clown.blog.service.UserService;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	
	@PostMapping(value = "/login")
	@ResponseBody
	public int login(User user) {
		//String username = user.getUsername();
		//String password = user.getPassword();
		
		return checkUser(user).getCode();
	}
	
	/**
	 * 检查用户信息
	 * @param user
	 * @return
	 */
	public UserEnum checkUser(User user) {
		User cUser = userService.queryUserByName(user.getUsername());
		if (cUser.equals(null)) {
			throw new RuntimeException("into checkUser ..." + UserEnum.USER_NOT_EXITS.getMessage());
		}
		if (!user.getPassword().equals(cUser.getPassword())){
			throw new RuntimeException("into checkUser ..." + UserEnum.USERNAME_OR_PASSWORD_REEOR.getMessage());
		}
		return UserEnum.LOGIN_SUCCESS;
	}
}
