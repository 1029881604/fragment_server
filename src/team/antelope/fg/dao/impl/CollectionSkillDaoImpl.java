package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.ICollectionSkillDao;
import team.antelope.fg.entity.CollectionSkill;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class CollectionSkillDaoImpl implements ICollectionSkillDao{

	@Override
	public int insert(CollectionSkill t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "insert into collection_skill values(null, ?, ?, now())");
			pstmt.setLong(1, t.getUser_id());
			pstmt.setLong(2, t.getSkill_id());
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
	public int update(CollectionSkill t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "update collection_skill set  user_id=?, skill_id=?, collect_date=? where id = ?");
			pstmt.setLong(1, t.getUser_id());
			pstmt.setLong(2, t.getSkill_id());
			pstmt.setDate(3, new Date( t.getCollect_date().getTime()));
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
	public int delete(CollectionSkill t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "delete from collection_skill where id = ?");
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
	public CollectionSkill queryById(Long id) {
		CollectionSkill collect = (CollectionSkill) DBUtil.exeQuery("select id, user_id, skill_id from  collection_skill  where id=?",
				new Long[]{id},
				new BeanHandler(CollectionSkill.class));
		return collect;
	}

	@Override
	public List<CollectionSkill> queryCollectsByUserId(Long userId) {
		List<CollectionSkill> collects = (List<CollectionSkill>) DBUtil.exeQuery("select * from collection_skill  where user_id=?",
				new Long[]{userId},
				new BeanListHandler(CollectionSkill.class));
		return collects;
	}

}
