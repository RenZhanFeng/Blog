package cr.ms.service;

import cr.ms.pojo.User;

public interface UserService {

	/**
	 * 通过用户名查找用户信息
	 * @param username //用户名
	 * @return 用户信息
	 */
	User getByUsername(String username);
	
	/**
	 * @see 通过用户名及密码查询
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 用户信息
	 */
	User get(String username, String password);
}
