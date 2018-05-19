package team.antelope.fg.dao;

import java.util.List;

import team.antelope.fg.entity.Orders;

/**
 * OrdersDao��orders����ز����ӿ�
 * @author ����
 *
 */
public interface IOrdersDao extends IBaseDao<Orders> {
	int queryTotalRecords();
	List<Orders> queryOrdersByUid(Long uid);
	List<Orders> queryOrdersByIsPay(Long uid);
	List<Orders> queryOrdersByNotPay(Long uid);
}
