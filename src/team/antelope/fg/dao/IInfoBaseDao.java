package team.antelope.fg.dao;
/**
 * 
 * @author 华文财
 * @time:2017年12月31日 下午7:50:35
 * @Description:TODO 不提供insert
 * @param <T>
 */
public interface IInfoBaseDao<T> {
	
	public int update(T t);	
	public int delete(T t);	
	public T queryById(Long id);
}
