package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IPersonInfoDao;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class PersonInfoDaoImpl implements IPersonInfoDao {

	@Override
	public int update(PersonInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update v_person set name=?, sex=?, email=?,"
				+ "age=?, headimg=?, starnum=?, dealnum=?, fansnum=? where id=?");
		try {
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getSex());
			pstmt.setString(3, t.getEmail());
			pstmt.setInt(4, t.getAge());
			pstmt.setString(5, t.getHeadimg());
			pstmt.setDouble(6, t.getStarnum());
			pstmt.setInt(7, t.getDealnum());
			pstmt.setInt(8, t.getFansnum());
			pstmt.setLong(9, t.getId());
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
	public int delete(PersonInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from v_person where id=?");
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
	public PersonInfo queryById(Long id) {
		PersonInfo pserson = (PersonInfo) DBUtil.exeQuery("select * from v_person where id=?",
				new Long[]{id},
				new BeanHandler(PersonInfo.class));
		return pserson;
	}

	@Override
	public List<PersonInfo> queryAllPersonInfo() {
		List<PersonInfo> psersons = (List<PersonInfo>) DBUtil.exeQuery("select * from v_person",
				null,
				new BeanListHandler(PersonInfo.class));
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
			pstmt = DBUtil.getStmt(conn, "select count(id) from v_person");
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
	public List<PersonInfo> queryAllPersonInfo(int from, int to) {
		List<PersonInfo> psersons = (List<PersonInfo>) DBUtil.exeQuery("select * from v_person limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(PersonInfo.class));
		return psersons;
	}

}
