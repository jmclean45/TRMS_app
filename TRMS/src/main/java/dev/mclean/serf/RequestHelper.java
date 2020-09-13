package dev.mclean.serf;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.mclean.controllers.CalculateController;
import dev.mclean.controllers.EmployeeController;
import dev.mclean.controllers.MailController;
import dev.mclean.controllers.RequestController;

public class RequestHelper {
	
	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/TRMS-App/signIn.do": {
			HttpSession sess= request.getSession();
			System.out.println(sess.getId());
			sess.setAttribute("username",request.getParameter("username"));
			sess.setAttribute("password",request.getParameter("password"));
			EmployeeController.signIn(request, response);
			break;
		}
		case "/TRMS-App/getEmpInfo.do": {
			EmployeeController.getEmpInfo(request, response);
			break;
		}
		case "/TRMS-App/reset.do": {
			EmployeeController.reset(request, response);
			break;
		}
		case "/TRMS-App/viewE.do": {
			EmployeeController.viewEv(request, response);
			break;
		}
		case "/TRMS-App/makeReq.do": {
			//maybe set it up so that recipient is pre-filled in
			RequestController.makeReq(request, response);
			
			break;
		}
		case "/TRMS-App/viewReq.do": {
			RequestController.viewReq(request, response);
			
			break;
		}
		case "/TRMS-App/reject.do": {
			RequestController.reject(request, response);
			
			break;
		}
		case "/TRMS-App/cancel.do": {
			RequestController.cancel(request, response);
			break;
		}
		
		case "/TRMS-App/myReq.do": {
			RequestController.myReq(request, response);
			
			break;
		}
		case "/TRMS-App/urgent.do": {
			EmployeeController.urgent(request, response);
			
			break;
		}
		case "/TRMS-App/approve.do": {
			HttpSession sess= request.getSession();
			int emp_id = (Integer.parseInt(sess.getAttribute("emp_id").toString()));
			if(emp_id>15) {
			RequestController.superA(request, response);
			}else if(emp_id<14) {
			RequestController.dhA(request,response);
			}else {
			RequestController.bcA(request, response);
			}
			break;
		}
		case "/TRMS-App/grade.do": {
			RequestController.grade(request,response);
			break;
		}
		case "/TRMS-App/finalApprove.do": {
			RequestController.finalApprove(request,response);
			break;
		}
		case "/TRMS-App/award.do": {
			RequestController.award(request,response);
			break;
		}
		case "/TRMS-App/calculate.do": {
			CalculateController.calculate(request, response);
			
			break;
		}
		case "/TRMS-App/getBen.do": {
			CalculateController.getBen(request, response);
			
			break;
		}
		case "/TRMS-App/available.do": {
			CalculateController.available(request, response);
			
			break;
		}
		case "/TRMS-App/sendMail.do": {
			System.out.println("here");
			MailController.sendMail(request, response);
			
			break;
		}
		case "/TRMS-App/viewMail.do": {
			System.out.println("here");
			MailController.viewMail(request, response);
			
			break;
		}
		default: {
			
			response.sendError(418, "I am a teapot!");
			break;
		}
		}
		
	}

}
