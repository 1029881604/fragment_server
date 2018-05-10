package team.antelope.fg.util.jdbc;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
 * BeanListHandler——将结果集多行记录转换成bean对象集合的处理器
 * 要借助rs.getMetaData()
 * @author 华文财
 * @time:2017年11月12日 下午12:35:49
 * @Description:TODO
 */
public class BeanListHandler implements IResultSetHandler {

	private Class<?> mClass;
	
	public BeanListHandler(Class<?> cla){
		mClass = cla;
	}
	
	@Override
	public Object handler(ResultSet rs) {
		// TODO 自动生成的方法存根
		if(rs == null){
			return null;
		}
		
		try {
			List<Object> beanList = new ArrayList<>();
			ResultSetMetaData metaData = rs.getMetaData();
			int colNum = metaData.getColumnCount();
			while(rs.next()){
				
				Object bean = mClass.newInstance();
				for(int i=1; i<=colNum; i++){
					Object object = rs.getObject(i);
					String colName = metaData.getColumnName(i);
					Field f = mClass.getDeclaredField(colName);
					f.setAccessible(true);
					// add at 17/12/30 for modify a error
					if(f.getType().getSimpleName().equals(Long.class.getSimpleName())){
//						f.setLong(bean, new Long(String.valueOf(object))); 怎么写都是错误的，因为f.setLong是给long类型的赋值而不是Long
						if(object == null){
							object = 0L;
						}
						f.set(bean, new Long(String.valueOf(object)));	//这时候应该用f.set
					} else if (f.getType().getSimpleName().equals(long.class.getSimpleName())){
						if(object == null){
							object = 0l;
						}
						f.setLong(bean, Long.parseLong(String.valueOf(object)));
					} else if (f.getType().getSimpleName().equals(float.class.getSimpleName())){
						if(object == null){
							object = 0f;
						}
						f.setFloat(bean, Float.parseFloat(String.valueOf(object)));
					} else if (f.getType().getSimpleName().equals(Float.class.getSimpleName())){
						if(object == null){
							object = 0F;
						}
//						f.setFloat(bean, Float.parseFloat(String.valueOf(object)));  setFloat只给float类型字段而不是Float类型
						f.set(bean, Float.parseFloat(String.valueOf(object)));
					}  else {
						f.set(bean, object);
					}
				}
				beanList.add(bean);
			}
			/*返回如果结果集行数大于0*/
			return beanList.size() > 0 ? beanList : null;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
