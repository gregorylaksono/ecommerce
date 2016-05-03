package com.ecommerce.hibernate;

import java.util.Date;
import java.util.List;

import com.ecommerce.model.Transaction;

public interface ITransactionDao {
	public List<Transaction> getTransactionByStartDate(Date date);
	public void saveTransaction(Transaction trx);
	public void updateTransaction(Transaction trx);
}
