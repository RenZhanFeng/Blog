package cr.ms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cr.ms.pojo.User;

public interface UserDao extends JpaRepository<User, Integer>{

	/**
	 * 通过用户名查找用户信息
	 * @param username //用户名
	 * @return 用户信息
	 */
	User findByUsername(String username);
	
	/**
	 * @see 通过用户名及密码查询
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 用户信息
	 */
	User getByUsernameAndPassword(String username, String password);
	
}
