package dev.mclean.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.mclean.models.Employee;
import dev.mclean.models.Event;
import dev.mclean.models.Request;
import dev.mclean.service.EmployeeService;
import dev.mclean.service.EventService;
import dev.mclean.service.RequestService;
import dev.mclean.util.JDBCConnection;

public class EmployeeController {

	public static Gson gson = new Gson();
	public static Connection conn = JDBCConnection.getConnection();

	public static void signIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		System.out.println(sess.getId());
		String username = (sess.getAttribute("username").toString());
		String password = (sess.getAttribute("password").toString());
		
		//System.out.println(e);
		if(EmployeeService.checkEmp(username, password)==false){
			response.getWriter().append("Failure");
			}else {
		 
		Employee e = EmployeeService.getEmp(username);
		sess.setAttribute("emp_id",e.getEmp_id());
		response.getWriter().append("Success");
		}
	}
		
	public static void getEmpInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		String username = (sess.getAttribute("username").toString());
		Employee e = EmployeeService.getEmp(username);
		response.getWriter().append(gson.toJson(e));
	}
	public static void viewEv(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		System.out.println(sess.getId());
		System.out.println(sess.getAttribute("username"));
		String username = (sess.getAttribute("username").toString());
		System.out.println(username);
		Employee e = EmployeeService.getEmp(username);
		System.out.println(e);
		List<Event> events= EventService.getAllEvents();
		response.getWriter().append(gson.toJson(events));
	}
	public static void reset(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
				String sql="UPDATE REQUEST SET Reimb_amt =0";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.executeQuery();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void urgent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String sql= "MERGE into Request USING event ON (request.ev_id = event.ev_id) WHEN MATCHED THEN UPDATE SET request.s_approval = 5 WHERE (event.start_date-request.req_date)<14";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			
			ResultSet rs=ps.executeQuery();
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
}
	

