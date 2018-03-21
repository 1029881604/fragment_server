package team.antelope.fg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import team.antelope.fg.dao.INeedPreInfoDao;
import team.antelope.fg.entity.NeedPreInfo;
import team.antelope.fg.entity.PersonInfo;
import team.antelope.fg.util.jdbc.BeanHandler;
import team.antelope.fg.util.jdbc.BeanListHandler;
import team.antelope.fg.util.jdbc.DBUtil;

public class NeedPreInfoDaoImpl implements INeedPreInfoDao {

	@Override
	public int update(NeedPreInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "update v_need_prehead set name=?,"
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
	public int delete(NeedPreInfo t) {
		int affectRows = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBUtil.getConn();
		pstmt = DBUtil.getStmt(conn, "delete from v_need_prehead where id=?");
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
	public NeedPreInfo queryById(Long id) {
		NeedPreInfo needInfo = (NeedPreInfo) DBUtil.exeQuery("select * from v_need_prehead where id=?",
				new Long[]{id},
				new BeanHandler(NeedPreInfo.class));
		return needInfo;
	}

	@Override
	public List<NeedPreInfo> queryAllNeedInfo() {
		List<NeedPreInfo> needInfos = (List<NeedPreInfo>) DBUtil.exeQuery("select * from v_need_prehead",
				null,
				new BeanListHandler(NeedPreInfo.class));
		return needInfos;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConn();
			pstmt = DBUtil.getStmt(conn, "select count(id) from v_need_prehead");
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
	public List<NeedPreInfo> queryAllNeedInfo(int from, int to) {
		List<NeedPreInfo> needInfos = (List<NeedPreInfo>) DBUtil.exeQuery("select * from v_need_prehead limit ?, ?",
				new Integer[]{from, to},
				new BeanListHandler(NeedPreInfo.class));
		return needInfos;
	}

	@Override
	public List<NeedPreInfo> queryNearbyInfos(String type, double latitude, double longitude) {
		List<NeedPreInfo> needInfos = (List<NeedPreInfo>) DBUtil.exeCSQuery("call sp_nearbyneed_infos(?,?,?) ",
				new Object[]{type, latitude, longitude},
				new BeanListHandler(NeedPreInfo.class));
		return needInfos;
	}

}
