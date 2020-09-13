package dev.mclean.service;

import dev.mclean.daos.EmployeeDAO;
import dev.mclean.daos.EmployeeDAOImpl;
import dev.mclean.models.Employee;

public class EmployeeService {
	
	public static EmployeeDAO ed = new EmployeeDAOImpl();
	
	public static Employee getEmp(String username) {
		return ed.getEmp(username);
	}
	public static Employee getEmpById(int emp_id) {
		return ed.getEmpById(emp_id);
	}
	public static boolean checkEmp(String username,String password) {
		return ed.checkEmp(username, password);
		}

}
