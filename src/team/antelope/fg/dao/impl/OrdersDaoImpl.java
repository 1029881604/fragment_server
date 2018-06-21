package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IOrdersDao;
import team.antelope.fg.entity.Orders;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

/**
 * orders����ز���ʵ����
 * @author ����
 *
 */
public class OrdersDaoImpl implements IOrdersDao {

	@Override
	public int insert(Orders orders) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into orders values(null, ?, ?, ?, ?, ?, ?, ?, ?,"
				+ "now(), ?, ?, ?)");
		try {
			pstmt.setLong(1, orders.getUid());
			pstmt.setLong(2,orders.getUid_s());
			pstmt.setLong(3, orders.getSkillid());
			pstmt.setString(4, orders.getTitle());
			pstmt.setString(5, orders.getContent());
			pstmt.setString(6, orders.getImg());
			pstmt.setString(7, orders.getSkilltype());
			pstmt.setDouble(8, orders.getPrice());
			pstmt.setBoolean(9, orders.isIspay());
			pstmt.setBoolean(10, orders.isIsdelete());
			pstmt.setBoolean(11, orders.isIscomment());
			affectRows = DBUtil.exeUpdate(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public int update(Orders orders) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "update orders set uid=?, uid_s=?, skillid=?, "
					+ "title=?, content=?, img=?, skilltype=?, price=?, ispay=?, "
					+ "isdelete=?, iscomment=? where id = ?");
			pstmt.setLong(1, orders.getUid());
			pstmt.setLong(2,orders.getUid_s());
			pstmt.setLong(3, orders.getSkillid());
			pstmt.setString(4, orders.getTitle());
			pstmt.setString(5, orders.getContent());
			pstmt.setString(6, orders.getImg());
			pstmt.setString(7, orders.getSkilltype());
			pstmt.setDouble(8, orders.getPrice());
			pstmt.setBoolean(9, orders.isIspay());
			pstmt.setBoolean(10, orders.isIsdelete());
			pstmt.setBoolean(11, orders.isIscomment());
			pstmt.setLong(11, orders.getId());
			affectRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public int delete(Orders orders) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from orders where id=?");
		try {
			pstmt.setLong(1, orders.getId());
			affectRows = DBUtil.exeUpdate(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public Orders queryById(Long id) {
		// TODO Auto-generated method stub
		Orders order = (Orders) DBUtil.exeQuery("select * from orders where id=?",
				new Long[]{id},
				new BeanHandler(Orders.class));
		return order;
	}

	@Override
	@SuppressWarnings(value="all")
	public List<Orders> queryOrdersByUid(Long uid) {
		// TODO Auto-generated method stub
		List<Orders> orders = (List<Orders>)DBUtil.exeQuery("select * from orders where uid=? and isdelete=0",
				new Long[] {uid},
				new BeanListHandler(Orders.class));
		return orders;
	}

	@Override
	@SuppressWarnings(value="all")
	public List<Orders> queryOrdersByIsPay(Long uid) {
		// TODO Auto-generated method stub
		List<Orders> orders = (List<Orders>)DBUtil.exeQuery("select * from orders where uid=? and isdelete=0 and ispay=1",
				new Long[] {uid},
				new BeanListHandler(Orders.class));
		return orders;
	}

	@Override
	@SuppressWarnings(value="all")
	public List<Orders> queryOrdersByNotPay(Long uid) {
		// TODO Auto-generated method stub
		List<Orders> orders = (List<Orders>)DBUtil.exeQuery("select * from orders where uid=? and isdelete=0 and ispay=0",
				new Long[] {uid},
				new BeanListHandler(Orders.class));
		return orders;
	}

	@Override
	public int queryTotalRecords() {
		// TODO Auto-generated method stub
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from orders");
			rs = pstmt.executeQuery();
			if(rs == null){
				return 0;
			} else{
				if(rs.next()){
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return count;
	}

	@Override
	public int addOrder(Long uid, Long uid_s, Long skillid, String title, String content, String img, String skilltype,
			double price, int ispay, int isdelete, int iscomment) {
		// TODO Auto-generated method stub
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "insert into orders values(null, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ "now(), ?, ?, ?)");
			pstmt.setLong(1, uid);
			pstmt.setLong(2, uid_s);
			pstmt.setLong(3, skillid);
			pstmt.setString(4, title);
			pstmt.setString(5, content);
			pstmt.setString(6, img);
			pstmt.setString(7, skilltype);
			pstmt.setDouble(8, price);
			pstmt.setInt(9, ispay);
			pstmt.setInt(10, isdelete);
			pstmt.setInt(11, iscomment);
			affectRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

}
