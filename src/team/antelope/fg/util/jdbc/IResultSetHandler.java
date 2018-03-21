package team.antelope.fg.util.jdbc;

import java.sql.ResultSet;

public interface IResultSetHandler {
	/**
     * @Method: handler
     * @Description: 结果集处理方法
     * @Anthor:hwc
     *
     * @param rs 查询结果集
     * @return
     */ 
     public Object handler(ResultSet rs);
}
