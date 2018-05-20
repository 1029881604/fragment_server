package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.Orders;

/**
 * Orders����
 * @author ����
 *
 */
public interface IOrdersService {
	Orders addOrder(
			String uid,
			String uid_s,
			String skillid,
			String title,
			String content,
			String img,
			String skilltype,
			String ispay,
			String isdelete,
			String iscomment);
	int deleteOrder(String id);//���������ʱ�����ƣ�����
	List<Orders> getAllOrders(long uid);
	List<Orders> getIsPayOrders(long uid);
	List<Orders> getNotPayOrders(long uid);
	
	int addOrderDetails(
			String uid,
			String uid_s,
			String skillid,
			String title,
			String content,
			String img,
			String skilltype,
			String ispay,
			String isdelete,
			String iscomment);
}
