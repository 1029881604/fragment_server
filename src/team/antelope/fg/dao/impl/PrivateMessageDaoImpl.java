package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IPrivateMessageDao;
import team.antelope.fg.entity.PrivateMessage;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class PrivateMessageDaoImpl implements IPrivateMessageDao {

	@Override
	public int insert(PrivateMessage t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into privatemessage values(null, ?, ?,"
				+ "?, ?, now(), ?, ?)");
		try {
			pstmt.setLong(1, t.getSenderid());
			pstmt.setString(2, t.getSendername());
			pstmt.setLong(3, t.getReceiverid());
			pstmt.setString(4, t.getReceivername());
			pstmt.setString(5, t.getContent());
			pstmt.setBoolean(6, t.isIsread());
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
	public int update(PrivateMessage t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update privatemessage set senderid=?, sendername=?, "
				+ "receiverid=?, receivername=?, sendtime=?, content=?, isread=? where "
				+ " id=?");
		try {
			pstmt.setLong(1, t.getSenderid());
			pstmt.setString(2, t.getSendername());
			pstmt.setLong(3, t.getReceiverid());
			pstmt.setString(4, t.getReceivername());
			pstmt.setTimestamp(5, t.getSendtime());
			pstmt.setString(6, t.getContent());
			pstmt.setBoolean(7, t.isIsread());
			pstmt.setLong(8, t.getId());
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
	public int delete(PrivateMessage t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from privatemessage where id=?");
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
	public PrivateMessage queryById(Long id) {
		PrivateMessage message = (PrivateMessage) DBUtil.exeQuery("select * from privatemessage where id=?",
				new Long[]{id},
				new BeanHandler(PrivateMessage.class));
		return message;
	}

	@Override
	public List<PrivateMessage> queryAllPrivateMessage() {
		List<PrivateMessage> messages = (List<PrivateMessage>) DBUtil.exeQuery("select * from privatemessage",
				null,
				new BeanListHandler(PrivateMessage.class));
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
			pstmt = DBUtil.getStmt(conn, "select count(id) from privatemessage");
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
	public List<PrivateMessage> queryAllPrivateMessage(int from, int to) {
		List<PrivateMessage> messages = (List<PrivateMessage>) DBUtil.exeQuery("select * from privatemessage limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(PublishSkill.class));
		return messages;
	}

	@Override
	public List<PrivateMessage> queryBySenderId(long senderId) {
		List<PrivateMessage> messages = (List<PrivateMessage>) DBUtil.exeQuery("select * from privatemessage where senderid=?",
				new Long[]{senderId},
				new BeanListHandler(PublishSkill.class));
		return messages;
	}
	
	
}
