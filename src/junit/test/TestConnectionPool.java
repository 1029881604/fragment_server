package junit.test;

import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;



import team.antelope.fg.entity.User;
import team.antelope.fg.util.jdbc.ConnectionPool;
import team.antelope.fg.util.jdbc.DBUtil;

public class TestConnectionPool {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInitPool() {
		fail("��δʵ��");
	}

	@Test
	public void testConnectionPool() {
		fail("��δʵ��");
	}

	@Test
	public void testGetConn() {
		
		ConnectionPool cp =	ConnectionPool.getInstance();
		CountDownLatch latch = new CountDownLatch(100);
		System.out.println("size:"+cp.size());
////		//����Ч��
		long start = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			new Thread(()->{
				Connection conn = DBUtil.getConn();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				PreparedStatement pstmt = DBUtil.getStmt(conn, "select * from user");
				ResultSet rs = DBUtil.exeQuery(pstmt);
				List<User> users = new ArrayList<User>();
				try {
					while(rs.next()){
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						users.add(user);
					}
					System.out.println(users.size());
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} finally{
					latch.countDown();
					DBUtil.close(pstmt);
					DBUtil.close(conn);
				}
			}, "thread"+i).start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
		System.out.println("size:"+cp.size());
	}

	@Test
	public void testClose() {
		ConnectionPool cp = ConnectionPool.getInstance();
		List <Connection> conns = new ArrayList<>();
		for(int i=0; i<34; i++){
			Connection conn = cp.getConn();
			conns.add(conn);
		}
		conns.forEach(conn->cp.close(conn));
		System.out.println(cp.size());
	}

}
