package dev.mclean.models;
import java.sql.Date;

public class Request {
	
	int req_id;
	int emp_id;
	int recipient;
	int ev_id;
	Date req_date;
	String fname;
	String lname;
	String req_status;
	String ev_type;
	String ev_desc;
	String emp_just;
	String location;
	String rej_just;
	String emp_grade;
	int hours_missed;
	int reimb_amt;
	int s_a;
	int dh_a;
	int bc_a;
	String grading_format;
	String passing_grade;
	public Request() {
		super();
	}
	public Request(int req_id) {
		super();
		this.req_id = req_id;
	}
	
	
	public Request(int req_id, String emp_grade) {
		super();
		this.req_id = req_id;
		this.emp_grade = emp_grade;
	}
	
	public Request(int req_id, String rej_just, int bc_a) {
		super();
		this.req_id = req_id;
		this.rej_just = rej_just;
		this.bc_a = bc_a;
	}
	public Request(int emp_id, int reimb_amt) {
		super();
		this.emp_id = emp_id;
		this.reimb_amt = reimb_amt;
	}
	public Request(int emp_id, int ev_id, String fname, String lname, String ev_type, String ev_desc, String emp_just,
			String location, int hours_missed) {
		super();
		this.emp_id = emp_id;
		this.ev_id = ev_id;
		this.fname = fname;
		this.lname = lname;
		this.ev_type = ev_type;
		this.ev_desc = ev_desc;
		this.emp_just = emp_just;
		this.location = location;
		this.hours_missed = hours_missed;
	}
	
	
	public Request(int req_id, int emp_id, String fname, String lname, String req_status, String emp_grade,
			int reimb_amt, String grading_format, String passing_grade) {
		super();
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.fname = fname;
		this.lname = lname;
		this.req_status = req_status;
		this.emp_grade = emp_grade;
		this.reimb_amt = reimb_amt;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
	}
	public Request(int req_id, int emp_id, int recipient, int ev_id, Date req_date, String fname, String lname,
			String req_status, String ev_type, String ev_desc, String emp_just, String location, String rej_just,
			String emp_grade, int hours_missed, int reimb_amt, int s_a, int dh_a, int bc_a) {
		super();
		this.req_id = req_id;
		this.emp_id = emp_id;
		this.recipient = recipient;
		this.ev_id = ev_id;
		this.req_date = req_date;
		this.fname = fname;
		this.lname = lname;
		this.req_status = req_status;
		this.ev_type = ev_type;
		this.ev_desc = ev_desc;
		this.emp_just = emp_just;
		this.location = location;
		this.rej_just = rej_just;
		this.emp_grade = emp_grade;
		this.hours_missed = hours_missed;
		this.reimb_amt = reimb_amt;
		this.s_a = s_a;
		this.dh_a = dh_a;
		this.bc_a = bc_a;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getRecipient() {
		return recipient;
	}
	public void setRecipient(int recipient) {
		this.recipient = recipient;
	}
	public int getEv_id() {
		return ev_id;
	}
	public void setEv_id(int ev_id) {
		this.ev_id = ev_id;
	}
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(Date req_date) {
		this.req_date = req_date;
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
	public String getReq_status() {
		return req_status;
	}
	public void setReq_status(String req_status) {
		this.req_status = req_status;
	}
	public String getEv_type() {
		return ev_type;
	}
	public void setEv_type(String ev_type) {
		this.ev_type = ev_type;
	}
	public String getEv_desc() {
		return ev_desc;
	}
	public void setEv_desc(String ev_desc) {
		this.ev_desc = ev_desc;
	}
	public String getEmp_just() {
		return emp_just;
	}
	public void setEmp_just(String emp_just) {
		this.emp_just = emp_just;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRej_just() {
		return rej_just;
	}
	public void setRej_just(String rej_just) {
		this.rej_just = rej_just;
	}
	public String getEmp_grade() {
		return emp_grade;
	}
	public void setEmp_grade(String emp_grade) {
		this.emp_grade = emp_grade;
	}
	public int getHours_missed() {
		return hours_missed;
	}
	public void setHours_missed(int hours_missed) {
		this.hours_missed = hours_missed;
	}
	public int getReimb_amt() {
		return reimb_amt;
	}
	public void setReimb_amt(int reimb_amt) {
		this.reimb_amt = reimb_amt;
	}
	public int getS_a() {
		return s_a;
	}
	public void setS_a(int s_a) {
		this.s_a = s_a;
	}
	public int getDh_a() {
		return dh_a;
	}
	public void setDh_a(int dh_a) {
		this.dh_a = dh_a;
	}
	public int getBc_a() {
		return bc_a;
	}
	public void setBc_a(int bc_a) {
		this.bc_a = bc_a;
		
	}
	public String getGrading_format() {
		return grading_format;
	}
	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}
	public String getPassing_grade() {
		return passing_grade;
	}
	public void setPassing_grade(String passing_grade) {
		this.passing_grade = passing_grade;
	}
	@Override
	public String toString() {
		return "Request [req_id=" + req_id + ", emp_id=" + emp_id + ", recipient=" + recipient + ", ev_id=" + ev_id
				+ ", req_date=" + req_date + ", fname=" + fname + ", lname=" + lname + ", req_status=" + req_status
				+ ", ev_type=" + ev_type + ", ev_desc=" + ev_desc + ", emp_just=" + emp_just + ", location=" + location
				+ ", rej_just=" + rej_just + ", emp_grade=" + emp_grade + ", hours_missed=" + hours_missed
				+ ", reimb_amt=" + reimb_amt + ", s_a=" + s_a + ", dh_a=" + dh_a + ", bc_a=" + bc_a
				+ ", grading_format=" + grading_format + ", passing_grade=" + passing_grade + "]";
	}
	
	
	
	}