package dev.mclean.models;

public class Employee {
	
	int emp_id;
	String fname;
	String lname;
	String job_t;
	String username;
	String password;
	String dept_name;
	int super_id;
	
	public Employee() {
		super();
	}

	public Employee(int emp_id, String fname, String lname, String job_t, String username, String password,
			String dept_name, int super_id) {
		super();
		this.emp_id = emp_id;
		this.fname = fname;
		this.lname = lname;
		this.job_t = job_t;
		this.username = username;
		this.password = password;
		this.dept_name = dept_name;
		this.super_id = super_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getJob_t() {
		return job_t;
	}

	public void setJob_t(String job_t) {
		this.job_t = job_t;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getSuper_id() {
		return super_id;
	}

	public void setSuper_id(int super_id) {
		this.super_id = super_id;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", fname=" + fname + ", lname=" + lname + ", job_t=" + job_t
				+ ", username=" + username + ", password=" + password + ", dept_name=" + dept_name + ", super_id="
				+ super_id + "]";
	}
	
	

}
