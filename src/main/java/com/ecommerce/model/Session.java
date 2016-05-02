package com.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

public class Session implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7100094338826251136L;
	
	private User user;
	private String sessionId;
	private Date startDate;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	

}
