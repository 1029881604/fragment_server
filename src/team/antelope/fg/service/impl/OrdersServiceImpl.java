package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IOrdersDao;
import team.antelope.fg.dao.impl.OrdersDaoImpl;
import team.antelope.fg.entity.Orders;
import team.antelope.fg.service.IOrdersService;

/**
 * 
 * @author 廖翔
 *
 */
public class OrdersServiceImpl implements IOrdersService {
	
	IOrdersDao iOrdersDao = new OrdersDaoImpl();
	
	@Override
	public Orders addOrder(String uid, String uid_s, String skillid, String title, String content, String img,
			String skilltype, String ispay, String isdelete, String iscomment) {
		// TODO Auto-generated method stub
		
		Orders orders = new Orders();
		orders.setUid(Long.parseLong(uid));
		orders.setUid_s(Long.parseLong(uid_s));
		orders.setSkillid(Long.parseLong(skillid));
		orders.setTitle(title);
		orders.setContent(content);
		orders.setImg(img);
		orders.setSkilltype(skilltype);
		orders.setIspay(Boolean.parseBoolean(ispay));
		orders.setIsdelete(Boolean.parseBoolean(isdelete));
		orders.setIscomment(Boolean.parseBoolean(iscomment));
		iOrdersDao.insert(orders);
		return orders;
	}

	//这个方法暂时不完善，别用
	@Override
	public int deleteOrder(String id) {
		// TODO Auto-generated method stub
		Orders orders = iOrdersDao.queryById(Long.parseLong(id));
		iOrdersDao.delete(orders);
		return 1;
	}

	@Override
	public List<Orders> getAllOrders(long uid) {
		// TODO Auto-generated method stub
		return iOrdersDao.queryOrdersByUid(uid);
	}

	@Override
	public List<Orders> getIsPayOrders(long uid) {
		// TODO Auto-generated method stub
		return iOrdersDao.queryOrdersByIsPay(uid);
	}

	@Override
	public List<Orders> getNotPayOrders(long uid) {
		// TODO Auto-generated method stub
		return iOrdersDao.queryOrdersByNotPay(uid);
	}

}
