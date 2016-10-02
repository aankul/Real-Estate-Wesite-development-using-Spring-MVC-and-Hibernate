package com.neu.project.pojo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="message")
public class Message {
	
	
	public Message() {
		
	}
	
	
	@Id
	@GeneratedValue
	@Column(name="messageId")
	private long messageId;

	@Column(name="message")
	private String message;
	
	@Column(name="toUser")	
	private String toUser;

	@Column(name="messageDate")	
	private Date messageDate;

	@ManyToOne
	@JoinColumn(name="personId")
	private User user;
		
	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	
}
