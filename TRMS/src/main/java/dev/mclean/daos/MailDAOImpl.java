package dev.mclean.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.mclean.models.Mail;
import dev.mclean.util.JDBCConnection;

public class MailDAOImpl implements MailDAO  {

	public static Connection conn= JDBCConnection.getConnection();

	public Mail getMail(int m_id) {
		try {
			String sql = "SELECT * FROM MAIL WHERE m_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, m_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Mail(rs.getInt("m_id"),rs.getDate("m_date"),rs.getString("m_type"),rs.getString("m_content"),rs.getString("m_sender"),rs.getInt("m_recipient"));
			}
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
	
	public List<Mail> getAllMail(int m_recipient) {
		try {
			String sql="SELECT * FROM MAIL WHERE M_RECIPIENT=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, m_recipient);
			
			ResultSet rs=ps.executeQuery();
			List<Mail> mymail = new ArrayList<Mail>();
			
			while(rs.next()) {
				mymail.add(new Mail(rs.getInt("m_id"),rs.getDate("m_date"),rs.getString("m_type"),rs.getString("m_content"),rs.getString("m_sender"),rs.getInt("m_recipient")));
			}
			return mymail;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		}

	public boolean createMail(Mail m) {
		try {
			String sql = "CALL CREATE_MAIL (?,?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);

			cs.setString(1, m.getType());
			cs.setString(2, m.getContent());
			cs.setString(3, m.getSender());
			cs.setInt(4, m.getM_recipient());

			cs.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;


}
	}

