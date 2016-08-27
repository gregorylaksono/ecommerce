package com.ecommerce.service;

import java.util.Date;
import java.util.List;

import com.ecommerce.model.Transaction;

public interface ITransactionService {

	public List<Transaction> getTransactionByDate(Date date);
	public void insertTransaction(Transaction trx);
	public void updateTransaction(Transaction trx);
	public void editTransaction();
}
