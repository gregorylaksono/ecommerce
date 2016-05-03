package com.ecommerce.service;

import java.util.Date;
import java.util.List;

import com.ecommerce.hibernate.ITransactionDao;
import com.ecommerce.model.Transaction;

public class TransactionServiceImpl implements ITransactionService {
	protected ITransactionDao transactionDao;
	
	@Override
	public List<Transaction> getTransactionByDate(Date date) {
		
		return transactionDao.getTransactionByStartDate(date);
	}

	@Override
	public void insertTransaction(Transaction trx) {
		transactionDao.saveTransaction(trx);
	}

	@Override
	public void updateTransaction(Transaction trx) {
		transactionDao.updateTransaction(trx);
	}

}
