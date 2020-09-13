package dev.mclean.models;

import java.sql.Date;

public class Mail {

	int m_id;
	Date m_date;
	String type;
	String content;
	String sender;
	int m_recipient;
	public Mail() {
		super();
	}
	
	public Mail(String type, String content, String sender, int m_recipient) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
		this.m_recipient = m_recipient;
	}

	public Mail(String type, String content, int m_recipient) {
		super();
		this.type = type;
		this.content = content;
		this.m_recipient = m_recipient;
	}

	public Mail(int m_id, Date m_date, String type, String content, String sender, int m_recipient) {
		super();
		this.m_id = m_id;
		this.m_date = m_date;
		this.type = type;
		this.content = content;
		this.sender = sender;
		this.m_recipient = m_recipient;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public int getM_recipient() {
		return m_recipient;
	}
	public void setM_recipient(int m_recipient) {
		this.m_recipient =m_recipient;
	}
	@Override
	public String toString() {
		return "Mail [m_id=" + m_id + ", m_date=" + m_date + ", type=" + type + ", content=" + content + ", sender="
				+ sender + ", m_recipient=" + m_recipient + "]";
	}

	
}
