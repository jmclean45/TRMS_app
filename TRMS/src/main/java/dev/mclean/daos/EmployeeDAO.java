package dev.mclean.daos;

import dev.mclean.models.Employee;

public interface EmployeeDAO {
	
	public Employee getEmp(String username);
	public Employee getEmpById(int emp_id);
	public boolean checkEmp(String username, String password);

}
