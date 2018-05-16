package team.antelope.fg.dao;


import java.util.List;
/**
 * 
 * @author ���Ĳ�
 * @time:2018��5��14�� ����11:09:20
 * @Description:TODO
 * @param <T>
 */
public interface IBaseDao<T> {
	public int insert(T t);	
	public int update(T t);	
	public int delete(T t);	
	public T queryById(Long id);
}
