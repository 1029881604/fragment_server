package team.antelope.fg.mapper.custom;

import team.antelope.fg.pojo.Person;

/**
 * �û����ݷ���
 * @author ���Ĳ�
 * @time:2018��5��17�� ����11:04:35
 * @Description:TODO
 */
public interface CustomPersonMapper {
	/**
	 * ͨ���û����������ѯ
	 * @param p
	 * @return 
	 * Person
	 */
	Person selectByNameAndPassword(Person person);
}
