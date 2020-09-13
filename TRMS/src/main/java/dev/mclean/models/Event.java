package dev.mclean.models;

import java.sql.Date;

public class Event {
	
	int ev_id;
	int ev_cost;
	String ev_type;
	Date start_date;
	String location;
	int coverage;
	int open;
	String overview;
	String grading_format;
	String passing_grade;

	
	
	public Event() {
		super();
	}



	public Event(int ev_cost, int coverage) {
		super();
		this.ev_cost = ev_cost;
		this.coverage = coverage;
	}



	public Event(int ev_id, int ev_cost, String ev_type, Date start_date, String location, String overview, int open) {
		super();
		this.ev_id = ev_id;
		this.ev_cost = ev_cost;
		this.ev_type = ev_type;
		this.start_date = start_date;
		this.location = location;
		this.overview = overview;
		this.open=open;
	}



	public Event(int ev_id, int ev_cost, String ev_type, Date start_date, String location, int coverage,
			String grading_format, String passing_grade) {
		super();
		this.ev_id = ev_id;
		this.ev_cost = ev_cost;
		this.ev_type = ev_type;
		this.start_date = start_date;
		this.location = location;
		this.coverage = coverage;
		this.grading_format = grading_format;
		this.passing_grade = passing_grade;
	}



	public int getEv_id() {
		return ev_id;
	}



	public void setEv_id(int ev_id) {
		this.ev_id = ev_id;
	}



	public int getOpen() {
		return open;
	}



	public void setOpen(int open) {
		this.open = open;
	}



	public int getEv_cost() {
		return ev_cost;
	}



	public String getOverview() {
		return overview;
	}



	public void setOverview(String overview) {
		this.overview = overview;
	}



	public void setEv_cost(int ev_cost) {
		this.ev_cost = ev_cost;
	}




	public String getEv_type() {
		return ev_type;
	}



	public void setEv_type(String ev_type) {
		this.ev_type = ev_type;
	}



	public Date getStart_date() {
		return start_date;
	}



	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}


/*
	public int getCoverage() {
		return coverage;
	}



	public void setCoverage(int coverage) {
		this.coverage = coverage;
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
*/


	@Override
	public String toString() {
		return "Event [ev_id=" + ev_id + ", ev_cost=" + ev_cost + ", ev_type=" + ev_type + ", start_date=" + start_date
				+ ", location=" + location + ", coverage=" + coverage + ", open=" + open + ", overview=" + overview
				+ ", grading_format=" + grading_format + ", passing_grade=" + passing_grade + "]";
	}



	




	
	
	
	
}