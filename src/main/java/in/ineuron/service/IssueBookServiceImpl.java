package in.ineuron.service;



import in.ineuron.dao.IIssueBookDao;
import in.ineuron.daofactory.IssueDaoFactory;
import in.ineuron.dto.IssueDto;

public class IssueBookServiceImpl implements IIssueBookService
{
	private IIssueBookDao issuedao;

	@Override
	public String issuebook(IssueDto issue) {
		// TODO Auto-generated method stub
		issuedao = IssueDaoFactory.getissuebookdao();
		return issuedao.issuebook(issue);
	}

	@Override
	public IssueDto returnbook(Integer bookId) {
		// TODO Auto-generated method stub
		issuedao = IssueDaoFactory.getissuebookdao();
		return issuedao.returnbook(bookId);
	}

	@Override
	public String checkdue(Integer studentId) {
		// TODO Auto-generated method stub
		issuedao = IssueDaoFactory.getissuebookdao();
		return issuedao.checkdue(studentId);
	}
	
}
