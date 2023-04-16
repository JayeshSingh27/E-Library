package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.StudentDto;
import in.ineuron.service.IStudentService;
import in.ineuron.servicefactory.StudentServiceFactory;
import in.ineuron.util.JdbcUtil;


@WebServlet("/StudentController/*")
public class StudentController extends HttpServlet 
{
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		StudentDto student=null;
		IStudentService studentservice = StudentServiceFactory.getstudentservice();
		if(request.getRequestURI().endsWith("studentlogin")) 
		{
			try {
				connection = JdbcUtil.getJdbcConnection();
				String sqlSelectQuery = "select studentId,studentEmailId,studentPassword from studentdb where studentId=?";
				if(connection != null) {
					pstmt = connection.prepareStatement(sqlSelectQuery);
					pstmt.setInt(1, Integer.parseInt(request.getParameter("student_Id")));
					if(pstmt != null) {
						rs = pstmt.executeQuery();
						RequestDispatcher rd = null;
						if(rs!=null){
							
							if(rs.next()){
								
								String semail = rs.getString(2);
								String spassword = rs.getString(3);								
								if(semail.equals(request.getParameter("student_Email"))
										&& spassword.equals(request.getParameter("student_Password")))
								{
										rd = request.getRequestDispatcher("../student_operations.html");
										rd.forward(request, response);
										System.out.println("Valid Credentials");										
								}
								else {									
									System.out.println("Invalid EmailId & Password...Please Try Again or Contact Admin");
									rd = request.getRequestDispatcher("../studentVerificationFail.jsp");
									rd.forward(request, response);
								}
							}
							else{
								System.out.println("Invalid Student ID...Please Try Again or Contact Admin");
								rd = request.getRequestDispatcher("../studentVerificationFail.jsp");
								rd.forward(request, response);
							}
						}
			
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getRequestURI().endsWith("addstudent")) {
			student = new StudentDto();
			student.setStudentId(Integer.parseInt(request.getParameter("student_id")));
			student.setStudentName(request.getParameter("student_name"));
			student.setStudentDepartment(request.getParameter("student_department"));
			student.setStudentYear(Integer.parseInt(request.getParameter("student_year")));
			student.setStudentCourse(request.getParameter("student_course"));
			student.setStudentPhoneno(request.getParameter("student_phone"));
			student.setStudentEmail(request.getParameter("student_email"));
			student.setStudentPassword(request.getParameter("student_password"));
			String status = studentservice.addstudent(student);
			RequestDispatcher rd = null;
			request.setAttribute("status", "failed");
			rd = request.getRequestDispatcher("../addstudentstatus.jsp");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
			}
			rd.forward(request, response);			
		}
		if(request.getRequestURI().endsWith("deletestudent")) {
			Integer sid = Integer.parseInt(request.getParameter("student_id"));
			String status = studentservice.deletestudent(sid);
			RequestDispatcher rd = null;
			request.setAttribute("status", "failed");
			rd = request.getRequestDispatcher("../deletestudentstatus.jsp");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
			}
			rd.forward(request, response);				
		}
		if(request.getRequestURI().endsWith("updatestudent")) {
			student = new StudentDto();
			student.setStudentId(Integer.parseInt(request.getParameter("student_id")));
			student.setStudentName(request.getParameter("student_name"));
			student.setStudentDepartment(request.getParameter("student_department"));
			student.setStudentYear(Integer.parseInt(request.getParameter("student_year")));
			student.setStudentCourse(request.getParameter("student_course"));
			student.setStudentPhoneno(request.getParameter("student_phone"));
			student.setStudentEmail(request.getParameter("student_email"));
			student.setStudentPassword(request.getParameter("student_password"));
			String status = studentservice.updatestudent(student);
			RequestDispatcher rd = null;
			request.setAttribute("status", "failed");
			rd = request.getRequestDispatcher("../updatestudentstatus.jsp");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
			}
			rd.forward(request, response);			
		}
		if(request.getRequestURI().endsWith("searchstudent")) {
			Integer sid = Integer.parseInt(request.getParameter("student_id"));
			student = new StudentDto();
			student = studentservice.searchstudent(sid); 
			RequestDispatcher rd = null;
			request.setAttribute("student", student);
			rd = request.getRequestDispatcher("../searchstudentstatus.jsp");
			rd.forward(request, response);
		}
	}

}
