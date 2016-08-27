package com.ecommerce.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Category;
import com.ecommerce.model.Transaction;

public class TransactionDaoImpl  implements ITransactionDao {
	private SessionFactory sessionFactory;
	
	@Override
	public void saveTransaction(Transaction trx) {
		Session session = sessionFactory.getCurrentSession();
		session.save(trx);
	}

	@Override
	public void updateTransaction(Transaction trx) {


	}

	@Override
	public List<Transaction> getTransactionByStartDate(Date date) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Query q = session.createQuery("SELECT t FROM Transaction t");
//		List list = q.getResultList();
//		session.getTransaction().commit();
//		session.close();
//		return list;
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("SELECT t FROM Transaction t");
		return q.getResultList();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
