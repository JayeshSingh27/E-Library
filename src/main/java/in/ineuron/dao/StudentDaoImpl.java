package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.ineuron.dto.StudentDto;
import in.ineuron.util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao
{
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StudentDto student=null;
	@Override
	public String addstudent(StudentDto student) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into studentdb (`studentId`,`studentName`,`studentDepartment`,`studentYear`,`studentCourse`,`studentPhoneNo`,`studentEmailId`,`studentPassword`) values (?,?,?,?,?,?,?,?)";
			if(connection != null){
				pstmt = connection.prepareStatement(sqlInsertQuery);
				pstmt.setInt(1, student.getStudentId());
				pstmt.setString(2, student.getStudentName());
				pstmt.setString(3, student.getStudentDepartment());
				pstmt.setInt(4,student.getStudentYear());
				pstmt.setString(5, student.getStudentCourse());
				pstmt.setString(6, student.getStudentPhoneno());
				pstmt.setString(7, student.getStudentEmail());
				pstmt.setString(8, student.getStudentPassword());
				if(pstmt!=null) {
					int rowsAffected = pstmt.executeUpdate();
					if(rowsAffected == 1) {
						return "success";
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}

	@Override
	public StudentDto searchstudent(Integer studentId) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlSelectQuery = "select studentId,studentName,studentDepartment,studentYear,studentCourse,studentPhoneNo,studentEmailId from studentdb where studentId=?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlSelectQuery);
				pstmt.setInt(1, studentId);
				rs = pstmt.executeQuery();
				if(rs!= null) {
					if(rs.next()) {
						student = new StudentDto();
						student.setStudentId(rs.getInt(1));
						student.setStudentName(rs.getString(2));
						student.setStudentDepartment(rs.getString(3));
						student.setStudentYear(rs.getInt(4));
						student.setStudentCourse(rs.getString(5));
						student.setStudentPhoneno(rs.getString(6));
						student.setStudentEmail(rs.getString(7));		
						return student;
					}
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	@Override
	public String deletestudent(Integer studentId) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlDeleteQuery = "delete from studentdb where studentId=?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlDeleteQuery);
				pstmt.setInt(1, studentId);
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1) {
					return "success";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "failed";
	}

	@Override
	public String updatestudent(StudentDto student) {
		// TODO Auto-generated method stub
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlUpdateQuery = "update studentdb set studentName=?,studentDepartment=?,studentYear=?,studentCourse=?,studentPhoneNo=?,studentEmailId=?,studentPassword=? where studentId=?";
			if(connection != null) {
				pstmt = connection.prepareStatement(sqlUpdateQuery);
				pstmt.setString(1, student.getStudentName());
				pstmt.setString(2, student.getStudentDepartment());
				pstmt.setInt(3, student.getStudentYear());
				pstmt.setString(4, student.getStudentCourse());
				pstmt.setString(5, student.getStudentPhoneno());
				pstmt.setString(6 ,student.getStudentEmail());
				pstmt.setString(7, student.getStudentPassword());
				pstmt.setInt(8, student.getStudentId());
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1){
					return "success";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failed";
	}

}
