package in.ineuron.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.IssueDto;
import in.ineuron.service.IIssueBookService;
import in.ineuron.servicefactory.IssueServiceFactory;

@WebServlet("/IssueBookController/*")
public class IssueBookController extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		IIssueBookService bookservice = IssueServiceFactory.getissuebookservice();
		IssueDto issuedto=null;
		
		if(request.getRequestURI().endsWith("issuebook")) {
			issuedto = new IssueDto();
			Integer bid = Integer.parseInt(request.getParameter("book_id"));
			String bissuedate = request.getParameter("issue_date");
			String bduedate = request.getParameter("return_date");
			Integer sid = Integer.parseInt(request.getParameter("student_id"));
			issuedto.setBookId(bid);
			issuedto.setBookIssueDate(bissuedate);
			issuedto.setBookIssueDueDate(bduedate);
			issuedto.setStudentId(sid);
			String status = bookservice.issuebook(issuedto);
			RequestDispatcher rd = null;
			if(status.equals("success")) {
				request.setAttribute("status", "success");
				rd = request.getRequestDispatcher("../issuebookstatus.jsp");
				rd.forward(request, response);				
			}
			else if(status.equals("failed1")) {
				request.setAttribute("status", "failed1");
				rd = request.getRequestDispatcher("../issuebookstatus.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("status", "failed2");
				rd = request.getRequestDispatcher("../issuebookstatus.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getRequestURI().endsWith("returnbook")) {
			Integer bid = Integer.parseInt(request.getParameter("book_id"));
			issuedto = new IssueDto();
			issuedto = bookservice.returnbook(bid);
			request.setAttribute("issuedto", issuedto);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../returnbookstatus.jsp");
			rd.forward(request, response);
		}
		if(request.getRequestURI().endsWith("checkdue")) {
			Integer sid = Integer.parseInt(request.getParameter("student_Id"));
			String status = bookservice.checkdue(sid);
			request.setAttribute("status", status);
			RequestDispatcher rd = request.getRequestDispatcher("../checkduestatus.jsp");
			rd.forward(request, response);
			
			
		}
		
	}

}
