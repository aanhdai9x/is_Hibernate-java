package com.cmc.dao;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cmc.pojo.Order;
import com.cmc.pojo.OrderDetail;
import com.cmc.util.HibernateUtil;

public class OrderAndOrderDetailDAO {

	private static SessionFactory factory;
	
	// Method to READ all the Order and OrderDetail
		public void listOrdersOrderDetails() {
			// get session factory
			factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			org.hibernate.Transaction tx = null;
			try {
				tx = session.beginTransaction();
				java.util.List orders = session.createQuery("FROM Order").list();
				java.util.List orderDetails = session.createQuery("FROM OrderDetail").list();
				for (Iterator iterator = ((Iterable) orders).iterator(); iterator.hasNext();) {
					Order order = (Order) iterator.next();
					System.out.print("\nOrder ID: " + order.getOrderId());
					System.out.print("\tCustomer ID: " + order.getCustomerId());
					System.out.print("\tOrder Date: " + order.getOrderDate());
					System.out.print("\tRequired Date: " + order.getRequiedDate());
					System.out.print("\tShipped Date: " + order.getShipAddress());
					System.out.print("\tShip Address: " + order.getShipAddress());
				}
				for (Iterator iterator = ((Iterable) orderDetails).iterator(); iterator.hasNext();) {
					OrderDetail order = (OrderDetail) iterator.next();
					System.out.print("\nOrder Detail ID: " + order.getOrderDetailId());
					System.out.print("\tOrder : " + order.getOrder().getOrderId());
					System.out.print("\tProduct ID: " + order.getProductId());
					System.out.print("\tUnit Price: " + order.getUnitPrice());
					System.out.print("\tQuantity: " + order.getQuantity());
					System.out.print("\tDiscount: " + order.getDiscount());
				}
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
}
