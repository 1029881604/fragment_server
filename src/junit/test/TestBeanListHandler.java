package junit.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import team.antelope.fg.entity.User;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class TestBeanListHandler {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBeanListHandler() {
		List<User> users = (List<User>) DBUtil.exeQuery("select * from user where id > ?", 
				new Integer[]{0}, new BeanListHandler(User.class));
		users.forEach(u->System.out.println(u.toString()));
	}

	@Test
	public void testHandler() {
		User user = (User) DBUtil.exeQuery("select * from user where id = ?", 
				new Integer[]{1}, new BeanHandler(User.class));
		System.out.println(user);
	}

}
