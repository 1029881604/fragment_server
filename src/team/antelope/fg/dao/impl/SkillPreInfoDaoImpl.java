package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.ISkillPreInfoDao;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.SkillPreInfo;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class SkillPreInfoDaoImpl implements ISkillPreInfoDao {

	@Override
	public int update(SkillPreInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update v_skill_prehead set name=?,"
				+ "headimg=?, longitude=?, latitude=?, title=?, addressdesc=? where id=?");
		try {
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getHeadimg());
			pstmt.setDouble(3, t.getLongitude());
			pstmt.setDouble(4, t.getLatitude());
			pstmt.setString(5, t.getTitle());
			pstmt.setString(6, t.getAddressdesc());
			pstmt.setLong(7, t.getId());
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
	public int delete(SkillPreInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from v_skill_prehead where id=?");
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
	public SkillPreInfo queryById(Long id) {
		SkillPreInfo skillInfo = (SkillPreInfo) DBUtil.exeQuery("select * from v_skill_prehead where id=?",
				new Long[]{id},
				new BeanHandler(SkillPreInfo.class));
		return skillInfo;
	}

	@Override
	public List<SkillPreInfo> queryAllSkillInfo() {
		List<SkillPreInfo> skillInfos = (List<SkillPreInfo>) DBUtil.exeQuery("select * from v_skill_prehead",
				null,
				new BeanListHandler(SkillPreInfo.class));
		return skillInfos;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from v_skill_prehead");
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
	public List<SkillPreInfo> queryAllSkillInfo(int from, int to) {
		List<SkillPreInfo> skillInfos = (List<SkillPreInfo>) DBUtil.exeQuery("select * from v_skill_prehead limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(SkillPreInfo.class));
		return skillInfos;
	}

	@Override
	public List<SkillPreInfo> queryNearbyInfos(String type, double latitude, double longitude) {
		List<SkillPreInfo> skillInfos = (List<SkillPreInfo>) DBUtil.exeCSQuery("call sp_nearbyskill_infos(?,?,?) ",
				new Object[]{type, latitude, longitude},
				new BeanListHandler(SkillPreInfo.class));
		return skillInfos;
	}

}
