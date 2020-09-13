package dev.mclean.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.mclean.models.Employee;
import dev.mclean.util.JDBCConnection;
	
public class EmployeeDAOImpl implements EmployeeDAO {

	public static Connection conn = JDBCConnection.getConnection();
	
	public Employee getEmp(String username) {
		try {
			String sql= "SELECT * FROM EMPLOYEE WHERE USERNAME = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setEmp_id(rs.getInt("emp_id"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setJob_t(rs.getString("job_t"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setDept_name(rs.getString("dept_name"));
				e.setSuper_id(rs.getInt("super_id"));
				
				return e;
			}
		} catch (SQLException k) {
			k.printStackTrace();
		}
		return null;
	}
	
	public Employee getEmpById(int emp_id) {
		try {
			String sql= "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, emp_id);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee e = new Employee();
				e.setEmp_id(rs.getInt("emp_id"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setJob_t(rs.getString("job_t"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setDept_name(rs.getString("dept_name"));
				e.setSuper_id(rs.getInt("super_id"));
				
				return e;
			}
		} catch (SQLException k) {
			k.printStackTrace();
		}
		return null;
	}
	public boolean checkEmp(String username,String password) {
		try {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Employee u = new Employee();
				u.setUsername(rs.getString("USERNAME"));
				u.setPassword(rs.getString("Password"));

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
