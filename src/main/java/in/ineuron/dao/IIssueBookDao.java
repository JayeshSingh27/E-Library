package in.ineuron.dao;
import in.ineuron.dto.IssueDto;

public interface IIssueBookDao {
	public String issuebook(IssueDto issue);
	public IssueDto returnbook(Integer bookId);
	public String checkdue(Integer studentId);	
}
