package team.antelope.fg.dao;
/**
 * 
 * @author ���Ĳ�
 * @time:2017��12��31�� ����7:50:35
 * @Description:TODO ���ṩinsert
 * @param <T>
 */
public interface IInfoBaseDao<T> {
	
	public int update(T t);	
	public int delete(T t);	
	public T queryById(Long id);
}
