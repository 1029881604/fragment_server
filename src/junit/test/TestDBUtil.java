package junit.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;

import team.antelope.fg.entity.User;
import team.antelope.fg.util.jdbc.ConnectionPool2;
import team.antelope.fg.util.jdbc.DBUtil;
import team.antelope.fg.util.jdbc.DBUtil2;

public class TestDBUtil {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetConn() {
		DBUtil.getConn();
	}

	@Test
	public void testGetStmtConnectionString() {
	}

	@Test
	public void testGetStmtConnectionStringInt() {
	}

	@Test
	public void testGetStmtConnection() {
		DBUtil2.getConn();
		ConnectionPool2 cp = ConnectionPool2.getInstance();
		CountDownLatch latch = new CountDownLatch(100);
		System.out.println("size:"+cp.size());
//		//测试效率
		long start = System.currentTimeMillis();
		for(int i=0; i<100; i++){
			new Thread(()->{
				Connection conn = DBUtil2.getConn();
				System.out.println(conn);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				PreparedStatement pstmt = DBUtil2.getStmt(conn, "select * from user");
				ResultSet rs = DBUtil2.exeQuery(pstmt);
				List<User> users = new ArrayList<User>();
				try {
					while(rs.next()){
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						users.add(user);
					}
				} catch (SQLException e) {
					// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
					e.printStackTrace();
				} finally{
					latch.countDown();
					DBUtil2.close(pstmt);
					DBUtil2.close();
				}
			}, "thread"+i).start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("time:"+(end-start));
		System.out.println("size:"+cp.size());
	}

	@Test
	public void testExeQueryPreparedStatement() {
	}

	@Test
	public void testExeQueryStatementString() {
		Connection conn = DBUtil.getConn();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		
		if(users != null){
			users.forEach(user-> System.out.println(user.toString()));
		}
	}

	@Test
	public void testExeUpdate() {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = DBUtil.getStmt(conn, "update user set name=? where id=?");
		try {
			pstmt.setString(1, "张三丰");
			pstmt.setInt(2, 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int row = DBUtil.exeUpdate(pstmt);
		System.out.println(row);
		if(row == 1){
			System.out.println("修改成功");
		}
		
	
	}

	@Test
	public void testCloseConnection() {
	}

	@Test
	public void testCloseStatement() {
	}

}
