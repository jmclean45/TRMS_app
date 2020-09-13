package dev.mclean.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.mclean.models.Event;
import dev.mclean.models.Request;
import dev.mclean.util.JDBCConnection;

public class RequestDAOImpl implements RequestDAO {

	public static Connection conn = JDBCConnection.getConnection();

	public Request getRequest(int req_id) {
		try {

			String sql = "SELECT * FROM REQUEST WHERE REQ_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, req_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Request r = new Request();
				r.setReq_id(rs.getInt("REQ_ID"));
				r.setEmp_id(rs.getInt("Emp_ID"));
				r.setRecipient(rs.getInt("RECIPIENT"));
				r.setEv_id(rs.getInt("EV_ID"));
				r.setReq_date(rs.getDate("REQ_date"));
				r.setFname(rs.getString("fname"));
				r.setLname(rs.getString("lname"));
				r.setReq_status(rs.getString("Req_status"));
				r.setEv_type(rs.getString("EV_TYPE"));
				r.setEv_desc(rs.getString("Ev_desc"));
				r.setEmp_just(rs.getString("EMP_JUST"));
				r.setLocation(rs.getString("LOCATION"));
				r.setRej_just(rs.getString("Rej_just"));
				r.setEmp_grade(rs.getString("Emp_GRADE"));
				r.setHours_missed(rs.getInt("Hours_Missed"));
				r.setReimb_amt(rs.getInt("Reimb_amt"));
				r.setS_a(rs.getInt("s_approval"));
				r.setDh_a(rs.getInt("dh_approval"));
				r.setBc_a(rs.getInt("bc_approval"));
					
				return r;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Request> getAllRequests(int recipient) {
		try {
			String sql = "SELECT * FROM REQUEST WHERE RECIPIENT=? ORDER BY REQ_STATUS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, recipient);

			ResultSet rs = ps.executeQuery();

			List<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				requests.add(new Request(rs.getInt("REQ_ID"),
						rs.getInt("Emp_id"),
						rs.getInt("RECIPIENT"),
						rs.getInt("EV_ID"),
						rs.getDate("REQ_date"),
						rs.getString("FNAME"),
						rs.getString("LNAME"),
						rs.getString("Req_status"),
						rs.getString("Ev_type"),
						rs.getString("Ev_desc"),
						rs.getString("EMP_JUST"),
						rs.getString("location"),
						rs.getString("Rej_just"),
						rs.getString("EMP_GRADE"),
						rs.getInt("Hours_Missed"),
						rs.getInt("Reimb_amt"),
						rs.getInt("s_approval"),
						rs.getInt("dh_approval"),
						rs.getInt("bc_approval")));
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	public List<Request> getMyRequests(int emp_id) {
		try {
			String sql = "SELECT * FROM REQUEST WHERE EMP_ID=? ORDER BY REQ_STATUS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, emp_id);

			ResultSet rs = ps.executeQuery();

			List<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				requests.add(new Request(rs.getInt("REQ_ID"),
						rs.getInt("Emp_id"),
						rs.getInt("RECIPIENT"),
						rs.getInt("EV_ID"),
						rs.getDate("REQ_date"),
						rs.getString("FNAME"),
						rs.getString("LNAME"),
						rs.getString("Req_status"),
						rs.getString("Ev_type"),
						rs.getString("Ev_desc"),
						rs.getString("EMP_JUST"),
						rs.getString("location"),
						rs.getString("Rej_just"),
						rs.getString("EMP_GRADE"),
						rs.getInt("Hours_Missed"),
						rs.getInt("Reimb_amt"),
						rs.getInt("s_approval"),
						rs.getInt("dh_approval"),
						rs.getInt("bc_approval")));
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	public boolean createRequest(Request r) {
		try {
			String sql = "CALL CREATE_REQ(?,?,?,?,?,?,?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setInt(1, r.getEmp_id());
			cs.setInt(2, r.getRecipient());
			cs.setString(3, r.getFname());
			cs.setString(4, r.getLname());
			cs.setString(5, r.getEv_type());
			cs.setString(6, r.getEv_desc());
			cs.setString(7, r.getEmp_just());
			cs.setString(8, r.getLocation());
			cs.setInt(9, r.getHours_missed());
			cs.setInt(10, r.getEv_id());

			cs.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateRequest(Request r) {
		try {
			String sql="UPDATE REQUEST SET RECIPIENT =?,REQ_STATUS=?,REJ_JUST=?,EMP_GRADE=?,REIMB_AMT=?,S_APPROVAL=?,DH_APPROVAL=?,BC_APPROVAL=? WHERE REQ_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getRecipient());
			ps.setString(2, r.getReq_status());
			ps.setString(3, r.getRej_just());
			ps.setString(4, r.getEmp_grade());
			ps.setInt(5, r.getReimb_amt());
			ps.setInt(6, r.getS_a());
			ps.setInt(7, r.getDh_a());
			ps.setInt(8, r.getBc_a());
			ps.setInt(9, r.getReq_id());
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();}
		return false;
	}
	
	public boolean deleteRequest(int req_id) {
		try {
			String sql = "DELETE REQUEST WHERE REQ_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, req_id);
	

			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Event getCalculate(int req_id) {
	try {
		String sql= "select * FROM event INNER JOIN EVENT_FORMAT on EVENT.ev_type=event_format.ev_type INNER JOIN REQUEST on request.ev_ID=event.ev_id WHERE req_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, req_id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			Event ev= new Event(rs.getInt("EV_COST"),rs.getInt("COVERAGE"));
	
			return ev;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
	}
	return null;
}
	public List<Request> getBen(int recipient) {
		try {
		String sql = "select * FROM event INNER JOIN EVENT_FORMAT on EVENT.ev_type=event_format.ev_type INNER JOIN REQUEST on request.ev_ID=event.ev_id WHERE recipient=? ORDER BY REQ_STATUS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, recipient);

			ResultSet rs = ps.executeQuery();

			List<Request> requests = new ArrayList<Request>();

			while (rs.next()) {
				requests.add(new Request(rs.getInt("REQ_ID"),
						rs.getInt("EMP_ID"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getString("REQ_Status"),
						rs.getString("emp_grade"),
						rs.getInt("reimb_amt"),
						rs.getString("Grading_Format"),
						rs.getString("Passing_Grade")));
			}
			return requests;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	

	@Override
	public double getAvailable(int emp_id) {
		
		try {
			String sql= "SELECT sum(REIMB_AMT) as Used FROM REQUEST WHERE EMP_ID=? AND req_status <> 'rejected'";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, emp_id);
			
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
			double ab= rs.getDouble("Used");
			return ab;
			}
		
			}catch(SQLException e) {
				e.printStackTrace();
		}
		return 0;
	}

	
	}
