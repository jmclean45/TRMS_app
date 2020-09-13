package dev.mclean.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.mclean.models.Employee;
import dev.mclean.models.Event;
import dev.mclean.models.Request;
import dev.mclean.service.EmployeeService;
import dev.mclean.service.RequestService;

public class CalculateController {
	public static Gson gson = new Gson();
	
	public static void calculate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid=Integer.parseInt(request.getParameter("req_id"));
		Event ev = RequestService.getCalculate(rid);
		response.getWriter().append(gson.toJson(ev));

}
	public static void available(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int eid=Integer.parseInt(request.getParameter("emp_id"));
		double av = RequestService.getAvailable(eid);
		String b = Double.toString(av);
		response.getWriter().append(b);

}
	public static void getBen(HttpServletRequest request, HttpServletResponse response) throws IOException {
	HttpSession sess = request.getSession();
	int rec = (Integer.parseInt(sess.getAttribute("emp_id").toString()));
	List<Request> reqs = RequestService.getBen(rec);
	response.getWriter().append(gson.toJson(reqs));
	
	
}
	
}