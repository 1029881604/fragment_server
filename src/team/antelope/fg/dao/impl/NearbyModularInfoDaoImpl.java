package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.INearbyModularInfoDao;
import team.antelope.fg.entity.NearbyModularInfo;
import team.antelope.fg.entity.Person;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class NearbyModularInfoDaoImpl implements INearbyModularInfoDao {

	@Override
	public int insert(NearbyModularInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "insert into nearbymodular values(?, ?, ?,"
				+ "?, ?, ?, ?, ?, ?)");
		try {
			pstmt.setString(1, t.getNeedtitle());
			pstmt.setString(2, t.getNeedbody());
			pstmt.setString(3, t.getNeedimg());
			pstmt.setString(4, t.getSkilltitle());
			pstmt.setString(5, t.getSkillbody());
			pstmt.setString(6, t.getSkillimg());
			pstmt.setString(7, t.getType());
			pstmt.setTimestamp(8, t.getNeedupdatetime());
			pstmt.setTimestamp(9, t.getSkillupdatetime());
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
	public int update(NearbyModularInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update nearbymodular set needtitle=?, needbody=?, needimg=?,"
				+ "skilltitle=?, skillbody=?, skillimg=?, needupdatetime=?, skillupdatetime=?"
				+ "where type=? ");
		try {
			pstmt.setString(1, t.getNeedtitle());
			pstmt.setString(2, t.getNeedbody());
			pstmt.setString(3, t.getNeedimg());
			pstmt.setString(4, t.getSkilltitle());
			pstmt.setString(5, t.getSkillbody());
			pstmt.setString(6, t.getSkillimg());
			pstmt.setTimestamp(7, t.getNeedupdatetime());
			pstmt.setTimestamp(8, t.getSkillupdatetime());
			pstmt.setString(9, t.getType());
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
	public int delete(NearbyModularInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from nearbymodular where type=?");
		try {
			pstmt.setString(1, t.getType());
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
	public NearbyModularInfo queryById(Long id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<NearbyModularInfo> queryAllModularInfo() {
		List<NearbyModularInfo> modularInfos = (List<NearbyModularInfo>) DBUtil.exeQuery("select * from nearbymodular",
				null,
				new BeanListHandler(NearbyModularInfo.class));
		return modularInfos;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(type) from nearbymodular");
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
	public List<NearbyModularInfo> queryAllModularInfo(int from, int to) {
		List<NearbyModularInfo> modularInfos = (List<NearbyModularInfo>) DBUtil.exeQuery("select * from nearbymodular"
				+ " limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(NearbyModularInfo.class));
		return modularInfos;
	}

	@Override
	public NearbyModularInfo queryByType(String name) {
		NearbyModularInfo modularInfo = (NearbyModularInfo) DBUtil.exeQuery("select * from nearbymodular where type=?",
				new String[]{name},
				new BeanHandler(NearbyModularInfo.class));
		return modularInfo;
	}

}
