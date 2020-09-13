package dev.mclean.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.mclean.models.Employee;
import dev.mclean.models.Request;
import dev.mclean.service.EmployeeService;
import dev.mclean.service.RequestService;

public class RequestController {
	public static Gson gson = new Gson();

	public static void makeReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
				System.out.println("catch");
		Request q = gson.fromJson(request.getReader(), Request.class);
		System.out.println(q);
		Employee m = EmployeeService.getEmpById(q.getEmp_id());
		q.setRecipient(m.getSuper_id());
		RequestService.createRequest(q);
		response.getWriter().append(gson.toJson(q));
	}

	public static void viewReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		int emp_id = (Integer.parseInt(sess.getAttribute("emp_id").toString()));
		System.out.println(emp_id);
		List<Request> reqs = RequestService.getAllRequests(emp_id);
		response.getWriter().append(gson.toJson(reqs));
	}
	public static void myReq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sess = request.getSession();
		int emp_id = (Integer.parseInt(sess.getAttribute("emp_id").toString()));
		System.out.println(emp_id);
		List<Request> reqs = RequestService.getMyRequests(emp_id);
		response.getWriter().append(gson.toJson(reqs));
		System.out.println(reqs);
	}

	public static void superA(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		Employee e = EmployeeService.getEmpById(r.getRecipient());
		r.setS_a(1);
		r.setRecipient(e.getSuper_id());

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}

	public static void dhA(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		r.setS_a(1);
		r.setDh_a(1);
		if (r.getEmp_id()>14) {
		}else {
		r.setRecipient(15);
		}

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}

	public static void bcA(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		r.setS_a(1);
		r.setDh_a(1);
		r.setBc_a(1);
		r.setReq_status("Approved");

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}
	public static void finalApprove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		r.setS_a(1);
		r.setDh_a(1);
		r.setBc_a(1);
		r.setReq_status("Approved");
		r.setReimb_amt(q.getReimb_amt());

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}
	public static void award(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		r.setReq_status("Awarded");

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}
	public static void grade(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		
		r.setEmp_grade(q.getEmp_grade());

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}
	public static void reject(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Request q = gson.fromJson(request.getReader(), Request.class);
		Request r = RequestService.getRequest(q.getReq_id());
		
		r.setRej_just(q.getRej_just());
		r.setReq_status("Rejected");
		r.setReimb_amt(0);
		r.setRecipient(200);

		RequestService.updateRequest(r);
		response.getWriter().append(gson.toJson(q));
	}
	public static void cancel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int rid=Integer.parseInt(request.getParameter("req_id"));
		RequestService.deleteRequest(rid);
		response.getWriter().append("success delete");
	}
	

}