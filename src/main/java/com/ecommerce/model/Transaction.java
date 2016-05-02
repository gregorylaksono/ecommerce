package com.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3330684324129486371L;
	
	private Item item;
	private Date trxDate;
	private int quantity;
	private int status;
	public static int STATUS_SUCCESS = 1;
	public static int STATUS_CANCEL = 2;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Date getTrxDate() {
		return trxDate;
	}
	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
