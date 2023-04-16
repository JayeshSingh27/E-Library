package in.ineuron.dto;

import java.io.Serializable;

public class StudentDto implements Serializable
{

	private static final long serialVersionUID = 1L;
	Integer studentId;
	String studentName;
	String studentDepartment;
	Integer studentYear;
	String studentCourse;
	String studentPhoneno;
	String studentEmail;
	String studentPassword;
	
	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentDepartment="
				+ studentDepartment + ", studentYear=" + studentYear + ", studentCourse=" + studentCourse
				+ ", studentPhoneno=" + studentPhoneno + ", studentEmail=" + studentEmail + "]";
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}

	public Integer getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(Integer studentYear) {
		this.studentYear = studentYear;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getStudentPhoneno() {
		return studentPhoneno;
	}

	public void setStudentPhoneno(String studentPhoneno) {
		this.studentPhoneno = studentPhoneno;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
	
	
	
}
