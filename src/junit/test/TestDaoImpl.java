package junit.test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import team.antelope.fg.dao.IUFDao;
import team.antelope.fg.dao.impl.NearbyModularInfoDaoImpl;
import team.antelope.fg.dao.impl.NeedPreInfoDaoImpl;
import team.antelope.fg.dao.impl.PersonInfoDaoImpl;
import team.antelope.fg.dao.impl.PrivateMessageDaoImpl;
import team.antelope.fg.dao.impl.PublicMessageDaoImpl;
import team.antelope.fg.dao.impl.PublishNeedDaoImpl;
import team.antelope.fg.dao.impl.PublishSkillDaoImpl;
import team.antelope.fg.dao.impl.UFDaoImpl;
import team.antelope.fg.dao.impl.UserDaoImpl;
import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.entity.PrivateMessage;
import team.antelope.fg.entity.PublicMessage;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.entity.User;

public class TestDaoImpl {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() {
		UserDaoImpl dao = new UserDaoImpl();
		User u = dao.findByName("mhtbb");
		dao.delete(u);
		List<User> all = dao.findAll();
		all.forEach(user-> { System.out.println(user.toString());});
	}

	@Test
	public void testUpdate() {
		IUFDao dao = new UFDaoImpl();
//		dao.insert(new Attention(100, 101));
		Person person = new Person(100L, "张三", "zhangsan", "男", "1923e343@qq.com",
				"18348893343", 22, "localhost:8080/fragment_server/images/person_head_img/zhangsan.jpg",
				3.5f, 30, 200);
//		Attention attention = dao.queryById(100l, 101l);
		List<PersonInfo> list = dao.findFriendsAll(person);
		list.forEach(a-> { System.out.println(a.toString());});
		
	}

	@Test
	public void testDelete() {
		long delay = System.currentTimeMillis() + 3600 * 24 * 3;
		PublishSkillDaoImpl dao = new PublishSkillDaoImpl();
//		dao.update(new PublishSkill(10l, 103l, "1333一个....的icon", "1我的icon....", new Timestamp(System.currentTimeMillis()), 
//				new Timestamp(delay),
//				 "2localhost:8080/fragment_server/images/skill_pre_img/perview33.jpg",
//				 "2i2con", true, false, "1江西师范大学", 102.3, 30.3));
		List<PublishSkill> allPublishSkill = dao.queryAllPublishSkill();
		allPublishSkill.forEach(s-> {System.out.println(s.toString());});
	}

	@Test
	public void testQueryById() {
		long delay = System.currentTimeMillis() + 3600 * 24 * 3;
		PublishNeedDaoImpl dao = new PublishNeedDaoImpl();
//		dao.delete(new PublishNeed(8, 103l, "104 need 。。", "4I need...", "4needtype3", new Timestamp(System.currentTimeMillis()), 
//				new Timestamp(delay), false, false, "4江西师范大学", 113.2, 31.5));
		List<PublishNeed> allPublishNeed = dao.queryAllPublishNeed();
		allPublishNeed.forEach(s-> {System.out.println(s.toString());});
	}

	@Test
	public void testGetTotalRecords() {
		PrivateMessageDaoImpl dao = new PrivateMessageDaoImpl();
		PrivateMessage u = new PrivateMessage(9l, 103l, "2没烦恼", 104l, "2不高兴", new Timestamp(System.currentTimeMillis()),
				"this is content", false);
		dao.update(u);
//		System.out.println(u.toString());
		List<PrivateMessage> all = dao.queryAllPrivateMessage();
		all.forEach(user-> { System.out.println(user.toString());});
	}

	@Test
	public void testFindAll() {
		PublicMessageDaoImpl dao = new PublicMessageDaoImpl();
		PublicMessage message = new PublicMessage(8l, 104l, new Timestamp(System.currentTimeMillis()),
				"1title", "1content", false);
		dao.delete(message);
		List<PublicMessage> all = dao.queryAllPublicMessage();
		all.forEach(user-> { System.out.println(user.toString());});
	}

	@Test
	public void testFindAllIntInt() {
		PersonInfoDaoImpl dao = new PersonInfoDaoImpl();
//		PersonInfo info = dao.queryById(100l);
//		info.setName("zs");
//		info.setEmail("zsemail");
//		dao.delete(info);
		List<PersonInfo> all = dao.queryAllPersonInfo();
		all.forEach(user-> { System.out.println(user.toString());});
	}

	@Test
	public void testFindByName() {
		NeedPreInfoDaoImpl dao = new NeedPreInfoDaoImpl();
		List<NeedPreInfo> all = dao.queryAllNeedInfo();
		all.forEach(user-> { System.out.println(user.toString());});
	}

	@Test
	public void testFindUsersByLike() {
		NearbyModularInfoDaoImpl dao = new NearbyModularInfoDaoImpl();
//		List<NearbyModularInfo> infos = dao.queryAllModularInfo();
//		infos.forEach(i->{System.out.println(i.toString());});
		NearbyModularInfo modularInfo = dao.queryByType("other");
		System.out.println(modularInfo.toString());
		
	}

}
