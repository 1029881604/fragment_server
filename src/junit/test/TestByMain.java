package junit.test;

import java.util.List;

import team.antelope.fg.dao.IUFDao;
import team.antelope.fg.dao.IUserDao;
import team.antelope.fg.dao.impl.UFDaoImpl;
import team.antelope.fg.dao.impl.UserDaoImpl;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.User;

public class TestByMain {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		IUFDao dao = new UFDaoImpl();
//		dao.insert(new Attention(100, 101));
		Person person = new Person(100L, "张三", "zhangsan", "男", "1923e343@qq.com",
				"18348893343", 22, "localhost:8080/fragment_server/images/person_head_img/zhangsan.jpg",
				3.5f, 30, 200);
//		Attention attention = dao.queryById(100l, 101l);
		List<PersonInfo> list = dao.findFriendsAll(person);
		list.forEach(a-> { System.out.println(a.toString());});
	}

}
