package cr.clown.blog.dao;

import java.util.List;

import cr.clown.blog.entity.User;

/**
 * 用户映射接口
 * @author Clown
 *
 */
public interface UserDao {
	
	/**
	 * 查询所有用户信息
	 * @return 用户列表
	 */
	List<User> queryAllUser();
	
	/**
	 * 通过ID查询用户信息
	 * @return 用户信息
	 */
	User queryUserById(String uid);
	
	/**
	 * 通过用户名查询用户信息
	 * @return 用户信息
	 */
	User queryUserByName(String username);
	
	/**
	 * 添加用户信息
	 * @return 
	 */
	Integer insertUser(User user);
	
	/**
	 * 修改用户信息
	 * @return 
	 */
	Integer updateUser(User user);
	
	/**
	 * 删除用户信息
	 * @return 
	 */
	Integer delUserById(String uid);

}
