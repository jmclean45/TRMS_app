package dev.mclean.controllers;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.mclean.models.Mail;
import dev.mclean.models.Request;
import dev.mclean.service.MailService;
import dev.mclean.service.RequestService;

public class MailController {
	
	public static Gson gson = new Gson();

	public static void sendMail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		
		Mail m = gson.fromJson(request.getReader(), Mail.class);
		System.out.println(m);
		m.setSender(sess.getAttribute("username").toString());
		System.out.println(m);
		MailService.createMail(m);
		response.getWriter().append(gson.toJson(m));
	}
	public static void viewMail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		int emp_id = (Integer.parseInt(sess.getAttribute("emp_id").toString()));
		List<Mail> me = MailService.getAllMail(emp_id);
		if(me.isEmpty()) {
			response.getWriter().append("false");
		}else {
		response.getWriter().append(gson.toJson(me));
		}
	
}
	
}