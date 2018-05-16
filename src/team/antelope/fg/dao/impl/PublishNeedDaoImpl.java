package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.IPublishNeedDao;
import team.antelope.fg.entity.PersonNeed;
import team.antelope.fg.entity.PublishNeed;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class PublishNeedDaoImpl implements IPublishNeedDao {

	@Override
	public int insert(PublishNeed t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into publishneed values(null, ?, ?, ?, ?,"
				+ "now(), date_add(now(), interval 3 day), ?, ?, ?, ?, ?)");
		try {
			pstmt.setLong(1, t.getUid());
			pstmt.setString(2, t.getTitle());
			pstmt.setString(3, t.getContent());
			pstmt.setString(4, t.getNeedtype());
			pstmt.setBoolean(5, t.isIscomplete());
			pstmt.setBoolean(6, t.isIsonline());
			pstmt.setString(7, t.getAddressdesc());
			pstmt.setDouble(8, t.getLongitude());
			pstmt.setDouble(9, t.getLatitude());
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
	public int update(PublishNeed t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "update publishneed set uid=?, title=?, content=?, needtype=?, "
					+ "customdate=?, requestdate=?, iscomplete=?, "
					+ "isonline=?, addressdesc=?, longitude=?, latitude=? where id=?");
			pstmt.setLong(1, t.getUid());
			pstmt.setString(2, t.getTitle());
			pstmt.setString(3, t.getContent());
			pstmt.setString(4, t.getNeedtype());
			pstmt.setTimestamp(5, t.getCustomdate());
			pstmt.setTimestamp(6, t.getRequestdate());
			pstmt.setBoolean(7, t.isIscomplete());
			pstmt.setBoolean(8, t.isIsonline());
			pstmt.setString(9, t.getAddressdesc());
			pstmt.setDouble(10, t.getLongitude());
			pstmt.setDouble(11, t.getLatitude());
			pstmt.setLong(12, t.getId());
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
	public int delete(PublishNeed t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from publishneed where id=?");
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
	public PublishNeed queryById(Long id) {
		PublishNeed need = (PublishNeed) DBUtil.exeQuery("select * from publishneed where id=?",
				new Long[]{id},
				new BeanHandler(PublishNeed.class));
		return need;
	}

	@Override
	public List<PublishNeed> queryAllPublishNeed() {
		List<PublishNeed> needs = (List<PublishNeed>) DBUtil.exeQuery("select * from publishneed",
				null,
				new BeanListHandler(PublishNeed.class));
		return needs;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from publishneed");
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
	public List<PublishNeed> queryAllPublishNeed(int from, int to) {
		List<PublishNeed> needs = (List<PublishNeed>) DBUtil.exeQuery("select * from publishneed limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(PublishSkill.class));
		return needs;
	}
	
	//lry添加
	@Override
	@SuppressWarnings(value="all")
	public List<PersonNeed> queryAllPersonNeed() {
		List<PersonNeed> personNeeds = (List<PersonNeed>) DBUtil.exeQuery("select n.id, n.uid, n.title, n.content, n.customdate, n.requestdate, " + 
				" n.needtype, n.iscomplete, n.isonline, n.addressdesc, " + 
				" p.name, p.email, p.headimg, p.starnum, p.phonenum, p.dealnum, p.fansnum " + 
				" from publishneed n , person p " + 
				" WHERE n.uid = p.id; ",
				null,
				new BeanListHandler(PersonNeed.class));
		return personNeeds;
	}

	@Override
	public List<PublishNeed> queryByuid(Long uid) {
		List<PublishNeed> publishNeeds = (List<PublishNeed>) DBUtil.exeQuery("select * from publishneed where uid=?",
				new Long[]{uid},
				new BeanListHandler(PublishNeed.class));
		return publishNeeds;
	}
}
