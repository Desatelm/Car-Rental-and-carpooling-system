package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Message_box")
public class MessageBox {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	int messageId;

	@Column(name = "SenderEmail")
	String senderEmail;

	@Transient
	int receiverId;

	@Column
	String message;

	@Column(name = "departure_date")
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

	public MessageBox(String senderEmail, int receiverId, String message) {
		super();
		this.senderEmail = senderEmail;
		this.receiverId = receiverId;
		this.message = message;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
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

	@Override
	public String toString() {
		return "MessageBox [senderEmail=" + senderEmail + ", message=" + message + "]";
	}

}
