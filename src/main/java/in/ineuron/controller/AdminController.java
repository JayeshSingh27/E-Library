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

import in.ineuron.dto.AdminDto;
import in.ineuron.service.IAdminService;
import in.ineuron.servicefactory.AdminServiceFactory;
import in.ineuron.util.JdbcUtil;

@WebServlet("/AdminController/*")
public class AdminController extends HttpServlet 
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
		IAdminService adminservice = AdminServiceFactory.getadminservice();
		AdminDto admin = null;
		
		if(request.getRequestURI().endsWith("AdminLogin")) {
			try {
				connection = JdbcUtil.getJdbcConnection();
				String sqlSelectQuery = "select adminId,adminEmail,adminPassword from admindb where adminId=?";
				if(connection != null) {
					pstmt = connection.prepareStatement(sqlSelectQuery);
					pstmt.setInt(1, Integer.parseInt(request.getParameter("admin_Id")));
					if(pstmt != null) {
						rs = pstmt.executeQuery();
						if(rs != null) {
							if(rs.next()) {
								String aemail = rs.getString(2);
								String apassword=  rs.getString(3);
								RequestDispatcher rd = null;
								if(aemail.equals(request.getParameter("admin_email")) && apassword.equals(request.getParameter("admin_password"))){
									System.out.println("valid");									
									rd = request.getRequestDispatcher("../adminoperations.html"); 
									rd.forward(request, response);
								}else {
									System.out.println("Invalid email & Password");
									rd = request.getRequestDispatcher("../adminVerificationFail.jsp"); 
									rd.forward(request, response);
								}
							}
						}
						else {
							System.out.println("invalid AdminId");
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		if(request.getRequestURI().endsWith("registeradmin")) {
			admin = new AdminDto();
			admin.setAdminId(Integer.parseInt(request.getParameter("admin_id")));
			admin.setAdminName(request.getParameter("admin_name"));
			admin.setAdminEmail(request.getParameter("admin_email"));
			admin.setAdminPassword(request.getParameter("admin_password"));
			String status = adminservice.registeradmin(admin);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../registeradminstatus.jsp");
			request.setAttribute("status", "failed");
			if(status.equals("success")) {
				request.setAttribute("status", "success");
			}
			rd.forward(request, response);
			
		}
	}
	

}
