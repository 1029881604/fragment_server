package team.antelope.fg.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IUserDao;
import team.antelope.fg.entity.User;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;
/**
 * 
 * @author 华文财
 * @time:2017年12月30日 上午11:26:23
 * @Description:TODO  不提供插入操作,因为是视图
 */
public class UserDaoImpl implements IUserDao {

	@Override
	public int insert(User t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "insert into v_user values(null, ?, ?, ?)");
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getPassword());
			pstmt.setString(3, t.getEmail());
			affectRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public int update(User t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "update v_user set  name=?, password=?, email=? where v_user.id = ?");
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getPassword());
			pstmt.setString(3, t.getEmail());
			pstmt.setLong(4, t.getId());
			affectRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public int delete(User t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "delete from v_user where v_user.id = ?");
			pstmt.setLong(1, t.getId());
			affectRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return affectRows;
	}

	@Override
	public User queryById(Long id) {
		User user = (User) DBUtil.exeQuery("select id, name, password, email from v_user where id=?",
				new Long[]{id},
				new BeanHandler(User.class));
		return user;
	}

	@Override
	public int getTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from v_user");
			rs = pstmt.executeQuery();
			if(rs == null){
				return 0;
			} else{
				if(rs.next()){
					count = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return count;
	}

	@Override
	public List<User> findAll() {
		List<User> users = (List<User>) DBUtil.exeQuery("select id, name, password, email from v_user",
				null,
				new BeanListHandler(User.class));
		return users;
	}

	@Override
	public List<User> findAll(int from, int to) {
		List<User> users = (List<User>) DBUtil.exeQuery("select id, name, password, email from v_user limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(User.class));
		return users;
	}

	@Override
	public User findByName(String name) {
		User user = (User) DBUtil.exeQuery("select id, name, password, email from v_user where name=?",
				new String[]{name},
				new BeanHandler(User.class));
		return user;
	}

	@Override
	public List<User> findUsersByLike(String name) {
		List<User> users = (List<User>) DBUtil.exeQuery("select id, name, password, email from v_user where"
				+ " name like '%?%' ",
				new String[] {name},
				new BeanListHandler(User.class));
		return users;
	}

}
