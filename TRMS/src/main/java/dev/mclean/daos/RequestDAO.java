package dev.mclean.daos;

import java.util.List;

import dev.mclean.models.Event;
import dev.mclean.models.Request;


public interface RequestDAO {

	public Request getRequest(int req_id);
	public List<Request> getAllRequests(int recipient);
	public List<Request> getMyRequests(int emp_id);
	public boolean createRequest (Request r);
	public boolean updateRequest(Request r);
	public boolean deleteRequest(int req_id);
	public Event getCalculate(int req_id);
	public double getAvailable(int emp_id);
	public List<Request> getBen(int recipient);
	
}
