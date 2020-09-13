package serviceTests;



import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import dev.mclean.daos.EventDAO;
import dev.mclean.daos.EventDAOImpl;
import dev.mclean.daos.MailDAO;
import dev.mclean.daos.MailDAOImpl;
import dev.mclean.daos.RequestDAO;
import dev.mclean.daos.RequestDAOImpl;
import dev.mclean.models.Employee;
import dev.mclean.models.Event;
import dev.mclean.models.Mail;
import dev.mclean.models.Request;
import dev.mclean.service.EmployeeService;
import dev.mclean.service.EventService;
import dev.mclean.service.MailService;
import dev.mclean.service.RequestService;


public class TRMStest {

	
	@Test
	public void CreateMail() {
		Mail m4 = new Mail("Type","Content","u1",556);
		assertTrue(MailService.createMail(m4));
	}
	
	@Test
	public void getMail() throws ParseException {
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
	//java.sql.Date sqlDate = new java.sql.Date(df.parse("08-13-2020").getTime());
	Mail m5 = new Mail(444, new java.sql.Date(df.parse("04-07-2020").getTime()),"m_type","cont","u2",555);
	Assertions.assertEquals(m5.toString(), MailService.getMail(444).toString());
	}
	@Test
	public void getAllMail() {
		Mail m4 = new Mail("Type","Content","u1",556);
		MailDAO md = new MailDAOImpl();
		Assertions.assertEquals(md.getAllMail(556).toString(), MailService.getAllMail(m4.getM_recipient()).toString());
	}
	@Test
	public void getRequest() {
		Request r4 = RequestService.getRequest(333);
		Assertions.assertEquals(r4.toString(), RequestService.getRequest(r4.getReq_id()).toString());
	}
	@Test
	public void createRequest() {
		Request r4 = RequestService.getRequest(333);
		r4.setReq_id(335);
		assertTrue(RequestService.createRequest(r4));
	}
	
	@Test
	public void getAllRequests() {
		Request r4 = RequestService.getRequest(333);
		RequestDAO md = new RequestDAOImpl();
		Assertions.assertEquals(md.getAllRequests(r4.getRecipient()).toString(), RequestService.getAllRequests(556).toString());
	}
	@Test
	public void updateRequest() {
	Request r4=RequestService.getRequest(333);
	Request r5= new Request(r4.getEmp_id(),r4.getReimb_amt());
	r5.setReimb_amt(555);
	
		assertTrue(RequestService.updateRequest(r5));
	}
	@Test
	public void deleteRequest() {
		Request r4 = RequestService.getRequest(334);
		assertTrue(RequestService.deleteRequest(r4.getReq_id()));
		
	}
	@Test
	public void getAllEvents() {
		EventDAO ed = new EventDAOImpl();
		Assertions.assertEquals(ed.getAllEvents().toString(), EventService.getAllEvents().toString());
	}
	
	@Test
	public void getEmp() {
		Employee e4= EmployeeService.getEmp("u1");
		Assertions.assertEquals(e4.toString(), EmployeeService.getEmp(e4.getUsername()).toString());
	}

	@Test
	public void checkEmp() {
		Employee e4= EmployeeService.getEmp("u1");
		assertTrue(EmployeeService.checkEmp(e4.getUsername(), e4.getPassword()));
	}
	@Test
	public void getEvent() {
		Event e5= EventService.getEvent(222);
		Assertions.assertEquals(e5.toString(),EventService.getEvent(e5.getEv_id()).toString());
	}
	@Test
	public void getEmp2() {
		Employee e5= EmployeeService.getEmpById(555);
		Assertions.assertEquals(e5.toString(),EmployeeService.getEmpById(e5.getEmp_id()).toString());
	}
	@Test
	public void getMyRequests() {
		Employee e4= EmployeeService.getEmp("u1");
		Assertions.assertEquals(RequestService.getMyRequests(e4.getEmp_id()).toString(), RequestService.getMyRequests(555).toString());
				
	}
	@Test
	public void getCalculate() {
		Request r4= RequestService.getRequest(333);
		Event e4=RequestService.getCalculate(r4.getReq_id());
		Assertions.assertEquals(e4.toString(), RequestService.getCalculate(333).toString());
	}
	@Test
	public void getAvailable() {
		RequestDAO rd= new RequestDAOImpl();
		Assertions.assertEquals(rd.getAvailable(555),RequestService.getAvailable(555));
	} 
	@Test
	public void getBen() {
		RequestDAO rd= new RequestDAOImpl();
		Assertions.assertEquals(rd.getBen(556).toString(),RequestService.getBen(556).toString());
	} 
	@Test
	public void modelMail() {
		Mail m4=MailService.getMail(444);
		m4.setM_id(777);
		m4.setType("test");
		m4.setContent("content");
		m4.setSender("u1");
		Mail m5 = new Mail(m4.getM_id(),m4.getM_date(),m4.getType(),m4.getContent(),m4.getSender(),m4.getM_recipient());
		
	}
	@Test
	public void modelEmp() {
		Employee e4=EmployeeService.getEmp("u1");
	
		Employee e5 = new Employee(e4.getEmp_id(),e4.getFname(),e4.getLname(),e4.getJob_t(),e4.getUsername(),e4.getPassword(),e4.getDept_name(),e4.getSuper_id());
		
	}
	

}