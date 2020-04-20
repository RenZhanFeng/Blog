package cr.clown.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.clown.blog.dao.UserDao;
import cr.clown.blog.entity.User;
import cr.clown.blog.enums.UserEnum;
import cr.clown.blog.exception.BlogException;
import cr.clown.blog.service.UserService;

/**
 * 用户服务接口的实现
 * @author Clown
 *
 */

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/**
	 * 查询全部用户信息
	 */
	@Override
	public List<User> queryAllUser() {
//		List<User> users = userDao.quertAllUser();
//		if (users.isEmpty()) {
//			throw new ExecutorException("查询的用户列表为空");
//		}
		return userDao.queryAllUser();
	}

	/**
	 * 通过用户ID查询用户信息
	 */
	@Override
	public User queryUserById(String uid) {
		// TODO 通过用户ID查询用户信息
		if (uid == null ) {//参数uid判空
			throw new RuntimeException("info queryUserById ..." + UserEnum.USER_ID_NOT_NULL.getMessage());
		}
		//执行查询
		User user = userDao.queryUserById(uid);
		if (user.equals(null)) {//结果判空
			throw new RuntimeException("info queryUserById ..." + UserEnum.USER_NOT_EXITS.getMessage());
		}
		return user;
	}


	/**
	 * 通过用户名查询用户信息
	 */
	@Override
	public User queryUserByName(String username) {
		// TODO 通过用户名查询用户信息
		if (username == null || "".equals(username)) {//参数username判空
			throw new RuntimeException("info queryUserByName ..." + UserEnum.USERNAME_NOT_NUll.getMessage());
		}
		//执行查询
		User user = userDao.queryUserByName(username);
		if (user.equals(null)) {//结果判空
			//throw new RuntimeException("info queryUserByName ..." + UserEnum.USER_NOT_EXITS.getMessage());
			throw new BlogException("4", UserEnum.USER_NOT_EXITS.getMessage(), "/selByName", "没有该用户的信息");
		}
		return user;
	}

	/**
	 * 添加用户信息
	 */
	@Override
	public boolean insertUser(User user) {
		if (user.equals(null)) {//参数user判空
			throw new RuntimeException("info insertUser ..." + UserEnum.USER_INFO_NOT_NUll.getMessage());
		}
		int i = userDao.insertUser(user);
		return (i > 0) ? true: false;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public boolean updateUser(User user) {
		if (user.equals(null)) {//参数user判空
			throw new RuntimeException("info updateUser ..." + UserEnum.USER_INFO_NOT_NUll.getMessage());
		}
		int i = userDao.updateUser(user);
		if (i > 0) {//更新是否成工
			return true;
		}
		return false;
	}


	/**
	 * 删除用户信息
	 */
	@Override
	public boolean delUserById(String uid) {
		if (uid == null ) {//参数uid判空
			throw new RuntimeException("info delUserById ..." + UserEnum.USER_ID_NOT_NULL.getMessage());
		}
		int i = userDao.delUserById(uid);
		return (i > 0) ? true: false;
	}

}
