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
	 * 通过ID查询用户信息
	 * @return 用户信息
	 */
	User queryUserById(Integer uid);
	
	/**
	 * 通过用户名查询用户信息
	 * @return 用户信息
	 */
	List<User> queryUserByName(String username);
	
	/**
	 * 添加用户信息
	 * @return 是否添加成功
	 */
	boolean insertUser(User user);
	
	/**
	 * 修改用户信息
	 * @return 
	 */
	boolean updateUser(User user);
	
	/**
	 * 删除用户信息
	 * @param uid 用户ID
	 * @return
	 */
	boolean delUserById(Integer uid);
}
