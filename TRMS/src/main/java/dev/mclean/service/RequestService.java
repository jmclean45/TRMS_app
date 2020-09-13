package dev.mclean.service;

import java.util.List;

import dev.mclean.daos.RequestDAO;
import dev.mclean.daos.RequestDAOImpl;
import dev.mclean.models.Event;
import dev.mclean.models.Request;

public class RequestService {
	
	public static RequestDAO rd = new RequestDAOImpl();
	
	public static Request getRequest(int req_id) {
		return rd.getRequest(req_id);
	}
	public static List<Request> getAllRequests(int recipient){
		return rd.getAllRequests(recipient);
	}
	public static List<Request> getMyRequests(int emp_id){
		return rd.getMyRequests(emp_id);
	}
	public static boolean createRequest (Request r) {
		return rd.createRequest(r);
	}
	public static boolean updateRequest(Request r) {
		return rd.updateRequest(r);
	}
	public static boolean deleteRequest(int req_id) {
		return rd.deleteRequest(req_id);
	}
	public static Event getCalculate(int req_id) {
		return rd.getCalculate(req_id);
	}
	public static double getAvailable(int emp_id) {
		return rd.getAvailable(emp_id);
	}
	public static List<Request> getBen(int recipient) {
		return rd.getBen(recipient);
	}

}
