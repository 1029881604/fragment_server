package team.antelope.fg.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import team.antelope.fg.dao.IUFDao;
import team.antelope.fg.entity.Attention;
import team.antelope.fg.entity.Person;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class UFDaoImpl implements IUFDao {

	@Override
	public int insert(Attention t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into attention values(?, ?)");
		try {
			pstmt.setLong(1, t.getUid());
			pstmt.setLong(2, t.getAttentionuserid());
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
	public int update(Attention t) {
		int affectRows = 0;
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update attention set 当有新字段则修改  where uid=?, attentionuserid=?");
		try {
			pstmt.setLong(1, t.getUid());
			pstmt.setLong(2, t.getFid());
			affectRows = DBUtil.exeUpdate(pstmt);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}*/
		return affectRows;
	}

	@Override
	public int delete(Attention t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from attention where uid=? and attentionuserid=?");
		try {
			pstmt.setLong(1, t.getUid());
			pstmt.setLong(2, t.getAttentionuserid());
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
	
	@Deprecated
	@Override
	public Attention queryById(Long id) {
		return null;
	}

	@Override
	public List<PersonInfo> findFriendsAll(Person person) {
		List<PersonInfo> friends = (List<PersonInfo>) DBUtil.exeCSQuery("call sp_find_attention(?) ", 
				new Long[]{person.getId()}, 
				new BeanListHandler(PersonInfo.class));
		return friends;
		
		/*List<PersonInfo> friends = new ArrayList <PersonInfo>();
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			cstmt = DBUtil.getCStmt(conn, "call sp_find_attention(?) ");
			cstmt.setLong(1, person.getId());
			rs = cstmt.executeQuery();
			if(rs == null){
				return null;
			} else{
				while(rs.next()){
					//id, name, email, sex, age, headimg, starnum, dealnum,  fansnum
					PersonInfo personInfo = new PersonInfo();
					personInfo.setId(rs.getLong(1));
					personInfo.setName(rs.getString(2));
					personInfo.setEmail(rs.getString(3));
					personInfo.setSex(rs.getString(4));
					personInfo.setAge(rs.getInt(5));
					personInfo.setHeadimg(rs.getString(6));
					personInfo.setStarnum(rs.getFloat(7));
					personInfo.setDealnum(rs.getInt(8));
					personInfo.setFansnum(rs.getInt(9));
					friends.add(personInfo);
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			DBUtil.close(rs);
			DBUtil.close(cstmt);
			DBUtil.close(conn);
		}
		return friends;*/
	}
	
	@Override
	public int getTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(*) from attention ");
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
	public Attention queryById(long uid, long attentionuserid) {
		Attention attention = (Attention) DBUtil.exeQuery("select uid, attentionuserid from attention where uid=? and attentionuserid=? ", 
				new Long[]{uid, attentionuserid}, 
				new BeanHandler(Attention.class));
		return attention;
	}

	@Override
	public List<Attention> queryAll() {
		List<Attention> ufs = (List<Attention>) DBUtil.exeQuery("select * from attention", null, new BeanListHandler(Attention.class));
		return ufs;
	}

}



