package dev.mclean.daos;

import java.util.List;

import dev.mclean.models.Mail;

public interface MailDAO {
	
	public Mail getMail(int m_id);
	public List<Mail> getAllMail(int m_recipient);
	public boolean createMail(Mail m);

}
