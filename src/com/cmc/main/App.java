package com.cmc.main;

import java.sql.Date;
import org.hibernate.SessionFactory;

import com.cmc.dao.OrderAndOrderDetailDAO;
import com.cmc.dao.OrderDAO;
import com.cmc.dao.OrderDetailDAO;
import com.cmc.pojo.Order;
import com.cmc.pojo.OrderDetail;
import com.cmc.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App {
	private static SessionFactory factory;
	static OrderDAO orderDAO = new OrderDAO();
	static OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
	static OrderAndOrderDetailDAO orderAndOrderDetailDAO = new OrderAndOrderDetailDAO();

	public static void main(String[] args) {
		// get session factory
		factory = HibernateUtil.getSessionFactory();

		Order o1 = new Order();
		o1.setCustomerId("12126");
		o1.setOrderDate(Date.valueOf("2021-12-15"));
		o1.setRequiedDate(Date.valueOf("2021-12-20"));
		o1.setShippedDate(Date.valueOf("2021-12-17"));
		o1.setShipAddress("Cau Giay");

		OrderDetail od1 = new OrderDetail();
		od1.setOrder(o1);
		od1.setProductId("111111");
		od1.setUnitPrice(4000.0);
		od1.setQuantity(2);
		od1.setDiscount(20);
		
		//Phan a
		//orderDAO.createOrder(o1, od1);

		//Phan b
		orderAndOrderDetailDAO.listOrdersOrderDetails();
		
		//Phan c
		orderDetailDAO.reportOfSale();
		
		//Phan d
		orderDetailDAO.findOrderByCustomer("12126");
		
	}
}
