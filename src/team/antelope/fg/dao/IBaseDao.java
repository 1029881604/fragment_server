package team.antelope.fg.dao;


import java.util.List;
/**
 * 
 * @author 华文财
 * @time:2018年5月14日 上午11:09:20
 * @Description:TODO
 * @param <T>
 */
public interface IBaseDao<T> {
	public int insert(T t);	
	public int update(T t);	
	public int delete(T t);	
	public T queryById(Long id);
}
