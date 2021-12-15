package com.cmc.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cmc.pojo.Order;
import com.cmc.pojo.OrderDetail;
import com.cmc.util.HibernateUtil;

public class OrderDetailDAO {
	private static SessionFactory factory;

	public void createOrderDetail(OrderDetail orderDetail) {
		// get session factory
		factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(orderDetail);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Map<String, Double> reportOfSale() {
		Map<String, Double> kq = new HashMap<String, Double>();
		// get session factory
		factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			java.util.List orderDetails = session.createQuery("FROM OrderDetail").list();
			for (Iterator iterator = ((Iterable) orderDetails).iterator(); iterator.hasNext();) {
				OrderDetail orderDetail = (OrderDetail) iterator.next();
				if (orderDetail.getOrder().getOrderDate().compareTo(Date.valueOf(LocalDate.now())) == 0) {
					System.out.print("\nOrder Detail ID: " + orderDetail.getOrderDetailId());
					System.out.print("\tOrder : " + orderDetail.getOrder().getOrderId());
					System.out.print("\tProduct ID: " + orderDetail.getProductId());
					System.out.print("\tUnit Price: " + orderDetail.getUnitPrice());
					System.out.print("\tQuantity: " + orderDetail.getQuantity());
					System.out.print("\tDiscount: " + orderDetail.getDiscount());
					System.out.print("\tTotal: " + ((orderDetail.getUnitPrice() * orderDetail.getQuantity())
							- ((orderDetail.getDiscount() / 100))
									* (orderDetail.getUnitPrice() * orderDetail.getQuantity())));
				}
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return kq;
	}

	public List<OrderDetail> findOrderByCustomer(String customerId) {
		List<OrderDetail> lod = new ArrayList<OrderDetail>();
		// get session factory
		factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			java.util.List orderDetails = session.createQuery("FROM OrderDetail").list();
			for (Iterator iterator = ((Iterable) orderDetails).iterator(); iterator.hasNext();) {
				OrderDetail orderDetail = (OrderDetail) iterator.next();
				if (orderDetail.getOrder().getCustomerId().equals("12126")) {
					System.out.print("\nOrder Detail ID: " + orderDetail.getOrderDetailId());
					System.out.print("\tOrder : " + orderDetail.getOrder().getOrderId());
					System.out.print("\tProduct ID: " + orderDetail.getProductId());
					System.out.print("\tUnit Price: " + orderDetail.getUnitPrice());
					System.out.print("\tQuantity: " + orderDetail.getQuantity());
					System.out.print("\tDiscount: " + orderDetail.getDiscount());
				}
			}
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lod;

	}

}