package team.antelope.fg.service.impl;

import java.util.List;

import team.antelope.fg.dao.IOrdersDao;
import team.antelope.fg.dao.impl.OrdersDaoImpl;
import team.antelope.fg.entity.Orders;
import team.antelope.fg.service.IOrdersService;

/**
 * 
 * @author ����
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

	//���������ʱ�����ƣ�����
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

	@Override
	public int addOrderDetails(String uid, String uid_s, String skillid, String title, String content, String img,
			String skilltype, String ispay, String isdelete, String iscomment) {
		// TODO Auto-generated method stub
		try {
			System.out.println("��ִ����Ӷ���");
			return iOrdersDao.addOrder(Long.parseLong(uid), Long.parseLong(uid_s), Long.parseLong(skillid), title, content, img, skilltype, Integer.parseInt(ispay), Integer.parseInt(isdelete), Integer.parseInt(iscomment));
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public Orders getOrderDetails(long id) {
		// TODO Auto-generated method stub
		return iOrdersDao.queryById(id);
	}

}
