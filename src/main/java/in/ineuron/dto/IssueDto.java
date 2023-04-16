package in.ineuron.dto;

import java.io.Serializable;

public class IssueDto implements Serializable
{

	private static final long serialVersionUID = 1L;
	Integer bookId;
	String bookIssueDate;
	String bookIssueDueDate;
	Integer studentId;
	@Override
	public String toString() {
		return "IssueDto [bookId=" + bookId + ", bookIssueDate=" + bookIssueDate + ", bookIssueDueDate="
				+ bookIssueDueDate + ", studentId=" + studentId + "]";
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookIssueDate() {
		return bookIssueDate;
	}
	public void setBookIssueDate(String bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}
	public String getBookIssueDueDate() {
		return bookIssueDueDate;
	}
	public void setBookIssueDueDate(String bookIssueDueDate) {
		this.bookIssueDueDate = bookIssueDueDate;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	

}
