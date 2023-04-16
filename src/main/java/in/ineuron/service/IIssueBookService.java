package in.ineuron.service;



import in.ineuron.dto.IssueDto;

public interface IIssueBookService {
	public String issuebook(IssueDto issue);
	public IssueDto returnbook(Integer bookId);
	public String checkdue(Integer studentId);	
}
