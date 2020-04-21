package cr.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ms.dao.UserDao;
import cr.ms.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public boolean isExist(String username) {
		User user = getByUsername(username);
		return null != user;
	}

	@Override
	public User getByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public User get(String username, String password) {
		return userDao.getByUsernameAndPassword(username, password);
	}

	public void add(User user) {
		userDao.save(user);
	}
}
