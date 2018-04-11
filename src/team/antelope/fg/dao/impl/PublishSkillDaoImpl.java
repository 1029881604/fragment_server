package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import team.antelope.fg.dao.IPublishSkillDao;
import team.antelope.fg.entity.PublishSkill;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;


public class PublishSkillDaoImpl implements IPublishSkillDao {

	@Override
	public int insert(PublishSkill t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into publishskill values(null, ?, ?, ?,"
				+ "now(), date_add(now(), interval 3 day), ?, ?, ?, ?, ?, ?, ?)");
		try {
			pstmt.setLong(1, t.getUid());
			pstmt.setString(2, t.getTitle());
			pstmt.setString(3, t.getContent());
			pstmt.setString(4, t.getImg());
			pstmt.setString(5, t.getSkilltype());
			pstmt.setBoolean(6, t.isIscomplete());
			pstmt.setBoolean(7, t.isIsonline());
			pstmt.setString(8, t.getAddressdesc());
			pstmt.setDouble(9, t.getLongitude());
			pstmt.setDouble(10, t.getLatitude());
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
	public int update(PublishSkill t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "update publishskill set uid=?, title=?, content=?, "
					+ "publishdate=?, stopdate=?, img=?, skilltype=?, iscomplete=?, "
					+ "isonline=?, addressdesc=?, longitude=?, latitude=? where id = ?");
			pstmt.setLong(1, t.getUid());
			pstmt.setString(2, t.getTitle());
			pstmt.setString(3, t.getContent());
			pstmt.setTimestamp(4,  t.getPublishdate());
			pstmt.setTimestamp(5, t.getStopdate());
			pstmt.setString(6, t.getImg());
			pstmt.setString(7, t.getSkilltype());
			pstmt.setBoolean(8, t.isIscomplete());
			pstmt.setBoolean(9, t.isIsonline());
			pstmt.setString(10, t.getAddressdesc());
			pstmt.setDouble(11, t.getLongitude());
			pstmt.setDouble(12, t.getLatitude());
			pstmt.setLong(13, t.getId());
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
	public int delete(PublishSkill t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from publishskill where id=?");
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
	public PublishSkill queryById(Long id) {
		PublishSkill skill = (PublishSkill) DBUtil.exeQuery("select * from publishskill where id=?",
				new Long[]{id},
				new BeanHandler(PublishSkill.class));
		return skill;
	}

	@Override
	public List<PublishSkill> queryAllPublishSkill() {
		List<PublishSkill> skills = (List<PublishSkill>) DBUtil.exeQuery("select * from publishskill",
				null,
				new BeanListHandler(PublishSkill.class));
		return skills;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from publishskill");
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
	@SuppressWarnings(value="all")
	public List<PublishSkill> queryAllPublishSkill(int from, int to) {
		List<PublishSkill> skills = (List<PublishSkill>) DBUtil.exeQuery("select * from publishskill limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(PublishSkill.class));
		return skills;
	}

//	 private long id;
//	    private long uid;
//	    private String title; 
//	    private String content; 
//	    private Timestamp publishdate;
//	    private Timestamp stopdate;
//	    private String img; 
//	    private String  skilltype;
//	    private boolean iscomplete;
//	    private boolean isonline;   
//	    private String addressdesc;	// allow null 
//	    private Double longitude;	// allow null
//		private Double latitude;	// allow null
	@Override
	@SuppressWarnings(value="all")
	public List<PublishSkill> queryOnlineSkillsByType(String type) {
		List<PublishSkill> skills = (List<PublishSkill>) DBUtil.exeQuery("select * from  publishskill where skilltype =? and isonline = 1",
				new String[]{type},
				new BeanListHandler(PublishSkill.class));
		return skills;
	}

}
