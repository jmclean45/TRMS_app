package dev.mclean.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dev.mclean.models.Event;
import dev.mclean.util.JDBCConnection;

public class EventDAOImpl implements EventDAO {
	public static Connection conn = JDBCConnection.getConnection();
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	java.sql.Date sqlDate = new java.sql.Date(0);

	public List<Event> getAllEvents() {
		try {
			List<Event> events = new ArrayList<Event>();
			String sql = "SELECT * FROM EVENT WHERE OPEN=1";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				events.add(new Event(rs.getInt("ev_id"), rs.getInt("ev_cost"), rs.getString("ev_type"),
						rs.getObject("start_date", Date.class), rs.getString("location"),rs.getString("overview"),rs.getInt("open")));
			}
			return events;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Event getEvent(int ev_id) {
	try {
		String sql= "Select * from event INNER JOIN EVENT_FORMAT on EVENT.ev_type=event_format.ev_type WHERE ev_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, ev_id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()) {
			java.sql.Date dbSqlDate = rs.getDate("START_DATE");
			Event ev= new Event();
			ev.setEv_id(rs.getInt("Ev_ID"));
			ev.setEv_cost(rs.getInt("EV_COST"));
			ev.setEv_type(rs.getString("EV_TYPE"));
			ev.setStart_date(dbSqlDate);
			ev.setLocation(rs.getString("LOCATION"));
			return ev;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
	}
	return null;
}
}