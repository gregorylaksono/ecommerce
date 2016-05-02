package com.ecommerce.service;

import java.util.Date;

import com.ecommerce.model.Transaction;

public interface ITransactionService {

	public Transaction getTransactionByDate(Date date);
	public void insertTransaction(Transaction trx);
	public void updateTransaction(Transaction trx);
}
