package team.antelope.fg.util.jdbc;

import java.sql.ResultSet;

public interface IResultSetHandler {
	/**
     * @Method: handler
     * @Description: �����������
     * @Anthor:hwc
     *
     * @param rs ��ѯ�����
     * @return
     */ 
     public Object handler(ResultSet rs);
}
