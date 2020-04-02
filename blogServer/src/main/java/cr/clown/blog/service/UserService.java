package cr.clown.blog.service;

import java.util.List;

import cr.clown.blog.entity.User;

/**
 * 用户服务接口
 * @author Clown
 *
 */
public interface UserService {
	
	/**
	 * 查询所有用户信息
	 * @return 用户列表
	 */
	List<User> queryAllUser();
	
	/**
	 * 添加用户信息
	 * @return 是否添加成功
	 */
	boolean insertUser(User user);
}
