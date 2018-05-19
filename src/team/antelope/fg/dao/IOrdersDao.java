package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.Orders;

/**
 * OrdersDao：orders表相关操作接口
 * @author 廖翔
 *
 */
public interface IOrdersDao extends IBaseDao<Orders> {
	int queryTotalRecords();
	List<Orders> queryOrdersByUid(Long uid);
	List<Orders> queryOrdersByIsPay(Long uid);
	List<Orders> queryOrdersByNotPay(Long uid);
}
