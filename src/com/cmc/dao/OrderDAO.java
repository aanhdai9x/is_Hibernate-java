package com.cmc.dao;

import java.util.Iterator;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.cmc.pojo.Order;
import com.cmc.pojo.OrderDetail;
import com.cmc.util.HibernateUtil;

import antlr.collections.List;

public class OrderDAO {
	private static SessionFactory factory;

	public void createOrder(Order order, OrderDetail orderDetail) {
		// get session factory
		factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(order);
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

}
