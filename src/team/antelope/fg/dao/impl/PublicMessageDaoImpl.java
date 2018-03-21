package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IPublicMessageDao;
import team.antelope.fg.entity.PrivateMessage;
import team.antelope.fg.entity.PublicMessage;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class PublicMessageDaoImpl implements IPublicMessageDao {

	@Override
	public int insert(PublicMessage t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into publicmessage values(null, ?, now(),"
				+ "?, ?, ?)");
		try {
			pstmt.setLong(1, t.getReceiverid());
			pstmt.setString(2, t.getTitle());
			pstmt.setString(3, t.getContent());
			pstmt.setBoolean(4, t.isIsread());
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
	public int update(PublicMessage t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update publicmessage set receiverid=?, sendtime=?, "
				+ "title=?, content=?, isread=? where id=?");
		try {
			pstmt.setLong(1, t.getReceiverid());
			pstmt.setTimestamp(2, t.getSendTime());
			pstmt.setString(3, t.getTitle());
			pstmt.setString(4, t.getContent());
			pstmt.setBoolean(5, t.isIsread());
			pstmt.setLong(6, t.getId());
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
	public int delete(PublicMessage t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from publicmessage where id=?");
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
	public PublicMessage queryById(Long id) {
		PublicMessage message = (PublicMessage) DBUtil.exeQuery("select * from publicmessage where id=?",
				new Long[]{id},
				new BeanHandler(PublicMessage.class));
		return message;
	}

	@Override
	public List<PublicMessage> queryAllPublicMessage() {
		List<PublicMessage> messages = (List<PublicMessage>) DBUtil.exeQuery("select * from publicmessage",
				null,
				new BeanListHandler(PublicMessage.class));
		return messages;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from publicmessage");
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
	public List<PublicMessage> queryAllPublicMessage(int from, int to) {
		List<PublicMessage> messages = (List<PublicMessage>) DBUtil.exeQuery("select * from publicmessage limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(PublicMessage.class));
		return messages;
	}
}
