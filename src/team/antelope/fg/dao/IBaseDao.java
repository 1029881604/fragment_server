package team.antelope.fg.dao;


import java.util.List;
/**
 * 
 * @author 华文财
 * @time:2017年12月29日 下午11:26:42
 * @Description:TODO
 * @param <T>
 */

public interface IBaseDao<T> {
	public int insert(T t);	
	public int update(T t);	
	public int delete(T t);	
	public T queryById(Long id);
}
