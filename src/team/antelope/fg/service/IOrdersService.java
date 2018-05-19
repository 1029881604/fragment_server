package team.antelope.fg.service;

import java.util.List;

import team.antelope.fg.entity.Orders;

/**
 * Orders操作
 * @author 廖翔
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
	int deleteOrder(String id);//这个方法暂时不完善，别用
	List<Orders> getAllOrders(long uid);
	List<Orders> getIsPayOrders(long uid);
	List<Orders> getNotPayOrders(long uid);
}
