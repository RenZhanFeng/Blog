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
	 * 添加用户信息
	 * @return 添加用户
	 */
	Integer insertUser(User user);

}
