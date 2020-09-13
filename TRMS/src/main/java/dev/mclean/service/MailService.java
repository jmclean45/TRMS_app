package dev.mclean.service;

import java.util.List;

import dev.mclean.daos.MailDAO;
import dev.mclean.daos.MailDAOImpl;
import dev.mclean.models.Mail;

public class MailService {
	
	public static MailDAO md = new MailDAOImpl();
	
	public static Mail getMail(int m_id) {
		return md.getMail(m_id);
	}
	public static List<Mail> getAllMail(int m_recipient){
		return md.getAllMail(m_recipient);
	}
	public static boolean createMail(Mail m) {
		return md.createMail(m);
	}

}
