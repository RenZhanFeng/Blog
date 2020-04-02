/**
 * 
 */
package cr.clown.blog.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cr.clown.blog.entity.User;
import cr.clown.blog.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserDaoTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void insert() {
		User user = new User("8","t6", "123", "t6rer", "y6erpic",new Date(), new Date());
		boolean flag = userService.insertUser(user);
		List<User> uList = userService.queryAllUser();
		for (User user2 : uList) {
			System.out.println(user2);
		}
		System.out.println(flag);
	}

}
