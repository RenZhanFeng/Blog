package cr.clown.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.executor.ExecutorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.clown.blog.dao.UserDao;
import cr.clown.blog.entity.User;
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

	@Override
	public List<User> queryAllUser() {
//		List<User> users = userDao.quertAllUser();
//		if (users.isEmpty()) {
//			throw new ExecutorException("查询的用户列表为空");
//		}
		return userDao.queryAllUser();
	}

	
	@Override
	public boolean insertUser(User user) {
		if (user.equals(null)) {
			throw new RuntimeException("请输入需要添加的用户");
		}
		int i = userDao.insertUser(user);
		return (i > 0) ? true: false;
	}

}
