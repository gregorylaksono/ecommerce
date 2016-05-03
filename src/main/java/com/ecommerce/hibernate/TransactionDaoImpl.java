package com.ecommerce.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ecommerce.model.Category;
import com.ecommerce.model.Transaction;

public class TransactionDaoImpl extends HibernateDaoSupport implements ITransactionDao {

	@Override
	public void saveTransaction(Transaction trx) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try{
			getHibernateTemplate().saveOrUpdate(trx);
			t.commit();			
		}catch(Exception e){
			t.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void updateTransaction(Transaction trx) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		org.hibernate.Transaction t = session.beginTransaction();
		try{
			getHibernateTemplate().saveOrUpdate(trx);
			t.commit();			
		}catch(Exception e){
			t.rollback();
			e.printStackTrace();
		}

	}

	@Override
	public List<Transaction> getTransactionByStartDate(Date date) {
		try{
			String hql = "SELECT t FROM Transaction t WHERE t.trxDate > ? AND t.trxDate < ?";
			Object []args = new Object[] {date, new Date()};
			List result = getHibernateTemplate().find(hql, args);
			if(result != null && result.size() > 0){
				return result;
			}
			else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
