package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IPersonDao;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PrivateMessage;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class PersonDaoImpl implements IPersonDao {

	@Override
	public int insert(Person t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into person values(null, ?, ?, ?,"
				+ "?, ?, ?, ?, ?, ?, ?)");
		try {
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getPassword());
			pstmt.setString(3, t.getSex());
			pstmt.setString(4, t.getEmail());
			pstmt.setString(5, t.getPhonenum());
			pstmt.setInt(6, t.getAge());
			pstmt.setString(7, t.getHeadimg());
			pstmt.setDouble(8, t.getStarnum());
			pstmt.setInt(9, t.getDealnum());
			pstmt.setInt(10, t.getFansnum());
			affectRows = DBUtil.exeUpdate(pstmt);
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
	public int update(Person t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update person set name=?, password=?, sex=?, email=?,"
				+ "phonenum=?, age=?, headimg=?, starnum=?, dealnum=?, fansnum=? where id=?");
		try {
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getPassword());
			pstmt.setString(3, t.getSex());
			pstmt.setString(4, t.getEmail());
			pstmt.setString(5, t.getPhonenum());
			pstmt.setInt(6, t.getAge());
			pstmt.setString(7, t.getHeadimg());
			pstmt.setDouble(8, t.getStarnum());
			pstmt.setInt(9, t.getDealnum());
			pstmt.setInt(10, t.getFansnum());
			pstmt.setLong(11, t.getId());
			affectRows = DBUtil.exeUpdate(pstmt);
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
	public int delete(Person t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from person where id=?");
		try {
			pstmt.setLong(1, t.getId());
			affectRows = DBUtil.exeUpdate(pstmt);
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
	public Person queryById(Long id) {
		Person pserson = (Person) DBUtil.exeQuery("select * from person where id=?",
				new Long[]{id},
				new BeanHandler(Person.class));
		return pserson;
	}

	@Override
	public Person queryByName(String name) {
		Person pserson = (Person) DBUtil.exeQuery("select * from person where name=?",
				new String[]{name},
				new BeanHandler(Person.class));
		return pserson;
	}

	@Override
	public Person queryByEmail(String email) {
		Person pserson = (Person) DBUtil.exeQuery("select * from person where email=?",
				new String[]{email},
				new BeanHandler(Person.class));
		return pserson;
	}

	@Override
	public Person queryByPhoneNum(String phoneNum) {
		Person pserson = (Person) DBUtil.exeQuery("select * from person where phonenum=?",
				new String[]{phoneNum},
				new BeanHandler(Person.class));
		return pserson;
	}
	
	
	@Override
	public List<Person> queryAllPerson() {
		List<Person> psersons = (List<Person>) DBUtil.exeQuery("select * from person",
				null,
				new BeanListHandler(Person.class));
		return psersons;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from person");
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
	public List<Person> queryAllPerson(int from, int to) {
		List<Person> psersons = (List<Person>) DBUtil.exeQuery("select * from person limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(Person.class));
		return psersons;
	}

}
