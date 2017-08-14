package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Message_box")
public class MessageBox {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	int messageId;
	
	@Column(name  = "SenderEmail")
	String senderEmail;
	
	@Column
	String message;
	
	

	@Column(name="departure_date")
	@Temporal(TemporalType.DATE)
	Date receiveDate;
 
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Date getReceiveDate() {
		return receiveDate;
	}


	public void setReceiveDate(Date receiveDate) {
		this.receiveDate = receiveDate;
	}
	
	public MessageBox() {
		super();		
	}

	

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	

	
    
}
