package team.antelope.fg.util.jdbc;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
/*
 * BeanHandler——将结果集一行记录转换成bean对象的处理器
 * 要借助rs.getMetaData()
 * @author 华文财
 * @time:2017年11月12日 下午12:35:49
 * @Description:TODO
 */
public class BeanHandler implements IResultSetHandler {
	
	private Class<?> mClass;
	
	public BeanHandler(Class<?> cla){
		mClass = cla;
	}
	@Override
	public Object handler(ResultSet rs) {
		if(rs == null){
			return null;
		}
		try {
			if(!rs.next()){
				return null;
			}
			Object bean = mClass.newInstance();
			ResultSetMetaData metaData = rs.getMetaData();
			int colNum = metaData.getColumnCount();
			for(int i=1; i<= colNum; i++){
				String colName = metaData.getColumnName(i);//获取表列名
				Object colData = rs.getObject(i);	//获取结果集中的数据
				Field f = mClass.getDeclaredField(colName);//获取并设置bean的字段f，要求和数据库表列名一致
				f.setAccessible(true);
				if(f.getType().getSimpleName().equals(Long.class.getSimpleName())){
//					f.setLong(bean, new Long(String.valueOf(object))); 怎么写都是错误的，因为f.setLong是给long类型的赋值而不是Long
					if(colData == null){
						colData = 0L;
					}
					f.set(bean, new Long(String.valueOf(colData)));	//这时候应该用f.set
				} else if (f.getType().getSimpleName().equals(long.class.getSimpleName())){
					if(colData == null){
						colData = 0l;
					}
					f.setLong(bean, Long.parseLong(String.valueOf(colData)));
				} else if (f.getType().getSimpleName().equals(float.class.getSimpleName())){
					if(colData == null){
						colData = 0f;
					}
					f.setFloat(bean, Float.parseFloat(String.valueOf(colData)));
				} else if (f.getType().getSimpleName().equals(Float.class.getSimpleName())){
					if(colData == null){
						colData = 0F;
					}
//					f.setFloat(bean, Float.parseFloat(String.valueOf(object)));  setFloat只给float类型字段而不是Float类型
					f.set(bean, Float.parseFloat(String.valueOf(colData)));
				}  else {
					f.set(bean, colData);
				}
			}
			
			return bean;
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
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
